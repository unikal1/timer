package com.timer.api;

import com.timer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * packageName : <span style="color: orange;">com.timer.api</span> <br>
 * name : <span style="color: orange;">UserController</span> <br>
 * <p>
 * <span style="color: white;">[description]</span>
 * </p>
 * see Also: <br>
 *
 * <pre>
 * code usage:
 * {@code
 *
 * }
 * modified log:
 * ==========================================================
 * DATE          Author           Note
 * ----------------------------------------------------------
 * 8/2/24        isanghyeog         first create
 *
 * </pre>
 */
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home"; // 홈 페이지 템플릿 (로그인 후)
    }

    @GetMapping("/register")
    public String register(Model model) {
        return "register"; // 회원가입 페이지 템플릿
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String password,
                               RedirectAttributes redirectAttributes) {
        if (userService.findByUsername(username) != null) {
            redirectAttributes.addFlashAttribute("error", "Username already exists");
            return "redirect:/register";
        }

        userService.registerUser(username, password, "ROLE_USER");
        return "redirect:/login";
    }

    @GetMapping("/timer")
    public String timer() {
        return "timer"; // 타이머 페이지로 이동
    }
}

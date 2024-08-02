package com.timer.api;

import com.timer.dao.ActivityLogRepository;
import com.timer.domain.ActivityLog;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * packageName : <span style="color: orange;">com.timer.api</span> <br>
 * name : <span style="color: orange;">AcitivityLogController</span> <br>
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
public class ActivityLogController {
    private final ActivityLogRepository activityLogRepository;

    @PostMapping("/submit")
    public ModelAndView submitActivity(@RequestParam("time") String time, @RequestParam("text") String text) {
        // 현재 인증된 사용자 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime activityDate;

        // 5시를 기준으로 날짜 조정
        if (now.toLocalTime().isBefore(LocalTime.of(5, 0))) {
            activityDate = now.minusDays(1).withHour(5).withMinute(0).withSecond(0).withNano(0);
        } else {
            activityDate = now.withHour(5).withMinute(0).withSecond(0).withNano(0);
        }

        // 입력된 시간 파싱
        int durationMinutes = parseTimeToMinutes(time);

        // ActivityLog 객체 생성 및 저장
        ActivityLog activityLog = new ActivityLog(username, activityDate, durationMinutes, text);
        activityLogRepository.save(activityLog);

        // 결과 페이지로 리다이렉트
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("message", "활동이 저장되었습니다.");
        return modelAndView;
    }

    private int parseTimeToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}

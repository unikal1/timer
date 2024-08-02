package com.timer.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * packageName : <span style="color: orange;">com.timer.domain</span> <br>
 * name : <span style="color: orange;">ActivityLog</span> <br>
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

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private LocalDateTime activityDate;
    private int durationMinutes;
    private String description;

    public ActivityLog(String username, LocalDateTime activityDate, int durationMinutes, String description) {
        this.username = username;
        this.activityDate = activityDate;
        this.durationMinutes = durationMinutes;
        this.description = description;
    }

}

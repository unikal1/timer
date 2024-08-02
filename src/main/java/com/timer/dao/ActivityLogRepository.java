package com.timer.dao;

import com.timer.domain.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName : <span style="color: orange;">com.timer.dao</span> <br>
 * name : <span style="color: orange;">ActivityLogRepository</span> <br>
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

@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {
}

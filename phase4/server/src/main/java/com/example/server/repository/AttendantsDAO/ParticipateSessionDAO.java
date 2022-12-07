package com.example.server.repository.AttendantsDAO;

import com.example.server.config.JdbcTemplateConfig;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ParticipateSessionDAO {

    public JdbcTemplateConfig jdbcTemplateConfig = new JdbcTemplateConfig();
    public JdbcTemplate template = new JdbcTemplate(jdbcTemplateConfig.dataSource());
    public String query = "insert into ATTENDANTS values (?, ?, ?)";

    public int participateSessionDAO(String sessionId, String userId, String StudyId) {
        System.out.println("sessionId = " + sessionId);
        System.out.println("StudyId = " + StudyId);
        int result = template.update(query, sessionId, userId, StudyId);
        return result;
    }


}

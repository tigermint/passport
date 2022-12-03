package com.example.server.Study.StudyDAO.JoinStudyDAO;

import com.example.server.config.JdbcTemplateConfig;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JoinStudyDAO {

    public JdbcTemplateConfig jdbcTemplateConfig = new JdbcTemplateConfig();

    public JdbcTemplate template = new JdbcTemplate(jdbcTemplateConfig.dataSource());

    public String query = "insert into PARTICIPATE values (?, ?, 0, ?)";

    public int joinStudyDAO(String studyId, String userId, String isLeader) {
        int result = template.update(query, studyId, userId, isLeader);
        return result;
    }

}

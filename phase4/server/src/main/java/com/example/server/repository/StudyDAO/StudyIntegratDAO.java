package com.example.server.repository.StudyDAO;

import com.example.server.config.JdbcTemplateConfig;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudyIntegratDAO {

    public JdbcTemplateConfig jdbcTemplateConfig = new JdbcTemplateConfig();

    public JdbcTemplate template = new JdbcTemplate(jdbcTemplateConfig.dataSource());

    String query = "select *\n" +
            "from PARTICIPATE\n";

    public boolean isParticipate(String studyId, String userId) {
        System.out.println("userId = " + userId);
        System.out.println("studyId = " + studyId);

        query = query + "where STUDY_ID = " + studyId + " and USER__ID = " + userId;
        List<Boolean> query1 = template.query(query, (rs, rowNum) -> {
            return true;
        });

        if (query1.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

}

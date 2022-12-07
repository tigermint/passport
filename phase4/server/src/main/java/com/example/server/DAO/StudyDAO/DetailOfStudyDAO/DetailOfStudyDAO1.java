package com.example.server.DAO.StudyDAO.DetailOfStudyDAO;

import com.example.server.config.JdbcTemplateConfig;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DetailOfStudyDAO1 {

    public JdbcTemplateConfig jdbcTemplateConfig = new JdbcTemplateConfig();

    public JdbcTemplate template = new JdbcTemplate(jdbcTemplateConfig.dataSource());

    public String query = "select NAME\n" +
            "from PARTICIPATE, user_\n" +
            "where PARTICIPATE.USER__ID = user_.ID and\n" +
            "    STUDY_ID = ";

    public String getDetailOfStudyDAO(String studyId) {
        query = query + studyId;
        query = query + " and IS_LEADER = 'true'";
        String result1 = template.queryForObject(query, String.class);
        return result1;
    }
}

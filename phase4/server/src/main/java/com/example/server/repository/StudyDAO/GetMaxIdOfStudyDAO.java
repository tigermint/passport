package com.example.server.repository.StudyDAO;

import com.example.server.config.JdbcTemplateConfig;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class GetMaxIdOfStudyDAO {

    public JdbcTemplateConfig jdbcTemplateConfig = new JdbcTemplateConfig();

    public JdbcTemplate template = new JdbcTemplate(jdbcTemplateConfig.dataSource());

    public String getStudyId = "select max(id) from study_";

    public int getMaxIdOfStudyDAO() {
        int StudyId = template.queryForObject(getStudyId, Integer.class);
        return StudyId;
    }

}

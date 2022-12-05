package com.example.server.DAO.SessionDAO;

import com.example.server.config.JdbcTemplateConfig;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class GetMaxIdOfSessionDAO {

    public JdbcTemplateConfig jdbcTemplateConfig = new JdbcTemplateConfig();

    public JdbcTemplate template = new JdbcTemplate(jdbcTemplateConfig.dataSource());

    public String getSessionId = "select max(id) from Session_";

    public int getMaxIdOfStudyDAO() {
        int SessionId = template.queryForObject(getSessionId, Integer.class);
        return SessionId;
    }
}

package com.example.server.repository.StudyDAO.ListOfStudyDAO;

import com.example.server.domain.StudyDTO.StudyListDTO;
import com.example.server.config.JdbcTemplateConfig;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListOfStudyDAO2 {

    static RowMapper<StudyListDTO> StudyRowMapper2 = (rs, rowNum) ->
            StudyListDTO.builder()
                    .id(rs.getInt("STUDY_ID"))
                    .category(rs.getString("CATEGORY").split(","))
                    .description(rs.getString("DESCRIPTION"))
                    .build();

    public JdbcTemplateConfig jdbcTemplateConfig = new JdbcTemplateConfig();

    public JdbcTemplate template = new JdbcTemplate(jdbcTemplateConfig.dataSource());

    public String query2 = "select STUDY_ID,\n" +
            "       CATEGORY,\n" +
            "       DESCRIPTION\n" +
            "from STUDY_CATEGORY,\n" +
            "     CATEGORY,\n" +
            "     STUDY_\n" +
            "where STUDY_.ID = STUDY_CATEGORY.STUDY_ID\n" +
            "  and STUDY_CATEGORY.CATEGORY_ID = CATEGORY.ID\n" +
            "order by STUDY_ID";

    public List<StudyListDTO> getAllStudyDAO2() {
        List<StudyListDTO> result2 = template.query(query2, StudyRowMapper2);
        return result2;
    }
}

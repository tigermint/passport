package com.example.server.Study.StudyDAO.DetailOfStudyDAO;

import com.example.server.Study.StudyDTO.StudyDetailDTO;
import com.example.server.config.JdbcTemplateConfig;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DetailOfStudyDAO2 {

    static RowMapper<StudyDetailDTO> StudyDetailMapper = (rs, rowNum) ->
            StudyDetailDTO.builder()
                    .round(rs.getInt("ROUND"))
                    .date(rs.getString("DATE_"))
                    .attendants(rs.getInt("SESSION_ATTENDANTS"))
                    .build();
    public JdbcTemplateConfig jdbcTemplateConfig = new JdbcTemplateConfig();

    public JdbcTemplate template = new JdbcTemplate(jdbcTemplateConfig.dataSource());

    public String query = "SELECT SESSION_.ROUND, COUNT(*) SESSION_ATTENDANTS, SESSION_.DATE_\n" +
            "FROM SESSION_, ATTENDANTS\n" +
            "WHERE SESSION_.ID = ATTENDANTS.SESSION__ID AND SESSION_.STUDY_ID = ";

    public List<StudyDetailDTO> getDetailOfStudyDAO(String studyId) {
        query = query + studyId;
        query = query + " GROUP BY SESSION_.STUDY_ID, SESSION_.ROUND, SESSION_.DATE_\n" +
                "ORDER BY SESSION_.ROUND";
        List<StudyDetailDTO> result = template.query(query, StudyDetailMapper);
        return result;
    }
}

package com.example.server.Study.StudyDAO;

import com.example.server.Study.StudyDTO.ListDTO;
import com.example.server.config.JdbcTemplateConfig;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListOfStudyDAO1 {

    static RowMapper<ListDTO> StudyRowMapper1 = (rs, rowNum) ->
            ListDTO.builder()
                    .id(rs.getInt("STUDY_ID"))
                    .name(rs.getString("NAME"))
                    .StartDate(rs.getString("START_DATE"))
                    .CurParticipants(rs.getInt("CUR_PARTICIPANTS"))
                    .MaxParticipants(rs.getInt("MAX_PARTICIPANTS"))
                    .IsCompleted(rs.getString("IS_COMPLETE"))
                    .build();

    public JdbcTemplateConfig jdbcTemplateConfig = new JdbcTemplateConfig();

    public JdbcTemplate template = new JdbcTemplate(jdbcTemplateConfig.dataSource());

    public String query1 = "select STUDY_ID,\n" +
            "       STUDY_.NAME,\n" +
            "       STUDY_.START_DATE,\n" +
            "       count(*) CUR_PARTICIPANTS,\n" +
            "       STUDY_.MAX_PARTICIPANTS,\n" +
            "       STUDY_.IS_COMPLETE\n" +
            "\n" +
            "from USER_,\n" +
            "     PARTICIPATE,\n" +
            "     STUDY_\n" +
            "\n" +
            "where USER_.ID = PARTICIPATE.USER__ID\n" +
            "  and PARTICIPATE.STUDY_ID = STUDY_.ID\n" +
            "\n" +
            "group by STUDY_ID,\n" +
            "         STUDY_.NAME,\n" +
            "         STUDY_.START_DATE,\n" +
            "         STUDY_.MAX_PARTICIPANTS,\n" +
            "         STUDY_.IS_COMPLETE\n" +
            "order by STUDY_ID";

    public List<ListDTO> getAllStudyDAO1() {
        List<ListDTO> result1 = template.query(this.query1, StudyRowMapper1);

        return result1;
    }
}

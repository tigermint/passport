package com.example.server.Study.StudyDAO.ListOfStudyDAO;

import com.example.server.Study.StudyDTO.StudyListDTO;
import com.example.server.config.JdbcTemplateConfig;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListOfStudyDAO1 {

    static RowMapper<StudyListDTO> StudyRowMapper1 = (rs, rowNum) ->
            StudyListDTO.builder()
                    .id(rs.getInt("ID"))
                    .name(rs.getString("NAME"))
                    .total_round(rs.getInt("TOTAL_ROUND"))
                    .participation_fee(rs.getInt("PARTICIPATION_FEE"))
                    .cur_participants(rs.getInt("CUR_PARTICIPANTS"))
                    .max_participants(rs.getInt("MAX_PARTICIPANTS"))
                    .max_absent_time(rs.getInt("MAX_ABSENT_TIME"))
                    .is_complete(rs.getString("IS_COMPLETE"))
                    .location(rs.getString("LOCATION"))
                    .bank_name(rs.getString("BANK_NAME"))
                    .bank_account(rs.getString("BANK_ACCOUNT"))
                    .start_date(rs.getString("START_DATE"))
                    .build();

    public JdbcTemplateConfig jdbcTemplateConfig = new JdbcTemplateConfig();

    public JdbcTemplate template = new JdbcTemplate(jdbcTemplateConfig.dataSource());

    public String query1 = "select STUDY_.ID,\n" +
            "       STUDY_.NAME,\n" +
            "       STUDY_.TOTAL_ROUND,\n" +
            "       STUDY_.PARTICIPATION_FEE,\n" +
            "       count(*) CUR_PARTICIPANTS,\n" +
            "       STUDY_.MAX_PARTICIPANTS,\n" +
            "       STUDY_.MAX_ABSENT_TIME,\n" +
            "       STUDY_.IS_COMPLETE,\n" +
            "       STUDY_.LOCATION,\n" +
            "       STUDY_.BANK_NAME,\n" +
            "       STUDY_.BANK_ACCOUNT,\n" +
            "       STUDY_.START_DATE\n" +
            "\n" +
            "from USER_,\n" +
            "     PARTICIPATE,\n" +
            "     STUDY_\n" +
            "\n" +
            "WHERE USER_.ID = PARTICIPATE.USER__ID\n" +
            "  AND PARTICIPATE.STUDY_ID = STUDY_.ID\n" +
            "\n" +
            "GROUP BY STUDY_.ID,\n" +
            "         STUDY_.NAME,\n" +
            "         STUDY_.TOTAL_ROUND,\n" +
            "         STUDY_.PARTICIPATION_FEE,\n" +
            "         STUDY_.MAX_PARTICIPANTS,\n" +
            "         STUDY_.MAX_ABSENT_TIME,\n" +
            "         STUDY_.IS_COMPLETE,\n" +
            "         STUDY_.LOCATION,\n" +
            "         STUDY_.BANK_NAME,\n" +
            "         STUDY_.BANK_ACCOUNT,\n" +
            "         STUDY_.START_DATE\n" +
            "\n" +
            "ORDER BY STUDY_.ID";

    public List<StudyListDTO> getAllStudyDAO1() {
        List<StudyListDTO> result1 = template.query(this.query1, StudyRowMapper1);

        return result1;
    }
}

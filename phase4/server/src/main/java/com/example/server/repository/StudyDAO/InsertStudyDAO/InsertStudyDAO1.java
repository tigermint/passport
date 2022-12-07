package com.example.server.repository.StudyDAO.InsertStudyDAO;

import com.example.server.domain.StudyDTO.StudyInsertDTO;
import com.example.server.config.JdbcTemplateConfig;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InsertStudyDAO1 {
    //config
    public JdbcTemplateConfig jdbcTemplateConfig = new JdbcTemplateConfig();

    public JdbcTemplate template = new JdbcTemplate(jdbcTemplateConfig.dataSource());

    static RowMapper<StudyInsertDTO> StudyInsertMapper1 = (rs, rowNum) ->
            StudyInsertDTO.builder()
                    .id(rs.getInt("ID"))
                    .bank_name(rs.getString("BANK_NAME"))
                    .bank_account(rs.getInt("BANK_ACCOUNT"))
                    .build();

    //query
    public String query1 = "select id, BANK_NAME, BANK_ACCOUNT\n" +
            "from user_\n" +
            "where id = ";

    public List<StudyInsertDTO> insertStudyDAO1(String userId) {
        query1 += userId;
        //유저의 은행정보 받아오는 쿼리
        List<StudyInsertDTO> result1 = template.query(query1, StudyInsertMapper1);
        return result1;
    }

}

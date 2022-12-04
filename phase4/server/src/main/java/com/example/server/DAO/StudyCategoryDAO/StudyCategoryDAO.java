package com.example.server.DAO.StudyCategoryDAO;

import com.example.server.DTO.StudyCategoryDTO.StudyCategoryDTO;
import com.example.server.DTO.StudyDTO.StudyCreateFormDTO;
import com.example.server.config.JdbcTemplateConfig;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class StudyCategoryDAO {

    public JdbcTemplateConfig jdbcTemplateConfig = new JdbcTemplateConfig();

    public JdbcTemplate template = new JdbcTemplate(jdbcTemplateConfig.dataSource());

    static RowMapper<StudyCategoryDTO> StudyInsertMapper = (rs, rowNum) ->
            StudyCategoryDTO.builder()
                    .id(rs.getInt("ID"))
                    .category(rs.getString("CATEGORY"))
                    .build();

    public String query1 = "select * from category where CATEGORY.CATEGORY = ?";
    public String query2 = "select * from category where CATEGORY.CATEGORY = ? or CATEGORY.CATEGORY = ?";
    public String query3 = "select * from category where CATEGORY.CATEGORY = ? or CATEGORY.CATEGORY = ? or CATEGORY.CATEGORY = ?";
    public String insertQuery = "insert into STUDY_CATEGORY values (?, ?)";
    public String getStudyId = "select max(id) from study_";
    public int insertStudyCategoryDAO(StudyCreateFormDTO Form) {
        String[] category = Form.getCategory();
        List<StudyCategoryDTO> result;
        int studyId = template.queryForObject(getStudyId, Integer.class);
        System.out.println("studyId = " + studyId);

        switch (category.length)
        {
            case 1:
                result = template.query(query1, StudyInsertMapper, category[0]);
                template.update(insertQuery, studyId, result.get(0).getId());
                break;
            case 2:
                result = template.query(query2, StudyInsertMapper, category[0], category[1]);
                template.update(insertQuery, studyId, result.get(0).getId());
                template.update(insertQuery, studyId, result.get(1).getId());
                break;
            case 3:
                result = template.query(query3, StudyInsertMapper, category[0], category[1], category[2]);
                template.update(insertQuery, studyId, result.get(0).getId());
                template.update(insertQuery, studyId, result.get(1).getId());
                template.update(insertQuery, studyId, result.get(2).getId());
                break;
        }
        return 0;
    }

}

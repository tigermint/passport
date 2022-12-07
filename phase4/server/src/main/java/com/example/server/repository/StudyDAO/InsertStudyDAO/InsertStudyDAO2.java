package com.example.server.repository.StudyDAO.InsertStudyDAO;

import com.example.server.domain.StudyDTO.StudyCreateFormDTO;
import com.example.server.domain.StudyDTO.StudyInsertDTO;
import com.example.server.config.JdbcTemplateConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.text.SimpleDateFormat;

import static com.example.server.config.DatabaseUtil.getConnection;

@Component
@Slf4j
public class InsertStudyDAO2 {
    //config
    public JdbcTemplateConfig jdbcTemplateConfig = new JdbcTemplateConfig();
    public JdbcTemplate template = new JdbcTemplate(jdbcTemplateConfig.dataSource());
    public LobHandler lobHandler = new DefaultLobHandler();

    static Connection conn = getConnection();
    Statement stmt;

    {
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //query
    public String query2 = "insert into study_ " +
            "values (?, ?, ?, ?, ?, ?, 'false', ?, ?, ?)";

    public int insertStudyDAO2(StudyCreateFormDTO Form, StudyInsertDTO insertDTO) throws SQLException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = simpleDateFormat.format(Form.getStart_date());

        ResultSet rs = null;
        StringBuffer sb = new StringBuffer();
        sb.append("Insert into STUDY_ ");
        sb.append("values ( ");
        sb.append("study_seq.nextval, ?, ?, ?, ?, ?, 'false', ?, ?, ?, ?, ?)");
        query2 = sb.toString();
        PreparedStatement ps = conn.prepareStatement(query2);
        ps.setString(1, Form.getName());
        ps.setInt(2, Form.getTotal_round());
        ps.setInt(3, Form.getParticipation_fee());
        ps.setInt(4, Form.getMax_participants());
        ps.setInt(5, Form.getMax_absent_time());
        ps.setString(6, Form.getLocation());
        ps.setString(7, insertDTO.getBank_name());
        ps.setInt(8, insertDTO.getBank_account());
        ps.setString(9, startDate);
        ps.setString(10, Form.getDescription());

        try {
            rs = ps.executeQuery();
            log.info("Study created");
        } catch (SQLException e) {
            log.warn("Study creation failed");
            throw new RuntimeException(e);
        }

        return 1;

    }


}

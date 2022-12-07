package com.example.server.DAO.SessionDAO;

import com.example.server.DTO.Session.*;
import com.example.server.config.JdbcTemplateConfig;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetSessionInfoDAO {

    public JdbcTemplateConfig jdbcTemplateConfig = new JdbcTemplateConfig();
    public JdbcTemplate template = new JdbcTemplate(jdbcTemplateConfig.dataSource());

    public String query1 = "select SESSION_.id, SESSION_.STUDY_ID, SESSION_.ROUND, SESSION_.DATE_, Study_.name StudyName, USER_.name UserName, USER__ID\n" +
            "from ATTENDANTS,\n" +
            "     SESSION_,\n" +
            "     STUDY_,\n" +
            "     USER_\n" +
            "where ATTENDANTS.SESSION__ID = SESSION_.ID\n" +
            "  and SESSION_.STUDY_ID = STUDY_.ID\n" +
            "  and USER_.ID = ATTENDANTS.USER__ID\n" +
            "  and ATTENDANTS.STUDY_ID = ?\n" +
            "  and ATTENDANTS.SESSION__ID = ?";

    public String query2 = "select STUDY_ID, USER__ID\n" +
            "from PARTICIPATE\n" +
            "where STUDY_ID = ?";

    static RowMapper<ResultOfSessionInfoDTO> SessionRowMapper = (rs, rowNum) ->
            ResultOfSessionInfoDTO.builder()
                    .ID(rs.getInt("ID"))
                    .STUDY_ID(rs.getInt("STUDY_ID"))
                    .ROUND(rs.getInt("ROUND"))
                    .DATE_(rs.getDate("DATE_"))
                    .STUDYNAME(rs.getString("STUDYNAME"))
                    .USERNAME(rs.getString("USERNAME"))
                    .USER__ID(rs.getString("USER__ID"))
                    .build();

    static RowMapper<getParicipateInfoDTO> ParticipateRowMapper = (rs, rowNum) ->
            getParicipateInfoDTO.builder()
                    .STUDY_ID(rs.getString("STUDY_ID"))
                    .USER__ID(rs.getString("USER__ID"))
                    .build();

    public ReturnOfSessionInfoAPIDTO GetSessionInfo(getSessionInfoDTO SessionInfoDTO) { //스터디 id, session id
        List<ResultOfSessionInfoDTO> query1 = template.query(this.query1, SessionRowMapper, SessionInfoDTO.getStudy__id(), SessionInfoDTO.getSession_id());
        List<getParicipateInfoDTO> query2 = template.query(this.query2, ParticipateRowMapper, SessionInfoDTO.getStudy__id());
        ReturnOfSessionInfoAPIDTO returnOfSessionInfoAPIDTO = new ReturnOfSessionInfoAPIDTO();
        List<AttendantsDTO> attendantsDTOS = new ArrayList<AttendantsDTO>();

        System.out.println("SessionInfoDTO = " + SessionInfoDTO.getStudy__id());
        System.out.println("SessionInfoDTO.getSession_id() = " + SessionInfoDTO.getSession_id());

        //Response Json에 공통값 처리
        returnOfSessionInfoAPIDTO.setID(query1.get(0).getID());
        returnOfSessionInfoAPIDTO.setSTUDY_ID(query1.get(0).getSTUDY_ID());
        returnOfSessionInfoAPIDTO.setROUND(query1.get(0).getROUND());
        returnOfSessionInfoAPIDTO.setDATE_(query1.get(0).getDATE_());
        returnOfSessionInfoAPIDTO.setATTENDANTS(attendantsDTOS);

        for (ResultOfSessionInfoDTO resultOfSessionInfoDTO : query1) {
            AttendantsDTO attendantsDTO = new AttendantsDTO();
            attendantsDTO.setUser_name(resultOfSessionInfoDTO.getUSERNAME());

            for (getParicipateInfoDTO getParicipateInfoDTO : query2) {
                if (resultOfSessionInfoDTO.getUSER__ID().equals(getParicipateInfoDTO.getUSER__ID())) {
                    attendantsDTO.setIn(true);
                    break;
                }
                attendantsDTO.setIn(false);
            }
            attendantsDTOS.add(attendantsDTO);
        }
        returnOfSessionInfoAPIDTO.setATTENDANTS(attendantsDTOS);

        return returnOfSessionInfoAPIDTO;
    }

}

package com.example.server.controller;

import com.example.server.domain.StudyDTO.*;
import com.example.server.repository.AttendantsDAO.ParticipateSessionDAO;
import com.example.server.repository.SessionDAO.CreateSessionDAO;
import com.example.server.repository.SessionDAO.GetMaxIdOfSessionDAO;
import com.example.server.repository.SessionDAO.GetSessionInfoDAO;
import com.example.server.repository.StudyCategoryDAO.StudyCategoryDAO;
import com.example.server.repository.StudyDAO.DetailOfStudyDAO.DetailOfStudyDAO1;
import com.example.server.repository.StudyDAO.DetailOfStudyDAO.DetailOfStudyDAO2;
import com.example.server.repository.StudyDAO.GetMaxIdOfStudyDAO;
import com.example.server.repository.StudyDAO.InsertStudyDAO.InsertStudyDAO1;
import com.example.server.repository.StudyDAO.InsertStudyDAO.InsertStudyDAO2;
import com.example.server.repository.StudyDAO.JoinStudyDAO.JoinStudyDAO;
import com.example.server.repository.StudyDAO.ListOfStudyDAO.ListOfStudyDAO1;
import com.example.server.repository.StudyDAO.ListOfStudyDAO.ListOfStudyDAO2;
import com.example.server.repository.StudyDAO.StudyIntegratDAO;
import com.example.server.domain.Session.ReturnOfSessionInfoAPIDTO;
import com.example.server.domain.Session.getSessionInfoDTO;
import com.example.server.domain.Session.user_DTO;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/study")
public class StudyAPIController {

    @GetMapping
    public List<StudyListDTO> getAllStudy() {
        ListOfStudyDAO1 listOfStudyDAO1 = new ListOfStudyDAO1();
        ListOfStudyDAO2 listOfStudyDAO2 = new ListOfStudyDAO2();

        List<StudyListDTO> allStudyDAO1 = listOfStudyDAO1.getAllStudyDAO1();
        List<StudyListDTO> allStudyDAO2 = listOfStudyDAO2.getAllStudyDAO2();

        ArrayList<String> category;

        for (StudyListDTO studyListDTO1 : allStudyDAO1) {
            category = new ArrayList<>();
            for (StudyListDTO studyListDTO2 : allStudyDAO2) {
                if (studyListDTO1.getId().equals(studyListDTO2.getId())) {
                    category.add(studyListDTO2.getCategory()[0]);
                    studyListDTO1.setCategory(studyListDTO2.getCategory());
                    studyListDTO1.setDescription(studyListDTO2.getDescription());
                }
                studyListDTO1.setCategory(category.toArray(new String[0]));
            }
        }
        System.out.println("StudyAPIController.getAllStudy");
        return allStudyDAO1;
    }

    @PostMapping
    public void addStudy(@RequestBody StudyCreateFormDTO studyCreateFormDTO) throws SQLException, ParseException {
        InsertStudyDAO1 insertStudyDAO1 = new InsertStudyDAO1();
        InsertStudyDAO2 insertStudyDAO2 = new InsertStudyDAO2();

        //스터디 테이블에 삽입
        List<StudyInsertDTO> studyInsertDTO1 = insertStudyDAO1.insertStudyDAO1(String.valueOf(studyCreateFormDTO.getUser_id()));
        insertStudyDAO2.insertStudyDAO2(studyCreateFormDTO, studyInsertDTO1.get(0));

        //study_category 테이블에 삽입
        StudyCategoryDAO studyCategoryDAO = new StudyCategoryDAO();
//        System.out.println("studyCategoryDAO = " + studyCategoryDAO);
        studyCategoryDAO.insertStudyCategoryDAO(studyCreateFormDTO);

        //session 테이블에 스터디 장 삽입
        CreateSessionDAO createSessionDAO = new CreateSessionDAO();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        createSessionDAO.joinSessionDAO(studyCreateFormDTO.getTotal_round(), sdf.format(studyCreateFormDTO.getStart_date()));

        //participant 테이블에 스터디 장 삽입
        JoinStudyDAO joinStudyDAO = new JoinStudyDAO();
        GetMaxIdOfStudyDAO getMaxIdOfStudyDAO = new GetMaxIdOfStudyDAO();
        int maxId = getMaxIdOfStudyDAO.getMaxIdOfStudyDAO();
        joinStudyDAO.joinStudyDAO(String.valueOf(maxId), String.valueOf(studyCreateFormDTO.getUser_id()), "true");

//        //attendants 테이블에 스터디 장 삽입
//        GetMaxIdOfSessionDAO getMaxIdOfSessionDAO = new GetMaxIdOfSessionDAO();
//        int maxIdOfSession = getMaxIdOfSessionDAO.getMaxIdOfStudyDAO();
//        ParticipateSessionDAO participateSessionDAO = new ParticipateSessionDAO();
//
//        for (int i = 0; i < studyCreateFormDTO.getTotal_round(); i++) {
//            System.out.println("i = " + i);
//            System.out.println("maxIdOfSession = " + maxIdOfSession);
//            participateSessionDAO.participateSessionDAO(String.valueOf(studyCreateFormDTO.getUser_id()),
//                    String.valueOf(maxIdOfSession - i),
//                    String.valueOf(maxId));
//        }
    }

    @GetMapping("/{study__id}")
    public StudyIntegrateDTO getDetailStudy(@PathVariable("study__id") String study__id, @RequestBody IsParticipateUserIdDTO user__id) {
        DetailOfStudyDAO1 detailOfStudyDAO1 = new DetailOfStudyDAO1();
        DetailOfStudyDAO2 detailOfStudyDAO2 = new DetailOfStudyDAO2();
        StudyIntegratDAO studyIntegratDAO = new StudyIntegratDAO();

        String leaderName = detailOfStudyDAO1.getDetailOfStudyDAO(study__id);
        List<StudyDetailDTO> sessionInfo = detailOfStudyDAO2.getDetailOfStudyDAO(study__id);

        for (StudyDetailDTO studyDetailDTO : sessionInfo) {
            studyDetailDTO.setIs_leader(leaderName);
        }

        //==============================================

        ListOfStudyDAO1 listOfStudyDAO1 = new ListOfStudyDAO1();
        ListOfStudyDAO2 listOfStudyDAO2 = new ListOfStudyDAO2();

        //스터디
        List<StudyListDTO> allStudyDAO1 = listOfStudyDAO1.getAllStudyDAO1();
        //카테고리
        List<StudyListDTO> allStudyDAO2 = listOfStudyDAO2.getAllStudyDAO2();

        ArrayList<String> category;

        for (StudyListDTO studyListDTO1 : allStudyDAO1) {
            category = new ArrayList<>();
            for (StudyListDTO studyListDTO2 : allStudyDAO2) {
                if (studyListDTO1.getId().equals(studyListDTO2.getId())) {
                    category.add(studyListDTO2.getCategory()[0]);
                    studyListDTO1.setCategory(studyListDTO2.getCategory());
                    studyListDTO1.setDescription(studyListDTO2.getDescription());
                }
                studyListDTO1.setCategory(category.toArray(new String[0]));
            }
        }

        //==========================================

        int temp = Integer.parseInt(study__id) - 1;
        boolean participate = studyIntegratDAO.isParticipate(String.valueOf(allStudyDAO1.get(temp).getId()), user__id.getUser_id());

        if (participate) {
            allStudyDAO1.get(temp).setIs_participating("true");
        } else {
            allStudyDAO1.get(temp).setIs_participating("false");
        }
        StudyIntegrateDTO studyIntegrateDTO = new StudyIntegrateDTO();
        studyIntegrateDTO.setStudyListDTO(allStudyDAO1.get(temp));
        studyIntegrateDTO.setSessions(sessionInfo);
        return studyIntegrateDTO;
    }

    @PostMapping("/{study__id}")
    public void joinStudy(@RequestBody StudyJoinDTO studyJoinDTO) {
        JoinStudyDAO joinStudyDAO = new JoinStudyDAO();
        joinStudyDAO.joinStudyDAO(studyJoinDTO.getStudy_id(), studyJoinDTO.getUser__id(), "false");
    }

    @GetMapping("/{study__id}/{session_id}")
    public ReturnOfSessionInfoAPIDTO getSessionInfo(@PathVariable("study__id") String study__id, @PathVariable("session_id") String session_id) {
        getSessionInfoDTO getSessionInfoDTO = new getSessionInfoDTO();
        getSessionInfoDTO.setStudy__id(study__id);
        getSessionInfoDTO.setSession_id(session_id);

        GetSessionInfoDAO getSessionInfoDAO = new GetSessionInfoDAO();
        ReturnOfSessionInfoAPIDTO returnOfSessionInfoAPIDTO = getSessionInfoDAO.GetSessionInfo(getSessionInfoDTO);
        return returnOfSessionInfoAPIDTO;
    }

    @PostMapping("/{study__id}/{session_id}")
    public void joinSession(@PathVariable("study__id") String study__id, @PathVariable("session_id") String session_id, @RequestBody user_DTO user_DTO) {
        GetMaxIdOfSessionDAO getMaxIdOfSessionDAO = new GetMaxIdOfSessionDAO();
        int maxIdOfSession = getMaxIdOfSessionDAO.getMaxIdOfStudyDAO();
        ParticipateSessionDAO participateSessionDAO = new ParticipateSessionDAO();


        participateSessionDAO.participateSessionDAO(user_DTO.getUser__id(), session_id, study__id);
    }
}

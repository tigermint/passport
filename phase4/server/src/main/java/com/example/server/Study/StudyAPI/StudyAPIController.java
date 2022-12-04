package com.example.server.Study.StudyAPI;

import com.example.server.DAO.StudyCategoryDAO.StudyCategoryDAO;
import com.example.server.DAO.StudyDAO.DetailOfStudyDAO.DetailOfStudyDAO1;
import com.example.server.DAO.StudyDAO.DetailOfStudyDAO.DetailOfStudyDAO2;
import com.example.server.DAO.StudyDAO.InsertStudyDAO.InsertStudyDAO1;
import com.example.server.DAO.StudyDAO.InsertStudyDAO.InsertStudyDAO2;
import com.example.server.DAO.StudyDAO.JoinStudyDAO.JoinStudyDAO;
import com.example.server.DAO.StudyDAO.ListOfStudyDAO.ListOfStudyDAO1;
import com.example.server.DAO.StudyDAO.ListOfStudyDAO.ListOfStudyDAO2;
import com.example.server.DAO.StudyDAO.StudyIntegratDAO;
import com.example.server.DTO.StudyDTO.*;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/study")
public class StudyAPIController {

//    @GetMapping
//    public List<StudyListDTO> getAllStudy() {
//        ListOfStudyDAO1 listOfStudyDAO1 = new ListOfStudyDAO1();
//        ListOfStudyDAO2 listOfStudyDAO2 = new ListOfStudyDAO2();
//
//        List<StudyListDTO> allStudyDAO1 = listOfStudyDAO1.getAllStudyDAO1();
//        List<StudyListDTO> allStudyDAO2 = listOfStudyDAO2.getAllStudyDAO2();
//
//        ArrayList<String> category;
//
//        for (StudyListDTO studyListDTO1 : allStudyDAO1) {
//            category = new ArrayList<>();
//            for (StudyListDTO studyListDTO2 : allStudyDAO2) {
//                if (studyListDTO1.getId().equals(studyListDTO2.getId())) {
//                    category.add(studyListDTO2.getCategory()[0]);
//                    studyListDTO1.setCategory(studyListDTO2.getCategory());
//                    studyListDTO1.setDescription(studyListDTO2.getDescription());
//                }
//                studyListDTO1.setCategory(category.toArray(new String[0]));
//            }
//        }
//        System.out.println("StudyAPIController.getAllStudy");
//        return allStudyDAO1;
//    }

    @PostMapping
    public void addStudy(@RequestBody StudyCreateFormDTO studyCreateFormDTO) throws SQLException {
        InsertStudyDAO1 insertStudyDAO1 = new InsertStudyDAO1();
        InsertStudyDAO2 insertStudyDAO2 = new InsertStudyDAO2();

        //스터디 테이블에 삽입
        List<StudyInsertDTO> studyInsertDTO1 = insertStudyDAO1.insertStudyDAO1(String.valueOf(studyCreateFormDTO.getUser_id()));
        insertStudyDAO2.insertStudyDAO2(studyCreateFormDTO, studyInsertDTO1.get(0));

        //study_category 테이블에 삽입
        StudyCategoryDAO studyCategoryDAO = new StudyCategoryDAO();
        studyCategoryDAO.insertStudyCategoryDAO(studyCreateFormDTO);
    }

    @GetMapping("/{study__id}")
    public StudyIntegrateDTO getDetailStudy(@PathVariable("study__id") String study__id, @RequestBody String user__id) {
        System.out.println("study__id = " + study__id);
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

        //==========================================


        boolean participate = studyIntegratDAO.isParticipate(String.valueOf(allStudyDAO1.get(0).getId()), user__id);

        if (participate) {
            allStudyDAO1.get(0).setIs_participating("true");
        } else {
            allStudyDAO1.get(0).setIs_participating("false");
        }
        StudyIntegrateDTO studyIntegrateDTO = new StudyIntegrateDTO();
        studyIntegrateDTO.setStudyListDTO(allStudyDAO1.get(0));
        studyIntegrateDTO.setSessions(sessionInfo);

        return studyIntegrateDTO;
    }

    @PostMapping("/{study__id}")
    public void joinStudy(@RequestBody StudyJoinDTO studyJoinDTO) {
        JoinStudyDAO joinStudyDAO = new JoinStudyDAO();
        joinStudyDAO.joinStudyDAO(studyJoinDTO.getStudy_id(), studyJoinDTO.getUser__id(), "false");
    }

}

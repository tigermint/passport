package com.example.server.Study.StudyAPI;

import com.example.server.Study.StudyDAO.DetailOfStudyDAO.DetailOfStudyDAO1;
import com.example.server.Study.StudyDAO.DetailOfStudyDAO.DetailOfStudyDAO2;
import com.example.server.Study.StudyDAO.JoinStudyDAO.JoinStudyDAO;
import com.example.server.Study.StudyDAO.ListOfStudyDAO.ListOfStudyDAO1;
import com.example.server.Study.StudyDAO.ListOfStudyDAO.ListOfStudyDAO2;
import com.example.server.Study.StudyDTO.StudyDetailDTO;
import com.example.server.Study.StudyDTO.StudyJoinDTO;
import com.example.server.Study.StudyDTO.StudyListDTO;
import org.springframework.web.bind.annotation.*;

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
        return allStudyDAO1;
    }

    @PostMapping
    public void addStudy() {

    }

    @GetMapping("/{study__id}")
    public List<StudyDetailDTO> getDetailStudy(@PathVariable("study__id") String study__id) {
        DetailOfStudyDAO1 detailOfStudyDAO1 = new DetailOfStudyDAO1();
        DetailOfStudyDAO2 detailOfStudyDAO2 = new DetailOfStudyDAO2();

        String leaderName = detailOfStudyDAO1.getDetailOfStudyDAO(study__id);
        List<StudyDetailDTO> sessionInfo = detailOfStudyDAO2.getDetailOfStudyDAO(study__id);

        for (StudyDetailDTO studyDetailDTO : sessionInfo) {
            studyDetailDTO.setIs_leader(leaderName);
        }

        return sessionInfo;
    }

    @PostMapping("/{study__id}")
    public void joinStudy(@RequestBody StudyJoinDTO studyJoinDTO) {
        JoinStudyDAO joinStudyDAO = new JoinStudyDAO();
        joinStudyDAO.joinStudyDAO(studyJoinDTO.getStudy_id(), studyJoinDTO.getUser__id(), "false");
    }

}

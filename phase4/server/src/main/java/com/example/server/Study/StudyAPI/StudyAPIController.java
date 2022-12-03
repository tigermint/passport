package com.example.server.Study.StudyAPI;

import com.example.server.Study.StudyDAO.ListOfStudyDAO1;
import com.example.server.Study.StudyDAO.ListOfStudyDAO2;
import com.example.server.Study.StudyDTO.StudyListDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}

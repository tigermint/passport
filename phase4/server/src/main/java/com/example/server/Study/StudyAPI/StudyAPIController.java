package com.example.server.Study.StudyAPI;

import com.example.server.Study.StudyDAO.ListOfStudyDAO1;
import com.example.server.Study.StudyDAO.ListOfStudyDAO2;
import com.example.server.Study.StudyDTO.ListDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/study")
public class StudyAPIController {

    @GetMapping
    public List<ListDTO> getAllStudy() {
        ListOfStudyDAO1 listOfStudyDAO1 = new ListOfStudyDAO1();
        ListOfStudyDAO2 listOfStudyDAO2 = new ListOfStudyDAO2();

        List<ListDTO> allStudyDAO1 = listOfStudyDAO1.getAllStudyDAO1();
        List<ListDTO> allStudyDAO2 = listOfStudyDAO2.getAllStudyDAO2();

        ArrayList<String> category;

        for (ListDTO listDTO1 : allStudyDAO1) {
            category = new ArrayList<>();
            for (ListDTO listDTO2 : allStudyDAO2) {
                if (listDTO1.getId().equals(listDTO2.getId())) {
                    category.add(listDTO2.getCategory()[0]);
                    listDTO1.setCategory(listDTO2.getCategory());
                    listDTO1.setDescription(listDTO2.getDescription());
                }
                listDTO1.setCategory(category.toArray(new String[0]));
            }
        }
        return allStudyDAO1;
    }


}

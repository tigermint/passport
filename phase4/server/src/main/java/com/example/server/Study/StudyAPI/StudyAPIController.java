package com.example.server.Study.StudyAPI;

import com.example.server.Study.StudyDTO.ListDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.server.Study.StudyDAO.ListOfStudyDAO;
import java.util.List;

@RestController
@RequestMapping("/study")
public class StudyAPIController {

    @GetMapping
    public List<ListDTO> getAllStudy() {
        ListOfStudyDAO listOfStudyDAO = new ListOfStudyDAO();
        return listOfStudyDAO.getAllStudyDAO();
    }


}

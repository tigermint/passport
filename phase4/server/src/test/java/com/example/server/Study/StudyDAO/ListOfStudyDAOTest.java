package com.example.server.Study.StudyDAO;

import com.example.server.Study.StudyDAO.ListOfStudyDAO.ListOfStudyDAO1;
import com.example.server.Study.StudyDAO.ListOfStudyDAO.ListOfStudyDAO2;
import com.example.server.Study.StudyDTO.StudyListDTO;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ListOfStudyDAOTest {


    @Test
    public void getAllStudyTest() {
        //given
        ListOfStudyDAO1 listOfStudyDAO1 = new ListOfStudyDAO1();
        List<StudyListDTO> allStudy;

        //when
        allStudy = listOfStudyDAO1.getAllStudyDAO1();

        //then
        Assertions.assertThat(allStudy.size()).isEqualTo(3);
    }

    @Test
    public void getAllStudyTest2() {
        //given
        ListOfStudyDAO2 listOfStudyDAO2 = new ListOfStudyDAO2();
        List<StudyListDTO> allStudy;

        //when
        allStudy = listOfStudyDAO2.getAllStudyDAO2();

        //then
        for (StudyListDTO studyListDTO : allStudy) {
            System.out.println(studyListDTO.getId());
            System.out.println(studyListDTO.getCategory());
            System.out.println(studyListDTO.getDescription());

        }
        Assertions.assertThat(allStudy.size()).isEqualTo(9);
    }
}
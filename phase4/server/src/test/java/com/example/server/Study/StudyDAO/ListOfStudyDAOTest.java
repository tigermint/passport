package com.example.server.Study.StudyDAO;

import com.example.server.Study.StudyDTO.ListDTO;
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
        List<ListDTO> allStudy;

        //when
        allStudy = listOfStudyDAO1.getAllStudyDAO1();

        //then
        Assertions.assertThat(allStudy.size()).isEqualTo(3);
    }

    @Test
    public void getAllStudyTest2() {
        //given
        ListOfStudyDAO2 listOfStudyDAO2 = new ListOfStudyDAO2();
        List<ListDTO> allStudy;

        //when
        allStudy = listOfStudyDAO2.getAllStudyDAO2();

        //then
        for (ListDTO listDTO : allStudy) {
            System.out.println(listDTO.getId());
            System.out.println(listDTO.getCategory());
            System.out.println(listDTO.getDescription());

        }
        Assertions.assertThat(allStudy.size()).isEqualTo(9);
    }
}
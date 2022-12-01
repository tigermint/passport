package com.example.server.Study.StudyDAO;

import com.example.server.Study.StudyDTO.ListDTO;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ListOfStudyDAOTest {
    @Autowired
    ListOfStudyDAO listOfStudyDAO = new ListOfStudyDAO();

    @Test
    public void getAllStudyTest() {
        //given
        List<ListDTO> allStudy;

        //when
        allStudy = listOfStudyDAO.getAllStudyDAO();

        //then
        Assertions.assertThat(allStudy.size()).isEqualTo(3);
    }
}
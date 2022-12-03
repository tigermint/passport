package com.example.server.Study.StudyDAO;

import com.example.server.Study.StudyDAO.JoinStudyDAO.JoinStudyDAO;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class JoinStudyDAOTest {

    @Test
    public void joinStudyDAOTest() {
        //given
        JoinStudyDAO joinStudyDAO = new JoinStudyDAO();

        //when
        String StudyId = "4";
        String UserId = "4";
        String isLeader = "true";
        int i = joinStudyDAO.joinStudyDAO(StudyId, UserId, isLeader);

        //then
        Assertions.assertThat(i).isEqualTo(1);

    }
}
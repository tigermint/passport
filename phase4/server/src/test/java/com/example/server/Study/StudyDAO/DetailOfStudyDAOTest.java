package com.example.server.Study.StudyDAO;

import com.example.server.Study.StudyDAO.DetailOfStudyDAO.DetailOfStudyDAO1;
import com.example.server.Study.StudyDAO.DetailOfStudyDAO.DetailOfStudyDAO2;
import com.example.server.Study.StudyDTO.StudyDetailDTO;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

public class DetailOfStudyDAOTest {

    @Test
    public void getStudyDetailDAO1Test() {

        //given
        DetailOfStudyDAO1 DetailOfStudyDAO1 = new DetailOfStudyDAO1();

        //when
        String detailOfStudyDAO = DetailOfStudyDAO1.getDetailOfStudyDAO("3");

        //then
        Assertions.assertThat(detailOfStudyDAO).isEqualTo("testUser3");

    }

    @Test
    public void getStudyDetailDAO2Test() {

        //given
        DetailOfStudyDAO2 DetailOfStudyDAO2 = new DetailOfStudyDAO2();

        //when
        List<StudyDetailDTO> detailOfStudyDAO = DetailOfStudyDAO2.getDetailOfStudyDAO("1");

        //then
        Assertions.assertThat(detailOfStudyDAO.get(1).getAttendants()).isEqualTo(4);

    }
}
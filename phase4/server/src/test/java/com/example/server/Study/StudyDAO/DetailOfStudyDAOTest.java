package com.example.server.Study.StudyDAO;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class DetailOfStudyDAOTest {

    @Test
    public void getStudyDetailDAOTest() {

        //given
        DetailOfStudyDAO1 DetailOfStudyDAO1 = new DetailOfStudyDAO1();

        //when
        String detailOfStudyDAO = DetailOfStudyDAO1.getDetailOfStudyDAO("3");

        //then
        Assertions.assertThat(detailOfStudyDAO).isEqualTo("testUser3");

    }
}
package study;

import org.junit.jupiter.api.*;

import java.sql.ResultSet;

class StudyDAOTest {

    @Test
    void createStudy() throws Exception {
        //given
        StudyDTO study = new StudyDTO();

        study.setId(51);
        study.setName("test");
        study.setTotalRound(10);
        study.setParticipationFee(10000);
        study.setMaxParticipants(10);
        study.setMaxAbsentTime(3);
        study.setComplete(false);
        study.setLocation("test");
        study.setBankName("test");
        study.setBankAccount(123456789);
        study.setStartDate("2020-01-01");

        //when
        ResultSet rs = null;
        rs = StudyDAO.createStudy(study);

        //then
        Assertions.assertNotNull(rs);
    }

    @Test
    void readListOfStudy() {
    }

    @Test
    void readDetailOfStudy() {
    }
}
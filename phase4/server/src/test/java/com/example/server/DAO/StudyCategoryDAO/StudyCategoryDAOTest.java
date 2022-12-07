package com.example.server.DAO.StudyCategoryDAO;

import com.example.server.DTO.StudyDTO.StudyCreateFormDTO;
import org.junit.Test;

public class StudyCategoryDAOTest {

    @Test
    public void insertStudyCategoryDAOTest(StudyCreateFormDTO Form) {
        //given
        Form.setCategory(new String[]{"간호사", "조산사", "토목기사"});

        //when
        StudyCategoryDAO studyCategoryDAO = new StudyCategoryDAO();
        int result = studyCategoryDAO.insertStudyCategoryDAO(Form);

        //then
    }
}
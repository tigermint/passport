package com.example.server.DAO.SessionDAO;

import com.example.server.DTO.Session.ReturnOfSessionInfoAPIDTO;
import com.example.server.DTO.Session.getSessionInfoDTO;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class GetSessionInfoDAOTest {

    @Test
    public void getSessionInfo() {
        //given
        getSessionInfoDTO getSessionInfoDTO = new getSessionInfoDTO();
        getSessionInfoDTO.setStudy__id("1");
        getSessionInfoDTO.setSession_id("1");
        GetSessionInfoDAO getSessionInfoDAO = new GetSessionInfoDAO();

        //when
        ReturnOfSessionInfoAPIDTO returnOfSessionInfoAPIDTO = getSessionInfoDAO.GetSessionInfo(getSessionInfoDTO);

        //then
        Assertions.assertThat(returnOfSessionInfoAPIDTO.getATTENDANTS().size()).isEqualTo(4);
    }
}
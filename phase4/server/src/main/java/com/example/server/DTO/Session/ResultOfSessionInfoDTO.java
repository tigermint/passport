package com.example.server.DTO.Session;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter @Setter
public class ResultOfSessionInfoDTO {

    private int ID;
    private int STUDY_ID;
    private int ROUND;
    private Date DATE_;
    private String STUDYNAME;
    private String USERNAME;
    private String USER__ID;

}

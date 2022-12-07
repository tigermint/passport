package com.example.server.domain.Session;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ReturnOfSessionInfoAPIDTO {

    private int ID;
    private int STUDY_ID;
    private int ROUND;
    private Date DATE_;
    private List<AttendantsDTO> ATTENDANTS;
}

package com.example.server.DTO.StudyDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter @Setter
public class StudyInsertDTO {

    private int id;
    private String name;
    private int total_round;
    private int participation_fee;
    private int max_absent_time;
    private String is_complete;
    private String location;
    private String bank_name;
    private int bank_account;
    private Date start_date;
    private String description;

}

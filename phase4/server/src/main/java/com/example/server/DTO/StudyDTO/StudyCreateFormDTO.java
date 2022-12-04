package com.example.server.DTO.StudyDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter @Setter
public class StudyCreateFormDTO {

    private int user_id;
    private String name;
    private int total_round;
    private String description;
    private int participation_fee;
    private int max_participants;
    private int max_absent_time;
    private String location;
    private Date start_date;
    private String[] category;

}

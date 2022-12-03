package com.example.server.Study.StudyDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class StudyListDTO {

    //ListOFStudyDAO1
    @JsonProperty(value = "id")
    private Integer id;
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "total_round")
    private Integer total_round;
    @JsonProperty(value = "participation_fee")
    private Integer participation_fee;
    @JsonProperty(value = "cur_participants")
    private Integer cur_participants;
    @JsonProperty(value = "max_participants")
    private Integer max_participants;
    @JsonProperty(value = "max_absent_time")
    private Integer max_absent_time;
    @JsonProperty(value = "is_complete")
    private String is_complete;
    @JsonProperty(value = "location")
    private String location;
    @JsonProperty(value = "bank_name")
    private String bank_name;
    @JsonProperty(value = "bank_account")
    private String bank_account;
    @JsonProperty(value = "start_date")
    private String start_date;

    //ListOFStudyDAO2
    @JsonProperty(value = "category")
    private String[] category;
    @JsonProperty(value = "description")
    private String description;


}

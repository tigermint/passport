package com.example.server.DTO.StudyDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class StudyDetailDTO {

    //DetailOfStudyDAO1
    @JsonProperty
    private String is_leader;

    //DetailOfStudyDAO2
    @JsonProperty
    private int round;
    @JsonProperty
    private String date;
    @JsonProperty
    private int attendants;
}

package com.example.server.Study.StudyDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class ListDTO {

    //ListOFStudyDAO1
    @JsonProperty(value = "id")
    private Integer id;
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "cur_participants")
    private Integer CurParticipants;
    @JsonProperty(value = "max_participants")
    private Integer MaxParticipants;
    @JsonProperty(value = "is_complete")
    private String IsCompleted;
    @JsonProperty(value = "start_date")
    private String StartDate;

    //ListOFStudyDAO2
    @JsonProperty(value = "category")
    private String[] Category;
    @JsonProperty(value = "description")
    private String Description;


}

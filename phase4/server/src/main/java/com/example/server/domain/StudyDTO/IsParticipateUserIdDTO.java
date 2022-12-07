package com.example.server.domain.StudyDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class IsParticipateUserIdDTO {

    @JsonProperty("user_id")
    private String user_id;
}


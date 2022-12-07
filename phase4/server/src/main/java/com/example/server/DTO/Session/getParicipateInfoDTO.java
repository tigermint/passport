package com.example.server.DTO.Session;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class getParicipateInfoDTO {

    private String STUDY_ID;
    private String USER__ID;
}

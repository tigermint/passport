package com.example.server.domain.StudyDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class StudyJoinDTO {

    private String study_id;
    private String user__id;

}

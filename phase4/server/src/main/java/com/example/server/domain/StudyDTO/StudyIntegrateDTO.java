package com.example.server.domain.StudyDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class StudyIntegrateDTO {

    public StudyListDTO studyListDTO;

    public List<StudyDetailDTO> sessions;

}

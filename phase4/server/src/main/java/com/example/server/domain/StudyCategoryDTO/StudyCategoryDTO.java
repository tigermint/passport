package com.example.server.domain.StudyCategoryDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class StudyCategoryDTO {
    private int id;
    private String category;
}

package com.example.server.DTO.StudyDTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class IsParticipateUserIdDTO {
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}


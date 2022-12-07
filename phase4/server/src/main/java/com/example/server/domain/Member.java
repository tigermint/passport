package com.example.server.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {
    private Long id;
    private String password;
    private String name;
    @JsonProperty(value = "school_email")
    private String schoolEmail;
    @JsonProperty(value = "bank_name")
    private String bankName;
    @JsonProperty(value = "bank_account")
    private String bankAccount;
    private boolean isActive;

    public Member() {

    }

    public Member(String password, String name, String schoolEmail, String bankName, String bankAccount) {
        this.password = password;
        this.name = name;
        this.schoolEmail = schoolEmail;
        this.bankName = bankName;
        this.bankAccount = bankAccount;
        this.isActive = true;
    }

    public Member(String schoolEmail, String password) {
        this.schoolEmail = schoolEmail;
        this.password = password;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public boolean setIsActive(boolean isActive) {
        return isActive;
    }
}

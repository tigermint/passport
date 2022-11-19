package study;

import java.util.Date;

public class StudyDTO {

    String id;
    String name;
    Integer totalRound;
    Integer ParticipationFee;
    Integer maxParticipants;
    Integer maxAbsentTime;
    Boolean isComplete;
    String Location;
    String bankName;
    Integer bankAccount;
    Date startDate;

    public StudyDTO() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalRound() {
        return totalRound;
    }

    public void setTotalRound(Integer totalRound) {
        this.totalRound = totalRound;
    }

    public Integer getParticipationFee() {
        return ParticipationFee;
    }

    public void setParticipationFee(Integer participationFee) {
        ParticipationFee = participationFee;
    }

    public Integer getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(Integer maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public Integer getMaxAbsentTime() {
        return maxAbsentTime;
    }

    public void setMaxAbsentTime(Integer maxAbsentTime) {
        this.maxAbsentTime = maxAbsentTime;
    }

    public Boolean getComplete() {
        return isComplete;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(Integer bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

}

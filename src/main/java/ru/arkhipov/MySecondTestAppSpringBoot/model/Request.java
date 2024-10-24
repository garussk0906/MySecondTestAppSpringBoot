package ru.arkhipov.MySecondTestAppSpringBoot.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {


    @NotBlank
    private String uid;

    private String operationUid;
    private Systems systemName;
    private String systemTime;
    private String source; // нет
    private int communicationId;
    private int templateId; // нет
    private int productCode; // нет
    private int smsCode; // нет


    @Override
    public String toString(){
        return "Request{" +
                "uid=' " + uid + '\'' +
                ", operationUid=' " + operationUid + '\'' +
                ", systemName=' " + systemName + '\'' +
                ", systemTime=' " + systemTime + '\'' +
                ", source=' " + source + '\'' +
                ", communicationId=' " + communicationId +
                ", templateId=' " + templateId +
                ", productCode=' " + productCode +
                ", smsCode=' " + smsCode +
                "}";
    }
}


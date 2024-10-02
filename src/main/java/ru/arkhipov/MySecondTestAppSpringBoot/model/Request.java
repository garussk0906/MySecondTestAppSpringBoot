package ru.arkhipov.MySecondTestAppSpringBoot.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {


    @NotBlank(message = "uid is required")
    @Size(max = 32, message = "uid must be up to 32 characters long")
    private String uid;

    @NotBlank(message = "operationUid is required")
    @Size(max = 32, message = "operationUid must be up to 32 characters long")
    private String operationUid;
    private String systemName; // нет

    @NotBlank(message = "systemTime is required")
    private String systemTime;
    private String source; // нет

    @Min(value = 1, message = "communicationId must be at least 1")
    @Max(value = 100000, message = "communicationId must be at most 100000")
    private int communicationId;
    private int templateId; // нет
    private int productCode; // нет
    private int smsCode; // нет


    @Override
    public String toString(){
        return "{" +
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


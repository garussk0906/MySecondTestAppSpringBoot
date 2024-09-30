package ru.arkhipov.MySecondTestAppSpringBoot.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder

public class Response {
    private String uid;
    private String operationUid;
    private String systemTime;
    private Codes code;
    private String errorcode;
    private String errorMessage;
}

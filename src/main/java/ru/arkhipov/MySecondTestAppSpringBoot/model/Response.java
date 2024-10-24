package ru.arkhipov.MySecondTestAppSpringBoot.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Response {
    private String uid;//Уникальный идентификатор сообщение
    private String operationUid;//Уникальный идентификатор операции
    private String systemTime;//Время создания сообщения
    private Codes code;//Код результата операции
    private Double annualBonus;//Бонус сотрудника
    private ErrorCodes errorCode;//Код ошибки
    private ErrorMessages errorMessages;//Сообщение об ошибке
}

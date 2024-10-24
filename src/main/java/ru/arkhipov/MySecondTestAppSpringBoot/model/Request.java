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
    @Size(max = 32)
    private String uid;//Уникальный идентификатор сообщение
    @NotBlank
    @Size(max = 32)
    private String operationUid;//Уникальный идентификатор операции
    private Systems systemName;//Имя системы отправителя
    @NotBlank
    private String systemTime;//Время создания сообщения
    private String source;//Наименование ресурса
    private Positions position;//Должность сотрудника
    private Double salary;//Зарплата сотрудника
    private Double bonus;//Коэффициент бонуса
    private Integer workDays;//Количество отработанных дней
    @Min(1)
    @Max(100000)
    private int communicationId;//Уникальный идентификатор коммуникации
    private int templateId;//Уникальный идентификатор шаблона
    private int productCode;//Код продукта
    private int smsCode;//СМС код



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


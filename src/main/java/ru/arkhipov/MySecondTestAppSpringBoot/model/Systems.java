package ru.arkhipov.MySecondTestAppSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Systems {

    CRM("Customer Relationship Management"),
    ERP("Enterprise Resource Planning"),
    WMS("Warehouse Management System");

    private final String description;

    Systems(String description) {
        this.description = description;
    }

    @JsonValue
//    @Contract(pure = true)
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}

package ru.arkhipov.MySecondTestAppSpringBoot.model;

import lombok.Getter;

@Getter
public enum Positions {
    DEV(2.2, false),
    HR(1.2, false),
    TL(2.6, true),
    MANAGER(3.0, true),
    CEO(4.0, true),
    ANALYST(2.5, false),  // Новая позиция
    INTERN(1.0, false),   // Новая позиция
    DIRECTOR(3.5, true);  // Новая позиция

    private final double positionCoefficient;
    private final boolean isManager;

    Positions(double positionCoefficient, boolean isManager) {
        this.positionCoefficient = positionCoefficient;
        this.isManager = isManager;
    }
}

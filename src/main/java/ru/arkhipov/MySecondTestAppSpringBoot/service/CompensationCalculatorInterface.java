package ru.arkhipov.MySecondTestAppSpringBoot.service;

import ru.arkhipov.MySecondTestAppSpringBoot.model.Positions;

public interface CompensationCalculatorInterface {
    double calculateQuarterlyBonus(Positions position, double baseSalary);
}

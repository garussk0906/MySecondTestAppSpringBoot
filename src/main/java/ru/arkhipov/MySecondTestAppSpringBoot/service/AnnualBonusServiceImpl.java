package ru.arkhipov.MySecondTestAppSpringBoot.service;

import ru.arkhipov.MySecondTestAppSpringBoot.model.Positions;

import java.time.Year;

public class AnnualBonusServiceImpl implements AnnualBonusService {

    @Override
    public double calculate(Positions positions, double salary, double bonus, int workDays) {
        int daysInYear = Year.now().length(); // Определение количества дней в текущем году
        return salary * bonus * daysInYear * positions.getPositionCoefficient() / workDays;
    }
}

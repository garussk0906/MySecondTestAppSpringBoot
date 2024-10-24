package ru.arkhipov.MySecondTestAppSpringBoot.service;

import org.junit.Test;
import org.springframework.web.bind.annotation.RestController;
import ru.arkhipov.MySecondTestAppSpringBoot.model.Positions;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CompensationCalculatorTest {

    // Тест для расчета квартальной премии для менеджера
    @Test
    public void testCalculateQuarterlyBonusForManager() {
        CompensationCalculatorInterface calculator = new CompensationCalculator();
        double baseSalary = 5000.0; // Пример базовой зарплаты
        double expectedBonus = 500.0; // Ожидаемая премия (10% от 5000)

        double actualBonus = calculator.calculateQuarterlyBonus(Positions.MANAGER, baseSalary);
        assertEquals(String.valueOf(expectedBonus), actualBonus, "Квартальная премия для менеджера рассчитана неверно.");
    }

    // Тест для расчета квартальной премии для не менеджера
    @Test
    public void testCalculateQuarterlyBonusForNonManager() {
        CompensationCalculatorInterface calculator = new CompensationCalculator();
        double baseSalary = 5000.0;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateQuarterlyBonus(Positions.DEV, baseSalary);
        });

        String expectedMessage = "Данная позиция не является управленческой.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "Исключение должно содержать корректное сообщение.");
    }

    // Тест для расчета квартальной премии для другого управленца (например, CEO)
    @Test
    public void testCalculateQuarterlyBonusForCEO() {
        CompensationCalculatorInterface calculator = new CompensationCalculator();
        double baseSalary = 10000.0; // Пример базовой зарплаты
        double expectedBonus = 1000.0; // Ожидаемая премия (10% от 10000)

        double actualBonus = calculator.calculateQuarterlyBonus(Positions.CEO, baseSalary);
        assertEquals(String.valueOf(expectedBonus), actualBonus, "Квартальная премия для CEO рассчитана неверно.");
    }
}

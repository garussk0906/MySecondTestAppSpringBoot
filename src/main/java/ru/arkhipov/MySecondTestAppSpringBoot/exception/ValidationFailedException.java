package ru.arkhipov.MySecondTestAppSpringBoot.exception;

public class ValidationFailedException extends Throwable {
    public ValidationFailedException(String message) {super(message); }
}

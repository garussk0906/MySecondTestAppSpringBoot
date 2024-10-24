package ru.arkhipov.MySecondTestAppSpringBoot.service;


import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.arkhipov.MySecondTestAppSpringBoot.exception.ValidationFailedException;

import javax.naming.Binding;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult)
            throws ValidationFailedException;

//    void isValid(BindingResult bindingResult) throws ValidationFailedException;
}

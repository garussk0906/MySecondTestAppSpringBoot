package ru.arkhipov.MySecondTestAppSpringBoot.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.arkhipov.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.arkhipov.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import ru.arkhipov.MySecondTestAppSpringBoot.model.*;
import ru.arkhipov.MySecondTestAppSpringBoot.service.ModifyResponseService;
import ru.arkhipov.MySecondTestAppSpringBoot.service.ValidationService;
import ru.arkhipov.MySecondTestAppSpringBoot.util.DateTimeUtil;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/api")
public class MyController {

    private final ModifyResponseService modifyResponseService;

    @Autowired
    public MyController(ValidationService validationService,
                        @Qualifier("modifyOperationUidResponseService") ModifyResponseService modifyResponseService) {
        this.modifyResponseService = modifyResponseService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                             BindingResult bindingResult) throws ValidationFailedException {

        log.info("request: {}", request);

        // Проверка на неподдерживаемый код
        if ("123".equals(request.getUid())) {
            log.error("Unsupported UID: {}", request.getUid());
            throw new UnsupportedCodeException("Unsupported UID: 123");
        }

        // Проверка валидации
        if (bindingResult.hasErrors()) {
            log.error("Validation errors: {}", bindingResult.getAllErrors());
            StringBuilder errorMessage = new StringBuilder("Validation failed for the following fields: ");
            bindingResult.getFieldErrors().forEach(error ->
                    errorMessage.append(error.getField())
                            .append(": ")
                            .append(error.getDefaultMessage())
                            .append("; ")
            );

            throw new ValidationFailedException(errorMessage.toString());
        }

        // Формирование успешного ответа
        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();

        // Логирование модифицированного ответа
        Response modifiedResponse = modifyResponseService.modify(response);
        log.info("modified response: {}", modifiedResponse);

        return new ResponseEntity<>(modifiedResponse, HttpStatus.OK);
    }
}

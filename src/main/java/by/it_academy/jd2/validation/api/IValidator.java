package by.it_academy.jd2.validation.api;

import by.it_academy.jd2.validation.api.exceptions.ValidationException;
import by.it_academy.jd2.validation.ValidationResult;

public interface IValidator<T> {
    ValidationResult validate(T data);
    default void validateOrThrow(T data) throws ValidationException {
        final ValidationResult result = validate(data);
        if (!result.isValid()) {
            throw new ValidationException(result.getErrors());
        }
    }
}

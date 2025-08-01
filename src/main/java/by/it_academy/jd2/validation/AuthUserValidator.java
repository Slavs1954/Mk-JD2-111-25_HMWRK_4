package by.it_academy.jd2.validation;

import by.it_academy.jd2.core.dto.AuthUser;
import by.it_academy.jd2.validation.api.IValidator;
import by.it_academy.jd2.validation.api.exceptions.ValidationException;

public class AuthUserValidator implements IValidator<AuthUser> {
    @Override
    public ValidationResult validate(AuthUser user) throws ValidationException {
        StringBuilder errors = new StringBuilder();
        if (user == null) {
            errors.append("User is null.").append("\n");
        }

        if (!errors.isEmpty()) {
            return new ValidationResult(false, errors.toString());
        }
        return new ValidationResult(true, errors.toString());
    }
}

package by.it_academy.jd2.validation;

import by.it_academy.jd2.core.dto.User;
import by.it_academy.jd2.validation.api.IValidator;
import by.it_academy.jd2.validation.api.exceptions.ValidationException;

public class UserValidator implements IValidator<User>{
    @Override
    public ValidationResult validate(User user) throws ValidationException {
        StringBuilder errors = new StringBuilder();
        if (user == null) {
            errors.append("User is null.").append("\n");
            return new ValidationResult(false, errors.toString());
        }
        validateUsername(user.getUsername(), errors);
        validatePassword(user.getPassword(), errors);

        if (!errors.isEmpty()) {
            return new ValidationResult(false, errors.toString());
        }

        return new ValidationResult(true, errors.toString());
    }

    private void validateUsername(String username, StringBuilder errors) {
        if (username == null || username.isBlank()) {
            errors.append("Username is null or blank.").append("\n");
            return;
        }
        if (!username.matches("^[a-zA-Z0-9_-]+$")) {
            errors.append("Username is not valid.").append("\n");
        }
    }
    private void validatePassword(String password, StringBuilder errors) {
        if (password == null || password.isBlank()) {
            errors.append("Password is null or blank.").append("\n");
            return;
        }
        if (!password.matches("^.{6,}$")) {
            errors.append("Password is too short.").append("\n");
        }
    }

}

package by.it_academy.jd2.validation;


public class ValidationResult {
    private final boolean valid;
    private final String errors;

    public ValidationResult(boolean valid, String errors) {
        this.valid = valid;
        this.errors = errors;
    }

    public boolean isValid() {
        return valid;
    }
    public String getErrors() {
        return errors;
    }
}

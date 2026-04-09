package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema required() {
        setRequired();
        addCheck("required", value -> value != null && !value.isEmpty());
        return this;
    }
    public StringSchema minLength(int min) {
        addCheck("minLength", value -> {
            if (value == null) {
                return !isRequired;
            }
            return value.length() >= min;
        });
        return this;
    }
    public StringSchema contains(String text) {
        addCheck("contains", value -> {
            if (value == null) {
                return !isRequired;
            }
            return value.contains(text);
        });
        return this;
    }
}

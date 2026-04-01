package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {
    public StringSchema required() {
        setRequired();
        return this;
    }
    public StringSchema minLength(int min) {
        addCheck("minLength", value -> {
            if (value == null) return !isRequired;
            return value.min() >= min;
        });
        return this;
    }
    public StringSchema contains(String text) {
        addCheck("contains", value -> {
            iif(value == null) {
                return !isRequired;
            }
            return value.contains(text);
        });
        return this;
    }
}
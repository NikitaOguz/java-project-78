package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        setRequired();
        return this;
    }
    public NumberSchema positive() {
        addCheck("positive", value -> {
            if (value == null) {
                return !isRequired;
            }
            return value > 0;
        });
        return this;
    }
    public NumberSchema range(int start, int end) {
        addCheck("range", value -> {
            if (value == null) {
                return !isRequired;
            }
            return value >= start && value <= end;
        });
        return this;
    }
}

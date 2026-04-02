package hexlet.code.schemas;

public final class MapSchema extends BaseSchema {
    public MapSchema required() {
        setRequired();
        return this;
    }
    public MapSchema sizeof(int size){
        addCheck("sizeof", value -> {
            if (value == null) {
                return !isRequired;
            }
            return value.size() == size;
        });
        return this;
    }
}
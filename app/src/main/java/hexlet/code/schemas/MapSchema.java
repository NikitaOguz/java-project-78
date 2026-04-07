package hexlet.code.schemas;

public final class MapSchema extends BaseSchema {
    public MapSchema required() {
        setRequired();
        return this;
    }
    public MapSchema sizeof(int size) {
        addCheck("sizeof", value -> {
            if (value == null) {
                return !isRequired;
            }
            return value.size() == size;
        });
        return this;
    }
    public MapSchema shape(Map<String, BaseSchema<T>> shapeMap) {
        addCheck("shape", value -> {
            if (value == null) {
                return !isRequired;
            }
            for(Map.Entry<String, BaseSchema<T> entry : shapeMap.entrySet()) {
                String key = entry.getKey();
                BaseSchema<T> schema = entry.getValue();
                Object checkKey = value.get(key);

                if (!schema.isValid((T) checkKey)) {
                    return false;
                }
            }
            return true;
    }
    return this;
}
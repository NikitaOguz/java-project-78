package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema<T> extends BaseSchema<Map<String, T>> {
    public MapSchema<T> required() {
        setRequired();
        return this;
    }
    public MapSchema<T> sizeof(int size) {
        addCheck("sizeof", value -> value.size() == size);
        return this;
    }
    public MapSchema<T> shape(Map<String, BaseSchema<T>> shapeMap) {
        addCheck("shape", value -> {
            if (value == null) {
                return !isRequired;
            }

            for (var entry : shapeMap.entrySet()) {
                String key = entry.getKey();
                BaseSchema<T> schema = entry.getValue();
                T fieldValue = value.get(key);

                if (!schema.isValid(fieldValue)) {
                    return false;
                }
            }

            return true;
        });
        return this;
    }

    @SuppressWarnings("unchecked")
    private boolean checkBySchema(BaseSchema<?> schema, Object value) {
        return ((BaseSchema<Object>) schema).isValid(value);
    }
}


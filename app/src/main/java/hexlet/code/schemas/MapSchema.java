package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema<T> extends BaseSchema<Map<String, T>> {
    public MapSchema<T> required() {
        setRequired();
        return this;
    }
    public MapSchema<T> sizeof(int size) {
        addCheck("sizeof", value -> {
            if (value == null) {
                return !isRequired;
            }
            return value.size() == size;
        });
        return this;
    }
    public MapSchema<T> shape(Map<String, BaseSchema<T>> shapeMap) {
        addCheck("shape", value -> {
            if (value == null) {
                return !isRequired;
            }

            for (Map.Entry<String, BaseSchema<T>> entry : shapeMap.entrySet()) {
                String key = entry.getKey();
                BaseSchema<T> schema = entry.getValue();
                T checkKey = value.get(key);

                if (!schema.isValid(checkKey)) {
                    return false;
                }
            }

            return true;
        });

        return this;
    }
}


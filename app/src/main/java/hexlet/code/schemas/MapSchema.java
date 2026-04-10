package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map<String, ?>> {
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
    public MapSchema shape(Map<String, BaseSchema<?>> shapeMap) {
        addCheck("shape", value -> {
            if (value == null) {
                return !isRequired;
            }
            for (Map.Entry<String, BaseSchema<?>> entry : shapeMap.entrySet()) {
                String key = entry.getKey();
                BaseSchema<?> schema = entry.getValue();
                Object fieldValue = value.get(key);

                if (!checkBySchema(schema, fieldValue)) {
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


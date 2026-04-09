package hexlet.code.schemas;

public class MapSchemaTest {
    private MapSchema mapSchema;

    private Map<String, String> data;

    @BeforeEach
    public void setUp() {
        mapSchema = new MapSchema();
        data = new HashMap<>();
        data.put("key", "value");
    }
    @Test
    public void testRequiredNull() {
        assertTrue(mapSchema.isValid(null));
    }

    @Test
    public void testRequiredPositive() {
        mapSchema.required();
        assertTrue(mapSchema.isValid(data));
    }
    @Test
    public void testRequiredNegative() {
        mapSchema.required();
        assertFalse(mapSchema.isValid(null));
    }
    @Test
    public void testSizeOf() {
        mapSchema.sizeof(2);
        data.put("key2", "value2");
        assertTrue(mapSchema.isValid(data));
    }
    @Test
    public void testSizeOfNegative() {
        mapSchema.sizeof(2);
        assertFalse(mapSchema.isValid(data));
    }
    @Test
    public void testShape() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().required().minLength(2));

        schema.shape(schemas);

        Map<String, String> human = new HashMap<>();
        human.put("firstName", "John");
        human.put("lastName", "Smith");

        assertTrue(schema.isValid(human));

    }
    @Test
    public void testShapeNegative() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().required().minLength(2));

        schema.shape(schemas);

        Map<String, String> human = new HashMap<>();
        human.put("firstName", "John");
        human.put("lastName", "B");

        assertFalse(schema.isValid(human));
    }
    @Test
    public void testShapeNull() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());

        schema.shape(schemas);

        Map<String, String> human = new HashMap<>();
        human.put("firstName", null);

        assertFalse(schema.isValid(human));
    }
}
package hexlet.code.schemas;

public class NumberSchemaTest {
    private NumberSchema numberSchema;
    @BeforeEach
    public void setUp() {
        numberSchema = new NumberSchema();
    }
    @Test
    public void testRequiredNull() {
        assertTrue(numberSchema.isValid(null));
    }
}
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
    @Test
    public void testRequiredPositive() {
        numberSchema.required();
        assertTrue(numberSchema.isValid(10));
        assertTrue(numberSchema.isValid(20));
        assertTrue(numberSchema.isValid(30));
    }
    @Test
    public void testRequiredNegative() {
        numberSchema.positive();
        numberSchema.required();

        assertFalse(numberSchema.isValid(0));
        assertFalse(numberSchema.isValid(-10));
    }
    @Test
    public void testPositive() {
        numberSchema.positive();
        assertTrue(numberSchema.isValid(null));
    }
    @Test
    public void testRange() {
        numberSchema.range(2, 6);
        assertTrue(numberSchema.isValid(2));
        assertTrue(numberSchema.isValid(4));
        assertTrue(numberSchema.isValid(6));
    }
    @Test public void testRangeNegative() {
        numberSchema.range(4,8);
        assertFalse(numberSchema.isValid(1));
        assertFalse(numberSchema.isValid(9));
    }
}
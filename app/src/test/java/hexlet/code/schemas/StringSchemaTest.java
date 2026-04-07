package hexlet.code.schemas;

import org.junit.jupiter.api.Test;
import hexlet.code.schemas.StringSchema;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringSchemaTest {
    private StringSchema stringSchema;

    @BeforeEach
    public void setUp() {
        stringSchema = new StringSchema();
    }
    @Test
    public void testRequiredNull() {
        assertTrue(stringSchema.isValid(null));
    }
    @Test
    public void testRequiredEmpty() {
        assertTrue(stringSchema.isValid(""));
    }
    @Test
    public void testRequired() {
        stringSchema.required();
        assertTrue(stringSchema.isValid("Hello"));
    }
    @Test
    public void testRequiredNegative() {
        stringSchema.required();
        assertFalse(stringSchema.isValid(null));
        assertFalse(stringSchema.isValid(""));
        //assertFalse(stringSchema.isValid("hello"));
    }
    @Test
    public void testMinLenght(String value)
    {
        stringSchema.minLength(5);
        assertTrue(stringSchema.isValid(value));
    }
    @Test
    public void testMinLengthNegative(String value) {
        stringSchema.min(7);
        assertFalse(stringSchema.isValid(value));
    }
    @Test
    public void testContains() {
        stringSchema.contains("llo");
        assertTrue(stringSchema.isValid("Hello"));
    }
    @Test
    public void testContainsNegative() {
        stringSchema.contains("zxc");
        assertFalse(stringSchema.isValid("Hello"));
    }
}
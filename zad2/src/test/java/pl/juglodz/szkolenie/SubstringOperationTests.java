
package pl.juglodz.szkolenie;

import org.junit.Test;
import org.junit.experimental.categories.Categories.ExcludeCategory;

import pl.juglodz.szkolenie.operation.OperationFactory;
import pl.juglodz.szkolenie.operation.SubstringOperation;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class SubstringOperationTests extends TestCase {

    public void testShouldCreateSubStringOperationHappyFlow() {
        // GIVEN good parameters
        String startText = "Witaj";
        String startNumber = "2";
        String endNumber = "4";
        String[] args = { OperationFactory.OPERATION_SUBSTRING, startText, startNumber, endNumber };
        SubstringOperation tested = SubstringOperation.create(args);
        String expected = "taj";
        // WHEN execute operation
        String result = tested.execute();
        // THEN get substring string.
        assertEquals("Because our startTxt is=" + startText + " and we substring  from " + startNumber + " to " + endNumber + ". We expected "
                + expected, expected, result);
    }

    // @Test(expected=NumberFormatException.class)
    public void testShouldGenerateErrorWhenParamNotANumber() {

        // GIVEN wrong 2'nd and 3'th parameters
        String startText = "Witaj";
        String startNumber = "two";
        String endNumber = "three";
        String[] args = { OperationFactory.OPERATION_SUBSTRING, startText, startNumber, endNumber };
        Exception ex = null;
        Class<NumberFormatException> expectedEx = NumberFormatException.class;
        // WHEN execute operation
        try {
            SubstringOperation tested = SubstringOperation.create(args);
            String result = tested.execute();
        } catch (Exception e) {
            ex = e;
        }
        // THEN get substring string.
        assertTrue("Because our startTxt is=" + startText + " but because 2'nd param is " + startNumber + " 3'th is  " + endNumber
                + ". We expected "
                + expectedEx.getName(), ex.getClass() == expectedEx);
    }

    public void testShouldThrowExceptionWhenNullParams() {
        // GIVEN wrong 2'nd and 3'th parameters
        String startText = null;
        String startNumber = null;
        String endNumber = null;
        String[] args = { OperationFactory.OPERATION_SUBSTRING, startText, startNumber, endNumber };
        Exception ex = null;
        Class<NumberFormatException> expectedEx = NumberFormatException.class;
        // WHEN execute operation
        try {
            SubstringOperation tested = SubstringOperation.create(args);
            String result = tested.execute();
        } catch (Exception e) {
            ex = e;
        }
        // THEN get substring string.
        assertTrue("Because our startTxt is=" + startText + " but because 2'nd param is " + startNumber + " 3'th is  " + endNumber
                + ". We expected "
                + expectedEx.getName() + " but we got " + ex.getClass(), ex.getClass() == expectedEx);
    }

}

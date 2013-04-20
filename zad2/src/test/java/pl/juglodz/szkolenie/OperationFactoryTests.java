
package pl.juglodz.szkolenie;

import org.hamcrest.core.IsAnything;

import junit.framework.TestCase;
import pl.juglodz.szkolenie.operation.Operation;
import pl.juglodz.szkolenie.operation.OperationFactory;
import pl.juglodz.szkolenie.operation.SubstringOperation;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class OperationFactoryTests extends TestCase {

    public void testShouldCreateSubStringOperation() {
        // GIVEN factory and args with substing operation name
        String[] params = new String[]{ OperationFactory.OPERATION_SUBSTRING, "text", "2", "4" };
        // WHEN creating operation
        Operation operation = OperationFactory.create(params);
        // THEN substring operation created
        assertThat("operation should be a SubstringOperation", operation, is(instanceOf(SubstringOperation.class)));
    }

    public void testShouldThrowExWhenWrongOperationName() {
        // GIVEN factory and args with wrong operation name
        String[] params = new String[]{ "WrongOperationName", "text", "2", "4" };
        // WHEN creating operation
        Exception ex = null;
        try {
            Operation operation = OperationFactory.create(params);
        } catch (Exception e) {
            ex = e;
        }
        // THEN substring operation created
        assertThat("operation ", ex, is(anything()));
    }

}

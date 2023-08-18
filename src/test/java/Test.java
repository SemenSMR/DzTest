import org.example.Worker;
import org.junit.jupiter.api.Assertions;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class Test {
    @org.junit.jupiter.api.Test
    public void testConcat_validArgument_success() {
        // given:
        Worker.OnTaskDoneListener listener = mock(Worker.OnTaskDoneListener.class);
        Worker.OnTaskErrorListener errorListener = mock(Worker.OnTaskErrorListener.class);
        // when:
        Worker worker = new Worker(listener,errorListener);
        worker.start();
        // then:
        InOrder inOrder = inOrder(listener, errorListener);
        for (int i = 0; i < 100; i++) {
            if (i == 33) {
                inOrder.verify(errorListener).onError("Task " + i + " isNotDone");
            } else {
                inOrder.verify(listener).onDone("Task " + i + " isDone");
            }
        }
        verifyNoMoreInteractions(listener, errorListener);
    }
}

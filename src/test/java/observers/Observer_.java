package observers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class Observer_ {

    @Mock Observer1 observer1;
    @Mock Observer2 observer2;

    @Test
    public void when_add_one_single_item_observers_should_be_notified() throws Exception {
        ObservedClass observedClass = new ObservedClass();
        observedClass.addObserver(observer1);
        observedClass.addObserver(observer2);

        observedClass.change("A change");

        verify(observer1).update("A change");
        verify(observer2).update("A change");
    }
}

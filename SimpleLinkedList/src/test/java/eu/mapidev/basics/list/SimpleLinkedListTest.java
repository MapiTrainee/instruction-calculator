package eu.mapidev.basics.list;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

public class SimpleLinkedListTest {

    private SimpleLinkedList<Object> numbers;
    private SimpleLinkedList<Object> names;

    @Before
    public void setUp() {
	names = new SimpleLinkedList<>();
	numbers = new SimpleLinkedList<>();
    }

    @Test
    public void shouldAllowToCreateSimpleLinkedListWithIntegersAndStrings() {
	assertThat(names, notNullValue());
	assertThat(numbers, notNullValue());
    }

}

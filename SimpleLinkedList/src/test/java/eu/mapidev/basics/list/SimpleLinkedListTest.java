package eu.mapidev.basics.list;

import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class SimpleLinkedListTest {

    @Test
    public void shouldAllowToCreateAnEmptySimpleLinkedListForIntegersAndStrings() {
	List<String> names = new SimpleLinkedList<>();
	List<Integer> numbers = new SimpleLinkedList<>();

	assertThat(names, notNullValue());
	assertThat(numbers, notNullValue());
    }

    @Test
    public void emptyListShouldHaveZeroSize() {
	SimpleLinkedList<String> emptyList = new SimpleLinkedList<String>();
	assertThat(emptyList.size(), equalTo(0));
    }

}

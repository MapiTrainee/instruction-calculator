package eu.mapidev.basics.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.Matchers;
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

    @Test
    public void emptyListShouldReturnIsEmptyEqualTrue() {
	SimpleLinkedList<String> emptyList = new SimpleLinkedList<>();
	assertThat(emptyList.isEmpty(), is(true));
    }

    @Test
    public void shouldAllowToAddThreeElements() {
	SimpleLinkedList<String> list = new SimpleLinkedList<>();
	assertThat(list.add("First"), is(true));
	assertThat(list.add("Second"), is(true));
	assertThat(list.add("Third"), is(true));
	assertThat(list.isEmpty(), is(false));
	assertThat(list.size(), equalTo(3));
    }

    @Test
    public void shouldAllowAddNulls() {
	SimpleLinkedList<Object> list = new SimpleLinkedList<>();
	assertThat(list.add(null), is(true));
	assertThat(list.add(null), is(true));
	assertThat(list.add(null), is(true));
	assertThat(list.isEmpty(), is(false));
	assertThat(list.size(), equalTo(3));
    }

    @Test
    public void shouldAllowToIterateThroughEachElementOfList() {
	SimpleLinkedList<String> list = new SimpleLinkedList<>();
	list.add("First");
	list.add("Second");
	list.add("Third");

	Iterator<String> it = list.iterator();
	assertThat(it.next(), is("First"));
	assertThat(it.next(), is("Second"));
	assertThat(it.next(), is("Third"));
	for (String element : list) {
	    assertThat(element, Matchers.isIn(Arrays.asList("First", "Second", "Third")));
	}
    }

    @Test
    public void containsMethodShouldAllowToCheckIfThereIsItemInList() {
	SimpleLinkedList<String> list = new SimpleLinkedList<>();
	list.add("First");
	list.add("Second");
	list.add("Third");

	assertThat(list.contains("Second"), is(true));
	assertThat(list.contains("Fourth"), is(false));
    }

    /**
     * LEARNING TESTS
     */
    @Test
    public void originalLinkedListShouldAllowAddNulls() {
	LinkedList<String> list = new LinkedList<>();
	assertThat(list.add(null), is(true));
	assertThat(list.add(null), is(true));
	assertThat(list.add(null), is(true));
	assertThat(list.isEmpty(), is(false));
	assertThat(list.size(), equalTo(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void originalLinkedListShouldThrowExceptionWhenTryToGetElementWithNotExistingIndex() {
	List<String> list = new LinkedList<>();
	list.add("Fist");
	list.add("Second");
	list.add("Third");
	list.get(10);
    }

}

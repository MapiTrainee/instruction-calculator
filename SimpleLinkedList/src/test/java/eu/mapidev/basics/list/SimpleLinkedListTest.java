package eu.mapidev.basics.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.contains;
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
    public void shouldAllowToAddNulls() {
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

    @Test
    public void shouldAllowToGetElementByCorrectIndex() {
	SimpleLinkedList<String> list = new SimpleLinkedList<>();
	list.add("First");
	list.add("Second");
	list.add("Third");

	assertThat(list.get(0), is("First"));
	assertThat(list.get(2), is("Third"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenTryToGetElementByNotExistingIndex() {
	SimpleLinkedList<String> emptyList = new SimpleLinkedList<>();
	emptyList.get(2);
    }

    @Test
    public void clearedListShouldBeLikeAnEmptyList() {
	SimpleLinkedList<String> list = new SimpleLinkedList<>();
	list.add("First");
	list.add("Second");
	list.add("Third");
	list.clear();
	assertThat(list.isEmpty(), is(true));
	assertThat(list.size(), equalTo(0));
    }

    @Test
    public void shouldAllowToGetFirstAndLastElementOfTheList() {
	SimpleLinkedList<String> list = new SimpleLinkedList<>();
	list.add("First");
	list.add("Second");
	list.add("Third");
	assertThat(list.getFirst(), is("First"));
	assertThat(list.getLast(), is("Third"));
    }

    @Test(expected = NullPointerException.class)
    public void emptyLitsShouldThrowExceptionWhenTryToGetFirstOrLast() {
	SimpleLinkedList<String> emptyList = new SimpleLinkedList<>();
	emptyList.getFirst();
    }

    @Test
    public void shouldAllowToRemoveElementsInList() {
	List<String> list = new SimpleLinkedList<>();
	list.add("First");
	list.add("Second");
	list.add("Third");
	list.add("Fourth");

	boolean removed = list.remove("Second");
	assertThat(removed, is(true));
	assertThat(list.size(), equalTo(3));
	assertThat(list, contains("First", "Third", "Fourth"));

	removed = list.remove("Fourth");
	assertThat(removed, is(true));
	assertThat(list.size(), equalTo(2));
	assertThat(list, contains("First", "Third"));

	removed = list.remove("First");
	assertThat(removed, is(true));
	assertThat(list.size(), equalTo(1));
	assertThat(list, contains("Third"));
	
	removed = list.remove("Third");
	assertThat(removed, is(true));
	assertThat(list.size(), equalTo(0));
    }

    @Test
    public void shouldGetRemovedEqualToFalseWhenTryToRemoveNotExistingElement() {
	List<String> list = new SimpleLinkedList<>();
	list.add("First");
	list.add("Second");
	list.add("Third");
	boolean removed = list.remove("Fifth");
	assertThat(removed, is(false));
	assertThat(list.size(), equalTo(3));
	assertThat(list, contains("First", "Second", "Third"));
    }

    /**
     * LEARNING TESTS
     */
    @Test
    public void originalLinkedListShouldAllowToAddNulls() {
	LinkedList<String> originalList = new LinkedList<>();
	assertThat(originalList.add(null), is(true));
	assertThat(originalList.add(null), is(true));
	assertThat(originalList.add(null), is(true));
	assertThat(originalList.isEmpty(), is(false));
	assertThat(originalList.size(), equalTo(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void originalLinkedListShouldThrowExceptionWhenTryToGetElementWithNotExistingIndex() {
	List<String> originalList = new LinkedList<>();
	originalList.add("First");
	originalList.add("Second");
	originalList.add("Third");
	originalList.get(10);
    }

    @Test
    public void originalLinkedListShouldAllowToGetFirstAndLastElement() {
	LinkedList<String> originalList = new LinkedList<>();
	originalList.add("First");
	originalList.add("Second");
	originalList.add("Third");
	assertThat(originalList.getFirst(), is("First"));
	assertThat(originalList.getLast(), is("Third"));
    }

}

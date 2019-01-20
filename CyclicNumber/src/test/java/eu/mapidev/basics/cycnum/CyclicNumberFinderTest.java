package eu.mapidev.basics.cycnum;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

public class CyclicNumberFinderTest {

    private CyclicNumberFinder finder;
    private static final String CYCLIC_NUMBER = "142857";
    private static final String NOT_CYCLIC_NUMBER = "01231";

    @Before
    public void SetUp() {
	finder = new CyclicNumberFinder();
    }

    @Test
    public void shouldReturnTrueWhenIsCyclicNumber() {
	boolean cyclicNumber = finder.isCyclicNumber(CYCLIC_NUMBER);
	assertThat(cyclicNumber, is(true));
    }

    @Test
    public void shouldReturnFalseWhenIsNotCyclicNumber() {
	boolean cyclicNumber = finder.isCyclicNumber(NOT_CYCLIC_NUMBER);
	assertThat(cyclicNumber, is(false));
    }

}

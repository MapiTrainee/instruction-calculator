package eu.mapidev.basics.cycnum;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CyclicNumberFinderTest {

    private final static CyclicNumberFinder FINDER = new CyclicNumberFinder();

    private final String input;
    private final boolean cyclicNumber;

    static class CyclicNumberData {

	private final String input;
	private final boolean cyclicNumber;

	public CyclicNumberData(String input, boolean isCyclic) {
	    this.input = input;
	    this.cyclicNumber = isCyclic;
	}
    }

    @Parameterized.Parameters
    public static List<CyclicNumberData> data() {
	return Arrays.asList(
		new CyclicNumberData("333", false),
		new CyclicNumberData("142857", true),
		new CyclicNumberData("142856", false),
		new CyclicNumberData("076923", false),
		new CyclicNumberData("0588235294117647", true),
		new CyclicNumberData("052631578947368421", true),
		new CyclicNumberData("0434782608695652173913", true),
		new CyclicNumberData("0344827586206896551724137931", true),
		new CyclicNumberData("0212765957446808510638297872340425531914893617", true),
		new CyclicNumberData("0169491525423728813559322033898305084745762711864406779661", true),
		new CyclicNumberData("016393442622950819672131147540983606557377049180327868852459", true),
		new CyclicNumberData("010309278350515463917525773195876288659793814432989690721649484536082474226804123711340206185567", true)
	);
    }

    public CyclicNumberFinderTest(CyclicNumberData cyclicNumberData) {
	this.input = cyclicNumberData.input;
	this.cyclicNumber = cyclicNumberData.cyclicNumber;
    }

    @Test
    public void shouldTestSomeNumbers() {
	assertThat(FINDER.isCyclicNumber(input), is(cyclicNumber));
    }

}

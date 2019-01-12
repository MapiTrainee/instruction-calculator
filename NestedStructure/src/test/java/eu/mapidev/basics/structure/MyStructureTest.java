package eu.mapidev.basics.structure;

import java.util.Collections;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

public class MyStructureTest {

    public static final String DUMMY_CODE = "Code";
    public static final String DUMMY_RENDERER = "Renderer";

    private IMyStructure structure;
    private INode dummyNode;

    @Before
    public void setUp() {
	dummyNode = new INode() {
	    @Override
	    public String getCode() {
		return DUMMY_CODE;
	    }

	    @Override
	    public String getRenderer() {
		return DUMMY_RENDERER;
	    }
	};
	List<INode> nodes = Collections.singletonList(dummyNode);
	structure = new MyStructure(nodes);
    }

    @Test
    public void shouldBeAbleToFindByCodeWhenItUsesDummyCode() {
	//when
	INode actualNode = structure.findByCode(DUMMY_CODE);
	//then
	assertThat(actualNode, is(dummyNode));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenCannotFindByCode() {
	//when
	structure.findByCode(null);
    }

    @Test
    public void shouldBeAbleToFindByRendererWhenItUsesDummyRenderer() {
	//when
	INode actualNode = structure.findByRenderer(DUMMY_RENDERER);
	//then
	assertThat(actualNode, is(dummyNode));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenCannotFindByRender() {
	//when
	structure.findByRenderer(null);
    }

    @Test
    public void shouldReturnTheNumberOfNodes() {
	//when
	int count = structure.count();
	//then
	assertThat(count, is(1));
    }

}

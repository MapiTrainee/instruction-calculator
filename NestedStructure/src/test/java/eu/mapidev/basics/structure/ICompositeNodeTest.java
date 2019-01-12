package eu.mapidev.basics.structure;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

public class ICompositeNodeTest {

    private ICompositeNode compsiteNode;

    @Before
    public void setUp() {
	compsiteNode = new ICompositeNode() {
	    @Override
	    public List<INode> getNodes() {
		return Arrays.asList(new INode() {
		    @Override
		    public String getCode() {
			return "codeFirstNode";
		    }

		    @Override
		    public String getRenderer() {
			return "rendererFirstNode";
		    }
		}, new INode() {
		    @Override
		    public String getCode() {
			return "codeSecondNode";
		    }

		    @Override
		    public String getRenderer() {
			return "rendererSecondNode";
		    }
		});
	    }
	};
    }

    @Test
    public void compositeNodeShouldReturnConcatenatedCodeStringWhenGetCodeIsUsing() {
	//when
	String actulCode = compsiteNode.getCode();

	//then
	assertThat(actulCode, is(equalTo("codeFirstNodecodeSecondNode")));
    }
    
    @Test
    public void compositeNodeShouldReturnConcatenatedRenderStringWhenGetRendererIsUsing() {
	//when
	String actualRenderer = compsiteNode.getRenderer();

	//then
	assertThat(actualRenderer, is(equalTo("rendererFirstNoderendererSecondNode")));
    }

}

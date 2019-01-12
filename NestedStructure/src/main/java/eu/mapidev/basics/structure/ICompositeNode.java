package eu.mapidev.basics.structure;

import java.util.List;

interface ICompositeNode extends INode {

    List<INode> getNodes();

    @Override
    public default String getRenderer() {
	StringBuilder builder = new StringBuilder();
	for (INode node : getNodes()) {
	    builder.append(node.getRenderer());
	}
	return builder.toString();
    }

    @Override
    public default String getCode() {
	StringBuilder builder = new StringBuilder();
	for (INode node : getNodes()) {
	    builder.append(node.getCode());
	}
	return builder.toString();
    }

}

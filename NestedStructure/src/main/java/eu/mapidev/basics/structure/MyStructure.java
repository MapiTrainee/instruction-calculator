package eu.mapidev.basics.structure;

import java.util.List;

public class MyStructure implements IMyStructure {

    private List<INode> nodes;

    MyStructure(List<INode> nodes) {
	this.nodes = nodes;
    }

    @Override
    public INode findByCode(String code) {
	for (INode node : nodes) {
	    if (node.getCode().equals(code)) {
		return node;
	    }
	}
	throw new IllegalArgumentException("There is no this code: " + code);
    }

    @Override
    public INode findByRenderer(String renderer) {
	for (INode node : nodes) {
	    if (node.getRenderer().equals(renderer)) {
		return node;
	    }
	}
	throw new IllegalArgumentException("There is no this renderer: " + renderer);
    }

    @Override
    public int count() {
	return nodes.size();
    }
}

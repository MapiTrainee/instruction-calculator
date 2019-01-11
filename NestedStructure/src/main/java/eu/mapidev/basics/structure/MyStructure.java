package eu.mapidev.basics.structure;

import java.util.List;

public class MyStructure implements IMyStructure {

    private List<INode> nodes;

    @Override
    public INode findByCode(String code) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public INode findByRenderer(String renderer) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int count() {
	throw new UnsupportedOperationException("Not supported yet.");
    }
}

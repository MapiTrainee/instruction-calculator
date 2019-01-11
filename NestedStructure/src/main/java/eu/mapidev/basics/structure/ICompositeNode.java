package eu.mapidev.basics.structure;

import java.util.List;

interface ICompositeNode extends INode {

    List<INode> getNodes();
}

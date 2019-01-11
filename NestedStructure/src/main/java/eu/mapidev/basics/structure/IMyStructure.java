package eu.mapidev.basics.structure;

interface IMyStructure {

    INode findByCode(String code);

    INode findByRenderer(String renderer);

    int count();
}

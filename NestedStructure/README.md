# nested-structure

### Description
- A task from [samouczekprogramisty.pl](http://www.samouczekprogramisty.pl/samouczek-na-rozmowie-zagniezdzona-struktura/) called "Nested structure"

### Todo
- analyze the following code and implement methods: "findByCode, findByRenderer, count"  in the MyStructure class,
```
interface IMyStructure {
  // should return a node with the specified code or null
  INode findByCode(String code);
  // should return a node with the given renderer or null
  INode findByRenderer(String renderer);
  // should return the number of nodes
  int count();
}
 
public class MyStructure implements IMyStructure {
  private List<INode> nodes;
}
 
interface INode {
  String getCode();
  String getRenderer();
}
 
interface ICompositeNode extends INode {
  List<INode> getNodes();
}
```
- try to avoid duplication of code, 
- consider the ICompositeNode interface in the analysis and implementation.

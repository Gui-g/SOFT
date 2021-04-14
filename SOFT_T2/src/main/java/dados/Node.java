package dados;

import java.util.HashMap;
import java.util.Map;

public class Node {

  private String name;

  Map<Node, Integer> adjacentNodes = new HashMap<>();

  public void addDestination(Node destination, int distance) {
    adjacentNodes.put(destination, distance);
  }

  public Node(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Map<Node, Integer> getAdjacentNodes() {
    return adjacentNodes;
  }

  public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
    this.adjacentNodes = adjacentNodes;
  }

}

package dados;

import java.util.*;

public class Node {

  private String name;

  private List<Node> shortestPath = new LinkedList<>();

  private Integer distance = Integer.MAX_VALUE;

  Map<Node, Integer> adjacentNodes = new HashMap<>();

  public void addDestination(Node destination, int distance) {
    adjacentNodes.put(destination, distance);
  }

  public Node() {}
  public Node(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Node> getShortestPath() {
    return shortestPath;
  }

  public void setShortestPath(List<Node> shortestPath) {
    this.shortestPath = shortestPath;
  }

  public Integer getDistance() {
    return distance;
  }

  public void setDistance(Integer distance) {
    this.distance = distance;
  }

  public Map<Node, Integer> getAdjacentNodes() {
    return adjacentNodes;
  }

  public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
    this.adjacentNodes = adjacentNodes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Node)) return false;
    Node node = (Node) o;
    return getName().equals(node.getName()) && getShortestPath().equals(node.getShortestPath()) && getDistance().equals(node.getDistance()) && getAdjacentNodes().equals(node.getAdjacentNodes());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getShortestPath(), getDistance(), getAdjacentNodes());
  }
}

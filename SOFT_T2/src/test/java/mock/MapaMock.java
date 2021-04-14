package mock;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

public class MapaMock {

  public static SimpleWeightedGraph<String, DefaultWeightedEdge> get() {
    SimpleWeightedGraph<String, DefaultWeightedEdge> graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

    graph.addVertex("A");
    graph.addVertex("B");
    graph.addVertex("C");
    graph.addVertex("D");
    graph.addVertex("E");
    graph.addVertex("F");

    graph.addEdge("A", "B");
    graph.setEdgeWeight(graph.getEdge("A", "B"), 10);
    graph.addEdge("A", "C");
    graph.setEdgeWeight(graph.getEdge("A", "C"), 15);

    graph.addEdge("B", "D");
    graph.setEdgeWeight(graph.getEdge("B", "D"), 12);
    graph.addEdge("B", "F");
    graph.setEdgeWeight(graph.getEdge("B", "F"), 15);

    graph.addEdge("C", "E");
    graph.setEdgeWeight(graph.getEdge("C", "E"), 10);

    graph.addEdge("D", "E");
    graph.setEdgeWeight(graph.getEdge("D", "E"), 2);
    graph.addEdge("D", "F");
    graph.setEdgeWeight(graph.getEdge("D", "F"), 1);

    graph.addEdge("F", "E");
    graph.setEdgeWeight(graph.getEdge("F", "E"), 5);

    return graph;
  }

}

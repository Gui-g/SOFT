package logica;

import dados.Node;
import dados.Onibus;
import dados.Rota;
import dados.Usuario;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.YenKShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.*;
import java.util.Map.Entry;

public class Manager implements ManagerInterface {

  @Override
  public ArrayList<Rota> encontrarRotas(Node inicio, Node fim, SimpleWeightedGraph<String, DefaultWeightedEdge> grafo) {
    YenKShortestPath<String, DefaultWeightedEdge> inspector = new YenKShortestPath<>(grafo);
    List<GraphPath<String, DefaultWeightedEdge>> response = inspector.getPaths(inicio.getName(), fim.getName(), 2);

    ArrayList<Rota> routes = new ArrayList<>();
    ArrayList<Node> nodes;
    Map<String, Node> mapNodes = new LinkedHashMap<>();

    for (GraphPath<String, DefaultWeightedEdge> path : response) {
      nodes = new ArrayList<>();
      Rota route = new Rota();
      for (DefaultWeightedEdge edge : path.getEdgeList()) {
        String edgeSource = grafo.getEdgeSource(edge);
        String edgeTarget = grafo.getEdgeTarget(edge);

        if (Objects.isNull(mapNodes.get(edgeSource))) {
          Node source = new Node(edgeSource);
          mapNodes.put(edgeSource, source);
        }
        if (Objects.isNull(mapNodes.get(edgeTarget))) {
          Node target = new Node(edgeTarget);
          mapNodes.put(edgeTarget, target);
        }
        mapNodes.get(edgeSource).addDestination(mapNodes.get(edgeTarget), (int) grafo.getEdgeWeight(edge));
      }

      for (Entry<String, Node> entry : mapNodes.entrySet()) {
        Node node = entry.getValue();
        nodes.add(node);
      }

      mapNodes.clear();
      route.setPath(nodes);
      routes.add(route);
    }

    return routes;
  }

  @Override
  public Long calcularTempoRota(Rota rota) {

    Long time = 0L;
    for (Node node : rota.getPath()) {
      for (Entry<Node, Integer> entry : node.getAdjacentNodes().entrySet()) {
        time += entry.getValue();
      }
    }

    return time;
  }

  @Override
  public SimpleWeightedGraph<String, DefaultWeightedEdge> criarGrafo(List<Rota> rotas) {
    SimpleWeightedGraph<String, DefaultWeightedEdge> graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

    for (Rota rota : rotas) {
      for (Node node : rota.getPath()) {
        if (!graph.containsVertex(node.getName())) {
          graph.addVertex(node.getName());
          for (Entry<Node, Integer> nodeAdjNode : node.getAdjacentNodes().entrySet()) {
            Node next = nodeAdjNode.getKey();
            if (!graph.containsEdge(node.getName(), next.getName())) {
              if (!graph.containsVertex(next.getName()))
                graph.addVertex(next.getName());
              graph.addEdge(node.getName(), next.getName());
              graph.setEdgeWeight(graph.getEdge(node.getName(), next.getName()), nodeAdjNode.getValue());
            }
          }
        } else {
          for (Entry<Node, Integer> nodeAdjNode : node.getAdjacentNodes().entrySet()) {
            Node next = nodeAdjNode.getKey();
            if (!graph.containsEdge(node.getName(), next.getName())) {
              if (!graph.containsVertex(next.getName()))
                graph.addVertex(next.getName());
              graph.addEdge(node.getName(), next.getName());
              graph.setEdgeWeight(graph.getEdge(node.getName(), next.getName()), nodeAdjNode.getValue());
            }
          }
        }
      }
    }

    return graph;
  }

  @Override
  public Double depositarCredito(Usuario user, Double valor) {

    user.increaseCredit(valor);

    return user.getCredit();
  }

  @Override
  public Double pagarOnibus(Usuario user, Double valor) {

    user.payBus(valor);

    return user.getCredit();
  }

  @Override
  public ArrayList<Onibus> onibusRota(ArrayList<Onibus> list, Rota rota) {
    ArrayList<Onibus> onibusRota = new ArrayList<>();

    for (Onibus bus : list) {
      if (bus.getRoute().equals(rota))
        onibusRota.add(bus);
    }

    return onibusRota;
  }

}

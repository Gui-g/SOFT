
package logica;

import dados.Node;
import dados.Onibus;
import dados.Rota;

import java.util.*;

public class Manager implements ManagerInterface {

  @Override
  public ArrayList<Rota> encontrarRotas(Node inicio, Node fim, Set<Node> grafo) {
    return null;
  }

  @Override
  public Set<Node> criarGrafo(List<Rota> rotas) {

    Set<Node> graph = new HashSet<>();
    int set = 0;

    //get all nodes
    for(Rota rota : rotas) {
      for(Node node : rota.getPath()) {
        for(Node element : graph) {
          if(node.getName().equals(element.getName()))
            set = 1;
        }

        if(set == 0)
          graph.add(node);
        set = 0;
      }
    }

    //get all destinations
    for(Rota rota : rotas) {
      for(Node node : rota.getPath()) {
        for(Node element : graph) {
          for(Map.Entry<Node, Integer> elementAdjNode : element.getAdjacentNodes().entrySet()) {
            Node test = elementAdjNode.getKey();
            for(Map.Entry<Node, Integer> nodeAdjNode : node.getAdjacentNodes().entrySet()) {
              Node test2 = nodeAdjNode.getKey();
              if(test.getName().equals(test2.getName()))
                set = 1;
            }

            if(set == 0)

          }
        }
      }
    }

    return null;
  }

  @Override
  public Long calcularTempoRota(Rota rota) {
    return null;
  }

  @Override
  public Long calcularTempoOnibus(Onibus onibus, Node destino, Set<Node> grafo) {
    return null;
  }

}

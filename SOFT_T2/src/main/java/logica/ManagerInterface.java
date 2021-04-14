package logica;

import dados.Node;
import dados.Rota;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.ArrayList;
import java.util.List;

public interface ManagerInterface {

  ArrayList<Rota> encontrarRotas(Node inicio, Node fim, SimpleWeightedGraph<String, DefaultWeightedEdge> grafo);

  SimpleWeightedGraph<String, DefaultWeightedEdge> criarGrafo(List<Rota> rotas);

  Long calcularTempoRota(Rota rota);

}

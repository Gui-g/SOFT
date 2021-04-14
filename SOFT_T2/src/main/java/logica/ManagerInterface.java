package logica;

import dados.Node;
import dados.Onibus;
import dados.Rota;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface ManagerInterface {

  ArrayList<Rota> encontrarRotas(Node inicio, Node fim, Set<Node> grafo);

  Set<Node> criarGrafo(List<Rota> rotas);

  Long calcularTempoRota(Rota rota);

  Long calcularTempoOnibus(Onibus onibus, Node destino, Set<Node> grafo);

}

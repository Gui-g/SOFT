package mock;

import dados.Node;

import java.util.HashSet;
import java.util.Set;

public class MapaMock {

  public static Set<Node> get() {
    Set<Node> mapa = new HashSet<>();

    Node nodeA = new Node("A");
    Node nodeB = new Node("B");
    Node nodeC = new Node("C");
    Node nodeD = new Node("D");
    Node nodeE = new Node("E");
    Node nodeF = new Node("F");

    nodeA.addDestination(nodeB, 10);
    nodeA.addDestination(nodeC, 15);

    nodeB.addDestination(nodeD, 12);
    nodeB.addDestination(nodeF, 15);

    nodeC.addDestination(nodeE, 10);

    nodeD.addDestination(nodeE, 2);
    nodeD.addDestination(nodeF, 1);

    nodeF.addDestination(nodeE, 5);

    mapa.add(nodeA);
    mapa.add(nodeB);
    mapa.add(nodeC);
    mapa.add(nodeD);
    mapa.add(nodeE);
    mapa.add(nodeF);

    return mapa;
  }

}

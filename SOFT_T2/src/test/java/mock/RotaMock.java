package mock;

import dados.Node;
import dados.Rota;

import java.util.ArrayList;

public class RotaMock {

  public static Rota getA() {
    Rota route = new Rota();
    ArrayList<Node> nodes = new ArrayList<>();

    Node nodeA = new Node("A");
    nodes.add(nodeA);
    Node nodeB = new Node("B");
    nodes.add(nodeB);
    Node nodeD = new Node("D");
    nodes.add(nodeD);
    Node nodeF = new Node("F");
    nodes.add(nodeF);
    Node nodeE = new Node("E");
    nodes.add(nodeE);

    nodeA.addDestination(nodeB, 10);
    nodeB.addDestination(nodeD, 12);
    nodeD.addDestination(nodeF, 1);
    nodeF.addDestination(nodeE, 5);

    route.setPath(nodes);
    return route;
  }

  public static Rota getB() {
    Rota route = new Rota();
    ArrayList<Node> nodes = new ArrayList<>();

    Node nodeA = new Node("A");
    nodes.add(nodeA);
    Node nodeC = new Node("C");
    nodes.add(nodeC);
    Node nodeE = new Node("E");
    nodes.add(nodeE);

    nodeA.addDestination(nodeC, 15);
    nodeC.addDestination(nodeE, 15);

    route.setPath(nodes);
    return route;
  }

  public static Rota getC() {
    Rota route = new Rota();
    ArrayList<Node> nodes = new ArrayList<>();

    Node nodeA = new Node("A");
    nodes.add(nodeA);
    Node nodeB = new Node("B");
    nodes.add(nodeB);
    Node nodeF = new Node("F");
    nodes.add(nodeF);
    Node nodeE = new Node("E");
    nodes.add(nodeE);

    nodeA.addDestination(nodeB, 10);
    nodeB.addDestination(nodeF, 15);
    nodeF.addDestination(nodeE, 5);

    route.setPath(nodes);
    return route;
  }

  public static Rota getD() {
    Rota route = new Rota();
    ArrayList<Node> nodes = new ArrayList<>();

    Node nodeA = new Node("A");
    nodes.add(nodeA);
    Node nodeB = new Node("B");
    nodes.add(nodeB);
    Node nodeD = new Node("D");
    nodes.add(nodeD);
    Node nodeE = new Node("E");
    nodes.add(nodeE);

    nodeA.addDestination(nodeB, 10);
    nodeB.addDestination(nodeD, 15);
    nodeD.addDestination(nodeE, 2);

    route.setPath(nodes);
    return route;
  }
}

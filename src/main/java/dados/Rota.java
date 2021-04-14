package dados;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Rota {

  private ArrayList<Node> path;

  public Rota() {
  }

  public Rota(ArrayList<Node> path) {
    this.path = path;
  }

  public ArrayList<Node> getPath() {
    return path;
  }

  public void setPath(ArrayList<Node> path) {
    this.path = path;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Rota)) return false;
    Rota rota = (Rota) o;
    return rota.getPath().stream().map(Node::getName).collect(Collectors.toList()).equals(this.path.stream().map(Node::getName).collect(Collectors.toList()));
  }
}

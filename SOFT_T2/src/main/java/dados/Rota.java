package dados;

import java.util.ArrayList;

public class Rota {

  private ArrayList<Node> path;

  public Rota() {}

  public Rota(ArrayList<Node> path) {
    this.path = path;
  }

  public ArrayList<Node> getPath() {
    return path;
  }

  public void setPath(ArrayList<Node> path) {
    this.path = path;
  }
}

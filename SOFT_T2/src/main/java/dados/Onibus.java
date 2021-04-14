package dados;

public class Onibus {

  public Node currentStop;
  public Rota route;

  public Node getCurrentStop() {
    return currentStop;
  }

  public void setCurrentStop(Node currentStop) {
    this.currentStop = currentStop;
  }

  public Rota getRoute() {
    return route;
  }

  public void setRoute(Rota route) {
    this.route = route;
  }
}

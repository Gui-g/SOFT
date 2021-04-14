package dados;

import java.time.LocalTime;

public class Onibus {
    public int id;
    public Node currentStop;
    public Rota route;
    public int direction;

    public int getId() {
      return id;
    }
    public void setId(int id) {
      this.id = id;
    }
    public void setCurrentStop(Node nextStop) {
      this.currentStop = nextStop;
    }
    public Node getNextStop() {
      return currentStop;
    }
    public Rota getRoute() {
      return route;
    }
    public void setRoute(Rota route) {
      this.route = route;
    }
    public int getDirection() {
      return direction;
    }
    public void setDirection(int direction) {
      this.direction = direction;
    }

}

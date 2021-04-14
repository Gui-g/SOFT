package mock;

import dados.Node;
import dados.Onibus;
import dados.Rota;
import mock.RotaMock;

public class OnibusMock {

  public static Onibus get() {

    RotaMock rota = new RotaMock();
    Onibus bus = new Onibus();

    bus.setId(1);
    bus.setRoute(rota.getB());
    for(Node path : rota.getB().getPath()) {
      if(path.getName().equals("C"))
        bus.setCurrentStop(path);
    }
    bus.setDirection(1);

    return bus;
  }

}

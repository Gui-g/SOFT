package mock;

import dados.Onibus;
import dados.Rota;
import mock.RotaMock;

public class OnibusMock {

    public static Onibus getA() {

        Onibus bus = new Onibus();

        Rota rota = RotaMock.getA();
        bus.setRoute(rota);
        bus.setCurrentStop(rota.getPath().get(0));

        return bus;
    }

    public static Onibus getB() {

        Onibus bus = new Onibus();

        Rota rota = RotaMock.getB();
        bus.setRoute(rota);
        bus.setCurrentStop(rota.getPath().get(1));

        return bus;
    }

    public static Onibus getC() {

        Onibus bus = new Onibus();

        Rota rota = RotaMock.getC();
        bus.setRoute(rota);
        bus.setCurrentStop(rota.getPath().get(0));

        return bus;
    }

    public static Onibus getD() {

        Onibus bus = new Onibus();

        Rota rota = RotaMock.getD();
        bus.setRoute(rota);
        bus.setCurrentStop(rota.getPath().get(2));

        return bus;
    }

}

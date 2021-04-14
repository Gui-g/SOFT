package logica;

import dados.Node;
import dados.Onibus;
import dados.Rota;
import mock.MapaMock;
import mock.OnibusMock;
import mock.RotaMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ManagerTest {

  @InjectMocks
  private Manager manager;

  private Set<Node> grafo;
  ArrayList<Rota> rotas;
  private Rota rotaA;
  private Rota rotaB;
  private Onibus onibus;
  private Node inicio;
  private Node fim;

  @Before
  public void setUp() {
    grafo = MapaMock.get();
    rotaA = RotaMock.getA();
    rotaB = RotaMock.getB();
    onibus = OnibusMock.get();
    rotas.add(rotaA);
    rotas.add(rotaB);
    rotas.add(RotaMock.getC());
    rotas.add(RotaMock.getD());
    inicio = new Node("A");
    fim = new Node("E");
  }

  @Test
  public void encontrarRotas() {
    ArrayList<Rota> expected = new ArrayList<>();
    expected.add(rotaA);
    expected.add(rotaB);

    ArrayList<Rota> actual = manager.encontrarRotas(inicio, fim, grafo);

    assertEquals(expected, actual);
  }

  @Test
  public void criarGrafo() {
    Set<Node> expected = grafo;

    Set<Node> actual = manager.criarGrafo(rotas);

    assertEquals(expected, actual);
  }

  @Test
  public void calcularTempoRota() {
    Long expected = 28L;

    Long actual = manager.calcularTempoRota(rotaA);

    assertEquals(expected, actual);
  }

  @Test
  public void calcularTempoOnibus() {
    Long expected = 10L;

    Long actual = manager.calcularTempoOnibus(onibus, fim, grafo);

    assertEquals(expected, actual);
  }
}

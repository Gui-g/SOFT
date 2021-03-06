package logica;

import dados.Node;
import dados.Onibus;
import dados.Rota;
import dados.Usuario;
import mock.MapaMock;
import mock.OnibusMock;
import mock.RotaMock;
import mock.UsuarioMock;
import org.jgrapht.alg.isomorphism.VF2GraphIsomorphismInspector;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ManagerTest {

  @InjectMocks
  private Manager manager;

  private final SimpleWeightedGraph<String, DefaultWeightedEdge> grafo = MapaMock.get();
  private final Rota rotaA = RotaMock.getA();
  private final Rota rotaB = RotaMock.getB();
  private final Rota rotaC = RotaMock.getC();
  private final Rota rotaD = RotaMock.getD();
  private final Node inicio = new Node("A");
  private final Node fim = new Node("E");
  private final Usuario user = UsuarioMock.get();
  private final Onibus onibusA = OnibusMock.getA();
  private final Onibus onibusB = OnibusMock.getB();
  private final Onibus onibusC = OnibusMock.getC();
  private final Onibus onibusD = OnibusMock.getD();
  ArrayList<Rota> rotas;
  ArrayList<Onibus> onibus;

  @Before
  public void setUp() {
    rotas = new ArrayList<>();
    rotas.add(rotaA);
    rotas.add(rotaB);
    rotas.add(rotaC);
    rotas.add(rotaD);
    onibus = new ArrayList<>();
    onibus.add(onibusA);
    onibus.add(onibusB);
    onibus.add(onibusC);
    onibus.add(onibusD);
  }

  @Test
  public void encontrarRotas() {
    ArrayList<Rota> expected = new ArrayList<>();
    expected.add(rotaD);
    expected.add(rotaB);

    ArrayList<Rota> actual = manager.encontrarRotas(inicio, fim, grafo);

    assertEquals(expected, actual);
  }

  @Test
  public void criarGrafo() {
    SimpleWeightedGraph<String, DefaultWeightedEdge> actual = manager.criarGrafo(rotas);

    VF2GraphIsomorphismInspector<String, DefaultWeightedEdge> inspector = new VF2GraphIsomorphismInspector<>(grafo, actual);
    assertTrue(inspector.isomorphismExists());
  }

  @Test
  public void calcularTempoRota() {
    Long expected = 28L;

    Long actual = manager.calcularTempoRota(rotaA);

    assertEquals(expected, actual);
  }

  @Test
  public void depositarCredito() {
    Double expected = 550.0;

    Double actual = manager.depositarCredito(user, 50.0);

    assertEquals(expected, actual);
  }

  @Test
  public void pagarOnibus() {
    Double expected = 450.0;

    Double actual = manager.pagarOnibus(user, 50.0);

    assertEquals(expected, actual);
  }

  @Test
  public void onibusRota() {
    ArrayList<Onibus> expected = new ArrayList<>();
    expected.add(onibusA);

    ArrayList<Onibus> actual = manager.onibusRota(onibus, rotaA);

    assertEquals(expected, actual);
  }
}

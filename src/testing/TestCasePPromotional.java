package testing;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import proiect.Comanda;
import proiect.PachetPromotional;
import ItemiComanda.Produs;
import RaportComenzi.Raport;

public class TestCasePPromotional extends TestCase{

	private Raport  raport = null ; 
	private PachetPromotional p = null; 
	private Comanda noup = null; 
	private Comanda nou = null; 
	private Comanda comanda = null; 
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		raport = new Raport();
		p = new PachetPromotional();
		noup = p.PachetDietetic();
		nou = p.PachetDePost(); 
		comanda = new Comanda(1); 
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		raport  = null; 
		 
		
	}
	
@Test
	public void TestNumar()
{
    comanda.adaugaPachet(p);
    comanda.adaugaPachet(p);
    assertEquals(comanda.numarPachetePromotionale(),2);
}
	
 @Test
 public void testGetter(){

    Comanda nou  =  p.PachetDePost();
    assertEquals(nou.getNumarComanda(),2);
 } 
 
 @Test
 public void TestProdsIntegratCorect(){
    Comanda noup = p.PachetDietetic();
    List<Produs> produsepa= noup.getProduse();
    assertEquals(produsepa.get(0).nume(),"Mancare dietetica");
 }
 @Test
 public void TesPgetpret(){
	 Comanda noup = p.PachetDietetic();
	 List<Produs> produsepa= noup.getProduse(); 
    assertEquals(produsepa.get(0).pret(),43.23f,0.001);
 }
@Test 
  public void TestPgetnume(){
	
	 Comanda noup = p.PachetDietetic();
	 List<Produs> produsepa= noup.getProduse(); 
    assertEquals(produsepa.get(1).nume(), "Bautura dietetica"); 
  }
}

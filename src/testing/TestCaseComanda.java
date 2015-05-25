package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import proiect.Comanda;
import proiect.PachetPromotional;
import proiect.State;
import ItemiComanda.MancareDietetica;
import ItemiComanda.Produs;
import RaportComenzi.Raport;

public class TestCaseComanda  extends TestCase{
	private Comanda comanda = null ; 
	private PachetPromotional p = null; 
	@Before
	public void setUp() throws Exception {
		super.setUp();
		comanda= new Comanda(0);
		 p = new PachetPromotional();
		 
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		comanda = null; 
		 
		
	}
@Test
public void testState(){
	
	    State state = comanda.getState(); 
	    assertEquals(state, null);
	    comanda.anuleazaComanda(); 
	    assertNotNull(comanda.getState());
	    assertEquals(comanda.getState(), comanda.getNerealizata());
}

@Test
public void testCost(){
	comanda.adaugaProdus(new MancareDietetica());
    comanda.adaugaProdus(new MancareDietetica());
    assertEquals(comanda.costComanda(), 86.46f, 0.001);
    
}
@Test
public void testNR(){
	comanda.adaugaProdus(new MancareDietetica());
    comanda.adaugaProdus(new MancareDietetica());
    comanda.adaugaProdus(new MancareDietetica());
    comanda.adaugaProdus(new MancareDietetica());
	assertEquals(comanda.numarProduse(), 4);
}

@Test
public void testNRPP(){
	
	    comanda.setNumarComanda(2);
	    comanda.adaugaPachet(p);
	    comanda.adaugaPachet(p);
	    assertEquals(comanda.numarPachetePromotionale(),2);
	    
	
}

@Test
public void test(){
	Comanda nou  =  p.PachetDePost();
    assertEquals(nou.getNumarComanda(),2);
    Comanda noup = p.PachetDietetic();
    List<Produs> produsepa= noup.getProduse();
    assertEquals(produsepa.get(0).nume(),"Mancare dietetica");
    assertEquals(produsepa.get(0).pret(),43.23f,0.001);
    assertEquals(produsepa.get(1).nume(), "Bautura dietetica"); 
}



}

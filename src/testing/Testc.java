package testing;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ItemiComanda.MancareDietetica;
import RaportComenzi.Raport;
import proiect.Comanda;
import proiect.PachetPromotional;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;
public class Testc  extends TestCase{
	private Comanda comandaDeTest = null ; 
	private PachetPromotional p = null;
	private Raport r = null; 


	@Before
	public void setUp() throws Exception {
		super.setUp();
		comandaDeTest = new Comanda(0);
		p = new PachetPromotional(); 
		r = new Raport(); 
		 
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		comandaDeTest = null; 
		p = null ; 
		r = null ; 
		
	}

	@Test
	public void test() {
		comandaDeTest.adaugaProdus(new MancareDietetica());
	    comandaDeTest.adaugaProdus(new MancareDietetica());
	    
	   //Adaug doua produse. trebuie sa nu fie null
	    assertNotNull(comandaDeTest.getProduse());
	    assertEquals(comandaDeTest.costComanda(), 86.46f, 0.001);
	  
	}
	
	@Test
	
	public void testNumarProduse(){
		comandaDeTest.adaugaProdus(new MancareDietetica());
	    comandaDeTest.adaugaProdus(new MancareDietetica());
	    assertEquals(comandaDeTest.numarProduse(),2);
		 
	}
	@Test
	public void testSepoateAplicaReducereSiNumarComenziReduse(){
		Comanda promotionala = p.PachetCu5Produse(); 
	    promotionala.platesteComanda();
	    r.adaugaComanda(promotionala);
	    assertEquals(r.numarComenziReduse(), 1);
	    assertTrue(promotionala.sePoateAplicaReducere());
	}
	@Test
	
	public void testMock(){
		
		Comanda comandanew = mock(Comanda.class);
		when(comandanew.sePoateAplicaReducere()).thenReturn(true);
		when(comandanew.costComanda()).thenReturn(100.0f);
		when(comandanew.aplicaReducere()).thenReturn(85.0f);
		doThrow(new RuntimeException()).when(comandanew).platesteComanda();
		r.adaugaComanda(comandanew);
		assertEquals(r.numarComenziReduse(),1);
	}
	
	@Test
 
 public void testNrPachProm(){
	 	Comanda comandaprom = new Comanda(0);
		PachetPromotional comandanew = mock(PachetPromotional.class);
		when(comandanew.PachetCu5Produse()).thenReturn(comandaDeTest);
		comandaDeTest.platesteComanda();
		r.adaugaComanda(comandaDeTest);
	    assertEquals(comandaDeTest.numarProduse(),0);
	
	
		
	}

}

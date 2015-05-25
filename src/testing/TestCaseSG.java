package testing;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import ItemiComanda.BauturaDietetica;
import ItemiComanda.MancareDietetica;
import ItemiComanda.PutInBottle;
import proiect.Comanda;

public class TestCaseSG extends TestCase{
	private Comanda comandaDeTest = null ; 
	private MancareDietetica mancare = null ; 
	private BauturaDietetica bauturad = null;
	private PutInBottle bottle = null; 
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		comandaDeTest = new Comanda(0);
		mancare = new MancareDietetica();
		bauturad = new BauturaDietetica(); 
		bottle  = new PutInBottle(); 
		 
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		comandaDeTest = null; 
		mancare = null; 
		bauturad = null;
		bottle = null; 
		 
		
	}
	@Test
	public void testM(){
		assertEquals(mancare.nume(),"Mancare dietetica");
		assertEquals(mancare.pret(), 43.23f,0.001);
	}
	@Test
	public void testB(){
		 assertEquals(bauturad.nume(), "Bautura dietetica");
		 assertEquals(bauturad.pret(),10.4f, 0.001);
	}
	@Test
	public void testP(){
		assertEquals(bottle.pachet() ,"In sticla");
	}
	


}

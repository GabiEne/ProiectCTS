package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import RaportComenzi.Raport;
import proiect.Comanda;
import proiect.PachetPromotional;

public class TestCaseRaport  extends TestCase{
	
	private Raport  raport = null ; 
	private PachetPromotional p = null; 
	private Comanda noup = null; 
	private Comanda nou = null; 
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		raport = new Raport();
		p = new PachetPromotional();
		noup = p.PachetDietetic();
		nou = p.PachetDePost(); 
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		raport  = null; 
		 
		
	}
	
	@Test
	public void testNrc(){
		raport.adaugaComanda(nou); 
		raport.adaugaComanda(noup); 
		assertEquals(raport.numarTotalComenzi(), 0);
		//comenzile nu sunt platite
	
	}
	
	@Test 
	public void testNrc1(){
		nou.platesteComanda();
		noup.platesteComanda(); 
		raport.adaugaComanda(nou); 
		raport.adaugaComanda(noup); 
		assertEquals(raport.numarTotalComenzi(), 2);
	}
	
	@Test
	public void testSePoateAdauga(){
		noup.platesteComanda();
        assertTrue(raport.sePoateAdauga(noup));
        nou.anuleazaComanda(); 
        assertFalse(raport.sePoateAdauga(nou));
        
	}
	
	@Test
	public void  testSTC(){
		noup.platesteComanda();
		raport.adaugaComanda(noup); 
		assertEquals(raport.sumaTotalaComenzi(),43.23f+10.4f, 0.001 );
	}
	
	@Test
	public void testNCR(){
		   Comanda promotionala = p.PachetCu5Produse(); 
	       promotionala.platesteComanda();
	       raport.adaugaComanda(promotionala);
	       assertEquals(raport.numarComenziReduse(), 1);
	}
	
	@Test
	public void testSR(){
		Comanda promotionala = p.PachetCu5Produse(); 
		assertEquals(promotionala.aplicaReducere(),62.22f , 0.001);
	}
	
	@Test
	public void testNRPPV(){
		noup.platesteComanda();
		raport.adaugaComanda(noup); 
	    assertEquals(raport.numaraPachetePromotionaleVandute(), 1);
	}
	
	@Test
	public void testChckProfit(){
		noup.platesteComanda(); 
		nou.platesteComanda();
		raport.adaugaComanda(noup); 
        raport.adaugaComanda(nou); 
        Comanda promotionala = p.PachetCu5Produse(); 
        promotionala.platesteComanda();
        raport.adaugaComanda(promotionala);
        assertFalse(raport.checkProfit());
        
	}
	@Test
	public void testPromo(){
		Comanda promotionala = p.PachetCu5Produse();
        assertFalse(promotionala.estePachetPromotional());
        assertTrue(nou.estePachetPromotional()); 
        nou.platesteComanda();
        raport.adaugaComanda(nou);
        assertEquals(raport.numaraPachetePromotionaleVandute(), 1);
        
	}
	
	
}
package testing;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import RaportComenzi.Raport;
import proiect.Comanda;

public class TestMock  extends TestCase{
 
  private   Raport  raport = null;
  private Comanda comanda = null;
  private List<Comanda> comenzi = new ArrayList<Comanda>();
  
	@Before
	public void setUp() throws Exception {
			
	}
   
	@After
	public void tearDown() throws Exception {
		comanda = null; 
	}

	@Test
	public void test1() {
		Comanda comanda = mock(Comanda.class);
		
		Raport raport = new Raport();
		when(comanda.getNumarComanda()).thenReturn(2);
		doThrow(new RuntimeException()).when(comanda).platesteComanda();
		
		
		raport.adaugaComanda(comanda);
		assertEquals(comanda.getNumarComanda(),2);
		assertEquals(comanda.getState(), comanda.getRealizata());
		assertEquals(raport.numarTotalComenzi(),1);
		
	}


}




	


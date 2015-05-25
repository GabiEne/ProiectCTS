package testing;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import proiect.Comanda;

public class TestareCuFisText {

	static FileReader reader;
	static BufferedReader buffer;
	static String deCitit;
	static String numar, passcheck;
	static Comanda comanda;
	static int numberToconvert;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		try {
			reader = new FileReader("NumereComanda");
			buffer = new BufferedReader(reader);
		
	 		deCitit = null;
	 		StringBuffer string = new StringBuffer();
			while((deCitit = buffer.readLine())!=null && deCitit.length()!= 0){
				//deCitit = buffer.readLine();
				
				string.append(deCitit);
				string.append("\n");
				numar = deCitit.split(" ")[0];
			    numberToconvert =  Integer.parseInt(numar);
				//comanda.setNumarComanda(numberToconvert);
				
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	


	@After
	public void tearDown() throws Exception {
		reader.close();
		buffer.close();
	}

	@Test
	public void test() {
		Comanda comanda = new Comanda(0);
		comanda.setNumarComanda(numberToconvert);
		assertTrue(comanda.estePachetPromotional());
	}

}

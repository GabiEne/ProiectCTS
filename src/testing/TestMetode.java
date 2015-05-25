package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import proiect.Comanda;
import proiect.PachetPromotional;
import proiect.State;
import ItemiComanda.Bautura;
import ItemiComanda.BauturaDietetica;
import ItemiComanda.BauturaNormala;
import ItemiComanda.MancareDePost;
import ItemiComanda.MancareDietetica;
import ItemiComanda.Pachet;
import ItemiComanda.Produs;
import ItemiComanda.PutInBottle;
import ItemiComanda.PutInPack;
import RaportComenzi.Raport;

public class TestMetode {

@SuppressWarnings("deprecation")
@Test    
	public void test() {
	//Test No.1 ->
		MancareDietetica mancare = new MancareDietetica();  
		assertEquals(mancare.nume(),"Mancare dietetica");
		assertEquals(mancare.pret(), 43.23f,0.001);
	//Test No.2 ->
	    BauturaDietetica bauturad = new BauturaDietetica(); 
	    assertEquals(bauturad.nume(), "Bautura dietetica");
	    assertEquals(bauturad.pret(),10.4f, 0.001);
	//Test No.3 ->
	    BauturaNormala bauturan  = new BauturaNormala(); 
	    assertEquals(bauturan.nume(), "Bautura normala");
	    assertEquals(bauturan.pret(), 12.4f , 0.001);
	//Test No.4 ->
	    MancareDePost mancareP =  new MancareDePost(); 
	    assertEquals(mancareP.nume(), "Mancare de post"); 
	    assertEquals(mancareP.pret(), 23.6f, 0.001);
	//Test No.5 ->
	    PutInBottle bottle  = new PutInBottle(); 
	    assertEquals(bottle.pachet() ,"In sticla");
	//Test No.6 ->
	    PutInPack pack = new PutInPack(); 
	    assertEquals(pack.pachet(),"In cutie" );
	//Test No.7 ->
	    Comanda comanda = new Comanda(1); 
	    State state = comanda.getState(); 
	    assertEquals(state, null);
	    
	//Test No. 8 -> anulez comanda, implicit 
	                //statusul comenzii trebuie sa se schimbe, sa nu fie null
	    
	    comanda.anuleazaComanda(); 
	    assertNotNull(comanda.getState());
	    
	//Test No. 9 -> acum statusul 
	    			//comenzii trebuie sa fie acelasi cu statusul 
	    			//implicit pentru situatia de nerealizat
	    assertEquals(comanda.getState(), comanda.getNerealizata());
	    
	//Test No. 10 -> test pentru un getter al unui obiect Comanda
	    comanda.setNumarComanda(2);
	    assertEquals(comanda.getNumarComanda(),2);
	    
	//Test No. 11 - > test pentru metoda costComanda
	    comanda.adaugaProdus(new MancareDietetica());
	    comanda.adaugaProdus(new MancareDietetica());
	    assertEquals(comanda.costComanda(), 86.46f, 0.001);
	    
	//Test No. 12 -> test pentru metoda ce returneaza numarul de produse
	    assertEquals(comanda.numarProduse(), 2);
	    
	    
	//Test No. 13 -> test pentru metoda  ce verifica daca se poate aplica reducere
	    assertFalse(comanda.sePoateAplicaReducere());
	    
	//Test No. 14 -> test pentru metoda numarului de pachete promotionale dintr-o comanda
	    assertEquals(comanda.numarPachetePromotionale(), 0);
	    
	//Test no.15 - >adaug pachete promotionale si verific din nou; 
	    PachetPromotional  p = new PachetPromotional();
	    comanda.adaugaPachet(p);
	    comanda.adaugaPachet(p);
	    assertEquals(comanda.numarPachetePromotionale(),2);
	    
	//Test No.16 -> verific daca pentru un pachet promotional, return-ul este corect
	    Comanda nou  =  p.PachetDePost();
	    assertEquals(nou.getNumarComanda(),2);
	    
	 //Test No.17 -> verific daac pentru un pachet promotional de un anumit tip, produsele sunt cele incluse
	    Comanda noup = p.PachetDietetic();
	    List<Produs> produsepa= noup.getProduse();
	    assertEquals(produsepa.get(0).nume(),"Mancare dietetica");
	    
	//Test No 18 -> verific si daca pretul este cel setat pentru pachetul dietetic; 
	    assertEquals(produsepa.get(0).pret(),43.23f,0.001);
	 
	//Test No 19 ->verific daca cel de-al doilea produs din pachetul promotional este ce trebuie
	    assertEquals(produsepa.get(1).nume(), "Bautura dietetica"); 
	    
	//Test No. 20 -> test pentru nr total  al comenzilor
	    Raport raport = new Raport(); 
	    raport.adaugaComanda(noup);
	    raport.adaugaComanda(nou); //trebuie sa fie 0 pentru ca aceste valori nu au fost inca 
	    						//platite si nu se vor adauga in vector
	    assertEquals(raport.numarTotalComenzi(), 0);
	    
	 //Test No. 21 -> schimb statusul comenzilor, si verific daca se pot adauga 
        noup.platesteComanda();
        assertTrue(raport.sePoateAdauga(noup));
        nou.anuleazaComanda(); 
        assertFalse(raport.sePoateAdauga(nou));
        
     //Test No. 22 -> verific din nou numarul comenzilor din raport dupa ce stiu ca una trebuie sa fie adaugata, iar una nu 
        raport.adaugaComanda(noup); 
        raport.adaugaComanda(nou); //asta nu va fi adaugata deoarce a fost anulata
        assertEquals(raport.numarTotalComenzi(), 1);
     
    //Test No. 23 ->verific metoda pentru suma totala a comenzilor
        assertEquals(raport.sumaTotalaComenzi(),43.23f+10.4f, 0.001 );
        
    //Test No. 24-> test  metoda care intoarce numarul comenzilor pentru care s-a aplicat o reducere
       Comanda promotionala = p.PachetCu5Produse(); 
       promotionala.platesteComanda();
       raport.adaugaComanda(promotionala);
       assertEquals(raport.numarComenziReduse(), 1);
  
      
    //Test No.25 -> test metoda ce calculeaza suma noua pentru o comanda ce poate beneficia de o reducere
       assertEquals(promotionala.aplicaReducere(),62.22f , 0.001);
     
    //Test No. 26-> test metoda care numara numarul total de pachete speciale vandute luate dupa codul comenzii
       assertEquals(raport.numaraPachetePromotionaleVandute(), 1);
    
    //Test No. 27 -> verific daca metoda pentru profit este corecta
        assertFalse(raport.checkProfit());
        
    //Test No. 28 -> verific metoda care returneaza numarul de pachete promotionale dintr-o comanda; 
        List<PachetPromotional> pachetePromotionale = new ArrayList<PachetPromotional>();
        pachetePromotionale.add(p); 
        pachetePromotionale.add(p);
        pachetePromotionale.add(p); 
        pachetePromotionale.add(p );
        assertFalse(promotionala.estePachetPromotional());
        //comandaPromotionala nu este pachetPromotional, deoarece codul sau este 3; 
        
    //Test No 29. 
        assertTrue(nou.estePachetPromotional()); //in schimb asta trebuie sa fie pentru ca nou are codul 1
        
    //Test No 30 //trebuie sa dea 1 pentru ca isngura comanda care s-a vandut, achitat si cu codul 1 a fost nou
        assertEquals(raport.numaraPachetePromotionaleVandute(), 1);
        
	}


}

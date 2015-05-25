package proiect;

import RaportComenzi.Raport;
import StrategyPlatesteComanda.Card;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Comanda comanda =  new Comanda(3);
    
    
    PachetPromotional  p = new PachetPromotional();
    Comanda dietetic = p.PachetDietetic();	
    dietetic.veziProduse();
    System.out.println("Pret Comanda:" + dietetic.costComanda());
    comanda.setMod(new Card());
    comanda.plateste();
    comanda.platesteComanda();
    dietetic.platesteComanda();
    System.out.println(dietetic.sePoateAplicaReducere());
    System.out.println(comanda.getState());
   // comanda.anuleazaComanda();
    Raport raport  = new Raport();
    raport.adaugaComanda(comanda);
    raport.adaugaComanda(dietetic);
    raport.veziComenzile();
    System.out.println(raport.numaraPachetePromotionaleVandute());
	}
	
}

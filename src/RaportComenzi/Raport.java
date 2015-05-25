package RaportComenzi;

import java.util.ArrayList;
import java.util.List;

import ItemiComanda.Produs;
import proiect.Comanda;
import proiect.State;



public class Raport {
	 private List<Comanda> comenzi = new ArrayList<Comanda>();
	 private Comanda c; 
	 public Comanda getC() {
		return c;
	}

	public void setC(Comanda c) {
		this.c = c;
	}

	public boolean sePoateAdauga(Comanda c){
			if(c.getState() == c.getRealizata() ){
				return true; 
			}else
				return false; 
	 }
	 
	 public void adaugaComanda(Comanda c){
		 
		if (sePoateAdauga(c)){
			 comenzi.add(c);
		}
	 }
	 
	 public void veziComenzile(){
		 for(Comanda c : comenzi){
			 System.out.println(c.getNumarComanda());
		 }
	 }
	 
	 public float sumaTotalaComenzi(){
		 float sumaTotala = 0.0f ;
		 for(Comanda c: comenzi) {
			 sumaTotala = sumaTotala+ c.costComanda();
		 }
		 return sumaTotala;
		 
	 }
		
	 public int numaraPachetePromotionaleVandute(){
		 int nr =0 ;
		 for (Comanda c : comenzi){
			if (c.getNumarComanda() == 1  || c.getNumarComanda() == 2){
				nr ++ ; 
				
			}
			
		 }
		 return nr; 
	 }
	 
	 public int numarComenziReduse(){
		int nr = 0 ; 
		for(Comanda c :comenzi){
			if(c.sePoateAplicaReducere()){
				nr ++ ; 
			}
		}
		return nr;
	 }
	 
	 public int numarTotalComenzi(){
		 int nr = 0; 
		 for(Comanda c: comenzi){
			 nr++;
		 }
		 return nr; 
	 }
	 
	 
	 public boolean checkProfit(){
		 if(this.numarComenziReduse()   >=   this.numarTotalComenzi()/2){
			 return false;
		 }
			 else
				 return true; 
		 }
	 
	 
}


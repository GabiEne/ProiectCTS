package proiect;

import java.util.ArrayList;
import java.util.List;

import ItemiComanda.Produs;
import StrategyPlatesteComanda.ModPlata;

public class Comanda {

	  State realizata; 
	  State nerealizata; 
	  public int numarComanda;

	  public State getRealizata() {
			return realizata;
		}
	  public void setRealizata(State realizata) {
			this.realizata = realizata;
		}
	  public State getNerealizata() {
			return nerealizata;
		}
	  public void setNerealizata(State nerealizata) {
			this.nerealizata = nerealizata;
		}
	  public int getNumarComanda() {
			return numarComanda;
		}
	  public void setNumarComanda(int numarComanda) {
			this.numarComanda = numarComanda;
		}
	  public State getState() {
			return state;
		}
	  public void setState(State state) {
			this.state = state;
		}

	
 
  
  private List<Produs> produse = new ArrayList<Produs>();
  public List<Produs> getProduse() {
	return produse;
}
  public void setProduse(List<Produs> produse) {
	this.produse = produse;
}




private List<PachetPromotional> pachetePromotionale = new ArrayList<PachetPromotional>();
  
  public void adaugaProdus(Produs prod){
	  produse.add(prod);
  }
  
  public float costComanda(){
	  float pret = 0.0f;
	  
	  for(Produs prod : produse){
		  pret = pret + prod.pret();
	  }
	  return pret;
  }
  
  public int numarProduse(){
	 int  count = 0; 
	  for(Produs prod: produse){
		  count = count+1;
	  }
	  return count; 
  }
  
  public void veziProduse(){
	  for(Produs prod: produse){
		  System.out.println(prod.nume());
	  }
  }
  
  public boolean sePoateAplicaReducere(){
	  if(this.numarProduse() >= 5){
		  return true;
	  }
	  else
		  return false;
  }
  
  public float aplicaReducere(){
	  float costNou = 0.0f;
	  if(sePoateAplicaReducere()){
		  
		  costNou = this.costComanda() - 0.15f * this.costComanda();
	  }
		  return costNou;
	  
  }
  
  public boolean estePachetPromotional(){
	  if(this.numarComanda == 1  || this.numarComanda == 2){
		  return true;
	  }
	  else
	  {
		  return false; 
	  }
  }

  public void adaugaPachet(PachetPromotional p){
	  if(estePachetPromotional()){
		  
	 
	  pachetePromotionale.add(p);
	  }
  }
  public int numarPachetePromotionale(){
		 int  count = 0; 
		  for(PachetPromotional p: pachetePromotionale){
			  count = count+1;
		  }
		  return count; 
	  }
  
 

  
  public State state = realizata; 

  
  public Comanda(  int numarComanda){
	  realizata = new Realizata(this);
	  nerealizata = new Nerealizata(this);
	  this.numarComanda = numarComanda;
	  
	  if(this.costComanda() > 0 && this.numarProduse() >0 ){
		  	state = realizata;
	  }
  }
  
  public void platesteComanda(){
	  realizata.platesteComanda();;
	
  }
  
  public void anuleazaComanda(){
	  
	 nerealizata.anuleazaComanda();
	
  }
 //strategy;
  private ModPlata mod;
  public ModPlata getMod() {
	  
	return mod;
  }
public void setMod(ModPlata mod) {
	
	this.mod = mod;
	}

  public void plateste(){
	 
	mod.Plateste();
  }
}

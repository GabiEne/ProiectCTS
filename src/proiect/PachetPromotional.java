package proiect;

import ItemiComanda.Bautura;
import ItemiComanda.BauturaDietetica;
import ItemiComanda.BauturaNormala;
import ItemiComanda.Mancare;
import ItemiComanda.MancareDePost;
import ItemiComanda.MancareDietetica;

public class PachetPromotional {
 
	public Comanda PachetDietetic(){
		Comanda comanda = new Comanda(1);
		comanda.adaugaProdus( new MancareDietetica());
		comanda.adaugaProdus(new BauturaDietetica());
		return comanda; 
	}
	
	public Comanda PachetDePost(){
		Comanda comanda = new Comanda(2); 
		comanda.adaugaProdus(new MancareDePost());
		comanda.adaugaProdus(new BauturaNormala ());
		return comanda; 
	}
	public Comanda PachetCu5Produse(){
		Comanda comanda = new Comanda(3); 
		comanda.adaugaProdus(new MancareDePost()); 
		comanda.adaugaProdus(new BauturaNormala());
		comanda.adaugaProdus(new BauturaNormala());
		comanda.adaugaProdus(new BauturaNormala());
		comanda.adaugaProdus(new BauturaNormala());
		return comanda;
	}
}

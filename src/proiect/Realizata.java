package proiect;

public class Realizata implements State{
 Comanda comanda; 
	public Realizata(Comanda comanda){
		this.comanda = comanda;
	}
	@Override
	public void platesteComanda() {
		System.out.println("Comanda a fost platita");
		comanda.setState(comanda.getRealizata());
	}
	@Override
	public void anuleazaComanda() {
		// TODO Auto-generated method stub
		System.out.println("Comanda nu a fost anulata");
		comanda.setState(comanda.getNerealizata());
	}
}

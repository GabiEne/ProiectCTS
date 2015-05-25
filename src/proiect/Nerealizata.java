package proiect;

public class Nerealizata implements State {
    Comanda comanda;
    public Nerealizata(Comanda comanda){
    	this.comanda = comanda;
    }
	@Override
	public void platesteComanda() {
		// TODO Auto-generated method stub
		System.out.println("Trebuie sa platiti");
		//comanda.setState(comanda.getState());
		comanda.setState(comanda.getNerealizata());
	
	}
	@Override
	public void anuleazaComanda() {
		// TODO Auto-generated method stub
		System.out.println("Comanda a fost anulata");
		comanda.setState(comanda.getNerealizata());
	}

	

}

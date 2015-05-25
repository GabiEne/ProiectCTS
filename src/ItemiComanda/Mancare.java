package ItemiComanda;

public abstract class Mancare implements Produs {
	public Pachet pachet(){
		return new PutInPack();
	}
	public abstract float pret();
}

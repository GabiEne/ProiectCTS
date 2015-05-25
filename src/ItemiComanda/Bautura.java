package ItemiComanda;

public abstract class Bautura  implements Produs {
	
 public Pachet pachet(){
	 
	 return new PutInBottle();
 }
 

}

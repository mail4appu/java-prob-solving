package Hashing;

public class HashingObject {
	private String nativPlace;
	private String wrkingPlace;
	public String getNativPlace() {
		return nativPlace;
	}
	public void setNativPlace(String nativPlace) {
		this.nativPlace = nativPlace;
	}
	public String getWrkingPlace() {
		return wrkingPlace;
	}
	public void setWrkingPlace(String wrkingPlace) {
		this.wrkingPlace = wrkingPlace;
	}
	
	public boolean equals(Object o){
		HashingObject ho= (HashingObject)o;
		return ho.nativPlace.equals(this.nativPlace) &&  ho.wrkingPlace.equals(this.wrkingPlace);
	}
	public int hashcode(){
		return nativPlace.hashCode()+wrkingPlace.hashCode();
	}

}

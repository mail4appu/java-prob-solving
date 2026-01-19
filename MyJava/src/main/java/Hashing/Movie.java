package Hashing;

/**
 * @author apparao
 *  if two objects are same they must return the same values in hashcode() and equals method
	    i.e ob1 returns 1 in the hashcode() ob2 also should return 1 hashcode()
	    if ob1 returns true in equals() ob2 should also return true in equals()
	    @Override// dont over ride below two methods and see the difference in ouput
	    public boolean equals(Object o) { //here we can pass movie object directly
 */
public class Movie {
	private String name;
	private String  actor;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public int getReleaseYr() {
		return releaseYr;
	}

	public void setReleaseYr(int releaseYr) {
		this.releaseYr = releaseYr;
	}

	private int releaseYr;

	//if two objects are same they must return the same values in hashcode() and equals method
	//i.e ob1 returns 1 in the hashcode() ob2 also should return 1 hashcode()
	//if ob1 returns true in equals() ob2 should also return true in equals()
	//@Override// dont over ride below two methods and see the difference in ouput
	public boolean equals(Object o) { //here we can pass movie object directly
		Movie m = (Movie) o;
		return m.actor.equals(this.actor) && m.name.equals(this.name) && m.releaseYr == this.releaseYr;
	}

	@Override
	public int hashCode() {
		return actor.hashCode() + name.hashCode() + releaseYr;
	}
}

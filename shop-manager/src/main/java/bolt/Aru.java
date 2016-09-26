package bolt;

public abstract class Aru {
	private long vonalKod;
	private String gyarto;
	
	public Aru(long vonalKod, String gyarto) {
		super();
		this.vonalKod = vonalKod;
		this.gyarto = gyarto;
	}
	
	public long getVonalKod() {
		return vonalKod;
	}
	

	public String getGyarto() {
		return gyarto;
	}
}

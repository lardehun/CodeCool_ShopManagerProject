package bolt;

import java.util.Date;

public abstract class Elelmiszer {
	long vonalKod;
	String gyarto;
	Date szavatossagiIdo;
	
	public Elelmiszer(long vonalKod, String gyarto, Date szavatossagiIdo) {
		this.vonalKod = vonalKod;
		this.gyarto = gyarto;
		this.szavatossagiIdo = szavatossagiIdo;
	}

	public long getVonalKod() {
		return vonalKod;
	}
	
	public boolean joMeg() {
		Date today = new Date();
		if (today.after(szavatossagiIdo)) {
			return false;
		}
		return true;
	}

	public String getGyarto() {
		return gyarto;
	}

	public Date getSzavatossagiIdo() {
		return szavatossagiIdo;
	}

}

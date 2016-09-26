package bolt;

import java.util.Date;

public abstract class Elelmiszer extends Aru{

	private Date szavatossagiIdo;
	
	public Elelmiszer(long vonalKod, String gyarto, Date szavatossagiIdo) {
		super(vonalKod, gyarto);
		this.szavatossagiIdo = szavatossagiIdo;
	}
	
	public boolean joMeg() {
		Date today = new Date();
		if (today.after(szavatossagiIdo)) {
			return false;
		}
		return true;
	}

	public Date getSzavatossagiIdo() {
		return szavatossagiIdo;
	}
}

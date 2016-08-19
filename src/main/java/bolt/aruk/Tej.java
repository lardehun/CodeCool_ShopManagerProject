package bolt.aruk;

import java.util.Date;

import bolt.Elelmiszer;

public abstract class Tej extends Elelmiszer{
	long vonalKod;
	final int LITER = 0;
	final int FELLITER = 0;
	final int POHAR = 0;
	final double ZSIROS = 0.0;
	final double FELZSIROS = 0.0;
	int urtartalom;
	String gyarto;
	Date szavatossag;	
	double zsirtartalom;
	
	public Tej(long vonalKod,int urtartalom,String gyarto,Date szavatossag,double zsirtartalom) {
		super(vonalKod, gyarto, szavatossag);
		this.vonalKod = vonalKod;
		this.gyarto = gyarto;
		this.szavatossag = szavatossag;
		this.zsirtartalom = zsirtartalom;
		this.urtartalom = urtartalom;
	}
	
	public boolean joMeg() {
		Date today = new Date();
		if (today.after(szavatossag)) {
			return false;
		}
		return true;
	}

	public int getUrtartalom() {
		return urtartalom;
	}

	public String getGyarto() {
		return gyarto;
	}

	public Date getSzavatossag() {
		return szavatossag;
	}

	public double getZsirtartalom() {
		return zsirtartalom;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ürtartalom:");
		builder.append(urtartalom);
		builder.append(" Gyárto:");
		builder.append(gyarto);
		builder.append(" Szavatosság:");
		builder.append(szavatossag);
		builder.append(" Zsirtartalom:");
		builder.append(zsirtartalom);
		return builder.toString();
	}
}

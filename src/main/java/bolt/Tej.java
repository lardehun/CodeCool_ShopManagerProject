package bolt;

import java.util.Date;

public class Tej {
	long vonalKod;
	final int LITER;
	final int FELLITER;
	final int POHAR;
	final double ZSIROS;
	final double FELZSIROS;
	int urtartalom;
	String gyarto;
	Date szavatossag;	
	double zsirtartalom;
	long ar;
	
	public Tej(long vonalKod,int urtartalom,String gyarto,Date szavatossag,double zsirtartalom,long ar) {
		this.vonalKod = vonalKod;
		this.ar = ar;
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

	public long getAr() {
		return ar;
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
		builder.append(" Ár:");
		builder.append(ar);
		return builder.toString();
	}
}

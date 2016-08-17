package bolt;

import java.util.Date;

public class Tej {
	int urtartalom;
	String gyarto;
	Date szavatossag;	
	double zsirtartalom;
	long ar;
	
	public Tej(int urtartalom,String gyarto,Date szavatossag,double zsirtartalom,long ar) {
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
		builder.append("�rtartalom:");
		builder.append(urtartalom);
		builder.append(" Gy�rto:");
		builder.append(gyarto);
		builder.append(" Szavatoss�g:");
		builder.append(szavatossag);
		builder.append(" Zsirtartalom:");
		builder.append(zsirtartalom);
		builder.append(" �r:");
		builder.append(ar);
		return builder.toString();
	}
}

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

	public void setUrtartalom(int urtartalom) {
		this.urtartalom = urtartalom;
	}

	public String getGyarto() {
		return gyarto;
	}

	public void setGyarto(String gyarto) {
		this.gyarto = gyarto;
	}

	public Date getSzavatossag() {
		return szavatossag;
	}

	public void setSzavatossag(Date szavatossag) {
		this.szavatossag = szavatossag;
	}

	public double getZsirtartalom() {
		return zsirtartalom;
	}

	public void setZsirtartalom(double zsirtartalom) {
		this.zsirtartalom = zsirtartalom;
	}

	public long getAr() {
		return ar;
	}

	public void setAr(long ar) {
		this.ar = ar;
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

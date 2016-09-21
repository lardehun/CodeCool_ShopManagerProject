package bolt.aruk.tej;

import java.util.Date;

import bolt.Elelmiszer;

public abstract class Tej extends Elelmiszer{
	final int LITER = 1000;
	final int FELLITER = 500;
	final int POHAR = 300;
	final double ZSIROS = 2.5;
	final double FELZSIROS = 1.5;
	int urtartalom;
	double zsirtartalom;
	
	public Tej(long vonalKod,int urtartalom,String gyarto,Date szavatossag,double zsirtartalom) {
		super(vonalKod, gyarto, szavatossag);
		this.zsirtartalom = zsirtartalom;
		this.urtartalom = urtartalom;
	}

	public int getUrtartalom() {
		return urtartalom;
	}

	public double getZsirtartalom() {
		return zsirtartalom;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ürtartalom:");
		builder.append(urtartalom);
		builder.append(" Zsirtartalom:");
		builder.append(zsirtartalom);
		return builder.toString();
	}
}

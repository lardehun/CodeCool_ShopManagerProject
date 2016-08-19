package bolt;

import java.util.Hashtable;

import bolt.aruk.Tej;

public class Bolt {
	String nev;
	String cim;
	String tulajdonos;
	Hashtable<?, ?> elelmiszerPult;
	
	public Bolt(String nev, String cim, String tulajdonos, Hashtable<?, ?> elelmiszerPult) {
		this.nev = nev;
		this.cim = cim;
		this.tulajdonos = tulajdonos;
		this.elelmiszerPult = elelmiszerPult;
	}
	
	public Bolt(String nev, String cim, String tulajdonos) {
		this.nev = nev;
		this.cim = cim;
		this.tulajdonos = tulajdonos;
	}

	public String getNev() {
		return nev;
	}

	public String getCim() {
		return cim;
	}

	public String getTulajdonos() {
		return tulajdonos;
	}
	
	public boolean vanMegAdottAru(Class<?> o) {
		return false;
	}
	
	public boolean vanMegTej() {
		if (elelmiszerPult.isEmpty()) {
			return false;			
		}
		return true;
	}
	
	public void feltoltElelmiszerrel(long vonalKod,long mennyiseg) {
		
	}
	
	public void feltoltUjElelmiszerrel(Elelmiszer e, long mennyiseg,long ar) {
		
	}
	
	public void torolElelmiszer(long vonalKod) {
		
	}
	
	public void vasarolElelmiszer(long vonalKod,long mennyiseg) {
		
	}
	
	public class BoltBejegyzes{
		Elelmiszer e;
		int mennyiseg;
		int ar;
		
		public BoltBejegyzes(Elelmiszer e, int mennyiseg, int ar) {
			super();
			this.e = e;
			this.mennyiseg = mennyiseg;
			this.ar = ar;
		}

		public Elelmiszer getE() {
			return e;
		}

		public void setE(Elelmiszer e) {
			this.e = e;
		}

		public int getMennyiseg() {
			return mennyiseg;
		}

		public void setMennyiseg(int mennyiseg) {
			this.mennyiseg = mennyiseg;
		}

		public void adMennyiseg(int mennyiseg) {
			
		}
		
		public void levonMennyiseg(int mennyiseg) {
			
		}
		
		public int getAr() {
			return ar;
		}

		public void setAr(int ar) {
			this.ar = ar;
		}
	}
}

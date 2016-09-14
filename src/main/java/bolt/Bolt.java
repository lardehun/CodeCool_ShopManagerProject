package bolt;

import java.util.Hashtable;

import bolt.aruk.Tej;
import bolt.kivetel.NemLetezoAruKivetel;
import bolt.kivetel.TulSokLevonasKivetel;

public class Bolt {
	private String nev;
	private String cim;
	private String tulajdonos;
	private Hashtable<Long, BoltBejegyzes> elelmiszerPult;
	
	public Bolt(String nev, String cim, String tulajdonos, Hashtable<Long, BoltBejegyzes> elelmiszerPult) {
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
	
	public boolean vanMegadottAru(Class<?> o) {
		for (BoltBejegyzes aru : elelmiszerPult.values()) {
			if (o.isAssignableFrom(aru.getE().getClass())) {
				if (aru.getMennyiseg() > 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean vanMegTej() {
		return vanMegadottAru(Tej.class);
	}
	
	public void feltoltElelmiszerrel(long vonalKod,long mennyiseg) throws NemLetezoAruKivetel{
		if (elelmiszerPult.containsKey(vonalKod)) {
			BoltBejegyzes jegyzes = elelmiszerPult.get(vonalKod);
			jegyzes.adMennyiseg(mennyiseg);
		}
		else {
			throw new NemLetezoAruKivetel("Nincs áru ezzel a vonalkóddal: " + vonalKod);
		}
		
	}
	
	public void feltoltUjElelmiszerrel(Elelmiszer e, long mennyiseg,long ar) {
		BoltBejegyzes jegyzes = new BoltBejegyzes(e, mennyiseg, ar);
		elelmiszerPult.put(e.getVonalKod(), jegyzes);
		
	}
	
	public void torolElelmiszer(long vonalKod) throws NemLetezoAruKivetel{
		if (elelmiszerPult.containsKey(vonalKod)) {
			elelmiszerPult.remove(vonalKod);
		}
		else {
			throw new NemLetezoAruKivetel("Nincs áru ezzel a vonalkóddal: " + vonalKod);
		}
	}
	
	public void vasarolElelmiszer(long vonalKod,long mennyiseg)  throws NemLetezoAruKivetel,TulSokLevonasKivetel{
		
		if (elelmiszerPult.containsKey(vonalKod)) {
			BoltBejegyzes aru = elelmiszerPult.get(vonalKod);
			if (!(aru.getMennyiseg() < mennyiseg)) {
				aru.levonMennyiseg(mennyiseg);
			}
			else {
				throw new TulSokLevonasKivetel("Nincs ennyi áru készleten: " + mennyiseg);
			}
		}
		else {
			throw new NemLetezoAruKivetel("Nincs áru ezzel a vonalkóddal: " + vonalKod);
		}
	}
	
	
	public class BoltBejegyzes{
		private Elelmiszer e;
		private long mennyiseg;
		private long ar;
		
		public BoltBejegyzes(Elelmiszer e, long mennyiseg, long ar) {
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

		public long getMennyiseg() {
			return mennyiseg;
		}

		public void setMennyiseg(long mennyiseg) {
			this.mennyiseg = mennyiseg;
		}

		public void adMennyiseg(long mennyiseg) {
			this.mennyiseg += mennyiseg;
		}
		
		public void levonMennyiseg(long mennyiseg) {
			this.mennyiseg -= mennyiseg;
		}
		
		public long getAr() {
			return ar;
		}

		public void setAr(long ar) {
			this.ar = ar;
		}
	}
}

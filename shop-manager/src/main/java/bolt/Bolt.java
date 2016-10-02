package bolt;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import bolt.aruk.tej.Tej;
import bolt.kivetel.BoltKivetel;
import bolt.kivetel.NemLetezoAruKivetel;
import bolt.kivetel.TulSokLevonasKivetel;
import bolt.kivetel.ZarvaKivetel;
import log.BoltLogger;
import log.Logger;

public class Bolt implements Shop{
	private String nev;
	private String cim;
	private String tulajdonos;
	private Hashtable<Long, BoltBejegyzes> aruk = new Hashtable<Long, Bolt.BoltBejegyzes>();
	private boolean nyitva =true;
	BoltLogger logger;
	
	public Bolt(String nev, String cim, String tulajdonos, Hashtable<Long, BoltBejegyzes> elelmiszerPult) {
		this.nev = nev;
		this.cim = cim;
		this.tulajdonos = tulajdonos;
		this.aruk = elelmiszerPult;
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
	
	
	
	public void setElelmiszerPult(Hashtable<Long, BoltBejegyzes> elelmiszerPult) {
		this.aruk = elelmiszerPult;
	}

	public boolean vanMegadottAru(Class<?> o) throws ZarvaKivetel {
		if (nyitva) {
			for (BoltBejegyzes aru : aruk.values()) {
				if (o.isAssignableFrom(aru.getE().getClass())) {
					if (aru.getMennyiseg() > 0) {
						return true;
					}
				}
			}
			return false;
		}
		throw new ZarvaKivetel("A bolt zárva.");
	}
	
	public boolean vanMegTej() throws ZarvaKivetel {
		if (nyitva) {
			return vanMegadottAru(Tej.class);
		}
		throw new ZarvaKivetel("A bolt zárva.");
	}
	
	public void feltoltElelmiszerrel(long vonalKod,long mennyiseg) throws NemLetezoAruKivetel, ZarvaKivetel{
		if (nyitva) {
			logger.addAruFeltoltes("feltoltMeglevoElelmiszer-- " + "Vonalkod: " + vonalKod + " Mennyiseg" + mennyiseg);
			if (aruk.containsKey(vonalKod)) {
				BoltBejegyzes jegyzes = aruk.get(vonalKod);
				jegyzes.adMennyiseg(mennyiseg);
			}
			else {
				throw new NemLetezoAruKivetel("Nincs áru ezzel a vonalkóddal: " + vonalKod);
			}
		}
		else {
			throw new ZarvaKivetel("A bolt zárva.");
		}
	}
	
	public Hashtable<Long, BoltBejegyzes> getElelmiszerPult() {
		logger.addAruListaLekerdezese("Arulista lekerdezes.");
		return aruk;
	}

	public void feltoltUjElelmiszerrel(Elelmiszer e, long mennyiseg,long ar) throws ZarvaKivetel{
		if (nyitva) {
			logger.addAruFeltoltes("feltoltUjElelmiszer-- " + "Vonalkod: " + e.getVonalKod() + " Mennyiseg: " + mennyiseg + " Ar: "+ar);
			BoltBejegyzes jegyzes = new BoltBejegyzes(e, mennyiseg, ar);
			aruk.put(e.getVonalKod(), jegyzes);
		}
		else {
			throw new ZarvaKivetel("A bolt zárva.");
		}
	}
	
	public void torolElelmiszer(long vonalKod) throws NemLetezoAruKivetel, ZarvaKivetel{
		if (nyitva) {
			logger.addAruTorles("torolElelmiszer-- " + "Vonalkod: " + vonalKod);
			if (aruk.containsKey(vonalKod)) {
				aruk.remove(vonalKod);
			}
			else {
				throw new NemLetezoAruKivetel("Nincs áru ezzel a vonalkóddal: " + vonalKod);
			}
		}
		else {
			throw new ZarvaKivetel("A bolt zárva.");
		}
	}
	
	public void vasarolElelmiszer(long vonalKod,long mennyiseg)  throws NemLetezoAruKivetel,TulSokLevonasKivetel, ZarvaKivetel{
		if (nyitva) {
			logger.addVasarlas("vasarolElelmiszer-- " + "Vonalkod: " + vonalKod + " Mennyiseg" + mennyiseg);
			if (aruk.containsKey(vonalKod)) {
				BoltBejegyzes aru = aruk.get(vonalKod);
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
		else {
			throw new ZarvaKivetel("A bolt zárva.");
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
	
	public class AruIterator implements Iterator<Aru>{
		Iterator<Aru> i;
		
		public AruIterator(Iterator<Aru> i) {
			this.i = i;
		}

		public boolean hasNext() {
			if (i.hasNext()) {
				return true;
			}
			return false;
		}

		public Aru next() {
			Aru a = (Aru)i.next();
			return new Aru( a.getVonalKod(), a.getGyarto()){};
		}
		
		public void remove() {
			i.remove();
		}
		
	}

	public Iterator<Aru> aruk() throws ZarvaKivetel {
		if (nyitva) {
			ArrayList<Aru> aruList = new ArrayList<Aru>();
			for (BoltBejegyzes jegyzes : aruk.values()) {
				aruList.add(jegyzes.getE());
			}
			return aruList.iterator();
		}
		else{
			throw new ZarvaKivetel("A bolt zárva.");
		}
	}

	public void vasarol(Aru a, long mennyiseg) throws ZarvaKivetel {
		if (nyitva) {
			logger.addVasarlas("vasarolAru-- " + "Vonalkod: " + a.getVonalKod() + " Mennyiseg" + mennyiseg);
			try {
				vasarolElelmiszer(a.getVonalKod(), mennyiseg);
			} catch (BoltKivetel e) {
				e.printStackTrace();
			}
		}
		else {
			throw new ZarvaKivetel("A bolt zárva.");
		}
	}

	public void nyit() {
		nyitva = true;
		logger = new BoltLogger(new File("C:\\logging.txt"));
	}

	public void zar() {
		nyitva = false;
		logger.closeLogging();
	}

	public BoltLogger getLog() {
		return logger;
	}
}

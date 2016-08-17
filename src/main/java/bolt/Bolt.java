package bolt;

import java.util.Hashtable;

public class Bolt {
	String nev;
	String cim;
	String tulajdonos;
	Hashtable tejpult;
	int flag;
	
	public Bolt(String nev, String cim, String tulajdonos, Hashtable tejpult) {
		this.nev = nev;
		this.cim = cim;
		this.tulajdonos = tulajdonos;
		this.tejpult = tejpult;
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
	
	public boolean vanMegTej() {
		if (tejpult.isEmpty()) {
			return false;			
		}
		return true;
	}
	
	public Tej vasarolTej(long vonalKod) {
		return null;
	}
	
	public void name(Tej tej) {
		
	}
	
	

}

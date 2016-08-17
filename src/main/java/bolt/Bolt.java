package bolt;

public class Bolt {
	String nev;
	String cim;
	String tulajdonos;
	Tej[] tejpult;
	int flag;
	
	public Bolt(String nev, String cim, String tulajdonos, Tej[] tejpult) {
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
		if (tejpult.length > 0) {
			return true;			
		}
		return false;
	}
	
	public Tej vasarolTej(Tej tej) {
		return null;
	}
	
	public void name(Tej tej) {
		
	}
	
	

}

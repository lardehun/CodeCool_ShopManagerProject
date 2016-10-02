package bolt;

import java.util.Iterator;

import bolt.kivetel.ZarvaKivetel;
import log.BoltLogger;

public interface Shop {
	public Iterator<Aru> aruk() throws ZarvaKivetel;
	public void vasarol(Aru a,long mennyiseg) throws ZarvaKivetel;
	public String getNev();
	public String getCim();
	public String getTulajdonos();
	public void nyit();
	public void zar();
	public BoltLogger getLog();
}

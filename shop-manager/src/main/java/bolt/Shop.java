package bolt;

import java.io.File;
import java.util.Iterator;

import bolt.kivetel.ZarvaKivetel;

public interface Shop {
	public Iterator<Aru> aruk() throws ZarvaKivetel;
	public void vasarol(Aru a,long mennyiseg) throws ZarvaKivetel;
	public String getNev();
	public String getCim();
	public String getTulajdonos();
	public void nyit();
	public void zar();
	public File getLog();
}

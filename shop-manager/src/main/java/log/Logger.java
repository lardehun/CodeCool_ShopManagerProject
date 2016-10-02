package log;

public interface Logger {
	final int FELTOLTES = 0;
	final int TORLES = 1;
	final int VASARLAS = 2;
	final int ARULISTALEKERES = 3;
	
	public void addVasarlas(String info);
	public void addAruTorles(String info);
	public void addAruFeltoltes(String info);
	public void addAruListaLekerdezese(String info);
	public void closeLogging();
}

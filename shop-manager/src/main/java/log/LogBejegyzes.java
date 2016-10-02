package log;

import java.util.Date;

interface LogBejegyzes {
	public Date getDate();
	public String getLogInfo();
	public boolean isVasarlas();
	public boolean isFeltoltes();
	public boolean isAruTorles();
	public boolean isAruListaLekeres();
}

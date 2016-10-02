package log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class BoltLogger implements Log,Logger{
	Vector<LogBejegyzes> log;
	File f;
	
	public BoltLogger(File f) {
		super();
		this.f = f;
	}

	public InputStream getLogStream() {
		try {
			return new FileInputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Iterator<LogBejegyzes> getVasarlasok() {
		List<LogBejegyzes> list = new ArrayList<LogBejegyzes>();
		for (LogBejegyzes logBejegyzes : log) {
			if (logBejegyzes.isVasarlas()) {
				list.add(logBejegyzes);
			}
		}
		return list.iterator();
	}
	public Iterator<LogBejegyzes> getFeltoltesek() {
		List<LogBejegyzes> list = new ArrayList<LogBejegyzes>();
		for (LogBejegyzes logBejegyzes : log) {
			if (logBejegyzes.isFeltoltes()) {
				list.add(logBejegyzes);
			}
		}
		return list.iterator();
	}
	public Iterator<LogBejegyzes> getAruTorlesek() {
		List<LogBejegyzes> list = new ArrayList<LogBejegyzes>();
		for (LogBejegyzes logBejegyzes : log) {
			if (logBejegyzes.isAruTorles()) {
				list.add(logBejegyzes);
			}
		}
		return list.iterator();
	}
	public Iterator<LogBejegyzes> getAruListaLekeresek() {
		List<LogBejegyzes> list = new ArrayList<LogBejegyzes>();
		for (LogBejegyzes logBejegyzes : log) {
			if (logBejegyzes.isAruListaLekeres()) {
				list.add(logBejegyzes);
			}
		}
		return list.iterator();
	}
	public Iterator<LogBejegyzes> getTeljesNaplozas() {
		return log.iterator();
	}
	public LogBejegyzes[] getTeljesNaplozasAsArray() {
		return (LogBejegyzes[]) log.toArray();
	}
	
	public void addVasarlas(String info) {
		log.add(new BoltLogBejegyzes(VASARLAS, new Date(), info));
		
	}
	public void addAruTorles(String info) {
		log.add(new BoltLogBejegyzes(TORLES, new Date(), info));
	}
	public void addAruFeltoltes(String info) {
		log.add(new BoltLogBejegyzes(FELTOLTES, new Date(), info));		
	}
	public void addAruListaLekerdezese(String info) {
		log.add(new BoltLogBejegyzes(ARULISTALEKERES, new Date(), info));
	}
	public void closeLogging() {
		StringBuilder sBuilder = new StringBuilder();
		FileWriter writer = null;
		for (LogBejegyzes logBejegyzes : log) {
			sBuilder.append(logBejegyzes.toString());
			sBuilder.append("\n");
		}
		try {
			writer = new FileWriter(f);
			writer.write(sBuilder.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	class BoltLogBejegyzes implements LogBejegyzes{
		int code;
		Date datum;
		String logInfo;
		
		public BoltLogBejegyzes(int code, Date datum, String logInfo) {
			this.code = code;
			this.datum = datum;
			this.logInfo = logInfo;
		}

		public Date getDate() {
			return datum;
		}

		public String getLogInfo() {
			return logInfo;
		}

		public boolean isVasarlas() {
			return this.code == VASARLAS;
		}

		public boolean isFeltoltes() {
			return this.code == FELTOLTES;
		}

		public boolean isAruTorles() {
			return this.code == TORLES;
		}

		public boolean isAruListaLekeres() {
			return this.code == ARULISTALEKERES;
		}
		
		@Override
		public String toString() {
			return code + " " + datum.toString() + " " + logInfo;
		}	
	}
}

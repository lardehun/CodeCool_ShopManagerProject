package log;

import java.io.InputStream;
import java.util.Iterator;

interface Log {
	public InputStream getLogStream();
	public Iterator getVasarlasok();
	public Iterator getFeltoltesek();
	public Iterator getAruTorlesek();
	public Iterator getAruListaLekeresek();
	public Iterator getTeljesNaplozas();
	public LogBejegyzes[] getTeljesNaplozasAsArray();
}

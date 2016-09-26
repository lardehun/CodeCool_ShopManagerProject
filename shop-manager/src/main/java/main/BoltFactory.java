package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import bolt.Aru;
import bolt.aruk.tej.FeltartosTej;
import bolt.aruk.tej.Sajt;
import bolt.aruk.tej.Szappan;
import bolt.aruk.tej.TartosTej;

public class BoltFactory {
	public Aru getAru(String aruNeve) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date factoryDate = sdf.parse("2017/09/12");
		if (aruNeve == "TartosTej") {
			return new TartosTej(1L, 100, "FactoryGyarto", factoryDate,1.5);
		}
		else if (aruNeve == "FelTartosTej") {
			return new FeltartosTej(2L, 100, "FactoryGyarto", factoryDate,1.5);
		}
		else if (aruNeve == "Szappan"){
			return new Szappan(3L, "FactoryGyarto");
		}
		else if (aruNeve == "Sajt") {
			return new Sajt(4L, "FactoryGyarto", factoryDate);
		}
		return null;
	}
}

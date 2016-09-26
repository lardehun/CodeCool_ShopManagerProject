package tests;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import bolt.Elelmiszer;
import bolt.aruk.tej.FeltartosTej;

public class ElelmiszerTest {

	
	@Test
	public void testJoMeg_Input2017m9d12_returnTrue() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date testDate = sdf.parse("2017/09/12");
		Elelmiszer testElelmiszer = new FeltartosTej(1, 12, "Test", testDate, 1.2);
		assertTrue(testElelmiszer.joMeg());
	}
	
	@Test
	public void testJoMeg_Input2015m9d12_returnTrue() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date testDate = sdf.parse("2015/09/12");
		Elelmiszer testElelmiszer = new FeltartosTej(1, 12, "Test", testDate, 1.2);
		assertFalse(testElelmiszer.joMeg());
	}

}

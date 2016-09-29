package tests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import bolt.Bolt;
import bolt.Elelmiszer;
import bolt.aruk.tej.FeltartosTej;
import bolt.kivetel.NemLetezoAruKivetel;
import bolt.kivetel.TulSokLevonasKivetel;
import bolt.kivetel.ZarvaKivetel;

public class BoltTest {

	@Test
	public void testfeltoltUjElelmiszerrel_InputFeltartosTej_returnTrue() throws ZarvaKivetel {
		Bolt testBolt = new Bolt("test", "test", "test");
		Elelmiszer testElelmiszer = new FeltartosTej(1L, 12, "Test", new Date(), 1.2);
		testBolt.feltoltUjElelmiszerrel(testElelmiszer, 10L, 200L);
		assertTrue(testBolt.getElelmiszerPult().containsKey(1L));
	}
	
	@Test
	public void testVanMegadottAru_Input10FeltartosTej_returnTrue() throws ZarvaKivetel {
		Bolt testBolt = new Bolt("test", "test", "test");
		Elelmiszer testElelmiszer = new FeltartosTej(1L, 12, "Test", new Date(), 1.2);
		testBolt.feltoltUjElelmiszerrel(testElelmiszer, 10L, 200L);
		assertTrue(testBolt.vanMegadottAru(FeltartosTej.class));
	}
	
	@Test
	public void testVanMegadottAru_Input0FeltartosTej_returnFalse() throws ZarvaKivetel {
		Bolt testBolt = new Bolt("test", "test", "test");
		Elelmiszer testElelmiszer = new FeltartosTej(1L, 12, "Test", new Date(), 1.2);
		testBolt.feltoltUjElelmiszerrel(testElelmiszer, 0L, 200L);
		assertFalse(testBolt.vanMegadottAru(FeltartosTej.class));
	}
	
	@Test(expected=NemLetezoAruKivetel.class)
	public void testfeltoltElelmiszerrel_InputFeltartosTejThatNotInBolt_returnNemLetezoAruKivetel() throws NemLetezoAruKivetel, ZarvaKivetel {
		Bolt testBolt = new Bolt("test", "test", "test");
		testBolt.feltoltElelmiszerrel(1L, 12L);
	}
	
	@Test
	public void testfeltoltElelmiszerrel_InputFeltartosTejThatIntheBolt_returnTrue() throws NemLetezoAruKivetel, ZarvaKivetel {
		Bolt testBolt = new Bolt("test", "test", "test");
		Elelmiszer testElelmiszer = new FeltartosTej(1L, 12, "Test", new Date(), 1.2);
		testBolt.feltoltUjElelmiszerrel(testElelmiszer, 10L, 200L);
		testBolt.feltoltElelmiszerrel(1L, 12);
		assertEquals(22L, testBolt.getElelmiszerPult().get(1L).getMennyiseg());
	}
	
	@Test(expected=NemLetezoAruKivetel.class)
	public void testtorolElelmiszer_InputVonalkodThatNotInElelmiszerPult_returnNemLetezoAruKivetel() throws NemLetezoAruKivetel, ZarvaKivetel {
		Bolt testBolt = new Bolt("test", "test", "test");
		testBolt.torolElelmiszer(1L);
	}
	
	@Test
	public void testtorolElelmiszer_RemoveTestElelmiszer_returnFalse() throws NemLetezoAruKivetel, ZarvaKivetel {
		Bolt testBolt = new Bolt("test", "test", "test");
		Elelmiszer testElelmiszer = new FeltartosTej(1L, 12, "Test", new Date(), 1.2);
		testBolt.feltoltUjElelmiszerrel(testElelmiszer, 10L, 200L);
		testBolt.torolElelmiszer(1L);
		assertFalse(testBolt.getElelmiszerPult().containsKey(1L));
	}
	
	@Test
	public void testvasarolElelmiszer_Input10FeltartosTej_returnTrue() throws NemLetezoAruKivetel, TulSokLevonasKivetel, ZarvaKivetel {
		Bolt testBolt = new Bolt("test", "test", "test");
		Elelmiszer testElelmiszer = new FeltartosTej(1L, 12, "Test", new Date(), 1.2);
		testBolt.feltoltUjElelmiszerrel(testElelmiszer, 10L, 200L);
		testBolt.vasarolElelmiszer(1L, 5L);
		assertEquals(5L, testBolt.getElelmiszerPult().get(1L).getMennyiseg());
	}
	
	@Test(expected=NemLetezoAruKivetel.class)
	public void testvasarolElelmiszer_Input1FeltartosTej_returnNemLetezoAruKivetel() throws NemLetezoAruKivetel, TulSokLevonasKivetel, ZarvaKivetel {
		Bolt testBolt = new Bolt("test", "test", "test");
		testBolt.vasarolElelmiszer(1L, 5L);
	}
	
	@Test(expected=TulSokLevonasKivetel.class)
	public void testvasarolElelmiszer_Input10FeltartosTej_returnTulSokLevonasKivetel() throws NemLetezoAruKivetel, TulSokLevonasKivetel, ZarvaKivetel {
		Bolt testBolt = new Bolt("test", "test", "test");
		Elelmiszer testElelmiszer = new FeltartosTej(1L, 12, "Test", new Date(), 1.2);
		testBolt.feltoltUjElelmiszerrel(testElelmiszer, 10L, 200L);
		testBolt.vasarolElelmiszer(1L, 50L);
	}

}

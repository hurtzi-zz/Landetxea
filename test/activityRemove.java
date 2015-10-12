
import businessLogic.ApplicationFacadeInterface;
import businessLogic.FacadeImplementation;
import gui.Launcher;
import gui.StartWindow;

import java.rmi.RemoteException;
import java.util.Vector;

import dataAccess.DataAccessLocal;
import domain.Activity;
import domain.Client;
import domain.Owner;
import domain.RuralHouse;
import junit.framework.TestCase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 */
public class activityRemove extends TestCase {

	public static ApplicationFacadeInterface facade;
	int a = 0;

	public activityRemove(String TestName) {
		super(TestName);
	}

	protected void setUp() throws Exception {
		super.setUp();
		facade = new FacadeImplementation();

	}

	protected void tearDown() throws Exception {
		if (a == 1) {
			facade.close();
		}
		super.tearDown();
	}

	public void testRemove1() throws InterruptedException {
		try {
			facade.setDataAccess(new DataAccessLocal());
			Vector<RuralHouse> ruralFav = new Vector<RuralHouse>();
			// Vector<RuralHouse> ruralFav2 = new Vector<RuralHouse>();

			Owner oo = new Owner(123123123, "123123", ruralFav, "axi", "axi", "axi", "qqq", true, ruralFav);
			// Owner oo2 = new Owner(123123123, "123123", ruralFav, "boss",
			// "boss", "boss", "qqq", true, ruralFav2);
			Activity a = new Activity("a", "b", 3, true, oo);
			boolean erantzuna = facade.deleteActivity(a, oo);
			facade.close();
			// espero gaizki ematea, ez dagoelako gordeta.
			assertEquals(true, erantzuna);

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void testRemove2() throws InterruptedException {
		try {
			facade.setDataAccess(new DataAccessLocal());
			Vector<RuralHouse> ruralFav = new Vector<RuralHouse>();
			// Vector<RuralHouse> ruralFav2 = new Vector<RuralHouse>();

			Owner oo = new Owner(123123123, "123123", ruralFav, "axi", "axi", "axi", "qqq", true, ruralFav);

			boolean erantzuna = facade.deleteActivity(null, oo);
			facade.close();
			assertEquals(false, erantzuna);

		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testRemove3() throws InterruptedException {
		try {
			facade.setDataAccess(new DataAccessLocal());
			Vector<RuralHouse> ruralFav = new Vector<RuralHouse>();
			// Vector<RuralHouse> ruralFav2 = new Vector<RuralHouse>();

			Owner oo = new Owner(123123123, "123123", ruralFav, "axi", "axi", "axi", "qqq", true, ruralFav);
			// Owner oo2 = new Owner(123123123, "123123", ruralFav, "boss",
			// "boss", "boss", "qqq", true, ruralFav2);
			Activity a = new Activity("a", "b", 3, true, oo);
			boolean erantzuna = facade.deleteActivity(a, null);
			facade.close();
			assertEquals(false, erantzuna);

		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	// owner ezberdina
	public void testRemove4() throws InterruptedException {
		try {
			facade.setDataAccess(new DataAccessLocal());
			Vector<RuralHouse> ruralFav = new Vector<RuralHouse>();
			Vector<RuralHouse> ruralFav2 = new Vector<RuralHouse>();

			// Owner oo = new Owner(123123123, "123123", ruralFav, "axi", "axi",
			// "axi", "qqq", true, ruralFav);
			Owner oo2 = new Owner(123123123, "123123", ruralFav, "boss", "boss", "boss", "qqq", true, ruralFav2);
			Activity a = new Activity("a", "b", 3, true, oo2);
			boolean erantzuna = facade.deleteActivity(a, null);
			facade.close();
			assertEquals(false, erantzuna);

		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

}


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
public class activityTest extends TestCase {

	public static ApplicationFacadeInterface facade;
	int a = 0;

	public activityTest(String TestName) {
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

	public void testActivity1() throws InterruptedException {
		try {
			facade.setDataAccess(new DataAccessLocal());
			;
			Activity a = facade.sortuActivity("a", "b", 3, true, null);
			facade.close();
			assertEquals(null, a);

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void testActivity2() throws InterruptedException {
		try {
			facade.setDataAccess(new DataAccessLocal());
			Vector<RuralHouse> ruralFav = new Vector<RuralHouse>();
			Client c = new Client("q", "q", "q", "q", true, ruralFav);
			Owner oo = new Owner(123123123, "123123", ruralFav, "axi", "axi", "axi", "qqq", true, ruralFav);
			Activity a = new Activity("a", "b", 3, true, oo);
			RuralHouse rr = new RuralHouse();
			boolean bb = false;
			try {
				bb = facade.addActivity(a, rr);
			} catch (Exception e) {
				System.out.println("Errorea, ezin izan da landetxean activity-a sortu");
			}
			facade.close();
			assertEquals(false, bb);

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void testActivity3() throws InterruptedException {
		try {
			facade.setDataAccess(new DataAccessLocal());
			Vector<RuralHouse> ruralFav = new Vector<RuralHouse>();
			// Client c = new Client("q", "q", "q", "q", true, ruralFav);
			Owner oo = new Owner(123123123, "123123", ruralFav, "axi", "axi", "axi", "qqq", true, ruralFav);
			Activity a = new Activity("a", "b", 3, true, oo);

			facade.close();
			assertEquals(Activity.class, a.getClass());

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void testActivity4() throws InterruptedException {
		try {
			facade.setDataAccess(new DataAccessLocal());
			Vector<RuralHouse> ruralFav = new Vector<RuralHouse>();
			Client c = new Client("q", "q", "q", "q", true, ruralFav);
			Owner oo = new Owner(123123123, "123123", ruralFav, "axi", "axi", "axi", "qqq", true, ruralFav);
			Activity a = facade.sortuActivity("a", "b", 3, true, oo);
			facade.close();
			assertEquals(Activity.class, a.getClass());

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void testActivity5() throws InterruptedException {
		try {
			facade.setDataAccess(new DataAccessLocal());
			Vector<RuralHouse> ruralFav = new Vector<RuralHouse>();
			// Client c = new Client("q", "q", "q", "q", true, ruralFav);
			Owner oo = new Owner(123123123, "123123", ruralFav, "axi", "axi", "axi", "qqq", true, ruralFav);
			Activity a = new Activity("a", "b", 3, true, oo);
			RuralHouse rr = new RuralHouse();
			boolean bb = false;
			try {
				bb = facade.addActivity(a, rr);
			} catch (Exception e) {
			}
			facade.close();
			assertEquals(false, bb);

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	public void testActivity6() throws InterruptedException {
		try {
			facade.setDataAccess(new DataAccessLocal());
			Vector<RuralHouse> ruralFav = new Vector<RuralHouse>();
			// Client c = new Client("q", "q", "q", "q", true, ruralFav);
			Owner oo = new Owner(123123123, "123123", ruralFav, "axi", "axi", "axi", "qqq", true, ruralFav);
			Activity a = new Activity("a", "b", 3, true, oo);
			RuralHouse rr = new RuralHouse();
			boolean bb = false;
			try {
				bb = facade.addActivity(null, rr);
			} catch (Exception e) {
			}
			facade.close();
			assertEquals(false, bb);

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}

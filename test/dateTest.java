package Tests;

import businessLogic.ApplicationFacadeInterface;
import businessLogic.FacadeImplementation;
import gui.Launcher;
import gui.StartWindow;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.Vector;

import dataAccess.DataAccessLocal;
import domain.Activity;
import domain.Client;
import domain.Offer;
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
public class dateTest extends TestCase {

    public static ApplicationFacadeInterface facade;
    int a = 0;

    public dateTest(String TestName) {
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

    public void testDate1() throws InterruptedException {
        try {
            facade.setDataAccess(new DataAccessLocal());
            Date today = new Date();
            System.out.println(today);
      
            Date bat = new Date();
            bat.setYear(2015);
            bat.setMonth(11);
            bat.setDate(15);
            Date bi = new Date();
            bi.setYear(2015);
            bi.setMonth(12);
            bi.setDate(15);
            
            	Vector<Offer> v =facade.getOffers(bat, bi);
            
            facade.close();
            assertEquals(Vector.class, v.getClass());

        } catch (RemoteException e) {
            e.printStackTrace();
        } 
    }
    public void testDate2() throws InterruptedException {
    	 try {
             facade.setDataAccess(new DataAccessLocal());
             Date bat = null;
             Date bi = new Date(11/12/2015);

             	Vector<Offer> v =facade.getOffers(bat, bi);
             
             facade.close();
             assertEquals(null, v);

         } catch (RemoteException e) {
             e.printStackTrace();
         } 
     }
    public void testDate3() throws InterruptedException {
    	try {
            facade.setDataAccess(new DataAccessLocal());
            Date bat = new Date(11/12/2015);
            Date bi = null;

            	Vector<Offer> v =facade.getOffers(bat, bi);
            
            facade.close();
            assertEquals(null, v);

        } catch (RemoteException e) {
            e.printStackTrace();
        } 
    }
    public void testDate4() throws InterruptedException {
        try {
        	facade.setDataAccess(new DataAccessLocal());
            Date bat = new Date(11/11/2014);
            Date bi = new Date(11/12/2015);
          
            	Vector<Offer> v =facade.getOffers(bat, bi);
            	Date today = new Date();
            System.out.println(today.before(bat));
            facade.close();
            assertEquals(null,v);

        } catch (RemoteException e) {
            e.printStackTrace();
        } 
    }
    public void testDate() throws InterruptedException {
        try {
        	facade.setDataAccess(new DataAccessLocal());
            Date bat = new Date(11/11/2015);
            Date bi = new Date(11/12/2014);

            	Vector<Offer> v =facade.getOffers(bat, bi);
            
            facade.close();
            assertEquals(null,v);

        } catch (RemoteException e) {
            e.printStackTrace();
        } 
    }
    public void testDate7() throws InterruptedException {
        try {
        	facade.setDataAccess(new DataAccessLocal());
            Date bat = new Date(11/11/2010);
            Date bi = new Date(11/12/2012);

            	Vector<Offer> v =facade.getOffers(bat, bi);
            
            facade.close();
            assertEquals(null,v);

        } catch (RemoteException e) {
            e.printStackTrace();
        } 
    }
}

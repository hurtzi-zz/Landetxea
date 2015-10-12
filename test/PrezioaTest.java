import businessLogic.ApplicationFacadeInterface;
import businessLogic.FacadeImplementation;
import dataAccess.DataAccessLocal;
import domain.Owner;
import domain.RuralHouse;
import gui.Register;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.Vector;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author itziiiiii
 */
public class PrezioaTest extends TestCase {
    
    public static ApplicationFacadeInterface facade;
    //private RuralHouse rh1;
    //private Date d1, d2;
   // private Float f1;
    

    public PrezioaTest(String testName) {
        super(testName);
    }

    @Override
    //exekututauko den testa baino lehen nahi duzuna (hasieratu bista kasu honetan)
    protected void setUp() throws Exception {
        super.setUp();
        facade = new FacadeImplementation();

       
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testCreateGui1() throws InterruptedException, Exception {
        try {//onartuko duen login bat.
            facade.setDataAccess(new DataAccessLocal());
            Date d1 = new Date();
            Date d2 = new Date();
            Vector<RuralHouse> vec = facade.SarchByOwner("ow");
            //nteger tlfn, String bankAccount,Vector<RuralHouse> ruralHousesBektorea,String name, String abizena, String login, String password,Boolean isOwner, Vector<RuralHouse> ruralFav
            Owner ow = new Owner(858558,"8585858585858",vec,"ow","ow","ow","ow",true,vec);
            RuralHouse rh = new RuralHouse (1,ow,"", "yguy");
            boolean b = facade.saveOffer(rh, d1, d2, 9999f);
            System.out.println(b);
            facade.close();
            assertEquals(true, b);
           
 
        } catch (RemoteException e) {
            e.printStackTrace();
        } 
    }
    
     public void testCreateGui2() throws InterruptedException, Exception {
        try {//onartuko duen login bat.
            facade.setDataAccess(new DataAccessLocal());
            Date d1 = new Date();
            Date d2 = new Date();
            Vector<RuralHouse> vec = facade.SarchByOwner("ow");
            //nteger tlfn, String bankAccount,Vector<RuralHouse> ruralHousesBektorea,String name, String abizena, String login, String password,Boolean isOwner, Vector<RuralHouse> ruralFav
            Owner ow = new Owner(858558,"8585858585858",vec,"ow","ow","ow","ow",true,vec);
            RuralHouse rh = new RuralHouse (1,ow,"", "yguy");
            boolean b = facade.saveOffer(rh, d1, d2, 7898558f);
            System.out.println(b);
            facade.close();
            assertEquals(false, b);
           
 
        } catch (RemoteException e) {
            e.printStackTrace();
        } 
    }
    
     public void testCreateGui3() throws InterruptedException, Exception {
        try {//onartuko duen login bat.
            facade.setDataAccess(new DataAccessLocal());
            Date d1 = new Date();
            Date d2 = new Date();
            Vector<RuralHouse> vec = facade.SarchByOwner("ow");
            //nteger tlfn, String bankAccount,Vector<RuralHouse> ruralHousesBektorea,String name, String abizena, String login, String password,Boolean isOwner, Vector<RuralHouse> ruralFav
            Owner ow = new Owner(858558,"8585858585858",vec,"ow","ow","ow","ow",true,vec);
            RuralHouse rh = new RuralHouse (1,ow,"", "yguy");
            boolean b = facade.saveOffer(rh, d1, d2, 0f);
            System.out.println(b);
            facade.close();
            assertEquals(false, b);
           
 
        } catch (RemoteException e) {
            e.printStackTrace();
        } 
    }
}
    
    


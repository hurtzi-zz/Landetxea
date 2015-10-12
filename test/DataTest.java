import businessLogic.ApplicationFacadeInterface;
import businessLogic.FacadeImplementation;
import dataAccess.DataAccessLocal;
import domain.Owner;
import domain.RuralHouse;
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
public class DataTest extends TestCase {

    public static ApplicationFacadeInterface facade;

    public DataTest(String testName) {
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

    public void testCreateGui1() throws InterruptedException, RemoteException, Exception {
        try {
            facade.setDataAccess(new DataAccessLocal());
            Date d1 = new Date();
            Date gaur = new Date(d1.getYear(), d1.getMonth(), d1.getDate());
            gaur.setHours(23);
            Date d2 = new Date();
            d2.after(gaur);
            Vector<RuralHouse> vec = facade.SarchByOwner("ow");
            //nteger tlfn, String bankAccount,Vector<RuralHouse> ruralHousesBektorea,String name, String abizena, String login, String password,Boolean isOwner, Vector<RuralHouse> ruralFav
            Owner ow = new Owner(858558, "8585858585858", vec, "ow", "ow", "ow", "ow", true, vec);
            RuralHouse rh = new RuralHouse(1, ow, "", "yguy");
            boolean b = facade.saveOffer(rh, d1, d2, 9999f);
            System.out.println(b);
            facade.close();
            assertEquals(true, b);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    public void testCreateGui2() throws InterruptedException, RemoteException, Exception {
        try {
            facade.setDataAccess(new DataAccessLocal());
            Date d1 = new Date();
            Date gaur = new Date(d1.getYear(), d1.getMonth(), d1.getDate());
            gaur.setHours(23);
            Date d2 = new Date();
            d2.equals(gaur);
            Vector<RuralHouse> vec = facade.SarchByOwner("ow");
            //nteger tlfn, String bankAccount,Vector<RuralHouse> ruralHousesBektorea,String name, String abizena, String login, String password,Boolean isOwner, Vector<RuralHouse> ruralFav
            Owner ow = new Owner(858558, "8585858585858", vec, "ow", "ow", "ow", "ow", true, vec);
            RuralHouse rh = new RuralHouse(1, ow, "", "yguy");
            boolean b = facade.saveOffer(rh, d1, d2, 9999f);
            System.out.println(b);
            facade.close();
            assertEquals(false, b);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    public void testCreateGui3() throws InterruptedException, RemoteException, Exception {
        try {
            facade.setDataAccess(new DataAccessLocal());
            Date d1 = new Date();
            Date gaur = new Date(d1.getYear(), d1.getMonth(), d1.getDate());
            gaur.setHours(23);
            Date d2 = new Date();
            d2.before(gaur);
            Vector<RuralHouse> vec = facade.SarchByOwner("ow");
            //nteger tlfn, String bankAccount,Vector<RuralHouse> ruralHousesBektorea,String name, String abizena, String login, String password,Boolean isOwner, Vector<RuralHouse> ruralFav
            Owner ow = new Owner(858558, "8585858585858", vec, "ow", "ow", "ow", "ow", true, vec);
            RuralHouse rh = new RuralHouse(1, ow, "", "yguy");
            boolean b = facade.saveOffer(rh, d1, d2, 9999f);
            System.out.println(b);
            facade.close();
            assertEquals(false, b);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}

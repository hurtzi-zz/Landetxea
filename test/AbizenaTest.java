import junit.framework.TestCase;
import businessLogic.*;
import domain.RuralHouse;
import gui.StartWindow;
import gui.*;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.Vector;
import businessLogic.ApplicationFacadeInterface;
import dataAccess.*;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import domain.Owner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static junit.framework.Assert.assertEquals;


public class AbizenaTest extends TestCase {

    public static ApplicationFacadeInterface facade;
    Register register;

    public AbizenaTest(String testName) {
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

    /*
     * ondo daudenak--> true bueltatu
     */
    //(1) ez zenbakirik - (3) karektere bat izan behar du (alfabetikoa) - (5)ez hitz erreserbatua - (7) karaktere kop >=1
    public void testCreateGui1() throws InterruptedException {
        try {
            facade.setDataAccess(new DataAccessLocal());
            boolean buelta = facade.createOwner(123456789, "12345678912365478910", "izena", "aBizena", "owner", "000");
            facade.close();
            assertEquals(true, buelta);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * gaizki daudenak--> true bueltatu
     */
    //(2)  >=1 integer&float
    public void testCreateGui2() throws InterruptedException {
        try {
            facade.setDataAccess(new DataAccessLocal());
            boolean buelta = facade.createOwner(123456789, "12345678912365478910", "izena", "i2.0zena1", "owner", "000");
            facade.close();
            assertEquals(false, buelta);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //(4)  ez du karaktere (alfabetikoa) bat bera ere ez 

    public void testCreateGui3() throws InterruptedException {
        try {
            facade.setDataAccess(new DataAccessLocal());
            boolean buelta = facade.createOwner(123456789, "12345678912365478910","izena", "*", "owner", "000");
            facade.close();
            assertEquals(false, buelta);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
public void testCreateGui4() throws InterruptedException {
        try {
            facade.setDataAccess(new DataAccessLocal());
            boolean buelta0 = facade.createOwner(123456789, "12345678912365478910", "izena", "true", "owner", "000");
            boolean buelta1 = facade.createOwner(123456789, "12345678912365478910", "izena", "false", "owner", "000");
            boolean buelta2 = facade.createOwner(123456789, "12345678912365478910", "izena", "null", "owner", "000");
            boolean buelta3 = facade.createOwner(123456789, "12345678912365478910", "izena", "abstract", "owner", "000");
            boolean buelta4 = facade.createOwner(123456789, "12345678912365478910", "izena", "byte", "owner", "000");
            boolean buelta5 = facade.createOwner(123456789, "12345678912365478910", "izena", "implements", "owner", "000");
            boolean buelta6 = facade.createOwner(123456789, "12345678912365478910", "izena", "public", "owner", "000");
            boolean buelta7 = facade.createOwner(123456789, "12345678912365478910", "izena", "while", "owner", "000");
            boolean buelta8 = facade.createOwner(123456789, "12345678912365478910", "izena", "this", "owner", "000");
            boolean buelta9 = facade.createOwner(123456789, "12345678912365478910", "izena", "super", "owner", "000");
            boolean buelta10 = facade.createOwner(123456789, "12345678912365478910", "izena", "long", "owner", "000");
            boolean buelta11 = facade.createOwner(123456789, "12345678912365478910", "izena", "class", "owner", "000");
            facade.close();
            assertEquals(false, buelta0);
            assertEquals(false, buelta1);
            assertEquals(false, buelta2);
            assertEquals(false, buelta3);
            assertEquals(false, buelta4);
            assertEquals(false, buelta5);
            assertEquals(false, buelta6);
            assertEquals(false, buelta7);
            assertEquals(false, buelta8);
            assertEquals(false, buelta9);
            assertEquals(false, buelta10);
            assertEquals(false, buelta11);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //(8)  karaktere kop <1
    public void testCreateGui5() throws InterruptedException {
        try {
            facade.setDataAccess(new DataAccessLocal());
            boolean buelta = facade.createOwner(123456789, "12345678912365478910","abizena", "", "owner", "000");
            facade.close();
            assertEquals(false, buelta);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



     
     


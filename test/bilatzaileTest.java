
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

/**
 *
 * @author Urtzi * TELEFONOAREN-aren proba kasuak
 *
 */
public class bilatzaileTest extends TestCase {

    public static ApplicationFacadeInterface facade;
    Register register;

    public bilatzaileTest(String testSearch) {
        super(testSearch);
    }

    @Override
    //exekututauko den testa baino lehen nahi duzuna (hasieratu bista kasu honetan)
    protected void setUp() throws Exception {
        super.setUp();
        facade = new FacadeImplementation();

        //--register = new Register();
        // register.addWindowListener(new WindowCloseManager());
        // register.pack();
        //--register.setVisible(true);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

///*
//* ondo daudenak--> true bueltatu
//*/
    // (1) ez zenbakirik - (3) karektere bat izan behar du (alfabetikoa)
    // (7) ez hitz erreserbatua - (9)karaktere kop >=1 - (11) latra  larrria = letra xehea
    public void testCreateGui1() throws InterruptedException {
        try {
            facade.setDataAccess(new DataAccessLocal());
            Vector<RuralHouse> buelta = facade.SarchByCity("Gasteiz");
            facade.close();
            assertEquals(true, buelta.isEmpty() == false);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//(5) "all" karaktere segida
    public void testCreateGui4() throws InterruptedException {
        try {
            facade.setDataAccess(new DataAccessLocal());
            Vector<RuralHouse> buelta = facade.SarchByCity("all");
            facade.close();
            assertEquals(true, buelta.isEmpty() == false);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

///*
//* gaizki daudenak--> false bueltatu
//*/
    //(2)   >=1 integer&float
    public void testCreateGui2() throws InterruptedException {
        try {
            facade.setDataAccess(new DataAccessLocal());
            Vector<RuralHouse> buelta = facade.SarchByCity("Gasteiz1");
            facade.close();
            assertEquals(false, buelta.isEmpty() == false);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //(4)   >=1 ez du karaktere (alfabetikoa) bat bera ere ez 
    public void testCreateGui3() throws InterruptedException {
        try {
            facade.setDataAccess(new DataAccessLocal());
            Vector<RuralHouse> buelta = facade.SarchByCity("#+/*");
            facade.close();
            assertEquals(false, buelta.isEmpty() == false);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //(6)   "alla" karaktere segida   "lla" karaktere segida
    public void testCreateGui5() throws InterruptedException {
        try {
            facade.setDataAccess(new DataAccessLocal());
            Vector<RuralHouse> buelta = facade.SarchByCity("alla");
            Vector<RuralHouse> buelta2 = facade.SarchByCity("lla");
            facade.close();
            assertEquals(false, buelta.isEmpty() == false);
            assertEquals(false, buelta2.isEmpty() == false);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //(5)   latra  larrria != letra xehea
    public void testCreateGui6() throws InterruptedException {
        try {
            facade.setDataAccess(new DataAccessLocal());
            Vector<RuralHouse> buelta0 = facade.SarchByCity("true");
            Vector<RuralHouse> buelta1 = facade.SarchByCity("false");
            Vector<RuralHouse> buelta2 = facade.SarchByCity("null");
            Vector<RuralHouse> buelta3 = facade.SarchByCity("abstract");
            Vector<RuralHouse> buelta4 = facade.SarchByCity("byte");
            Vector<RuralHouse> buelta5 = facade.SarchByCity("implements");
            Vector<RuralHouse> buelta6 = facade.SarchByCity("public");
            Vector<RuralHouse> buelta7 = facade.SarchByCity("while");
            Vector<RuralHouse> buelta8 = facade.SarchByCity("this");
            Vector<RuralHouse> buelta9 = facade.SarchByCity("super");
            Vector<RuralHouse> buelta10 = facade.SarchByCity("long");
            Vector<RuralHouse> buelta11 = facade.SarchByCity("class");
            facade.close();
            assertEquals(false, buelta0.isEmpty() == false);
            assertEquals(false, buelta1.isEmpty() == false);
            assertEquals(false, buelta2.isEmpty() == false);
            assertEquals(false, buelta3.isEmpty() == false);
            assertEquals(false, buelta4.isEmpty() == false);
            assertEquals(false, buelta5.isEmpty() == false);
            assertEquals(false, buelta6.isEmpty() == false);
            assertEquals(false, buelta7.isEmpty() == false);
            assertEquals(false, buelta8.isEmpty() == false);
            assertEquals(false, buelta9.isEmpty() == false);
            assertEquals(false, buelta10.isEmpty() == false);
            assertEquals(false, buelta11.isEmpty() == false);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //(6)  karaktere kop <1
    public void testCreateGui7() throws InterruptedException {
        try {
            facade.setDataAccess(new DataAccessLocal());
            Vector<RuralHouse> buelta = facade.SarchByCity("");
            facade.close();
            assertEquals(false, buelta.isEmpty() == false);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //(12)   latra  larrria != letra xehea
    public void testCreateGui8() throws InterruptedException {
        try {
            facade.setDataAccess(new DataAccessLocal());
            Vector<RuralHouse> buelta = facade.SarchByCity("gasteiz");
            facade.close();
            assertEquals(true, buelta.isEmpty() == false);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * BESTE
     */
    private static void createGui(JPanel contents, String windowName) {
        JFrame frame = new JFrame(windowName);
        frame.getContentPane().add(contents);
        frame.addWindowListener(new WindowCloseManager());
        frame.pack();
        frame.setVisible(true);
    }

    private static class WindowCloseManager extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent evt) {
            System.exit(0);
        }
    }
}

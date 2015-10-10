//
//import junit.framework.TestCase;
//import businessLogic.*;
//import domain.RuralHouse;
//import gui.StartWindow;
//import gui.*;
//import java.rmi.RemoteException;
//import java.util.Iterator;
//import java.util.Vector;
//import businessLogic.ApplicationFacadeInterface;
//import dataAccess.*;
//import com.db4o.ObjectContainer;
//import com.db4o.ObjectSet;
//import domain.Owner;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import static junit.framework.Assert.assertEquals;
//
///**
// *
// * @author Urtzi * TELEFONOAREN-aren proba kasuak
// *
// */
//public class kontuaTest extends TestCase {
//
//    public static ApplicationFacadeInterface facade;
//    Register register;
//
//    public kontuaTest(String testSearch) {
//        super(testSearch);
//    }
//
//    @Override
//    //exekututauko den testa baino lehen nahi duzuna (hasieratu bista kasu honetan)
//    protected void setUp() throws Exception {
//        super.setUp();
//        facade = new FacadeImplementation();
//
//        //--register = new Register();
//        // register.addWindowListener(new WindowCloseManager());
//        // register.pack();
//        //--register.setVisible(true);
//    }
//
//    @Override
//    protected void tearDown() throws Exception {
//        super.tearDown();
//    }
//
//    /*
//     * ondo daudenak--> true bueltatu
//     */
//    //(1) 20 digitu kop - (4) karaktere berezirik gabe - (11) karaktere alfabetikorik ez - (13) hutsik ez
//    public void testCreateGui1() throws InterruptedException {
//        try {
//            facade.setDataAccess(new DataAccessLocal());
//            boolean buelta = facade.createOwner(123456789, "12345678912365478910", "Owner", "Altuna", "owner", "000");
//            facade.close();
//            assertEquals(true, buelta);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    //(6) gidoirik gabe mugetan eta 3 tartean
//    public void testCreateGui5() throws InterruptedException {
//        try {
//            facade.setDataAccess(new DataAccessLocal());
//            boolean buelta = facade.createOwner(123456789, "4443-1444-20-8234567890", "Owner", "Altuna", "owner", "000");
//            facade.close();
//            assertEquals(true, buelta);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /*
//     * gaizki daudenak--> true bueltatu
//     */
//    //(2) 20 digitu baino gutxiago
//    public void testCreateGui2() throws InterruptedException {
//        try {
//            facade.setDataAccess(new DataAccessLocal());
//            boolean buelta = facade.createOwner(123456789, "2145678", "Owner", "Altuna", "owner", "000");
//            facade.close();
//            assertEquals(false, buelta);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    //(3) 20 digitu baino gehiago
//    public void testCreateGui3() throws InterruptedException {
//        try {
//            facade.setDataAccess(new DataAccessLocal());
//            boolean buelta = facade.createOwner(123456789, "9202149955595755448732145678", "Owner", "Altuna", "owner", "000");
//            facade.close();
//            assertEquals(false, buelta);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    //(5) karakter bereziak (ikurrak, sinboloak...)
//    public void testCreateGui4() throws InterruptedException {
//        try {
//            facade.setDataAccess(new DataAccessLocal());
//            boolean buelta = facade.createOwner(123456789, "2021499553¬¬2145678@", "Owner", "Altuna", "owner", "000");
//            facade.close();
//            assertEquals(false, buelta);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    //(7) gidoia hasieran - (8)gidoia amaieran - (9)>3 gidoio tartean - (10)<2 gidoio tartean
//    public void testCreateGui6() throws InterruptedException {
//        try {
//            facade.setDataAccess(new DataAccessLocal());
//            boolean buelta0 = facade.createOwner(123456789, "-44431444-20-8234567890", "Owner", "Altuna", "owner", "000");
//            boolean buelta1 = facade.createOwner(123456789, "4443-1444-20-8234567890-", "Owner", "Altuna", "owner", "000");
//            boolean buelta2 = facade.createOwner(123456789, "-4443-1444-20-8234-567890", "Owner", "Altuna", "owner", "000");
//            boolean buelta3 = facade.createOwner(123456789, "44431444-20-8234567890", "Owner", "Altuna", "owner", "000");
//            facade.close();
//            assertEquals(false, buelta0);
//            assertEquals(false, buelta1);
//            assertEquals(false, buelta2);
//            assertEquals(false, buelta3);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    //(12) karaktere alfabetikoekin
//
//    public void testCreateGui7() throws InterruptedException {
//        try {
//            facade.setDataAccess(new DataAccessLocal());
//            boolean buelta = facade.createOwner(123456789, "12345a7893r2f5478910", "Owner", "Altuna", "owner", "000");
//            boolean buelta2 = facade.createOwner(123456789, "4443-1e44-20-82s45678g0", "Owner", "Altuna", "owner", "000");
//            facade.close();
//            assertEquals(false, buelta);
//            assertEquals(false, buelta2);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    //(14) hutsik
//    public void testCreateGui8() throws InterruptedException {
//        try {
//            facade.setDataAccess(new DataAccessLocal());
//            boolean buelta = facade.createOwner(123456789, "", "Owner", "Altuna", "owner", "000");
//            boolean buelta2 = facade.createOwner(123456789, "    -    -  -          ", "Owner", "Altuna", "owner", "000");
//            facade.close();
//            assertEquals(false, buelta);
//            assertEquals(false, buelta2);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /*
//     * BESTE
//     */
//    private static void createGui(JPanel contents, String windowName) {
//        JFrame frame = new JFrame(windowName);
//        frame.getContentPane().add(contents);
//        frame.addWindowListener(new WindowCloseManager());
//        frame.pack();
//        frame.setVisible(true);
//    }
//
//    private static class WindowCloseManager extends WindowAdapter {
//
//        @Override
//        public void windowClosing(WindowEvent evt) {
//            System.exit(0);
//        }
//    }
//}

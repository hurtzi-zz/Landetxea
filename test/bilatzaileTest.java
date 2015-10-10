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
//public class bilatzaileTest extends TestCase {
//
//    public static ApplicationFacadeInterface facade;
//    Register register;
//
//    public bilatzaileTest(String testSearch) {
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
//    
/////*
////* ondo daudenak--> true bueltatu
////*/
//
//    //(1) gutxiago 20 katere baino gutxiago       
//    public void testCreateGui1() throws InterruptedException {
//        try {
//            facade.setDataAccess(new DataAccessLocal());
//            Vector<RuralHouse> buelta = facade.SarchByCity("Gasteiz");
//            facade.close();
//            assertEquals(true, buelta.isEmpty()==false);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
////    //(3) karakterik berez gabe       
////    public void testCreateGui3() throws InterruptedException {
////        try {
////            System.out.println("(2)");
////            String bilIzena = "donosti";
////                    //ApplicationFacadeInterface facade = StartWindow.getBusinessLogic();                                        
////            //Vector<RuralHouse> buelta  = facade.SarchByCity(bilIzena);
////            //vectorImp(buelta);
////            assertEquals(true, facade.SarchByCity(bilIzena));
////        } catch (RemoteException e) {
////            e.printStackTrace();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
//
/////*
////* gaizki daudenak--> false bueltatu
////*/
//    //(2)  20 katere baino gehiago 
//    public void testCreateGui2() throws InterruptedException {
//             try {
//            facade.setDataAccess(new DataAccessLocal());
//            Vector<RuralHouse> buelta = facade.SarchByCity("GasteizGasteizGasteiz");
//            facade.close();
//            assertEquals(false, buelta.isEmpty()==false);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
////
////    //(4) karaktere bereziekin      
////    public void testCreateGui4() throws InterruptedException {
////        try {
////            System.out.println("(4)");
////            String bilIzena = "donosti!";
////                    //ApplicationFacadeInterface facade = StartWindow.getBusinessLogic();                                        
////            //Vector<RuralHouse> buelta  = facade.SarchByCity(bilIzena);
////            //vectorImp(buelta);
////            assertEquals(false, facade.SarchByCity(bilIzena));
////        } catch (RemoteException e) {
////            e.printStackTrace();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
////
////    public void vectorImp(Vector<RuralHouse> buelta) {
////        System.out.println("---------------------------------------");
////        int i = 1;
////        System.out.println("buelta.size()== " + buelta.size());
////        if (buelta.size() == 0) {
////            System.out.println("erantzuna hutsik");
////        } else {
////            System.out.println("etxeak: ");
////            Iterator<RuralHouse> irt = buelta.iterator();
////            while (irt.hasNext()) {
////                System.out.print("(" + i + ") ");
////                System.out.print(irt.next().getHouseNumber() + "\n");
////                i++;
////            }
////        }
////        System.out.println("--------------------------------------");
////
////    }
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

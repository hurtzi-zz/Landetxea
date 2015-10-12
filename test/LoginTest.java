import businessLogic.ApplicationFacadeInterface;
import businessLogic.FacadeImplementation;
import gui.Launcher;
import gui.StartWindow;
 
import java.rmi.RemoteException;
 
import dataAccess.DataAccessLocal;
import junit.framework.TestCase;
 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 */
public class LoginTest extends TestCase {
 
    public static ApplicationFacadeInterface facade;
    int a = 0;
 
    public LoginTest(String TestName) {
        super(TestName);
    }
 
    /**
     *
     * @throws Exception
     */
    @Override
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
 
    public void testCreateGui1() throws InterruptedException {
        try {//onartuko duen login bat.
            facade.setDataAccess(new DataAccessLocal());;
            boolean b = facade.createClient("wer", "Altuna", "wer", "1234", true);
            System.out.println(b);
            facade.close();
            assertEquals(true, b);
           
 
        } catch (RemoteException e) {
            e.printStackTrace();
        } 
    }
     public void testCreateGui2() throws InterruptedException {
        try {//karaktere bereziak ez onartu
            facade.setDataAccess(new DataAccessLocal());
      
            boolean buelta = facade.createClient("Itziar", "Altuna", "itziar!", "1234", true);
            facade.close();
            assertEquals(false, buelta);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     public void testCreateGui3() throws InterruptedException {
        try {//zenbakiak ez onartu
            facade.setDataAccess(new DataAccessLocal());
            boolean buelta1=facade.createClient("Itziar", "Altuna", "itziar8", "1234", true);
            facade.close();
            assertEquals(false, buelta1);
            
 
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    public void testCreateGui4() throws InterruptedException {
        try {//20 karaktere gehienez.
            facade.setDataAccess(new DataAccessLocal());
             boolean buelta2=facade.createClient("Itziar", "Altuna", "itziarrrrrrrrrrrrrrrr", "1234", true);
             facade.close();
            assertEquals(false,buelta2);
 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void testCreateGui5() throws InterruptedException {
        try {//gutxienez karaktere bateko 
            facade.setDataAccess(new DataAccessLocal());
            boolean buelta3= facade.createClient("Itziar", "Altuna", "", "1234", true);
            facade.close();
            assertEquals(false, buelta3);
            
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
}

import junit.framework.TestCase;
import businessLogic.*;
import domain.RuralHouse;
import gui.StartWindow;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.Vector;
import businessLogic.ApplicationFacadeInterface;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Urtzi  * BILATZAILEAREN-aren proba kasuak
 */
public class bilatzaileTest extends TestCase{
	public static ApplicationFacadeInterface facade;
	private int a = 0;
	
	 public  bilatzaileTest(String testSearch) {
	        super(testSearch);
	    }
         
            @Override
            //exekututauko den testa baino lehen nahi duzuna (hasieratu bista kasu honetan)
	    protected void setUp() throws Exception {
	        super.setUp();
	        facade = new FacadeImplementation();
	    
	    }
            
            @Override
	    protected void tearDown() throws Exception {
		 if (a == 1)
			 facade.close();
	     super.tearDown();
	    }
            
/*
 * ondo daudenak--> true bueltatu
 */                
	    public void testCreateGui1() throws InterruptedException {
	    	try { //(1) gutxiago 20 katere baino gutxiago
                    System.out.println("(1) gutxiago 20 katere baino gutxiago");
                    String bilIzena= "qwertyuiopasdfghjklñ";
                    //ApplicationFacadeInterface facade = StartWindow.getBusinessLogic();                                        
                    //Vector<RuralHouse> buelta  = facade.SarchByCity(bilIzena);
                    //vectorImp(buelta);
	    		assertEquals(true, facade.SarchByCity(bilIzena));
                         bilIzena= "qwertyuiopasdfghjk";
                        assertEquals(true, facade.SarchByCity(bilIzena));
                         bilIzena= "qwer";
                        assertEquals(true, facade.SarchByCity(bilIzena));
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}   
	    }
/*
 * gaizki daudenak--> true bueltatu
 */          
            public void testCreateGui2() throws InterruptedException {
	    	try {//(2) gutxiago 20 katere baino gutxiago
                    System.out.println("(1) gutxiago 20 katere baino gutxiago");
                    String bilIzena= "qwertyuiopasdfghjklñz";
                    //ApplicationFacadeInterface facade = StartWindow.getBusinessLogic();                                        
                    //Vector<RuralHouse> buelta  = facade.SarchByCity(bilIzena);
                    //vectorImp(buelta);
	    		assertEquals(false, facade.SarchByCity(bilIzena));
                         bilIzena= "qwertyuiopasdfghjklñzx";
                        assertEquals(false, facade.SarchByCity(bilIzena));
                         bilIzena= "qwertyuiopasdfghjklñzcvbn";
                        assertEquals(false, facade.SarchByCity(bilIzena));
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}   
	    }
	   
            
            public void vectorImp(Vector<RuralHouse> buelta){ 
                System.out.println("---------------------------------------");
		int i = 1;
                System.out.println("buelta.size()== "+buelta.size());
		if (buelta.size() == 0) {
			System.out.println("erantzuna hutsik");
		} else {
			System.out.println("etxeak: ");
			Iterator<RuralHouse> irt = buelta.iterator();
			while (irt.hasNext()) {
				System.out.print("(" + i + ") ");
				System.out.print(irt.next().getHouseNumber()+"\n");
				i++;
			}
		}
		System.out.println("--------------------------------------");
	
                
               
	    }
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
}

	 
	 

	 

	 

import junit.framework.TestCase;
import businessLogic.*;
import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import java.rmi.RemoteException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Urtzi
 */
public class bilatzaileTest extends TestCase{
	public static ApplicationFacadeInterface facade;
	private int a = 0;
	
	 public  bilatzaileTest(String testSearch) {
	        super(testSearch);
	    }
         
            @Override
            //ejekututauko den testa baino lehen nahi duzuna (hasieratu bista kasu honetan)
	    protected void setUp() throws Exception {
	        super.setUp();
	        // Creating Contact model
	        facade = new FacadeImplementation();
		// Creating Contact view
	    
	    }
            
            @Override
	    protected void tearDown() throws Exception {
		 if (a == 1)
			 facade.close();
	     super.tearDown();
	    }
            
            //BILATZAILEAREN-aren proba kasuak
	    public void testCreateGui1() throws InterruptedException {
	    	try { //(1), (3), (5) eta (7) kasuak. Hau da, ONDO daudenak.
	    		assertEquals(true, facade.SarchByCity("asd3@msn.com"));
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}   
	    }
	   
}

	 
	 

	 

	 
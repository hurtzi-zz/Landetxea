import junit.framework.TestCase;
import businessLogic.*;
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
	        facade = new FacadeImplementation();
	    
	    }
            
            @Override
	    protected void tearDown() throws Exception {
		 if (a == 1)
			 facade.close();
	     super.tearDown();
	    }
            
            //BILATZAILEAREN-aren proba kasuak
	    public void testCreateGui1() throws InterruptedException {
	    	try { //.......
                    System.out.println("urtzi: ");
	    		assertEquals(true, facade.SarchByCity("asdm"));
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}   
	    }
	   
}

	 
	 

	 

	 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 

package roseindia;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import junit.framework.TestCase;



/**
 *
 * @author Xabier
 
public class StudentViewTest extends TestCase {
    StudentView view;
    StudentModel studentModel; 
    
    public StudentViewTest(String testName) {
        super(testName);
    }
    
    @Override
    //ejekututauko den testa baino lehen nahi duzuna (hasieratu bista kasu honetan)
    protected void setUp() throws Exception {
        super.setUp();
        // Creating Contact model
	 studentModel = new StudentModel();
	// Creating Contact view
	view = new StudentView(studentModel);
	studentModel.addContactView(view);
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    
    public void testCreateGui1() throws InterruptedException {
        
         createGui(view,"Enter Student detail");
         // TestuEremuari balioa(IZENA) ematen diogu
         view.firstName.setText("Xabier");
         // Hemen baieztatu daiteke SARRERA
         studentModel.setFirstName("Xabier");
         Thread.sleep(1000);
         // TestuEremuari balioa(DEITURA) ematen diogu
         view.lastName.setText("Telleria");
         // Hemen baieztatu daiteke SARRERA
         studentModel.setLastName("Telleria");
         Thread.sleep(1000);
         // TestuEremuari balioa(IKASTURTEA) ematen diogu
         view.course.setText("AA");
         studentModel.setCourse("AA");
         // val aldagaiak 1111 itzuli behar du
         // course sarrera ez baita zenbakia
         assertEquals(1111, studentModel.val);
         Thread.sleep(1000);
         // TestuEremuari balioa(HELBIDEA) ematen diogu
         view.address.setText("Goiko Kalea, 17");
         // Hemen baieztatu daiteke SARRERA
         studentModel.setAddress("Goiko Kalea, 17");
         Thread.sleep(4000);
         
         StudentDisplayView displayView = new StudentDisplayView();
	studentModel.addContactView(displayView);
	createGui(displayView, "Student Details");
        Thread.sleep(2000);
        
        studentModel.updateView();
        Thread.sleep(6000);
         
         
    }

    public void testCreateGui2() throws InterruptedException {
        
         createGui(view,"Enter Student detail");
         // TestuEremuari balioa(IZENA) ematen diogu
         view.firstName.setText("Xabier");
         // Hemen baieztatu daiteke SARRERA
         studentModel.setFirstName("Xabier");
         Thread.sleep(1000);
         // TestuEremuari balioa(DEITURA) ematen diogu
         view.lastName.setText("Telleria");
         // Hemen baieztatu daiteke SARRERA
         studentModel.setLastName("Telleria");
         Thread.sleep(1000);
         // TestuEremuari balioa(IKASTURTEA) ematen diogu
         view.course.setText("99");
         studentModel.setCourse("99");
         // val aldagaiak 2222 itzuli behar du
         // course elementuaren balioa, zenbaki erakoa da baina
         // ez du betetzen:  1 <= course <= 9 Baldintza egoera 
         assertEquals(2222, studentModel.val);
         Thread.sleep(1000);
         // TestuEremuari balioa(HELBIDEA) ematen diogu
         view.address.setText("Goiko Kalea, 17");
         // Hemen baieztatu daiteke SARRERA
         studentModel.setAddress("Goiko Kalea, 17");
         Thread.sleep(4000);
         
         StudentDisplayView displayView = new StudentDisplayView();
	studentModel.addContactView(displayView);
	createGui(displayView, "Student Details");
        Thread.sleep(2000);
        
        studentModel.updateView();
        Thread.sleep(6000);
         
         
    }

    private static void createGui(JPanel contents, String windowName) {
		JFrame frame = new JFrame(windowName);
		frame.getContentPane().add(contents);
		frame.addWindowListener(new WindowCloseManager());
		frame.pack();
		frame.setVisible(true);
	}
    
    private static class WindowCloseManager extends WindowAdapter {
		public void windowClosing(WindowEvent evt) {
			System.exit(0);
		}
	}
    public void testGetUpdateRef() {
    }

    public void testGetFirstName() {
    }

    public void testGetLastName() {
    }

    public void testGetCourse() {
    }

    public void testGetAddress() {
    }

    public void testRefresh() {
    }
    
}
*/
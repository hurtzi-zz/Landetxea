package gui;

import java.awt.Color;
import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;







import javax.swing.UIManager;

import configuration.ConfigXML;
import dataAccess.DataAccessLocal;
import dataAccess.DataAccessRemote;
import exceptions.DB4oManagerCreationException;
import businessLogic.ApplicationFacadeInterface;
import businessLogic.FacadeImplementation;

public class Launcher implements Serializable{
	
	
	
	public static void main(String[] args) {
		
//		MainWindow a=new MainWindow();
//		a.setVisible(true);
		
		StartWindow a=new StartWindow();
		a.setVisible(true);
		
		ConfigXML c=ConfigXML.getInstance();


		
		try {
			
			ApplicationFacadeInterface appFacadeInterface;
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

			if (c.isBusinessLogicLocal()) {
				
			 appFacadeInterface=new FacadeImplementation();
				
				if (c.isDatabaseLocal()) 
					 appFacadeInterface.setDataAccess(new DataAccessLocal());
			    else 
			    	 appFacadeInterface.setDataAccess(new DataAccessRemote());
			}
			
			else {
				
				System.setProperty("java.security.policy", c.getJavaPolicyPath());				
				System.setSecurityManager(new RMISecurityManager());
				
				final String businessLogicNode = c.getBusinessLogicNode();
				// Remote service name
				String serviceName = "/"+c.getServiceRMI();
				// RMI server port number
				int portNumber = Integer.parseInt(c.getPortRMI());
				// RMI server host IP IP 
				
				appFacadeInterface=(ApplicationFacadeInterface) Naming.lookup("rmi://"+ businessLogicNode + ":" + portNumber + serviceName);
			} 
			
			StartWindow.setBussinessLogic(appFacadeInterface);
			
		} catch (java.rmi.ConnectException e) {
	//		a.lblNewLabel.setText("No business logic: Run BusinessLogicServer first!!");
	//		a.lblNewLabel.setForeground(Color.RED);
			System.out.println("11");
			System.out.println("Error in StartWindow: "+e.toString());
		} catch (java.rmi.NotBoundException e) {
	//		a.lblNewLabel.setText("No business logic: Maybe problems running BusinessLogicServer");
	//		a.lblNewLabel.setForeground(Color.RED);
			System.out.println("12");
			System.out.println("Error in StartWindow: "+e.toString());
		} catch (com.db4o.ext.DatabaseFileLockedException e) {
	//		a.lblNewLabel.setText("Database locked: Do not run BusinessLogicServer or BusinessLogicServer!!");
	//		a.lblNewLabel.setForeground(Color.RED);		
			System.out.println("13");
			System.out.println("Error in StartWindow: "+e.toString());
		} catch (DB4oManagerCreationException e) {
		//	a.lblNewLabel.setText("No database: Run DB4oManagerServer first!!");
		//	a.lblNewLabel.setForeground(Color.RED);		
			System.out.println("14");
			System.out.println("Error in StartWindow: "+e.toString());

			
		}catch (Exception e) {
		///	a.lblNewLabel.setText("Error: "+e.toString());
		//	a.lblNewLabel.setForeground(Color.RED);		
			System.out.println("Error in StartWindow: "+e.toString());
		}


	}

}

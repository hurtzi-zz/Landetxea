package dataAccess;

import java.util.ListIterator;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;

import configuration.ConfigXML;

import java.io.*;

public class DataAccessLocal extends DataAccessCommon implements Serializable {
	private static EmbeddedConfiguration configuration;

	public DataAccessLocal() {
		super();
		ConfigXML c = ConfigXML.getInstance();
		String dataBaseOpenMode = c.getDataBaseOpenMode();
		if (!dbExits()) {
			configuration = Db4oEmbedded.newConfiguration();
			db = Db4oEmbedded.openFile(configuration, c.getDb4oFilename());
			db.ext().configure().updateDepth(5);
			DataAccessCommon.getInstance().initializeDB();
			System.out.println("DataBase Initialized");
		} else {
			if ((c.getDataBaseOpenMode().equals("initialize")))new File(c.getDb4oFilename()).delete();
			DataAccessLocal.openDatabase(dataBaseOpenMode);
		}

	}

	public static void openDatabase(String mode) {
		ConfigXML c = ConfigXML.getInstance();
		String db4oFileName = c.getDb4oFilename();
		if (mode.compareTo("open") == 0) {
//			db = Db4oEmbedded.openFile(configuration, db4oFileName);
//			db.ext().configure().updateDepth(5);
			System.out.println("DataBase Opened");
			configuration = Db4oEmbedded.newConfiguration();
			db = Db4oEmbedded.openFile(configuration, db4oFileName);
			//kotuz!!!!
			db.ext().configure().updateDepth(5);


		} else if (mode.compareTo("initialize") == 0) {
			configuration = Db4oEmbedded.newConfiguration();
			db = Db4oEmbedded.openFile(configuration, db4oFileName);
			db.ext().configure().updateDepth(5);
			DataAccessCommon.getInstance().initializeDB();
			System.out.println("DataBase Initialized");
		}
	}
	

	public boolean dbExits() {
		ConfigXML c = ConfigXML.getInstance();
		String db4oFileName = c.getDb4oFilename();
		File fichero = new File(db4oFileName);
		if (fichero.exists()) {
			System.out.println("El fichero " + db4oFileName + " existe");
			return true;
		} else {
			System.out.println("Sortzen... " + db4oFileName);
			return false;
		}
	}

}

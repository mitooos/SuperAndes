package persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLUtil {
	
	private final static String SQL = SuperAndesPersistence.SQL;
	
	private SuperAndesPersistence sap;
	
	public SQLUtil(SuperAndesPersistence sap) {
		this.sap = sap;
	}

	public Long nextval(PersistenceManager pm) {

		Query q = pm.newQuery(SQL,"SELECT " + sap.darSeq() + ".nextval FROM DUAL");
		q.setResultClass(Long.class);
		return (Long) q.executeUnique();
	}
	
	public int booleanToInt(boolean bol) {
		if(bol)
			return 1;
		return 0;
	}
	
	public boolean intToBoolean(int i) {
		if(i == 1)
			return true;
		return false;
	}
}

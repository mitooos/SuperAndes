package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.FechasSemana;

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
	
	public String fechaSql(String fecha) {
		return "TO_DATE('" + fecha + "','DD/MM/YYYY')";
	}
	
	public Integer darMesesFuncionamiento(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "(SELECT MONTHS_BETWEEN(LAST_DAY(ADD_MONTHS(SYSDATE,-1)), TO_DATE('01/01/2018','DD/MM/YYYY')) FROM DUAL)");
		q.setResultClass(Integer.class);
		return (Integer) q.executeUnique();
	}
	
	public List<FechasSemana> darFechasSemana(PersistenceManager pm){
		Query q = pm.newQuery(SQL, "SELECT TRUNC(to_date(mon,'MON-YY'), 'iw') + nxt AS fechaInic , TRUNC(to_date(mon,'MON-YY'), 'iw') + 6 + nxt AS fechaFin FROM (SELECT LEVEL*7 - 7 AS nxt FROM dual CONNECT BY LEVEL <=6) CROSS JOIN (SELECT 'DEC-17' AS mon FROM dual" + 
				"   UNION ALL SELECT 'JAN-18' FROM dual UNION ALL SELECT 'FEB-18' FROM dual UNION ALL SELECT 'MAR-18' FROM dual UNION ALL SELECT 'APR-18' FROM dual UNION ALL SELECT 'MAY-18' FROM dual UNION ALL SELECT 'JUN-18' FROM dual UNION ALL SELECT 'JUL-18' FROM dual UNION ALL SELECT 'AUG-18'" + 
				"   FROM dual UNION ALL SELECT 'SEP-18' FROM dual UNION ALL SELECT 'OCT-18' FROM dual UNION ALL SELECT 'NOV-18' FROM dual ) m  WHERE to_date(mon,'MON-YY') <= TRUNC(to_date(mon,'MON-YY'), 'iw') + nxt  AND last_day(to_date(mon,'MON-YY')) >= TRUNC(to_date(mon,'MON-YY'), 'iw') + nxt ORDER BY 2");
		q.setResultClass(FechasSemana.class);
		return q.executeList();
	}
}

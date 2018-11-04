package negocio;

import java.util.Date;

public class fechaSucursalCont {
	
	public Date fecha;
	
	public Long ID_SUCURSAL;
	
	public Integer cont;
	
	public String toString() {
		return "Sucursal: " + this.ID_SUCURSAL + ", fecha: " + this.fecha.toString();
	}

}

package negocio;

public class VentasSucursalTotales {

	public Long id_sucursal;
	public Integer total;
	
	public String toString() {
		return "id sucursal:" + this.id_sucursal + ", total ventas:" + this.total;
	}
}

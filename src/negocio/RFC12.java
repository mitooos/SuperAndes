package negocio;

public class RFC12 {
	
	public Producto proudctoMasVendido;
	
	public Producto productoMenosVendido;
	
	public Proveedor proveedorMenosSolicitado;
	
	public Proveedor proveedorMasSolicitado;
	
	public RFC12(Producto productoMenos, Producto productoMas, Proveedor proveedorMenos, Proveedor proveedorMas) {
		this.productoMenosVendido = productoMenos;
		this.proudctoMasVendido = productoMas;
		this.proveedorMenosSolicitado = proveedorMenos;
		this.proveedorMasSolicitado = proveedorMas;
	}
	
	@Override
	public String toString() {
		return "Producto menos vendido: " + this.productoMenosVendido.toString() + 
				", Producto mas vendido: " + this.proudctoMasVendido.toString() +
				", Proveedor menos solicitado: " + this.proveedorMenosSolicitado.toString() + 
				", Proveedor mas solicitado: " + this.proveedorMasSolicitado.toString();
	}

}

package negocio;

import java.util.Date;

public class Compra {
	
	private Long id;
	
	private Integer precioTotal;
	
	private boolean pagada;
	
	private String fecha;
	
	private Long idCliente;
	
	private Long idSucursal;
	




	/**
	 * constructor por defecto
	 */
	public Compra() {
		this.id = 0L;
		this.precioTotal = 0;
		this.pagada = false;
		this.fecha = "";
		this.idCliente = 0L;
		this.idSucursal = 0L;
	}
	
	/**
	 * constructor con valores
	 * @param id0
	 * @param precioTotal0
	 * @param pagada0
	 */
	public Compra(Long id0, Integer precioTotal0, boolean pagada0,String fecha, Long idCliente0, Long idSucursal0) {
		this.id = id0;
		this.precioTotal = precioTotal0;
		this.pagada = pagada0;
		this.fecha = fecha;
		this.idCliente = idCliente0;
		this.idSucursal = idSucursal0;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Integer precioTotal) {
		this.precioTotal = precioTotal;
	}

	public boolean isPagada() {
		return pagada;
	}

	public void setPagada(boolean pagada) {
		this.pagada = pagada;
	}
	
	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	
	public Long getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(Long idSucursal) {
		this.idSucursal = idSucursal;
	}
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public void setFecha(Date fech) {
		this.fecha = fech.toString();
	}
	
	public void setPRECIO_TOTAL(Integer i) {
		this.precioTotal = i;
	}
	
	public void setPagada(int i) {
		this.pagada = (i==1)? true:false;
	}
	
	public void setID_CLIENTE(Long id) {
		this.idCliente = id;
	}
	
	public void setID_SUCURSAL(Long id) {
		this.idSucursal = id;
	}
	
	public String toString() {
		return "Id: " + this.id + ", id cliente: " + this.idCliente + ", precio total: " + this.precioTotal + ", fecha: " + this.fecha + ", id sucursal: " + this.idSucursal;
	}


}

package negocio;

import java.util.Date;

public class OrdenDeCompra {

	private Long id;
	
	private String fechaEstimadaEntrega;
	
	private boolean entregado;
	
	private Integer calificacion;
	
	private String fechaEntregado;
	
	private Long idProveedor;
	
	private Long idSucursal;
	
	
	
	/**
	 * constructor por defecto
	 */
	public OrdenDeCompra() {
		this.id = 0L;
		this.fechaEstimadaEntrega = "";
		this.entregado = false;
		this.calificacion = 0;
		this.fechaEntregado = "";
		this.idProveedor = 0L;
		this.idSucursal = 0L;
		
	}
	
	/**
	 * Construcor con valores
	 * @param id0
	 * @param fechaEstimadaEntrega0
	 * @param entregado0
	 * @param calificacion0
	 * @param fechaEntregado0
	 */
	public OrdenDeCompra(Long id0, String fechaEstimadaEntrega0, int entregado0, Integer calificacion0, String fechaEntregado0, Long idProveedor0,Long idSucursal0) {
		this.id = id0;
		this.fechaEstimadaEntrega = "";
		this.entregado = (entregado0 == 1)? true:false;
		this.calificacion = calificacion0;
		this.fechaEntregado = fechaEntregado0;
		this.idProveedor = idProveedor0;
		this.idSucursal = idSucursal0;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFechaEstimadaEntrega() {
		return fechaEstimadaEntrega;
	}

	public void setFechaEstimadaEntrega(String fechaEstimadaEntrega) {
		this.fechaEstimadaEntrega = fechaEstimadaEntrega;
	}

	public boolean isEntregado() {
		return entregado;
	}

	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	public String getFechaEntregado() {
		return fechaEntregado;
	}

	public void setFechaEntregado(String fechaEntregado) {
		this.fechaEntregado = fechaEntregado;
	}

	public Long getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}

	public Long getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(Long idSucursal) {
		this.idSucursal = idSucursal;
	}
	
	public void setFECHA_ESTIMADA_ENTREGA(Date fech) {
		this.fechaEstimadaEntrega = fech.toString();
	}
	
	public void setEntregado(int i) {
		this.entregado = (i==1)? true :false;
	}
	
	public void setFECHA_ENTREGA(Date fech) {
		this.fechaEntregado = fech.toString();
	}
	
	public void setID_PROVEEDOR(Long id) {
		this.idProveedor = id;
	}
	
	public void setID_SUCURSAL(long id) {
		this.idSucursal = id;
	}
	


	@Override
	public String toString() {
		return "Id proveedor" + this.idProveedor + "Id: " + this.id + ", Fecha estimada de entrega: " + this.fechaEstimadaEntrega + ", calificacion: " + this.calificacion + ", fecha entrega: " + this.fechaEntregado
				+ ", id sucursal:" + this.idSucursal;
	}
	
	
	
	
}

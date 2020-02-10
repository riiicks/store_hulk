package com.todo1.store.data.dto;

import java.util.Date;

public class VentaDTO {

	private Long ventaId;

	private Long productoId;

	private Integer cantidad;

	private Date fechaVenta;

	public Long getVentaId() {
		return ventaId;
	}

	public void setVentaId(Long ventaId) {
		this.ventaId = ventaId;
	}

	public Long getProductoId() {
		return productoId;
	}

	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public VentaDTO(Long productoId, Integer cantidad) {
		super();
		this.productoId = productoId;
		this.cantidad = cantidad;
	}

}

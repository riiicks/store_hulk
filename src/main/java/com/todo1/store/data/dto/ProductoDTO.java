package com.todo1.store.data.dto;

import java.io.Serializable;
import java.util.Date;

public class ProductoDTO implements Serializable {

	private static final long serialVersionUID = -2724703282364088795L;

	private Long productoId;

	private String producto;

	private Integer cantidad;

	private Date fechaIngreso;

	private Integer estatus;

	private Float precio;

	public Long getProductoId() {
		return productoId;
	}

	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public ProductoDTO() {
		super();
	}

	public ProductoDTO(String producto, Integer cantidad, Float precio) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public ProductoDTO(Long productoId, Integer cantidad) {
		super();
		this.productoId = productoId;
		this.cantidad = cantidad;
	}

}

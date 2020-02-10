package com.todo1.store.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class AltaProductoRequest implements Serializable {

	private static final long serialVersionUID = 9180017093672837694L;

	@JsonProperty(required = true, value = "cantidad")
	private Integer cantidad;

	@JsonProperty(required = true, value = "descripcion")
	private String descripcion;

	@JsonProperty(required = true, value = "precio")
	private Float precio;

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

}

package com.todo1.store.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class VentaProductoRequest implements Serializable {

	private static final long serialVersionUID = 8109639873220574749L;

	@JsonProperty(required = true, value = "productoId")
	private Long productoId;

	@JsonProperty(required = true, value = "cantidad")
	private Integer cantidad;

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

}

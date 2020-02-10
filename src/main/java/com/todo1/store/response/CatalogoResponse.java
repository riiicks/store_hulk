package com.todo1.store.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CatalogoResponse extends BaseResponse {

	private static final long serialVersionUID = 4264716440521879546L;

	private List<ProductoResponse> producto;

	public List<ProductoResponse> getProducto() {
		return producto;
	}

	public void setProducto(List<ProductoResponse> producto) {
		this.producto = producto;
	}

	public CatalogoResponse() {
		super();
	}

	public CatalogoResponse(String mensaje, String codigo) {
		super(mensaje, codigo);
	}

	public CatalogoResponse(String codigo, String mensaje, List<ProductoResponse> producto) {
		super(mensaje, codigo);
		this.producto = producto;
	}
}

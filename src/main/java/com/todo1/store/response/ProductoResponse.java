package com.todo1.store.response;

public class ProductoResponse {

	private Long productoId;

	private String producto;

	private Integer cantidad;

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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public ProductoResponse() {
		super();
	}

	public ProductoResponse(Long productoId, String producto, Integer cantidad, Float precio) {
		super();
		this.productoId = productoId;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "ProductoResponse [productoId=" + productoId + ", producto=" + producto + ", cantidad=" + cantidad
				+ ", precio=" + precio + "]";
	}

}

package com.todo1.store.service;

import com.todo1.store.request.AltaProductoRequest;
import com.todo1.store.request.ModificacionProductoRequest;
import com.todo1.store.request.VentaProductoRequest;
import com.todo1.store.response.BaseResponse;
import com.todo1.store.response.CatalogoResponse;

public interface StoreService {

	public CatalogoResponse getProductos();

	public BaseResponse altaProducto(AltaProductoRequest request);

	public BaseResponse bajaProducto(Long productoId);

	public BaseResponse actualizarProducto(ModificacionProductoRequest request);

	public CatalogoResponse getProductoById(Long productoId);

	public BaseResponse ventaProducto(VentaProductoRequest request);

}

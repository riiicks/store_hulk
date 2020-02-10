package com.todo1.store.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo1.store.data.dao.ProductoDAO;
import com.todo1.store.data.dao.VentaDAO;
import com.todo1.store.data.dto.ProductoDTO;
import com.todo1.store.data.dto.VentaDTO;
import com.todo1.store.request.AltaProductoRequest;
import com.todo1.store.request.ModificacionProductoRequest;
import com.todo1.store.request.VentaProductoRequest;
import com.todo1.store.response.BaseResponse;
import com.todo1.store.response.CatalogoResponse;
import com.todo1.store.response.ProductoResponse;

@Service
public class StoreService {

	@Autowired
	private ProductoDAO productoDAO;

	@Autowired
	private VentaDAO ventaDAO;

	public CatalogoResponse getProductos() {

		List<ProductoResponse> lstResponse = new ArrayList<ProductoResponse>();

		List<ProductoDTO> lst = productoDAO.getProductos();

		if (!lst.isEmpty())
			for (ProductoDTO dto : lst) {
				lstResponse.add(new ProductoResponse(dto.getProductoId(), dto.getProducto(), dto.getCantidad(),
						dto.getPrecio()));
			}

		return new CatalogoResponse("ok", "", lstResponse);
	}

	public BaseResponse altaProducto(AltaProductoRequest request) {

		if (productoDAO
				.saveProducto(new ProductoDTO(request.getDescripcion(), request.getCantidad(), request.getPrecio())))
			return new BaseResponse("ok", "");
		else
			return new BaseResponse("ko", "ocurrio un error al guardar el producto.Contacte al administrador");
	}

	public BaseResponse bajaProducto(Long productoId) {

		if (productoDAO.deleteProducto(productoId))
			return new BaseResponse("ok", "");
		else
			return new BaseResponse("ko", "ocurrio un error al guardar el producto.Contacte al administrador");
	}

	public BaseResponse actualizarProducto(ModificacionProductoRequest request) {

		if (productoDAO.updateProducto(new ProductoDTO(request.getProductoId(), request.getCantidad())))
			return new CatalogoResponse("ok", "");
		else
			return new CatalogoResponse("ko", "ocurrio un error al actualizar el producto.Contacte al administrador");
	}

	public CatalogoResponse getProductoById(Long productoId) {

		List<ProductoResponse> lstResponse = new ArrayList<ProductoResponse>();

		ProductoDTO dto = productoDAO.getProductoById(productoId);

		if (dto.getProductoId() != null)
			lstResponse.add(
					new ProductoResponse(dto.getProductoId(), dto.getProducto(), dto.getCantidad(), dto.getPrecio()));

		return new CatalogoResponse("ok", "", lstResponse);

	}

	public BaseResponse ventaProducto(VentaProductoRequest request) {

		if (ventaDAO.saveVenta(new VentaDTO(request.getProductoId(), request.getCantidad())))
			return new BaseResponse("ok", "");
		else
			return new BaseResponse("ko", "ocurrio un error al guardar el producto.Contacte al administrador");
	}
}

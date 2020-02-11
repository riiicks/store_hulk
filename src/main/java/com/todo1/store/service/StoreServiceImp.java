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
public class StoreServiceImp implements StoreService {

	@Autowired
	private ProductoDAO productoDAO;

	@Autowired
	private VentaDAO ventaDAO;

	/*
	 * En este servicio se manda a llamar todos los productos con un estatus mayor a
	 * cero el cual en la logica seria todos los productos que estan activos
	 */
	public CatalogoResponse getProductos() {

		List<ProductoResponse> lstResponse = new ArrayList<ProductoResponse>();
		try {
			List<ProductoDTO> lst = productoDAO.getProductos();

			if (!lst.isEmpty())
				for (ProductoDTO dto : lst) {
					lstResponse.add(new ProductoResponse(dto.getProductoId(), dto.getProducto(), dto.getCantidad(),
							dto.getPrecio()));
				}

			return new CatalogoResponse("ok", "", lstResponse);
		} catch (Exception e) {
			return new CatalogoResponse("ko", "Ocurrio un error al obtener los productos", lstResponse);
		}
	}

	/*
	 * Para dar de alta un nuevo producto, se recibe un objeto de tipo
	 * AltaProductoRequest el cual contendra los datos que se guardaran.
	 */
	public BaseResponse altaProducto(AltaProductoRequest request) {

		try {
			if (productoDAO.saveProducto(
					new ProductoDTO(request.getDescripcion(), request.getCantidad(), request.getPrecio())))
				return new BaseResponse("ok", "");
			else
				return new BaseResponse("ko", "ocurrio un error al guardar el producto.Contacte al administrador");
		} catch (Exception e) {
			return new BaseResponse("ko", "Ocurrio un error. Contacte al administrador");
		}
	}

	/*
	 * Por lo general realizo borrados logicos para la eliminacion de datos, lo que
	 * indicaria que solo se actualizaria el campo
	 */
	public BaseResponse bajaProducto(Long productoId) {

		if (productoDAO.deleteProducto(productoId))
			return new BaseResponse("ok", "");
		else
			return new BaseResponse("ko", "ocurrio un error al guardar el producto.Contacte al administrador");
	}

	/*
	 * En este metodo actualiza el producto recibe de entrada un objecto en el cual
	 * trae los datos que se modificaran
	 */
	public BaseResponse actualizarProducto(ModificacionProductoRequest request) {

		if (productoDAO.updateProducto(new ProductoDTO(request.getProductoId(), request.getCantidad())))
			return new CatalogoResponse("ok", "");
		else
			return new CatalogoResponse("ko", "ocurrio un error al actualizar el producto.Contacte al administrador");
	}

	/*
	 * En este metodo manda a llamar un producto de acuerdo al id.
	 */
	public CatalogoResponse getProductoById(Long productoId) {

		List<ProductoResponse> lstResponse = new ArrayList<ProductoResponse>();

		ProductoDTO dto = productoDAO.getProductoById(productoId);

		if (dto.getProductoId() != null)
			lstResponse.add(
					new ProductoResponse(dto.getProductoId(), dto.getProducto(), dto.getCantidad(), dto.getPrecio()));

		return new CatalogoResponse("ok", "", lstResponse);

	}

	/*
	 * El metodo recibe un objeto de tipo VentaProductoRequest en el cual lleva el
	 * id del producto y la cantidad
	 */
	public BaseResponse ventaProducto(VentaProductoRequest request) {
		try {
			if (ventaDAO.saveVenta(new VentaDTO(request.getProductoId(), request.getCantidad())))
				return new BaseResponse("ok", "");
			else
				return new BaseResponse("ko", "ocurrio un error al guardar el producto.Contacte al administrador");
		} catch (Exception e) {
			return new BaseResponse("ko", "ocurrio un error al guardar el producto.");
		}
	}
}
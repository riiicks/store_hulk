package com.todo1.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo1.store.request.AltaProductoRequest;
import com.todo1.store.request.ModificacionProductoRequest;
import com.todo1.store.request.VentaProductoRequest;
import com.todo1.store.response.BaseResponse;
import com.todo1.store.response.CatalogoResponse;
import com.todo1.store.service.StoreServiceImp;

@RestController
@RequestMapping("/store")
public class StoreController {

	@Autowired
	private StoreServiceImp storeService;

	@RequestMapping(value = "/productos", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<CatalogoResponse> getProductos() {

		CatalogoResponse response = storeService.getProductos();

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/producto/ingreso", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<BaseResponse> ingresoProducto(@RequestBody AltaProductoRequest request) {

		BaseResponse response = storeService.altaProducto(request);

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/producto/salida/{productoId}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<BaseResponse> salidaProducto(@PathVariable("productoId") Long productoId) {

		BaseResponse response = storeService.bajaProducto(productoId);

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/producto/modificacion", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<BaseResponse> actualizaProducto(
			@RequestBody ModificacionProductoRequest request) {

		BaseResponse response = storeService.actualizarProducto(request);

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/producto/{productoId}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<CatalogoResponse> getProductoById(@PathVariable("productoId") Long productoId) {

		CatalogoResponse response = storeService.getProductoById(productoId);

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/producto/venta", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<BaseResponse> ventaProducto(@RequestBody VentaProductoRequest request) {

		BaseResponse response = storeService.ventaProducto(request);

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}

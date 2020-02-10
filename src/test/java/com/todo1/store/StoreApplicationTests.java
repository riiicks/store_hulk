package com.todo1.store;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.todo1.store.controller.StoreController;
import com.todo1.store.request.ModificacionProductoRequest;
import com.todo1.store.response.BaseResponse;
import com.todo1.store.response.CatalogoResponse;
import com.todo1.store.response.ProductoResponse;

@SpringBootTest
class StoreApplicationTests {

	public static final Logger log = LoggerFactory.getLogger(StoreApplicationTests.class);

	@Autowired
	private StoreController controller;

	@Test
	public void getProductos() {

		ResponseEntity<CatalogoResponse> response = controller.getProductos();

		log.info("Test ...........");

		if (response.getStatusCode() == HttpStatus.OK)
			for (ProductoResponse r : response.getBody().getProducto()) {
				log.info("" + r);
			}

	}

	@Test
	public void getProductoById() {

		ResponseEntity<CatalogoResponse> response = controller.getProductoById(1L);

		log.info("Test ...........");

		if (response.getStatusCode() == HttpStatus.OK)
			for (ProductoResponse r : response.getBody().getProducto()) {
				log.info("" + r);
			}

	}

	@Test
	public void updateProducto() {

		ModificacionProductoRequest request = new ModificacionProductoRequest();

		request.setCantidad(10);

		request.setProductoId(1L);

		request.setPrecio((float) 8.90);

		ResponseEntity<BaseResponse> response = controller.actualizaProducto(request);

		log.info("Test ...........");

		if (response.getStatusCode() == HttpStatus.OK)
			log.info("Succes !!!");

	}

}

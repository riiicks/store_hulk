package com.todo1.store.data.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.todo1.store.data.dto.VentaDTO;

@Repository
public class VentaDAO extends AbstractDAO {

	/*
	 * En el metodo siguiente para registrar una venta realiza un insert en la venta
	 * y despues actualiza en la tabla de producto.
	 */
	@Transactional
	public boolean saveVenta(VentaDTO dto) {

		try {
			String sql = "insert into venta (producto_id, cantidad) values ( ?, ?)";

			template.update(sql, dto.getProductoId(), dto.getCantidad());

			sql = "update producto set cantidad = ? where producto_id = ?;";

			template.update(sql, dto.getCantidad(), dto.getProductoId());

			return true;
		} catch (Exception e) {
			log.error("Error al guardar la venta " + e);
			return false;
		}
	}

}

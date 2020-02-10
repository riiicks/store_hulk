package com.todo1.store.data.dao;

import org.springframework.stereotype.Repository;

import com.todo1.store.data.dto.VentaDTO;

@Repository
public class VentaDAO extends AbstractDAO {

	public boolean saveVenta(VentaDTO dto) {

		try {
			final String sql = "insert into producto (producto_id, cantidad) values ( ?, ?)";

			template.update(sql, dto.getProductoId(), dto.getCantidad());

			return true;
		} catch (Exception e) {
			log.error("Error al guardar la venta " + e);
			return false;
		}
	}

}

package com.todo1.store.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.todo1.store.data.dto.ProductoDTO;

@Repository
public class ProductoDAO extends AbstractDAO {

	public boolean saveProducto(ProductoDTO dto) {

		try {
			final String sql = "insert into producto (descripcion,cantidad, precio) values (?,?,?)";

			template.update(sql, dto.getProducto(), dto.getCantidad(), dto.getPrecio());

			return true;
		} catch (Exception e) {
			log.error("Error al guardar producto " + e);
			return false;
		}
	}

	public boolean updateProducto(ProductoDTO dto) {

		try {
			final String sql = "update producto set precio = ? where producto_id = ?";

			template.update(sql, dto.getCantidad(), dto.getProductoId());

			return true;
		} catch (Exception e) {
			log.error("Error al actualizar el producto " + e);
			return false;
		}
	}

	public boolean deleteProducto(Long productoId) {

		try {

			final String sql = "update producto set estatus = 0 where producto_id = ?";

//			final String sql = "delete from producto where producto_id = ?";

			template.update(sql, productoId);

			return true;
		} catch (Exception e) {
			log.error("Error al eliminar el producto " + e);
			return false;
		}
	}

	public List<ProductoDTO> getProductos() {

		final String query = "SELECT producto_id, descripcion, cantidad, precio FROM public.producto where estatus > 0;";

		return (List<ProductoDTO>) template.query(new PreparedStatementCreator() {

			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {

				PreparedStatement ps = conn.prepareStatement(query);
				return ps;
			}
		}, (resultSet, i) -> {
			return toProduc(resultSet);
		});

	}

	public ProductoDTO getProductoById(Long id) {

		final String query = "SELECT producto_id, descripcion, cantidad, precio FROM public.producto where estatus > 0 and producto_id = ?;";

		List<ProductoDTO> lst = (List<ProductoDTO>) template.query(new PreparedStatementCreator() {

			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {

				PreparedStatement ps = conn.prepareStatement(query);

				ps.setLong(1, id);

				return ps;
			}
		}, (resultSet, i) -> {
			return toProduc(resultSet);
		});

		if (lst.isEmpty())
			return new ProductoDTO();

		return lst.get(0);
	}

	private ProductoDTO toProduc(ResultSet resultSet) throws SQLException {

		try {
			ProductoDTO producto = new ProductoDTO();
			producto.setProductoId(resultSet.getLong("producto_id"));
			producto.setProducto(resultSet.getString("descripcion"));
			producto.setCantidad(resultSet.getInt("cantidad"));
			producto.setPrecio(resultSet.getFloat("precio"));
			return producto;
		} catch (Exception e) {
			log.error("Error " + e);
			return new ProductoDTO();
		}
	}

}

CREATE TABLE producto(
producto_id BIGINT  PRIMARY KEY AUTO_INCREMENT,
descripcion VARCHAR(255),
cantidad INTEGER DEFAULT 0,
precio float default 0.0,
fecha_ingreso timestamp default NOW(),
estatus INTEGER default 1
);

CREATE TABLE salida(
producto_id BIGINT,
fecha_salida timestamp default NOW()
);
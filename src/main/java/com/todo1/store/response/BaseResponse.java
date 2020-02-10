package com.todo1.store.response;

import java.io.Serializable;

public class BaseResponse implements Serializable {

	private static final long serialVersionUID = 6250525239620285035L;

	private String mensaje;

	private String codigo;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public BaseResponse() {
		super();
	}

	public BaseResponse(String mensaje, String codigo) {
		super();
		this.mensaje = mensaje;
		this.codigo = codigo;
	}

}

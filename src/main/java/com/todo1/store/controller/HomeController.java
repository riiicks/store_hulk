package com.todo1.store.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping({ "/home", "" })
	public String Home(Model model) throws IOException {
		return "Home";
	}

	@RequestMapping({ "/", "" })
	public String redirectHome() {

		return "Home";
	}

	@RequestMapping({ "/productos", "" })
	public String Productos() {
		return "Productos";
	}

	@RequestMapping({ "/ventas", "" })
	public String Ventas() {
		return "Ventas";
	}
}

package com.bd.basico.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mensajeControlador {

	//creamos un metodo para visualizar el archivo
	@GetMapping("/mensajess")
	public String mensaje() {
		
		//retornamos hacia la vista
		return "mensaje1";
	}  //fin del metodo
	
}  //fin de la clase...

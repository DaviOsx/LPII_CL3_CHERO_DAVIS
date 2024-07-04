package com.bd.basico.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bd.basico.modelo.TblProducto;
import com.bd.basico.servicio.IProductoServicio;


@Controller
@RequestMapping("/Vistas")

public class ProductoController {	
	
	//inyeccion de dependencia...
			@Autowired
			private IProductoServicio IProductoServicio;
			//creamos el metodo listado..
			@GetMapping("ListadoProducto")
			public String ListadoAuto(Model modelo) {
				//recuperamos el listado de autos..
				List<TblProducto> listado=IProductoServicio.ListadoProducto();
				for(TblProducto lis:listado) {
			System.out.println("codigo "+lis.getIdproductocl3()+" "+" nombre "+lis.getNombrecl3());
				}
				//enviamos la data hacia la vista..
				modelo.addAttribute("listado",listado);
				//retornamos
				return "/Vistas/ListadoProducto";
				
			}  //fin del metodo listado cliente...			
			
			//creamos los respectivos para metodos para registrar...
			@GetMapping("RegistrarProducto")
			public String RegistrarProducto(Model modelo) {
				//realizamos la respectiva instancia...
				TblProducto producto=new TblProducto();
				//enviamos a la vista...
				modelo.addAttribute("regproducto",producto);
				//retornamos
				return "/Vistas/FrmCrearProducto";
				
			}  //fin del metodo registrar.
			
			//realizamos el mapeo con postmapping
			@PostMapping("/GuardarProducto")
			public String GuardarProducto(@ModelAttribute TblProducto  producto,Model modelo) {
				System.out.print("desdeGuardarProdcuto:"+producto.toString());
				IProductoServicio.RegistrarProducto(producto);
				System.out.println("dato registrado en la bd");
				//retornamos al listado...
				return "redirect:/Vistas/ListadoProducto";	
			}  //fin del metodo string...
			
			//*****************crearmos el metodo editar...
			@GetMapping("/editar/{id}")
			public String Editar(@PathVariable("id") Integer idprodcutocl3,Model modelo) {
				TblProducto producto=IProductoServicio.BuscarporId(idprodcutocl3);
				//enviamos hacia la vista...
				modelo.addAttribute("regproducto",producto);
				//retornamos el frmcrearcliente...
				return "/Vistas/FrmCrearProducto";	
			}  //fin del metodo editar...
			
			//************************creamos el metodo eliminar..
			@GetMapping("/eliminar/{id}")
			public String eliminar(@PathVariable("id") Integer idprodcutocl3,Model modelo) {
				
				//aplicamos inyeccion de dependencia...
				IProductoServicio.Eliminar(idprodcutocl3);
				//actulizar el listado
				List<TblProducto> listado=IProductoServicio.ListadoProducto();
				//enviamos a la vista
				modelo.addAttribute("listado",listado);
				//redireccionamos
				return "redirect:/Vistas/ListadoProducto";		
			}   //fin del metodo eliminar...	
	
	

} //FIN DE CONTROLADOR

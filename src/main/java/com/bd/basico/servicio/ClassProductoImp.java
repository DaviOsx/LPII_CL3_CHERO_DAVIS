package com.bd.basico.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bd.basico.modelo.TblProducto;
import com.bd.basico.repositorio.IProductoRepositorio;
	
	@Service
	public class ClassProductoImp  implements IProductoServicio{
		
		//aplicamos la inyeccion de dependencia...
		@Autowired
		private IProductoRepositorio iproductorepository;

		@Override
		public List<TblProducto> ListadoProducto(){
			//devuelve el listado
			return (List<TblProducto>)iproductorepository.findAll();
		}

		@Override
		public void RegistrarProducto(TblProducto producto) {
			//registrar los datos
			iproductorepository.save(producto);			
		}

		@Override
		public TblProducto BuscarporId(Integer id) {
			//buscar por codigo, si no encuentra devuelve nulo..		
			return iproductorepository.findById(id).orElse(null);
		}

		@Override
		public void Eliminar(Integer id) {
			//eliminar por codigo
			iproductorepository.deleteById(id);
			
		}	

}

package com.bd.basico.servicio;

import java.util.List;

import com.bd.basico.modelo.TblProducto;

public interface IProductoServicio {
	
	
	//declaramos los metodos
		public List<TblProducto> ListadoProducto();
		public void RegistrarProducto(TblProducto producto);
		public TblProducto BuscarporId(Integer id);
		public void Eliminar(Integer id);

}

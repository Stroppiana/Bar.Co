package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import datos.Conexion;

public class Producto {
	
	private int idProducto;
	private String nombre;
	private String fragil;
	private int peso;
	private int idDivisa;
	
	
	public Producto() {
		
	}
	
	public Producto(String nombre, String fragil,int peso) {
		super();
		this.nombre = nombre;
		this.fragil = fragil;
		this.peso = peso;
	}


	public Producto(int idProducto, String nombre,  String fragil,int peso, int idDivisa) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.fragil = fragil;
		this.peso = peso;
		this.idDivisa = idDivisa;
	}



	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", peso=" + peso  + ", fragil=" + fragil + "]";
	}


	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}

	public String getFragil() {
		return fragil;
	}
	public void setFragil(String fragil) {
		this.fragil = fragil;
	}
	
	
	public int getIdDivisa() {
		return idDivisa;
	}


	public void setIdDivisa(int idDivisa) {
		this.idDivisa = idDivisa;
	}
	
	Conexion conexion = new Conexion ();
	Connection con = conexion.conectar(); 
	PreparedStatement stmt;
	

	public LinkedList<Producto> mostrarProductos() {
		String sql = "SELECT * FROM producto";
		
		LinkedList<Producto> productos = new LinkedList<>();
	    
	    try {
	        PreparedStatement stmt = con.prepareStatement(sql);

	        ResultSet resultados = stmt.executeQuery();
	        
	        while (resultados.next()) {
	            int id_producto = resultados.getInt("id_producto");
	            String	nombre_producto = resultados.getString("nombre_producto");
	            String fragilidad = resultados.getString("fragilidad");
	           	int peso = resultados.getInt("peso");
	           	int id_divisa = resultados.getInt("id_divisa");

	            Producto producto = new Producto(id_producto, nombre_producto, fragilidad, peso, id_divisa);
	            
	            productos.add(producto);

	            System.out.println("ID: " + id_producto + "\n PRODUCTO: " + nombre_producto + "\n FRAGILIDAD: " + fragilidad + "\n PESO: " + peso + "\n DIVISA " + id_divisa);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Error");
	    }
	    
	    return productos;
	
	} 
	
	
	
	public int seleccionProducto(String nombreProducto) {
		
		int idProducto = -1;

		String sql = "SELECT `id_producto` FROM `producto` WHERE  `nombre_producto` = ?";
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, nombreProducto);
			
			ResultSet resultado = stmt.executeQuery();
			
			if (resultado.next()) {
				
				idProducto = resultado.getInt("id_producto");
			}
			
		}catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Error");
		}
		
		
		return idProducto;
	}


}


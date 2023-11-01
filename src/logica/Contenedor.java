package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import datos.Conexion;

//import javax.swing.JOptionPane;

public class Contenedor {
	
	private int idContenedor;
	private int toneladas;
	//private boolean disponibilidad;
	
	public Contenedor(int idContenedor,int toneladas) {
		super();
		this.idContenedor = idContenedor;
		this.toneladas = toneladas;
	}
	
	public Contenedor() {
		
	}
	
	public int getIdContenedor() {
		return idContenedor;
	}

	public void setIdContenedor(int idContenedor) {
		this.idContenedor = idContenedor;
	}
	public int getToneladas() {
		return toneladas;
	}
	public void setToneladas(int toneladas) {
		this.toneladas = toneladas;
	}
	
	Conexion conexion = new Conexion ();
	Connection con = conexion.conectar(); 
	PreparedStatement stmt;
	
	
	public boolean asignarProducto(int idContenedor, int idProducto) {
		
		//instruccion de CONTENEDOR_PRODUCTO
		
		String sql = "INSERT INTO `contenedor_producto`(`id_contenedor`, `id_producto`) VALUES (?,?)";
		
		try {
			
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idContenedor);
			stmt.setInt(2, idProducto);
			stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
			
	}
	
	
	public LinkedList<Contenedor> mostrarContenedores() {
		String sql = "SELECT * FROM contenedor";
		
		LinkedList<Contenedor> contenedores = new LinkedList<>();
	    
	    try {
	        PreparedStatement stmt = con.prepareStatement(sql);

	        ResultSet resultados = stmt.executeQuery();
	        
	        while (resultados.next()) {
	            int id_contenedor = resultados.getInt("id_contenedor");
	            int	toneladas = resultados.getInt("toneladas");
	

	            Contenedor contenedor = new Contenedor(id_contenedor, toneladas);
	            
	            contenedores.add(contenedor);

	            System.out.println("ID: " + id_contenedor + ", TONELADAS ACT: " + toneladas);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Error");
	    }
	    
	    return contenedores;
	
	} 
	
	
	public int seleccionContenedor(int id) {
		
		int idContenedor = -1;

		String sql = "SELECT `id_contenedor` FROM `contenedor` WHERE  `id_contenedor` = ?";
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet resultado = stmt.executeQuery();
			
			if (resultado.next()) {
				
				idContenedor = resultado.getInt("id_contenedor");
			}
			
		}catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Error");
		}
		
		
		return idContenedor;
	}
	
	
	/*
	
	public void Contener(Producto producto) {
		if (producto.getPeso()<this.capacidad) {
			JOptionPane.showMessageDialog(null, "Su producto podrá ser trasladado dentro de un contenedor");
		} else {
			JOptionPane.showMessageDialog(null, "Su producto no entra en el contenedor");
		}
	}
	*/
	
	
	
}

package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;

import datos.Conexion;

public class RutaMaritima {
	
	
	private int idRuta;
	private  String origen;
	private String destino;
	private int distancia;
	
	public RutaMaritima() {
		
	}
	
	public RutaMaritima(String origen, String destino, int distancia) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.distancia = distancia;
	}
	public int getIdRuta() {
		return idRuta;
	}
	public void setIdRuta(int idRuta) {
		this.idRuta = idRuta;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public int getDistancia() {
		return distancia;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	@Override
	public String toString() {
		return "RutaMaritima [idRuta=" + idRuta + ", origen=" + origen + ", destino=" + destino + ", distancia="
				+ distancia + "]";
	}
	

	Conexion conexion = new Conexion ();
	Connection con = conexion.conectar(); 
	PreparedStatement stmt;
	
	public boolean generarRutaMaritima () {
		
		String sql = "INSERT INTO `ruta_maritima`(`origen`, `destino`, `distancia_ruta`)  VALUES (?,?,?)";
		
		System.out.println(sql);
		System.out.println(stmt);
		
		try {
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, this.getOrigen());
			stmt.setString(2, this.getDestino());
			stmt.setInt(3, this.getDistancia());
			stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
		
	}

	
	
	
	
	
}

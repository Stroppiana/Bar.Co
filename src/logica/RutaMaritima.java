package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

import datos.Conexion;

public class RutaMaritima {
	
	
	private int idRuta;
	private  int origen;
	private int destino;
	private double distancia;
	private String tiempoViaje;
	private String ruta;
	
	
	public RutaMaritima() {
		
	}
	
	public RutaMaritima(int origen, int destino, double distancia, String tiempoViaje) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.distancia = distancia;
		this.tiempoViaje = tiempoViaje;
	}
	
	public RutaMaritima(int idRuta, int origen, int destino, double distancia, String tiempoViaje) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.distancia = distancia;
		this.tiempoViaje = tiempoViaje;
	}
	
	
	public RutaMaritima(String ruta) {
		this.ruta = ruta;
	}




	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public int getIdRuta() {
		return idRuta;
	}
	public void setIdRuta(int idRuta) {
		this.idRuta = idRuta;
	}

	public double getDistancia() {
		return distancia;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	

	public int getOrigen() {
		return origen;
	}

	public void setOrigen(int origen) {
		this.origen = origen;
	}

	public int getDestino() {
		return destino;
	}

	public void setDestino(int destino) {
		this.destino = destino;
	}
	
	
	

	public String getTiempoViaje() {
		return tiempoViaje;
	}

	public void setTiempoViaje(String tiempoViaje) {
		this.tiempoViaje = tiempoViaje;
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
		
		String sql = "INSERT INTO `ruta_maritima`(`origen`, `destino`, `distancia_ruta`, `tiempo_viaje`)  VALUES (?,?,?,?)";
		
		System.out.println(sql);
		System.out.println(stmt);
		
		try {
			
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, this.getOrigen());
			stmt.setInt(2, this.getDestino());
			stmt.setDouble(3, this.getDistancia());
			stmt.setString(4, this.getTiempoViaje());
			stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
		
	}

	
	public boolean guardarDistanciaRuta(int idOrigen, int idDestino) {
	    try {
	        // Consulta SQL para obtener las coordenadas de latitud y longitud de los puertos de origen y destino
	        String sql = "SELECT ubicacion_latitud, ubicacion_longitud FROM puerto WHERE id_puerto = ? OR id_puerto = ?";
	        
	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setInt(1, idOrigen);
	        stmt.setInt(2, idDestino);
	        
	        ResultSet rs = stmt.executeQuery();
	        
	        double latitudOrigen = 0;
	        double longitudOrigen = 0;
	        double latitudDestino = 0;
	        double longitudDestino = 0;
	        
	        while (rs.next()) {
	            int puertoId = rs.getInt("id_puerto");
	            if (puertoId == idOrigen) {
	                latitudOrigen = rs.getDouble("ubicacion_latitud");
	                longitudOrigen = rs.getDouble("ubicacion_longitud");
	            } else if (puertoId == idDestino) {
	                latitudDestino = rs.getDouble("ubicacion_latitud");
	                longitudDestino = rs.getDouble("ubicacion_longitud");
	            }
	        }
	        
	        rs.close();
	        stmt.close();
	        
	        // Calcular la distancia entre los dos puertos
	        double distancia = calcularDistancia(latitudOrigen, longitudOrigen, latitudDestino, longitudDestino);

	        // Actualizar la tabla ruta_maritima con la distancia calculada
	        sql = "UPDATE ruta_maritima SET distancia_ruta = ? WHERE id_ruta_maritima = ?";
	        stmt = con.prepareStatement(sql);
	        stmt.setDouble(1, distancia);
	       // stmt.setInt(2, idRutaMaritima);
	        stmt.executeUpdate();
	        
	        stmt.close();
	        
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	
	public double calcularDistancia(double latitudOrigen, double longitudOrigen, double latitudDestino, double longitudDestino) {
	    // Radio de la Tierra en kilómetros (aproximado)
	    double radioTierra = 6371.0;

	    // Convertir las latitudes y longitudes de grados a radianes
	    double latitudOrigenRad = Math.toRadians(latitudOrigen);
	    double longitudOrigenRad = Math.toRadians(longitudOrigen);
	    double latitudDestinoRad = Math.toRadians(latitudDestino);
	    double longitudDestinoRad = Math.toRadians(longitudDestino);

	    // Diferencia de latitud y longitud
	    double diferenciaLatitud = latitudDestinoRad - latitudOrigenRad;
	    double diferenciaLongitud = longitudDestinoRad - longitudOrigenRad;

	    // Calcular la distancia utilizando la fórmula de Haversine
	    double a = Math.sin(diferenciaLatitud / 2) * Math.sin(diferenciaLatitud / 2) +
	               Math.cos(latitudOrigenRad) * Math.cos(latitudDestinoRad) *
	               Math.sin(diferenciaLongitud / 2) * Math.sin(diferenciaLongitud / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distancia = radioTierra * c;

	    return distancia;
	}
	
	
		public LinkedList<RutaMaritima> mostrarRutas() {
		String sql = "SELECT * FROM ruta_maritima";
		
		LinkedList<RutaMaritima> rutas = new LinkedList<>();
	    
	    try {
	        PreparedStatement stmt = con.prepareStatement(sql);

	        ResultSet resultados = stmt.executeQuery();
	        
	        while (resultados.next()) {
	            int id_ruta_maritima = resultados.getInt("id_ruta_maritima");
	            int origen = resultados.getInt("origen");
	            int destino = resultados.getInt("destino");
	            double distancia_ruta = resultados.getDouble("distancia_ruta");
	            String tiempo_viaje = resultados.getString("tiempo_viaje");
	           
	            
	            RutaMaritima ruta = new RutaMaritima(id_ruta_maritima, origen, destino, distancia_ruta, tiempo_viaje);
	            
	            
	            rutas.add(ruta);

	            System.out.println("ID: " + id_ruta_maritima + ", RUTA ORIGEN: " + origen + ", Destino: " + destino);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Error");
	    }
	    
	    return rutas;
	
	}
		

	

	
	
	
}

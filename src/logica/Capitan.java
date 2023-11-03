package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import datos.Conexion;
import interfaz.PantallaCapitan;

public class Capitan extends Persona {
	private int idCapitan;
	private LinkedList <Capitan> capitanes = new LinkedList <>();
	
	public Capitan(String nombre, String apellido, String mail, String clave, String rol, int idCapitan) {
		super(nombre, apellido, mail, clave);
		this.idCapitan = idCapitan;
		//this.capitanes = capitanes;
	}
	public int getIdCapitan() {
		return idCapitan;
	}
	public void setIdCapitan(int idCapitan) {
		this.idCapitan = idCapitan;
	}
	public LinkedList<Capitan> getCapitanes() {
		return capitanes;
	}
	public void setCapitanes(LinkedList<Capitan> capitanes) {
		this.capitanes = capitanes;
	}
	@Override
	public String toString() {
		return "Capitan [idCapitan=" + idCapitan + ", capitanes=" + capitanes + "]";
	}

	/*
	public void agregar () {
		Capitan capitan1 = new Capitan ("", "", "", "", "", 0);
		capitanes.add(capitan1);
		
	}
	*/
	Conexion conexion = new Conexion ();
	Connection con = conexion.conectar(); 
	PreparedStatement stmt;
	
	
	public boolean inicioSesionCapitan () {
		PantallaCapitan pe = new PantallaCapitan ();
		
		String sql= "SELECT * FROM `capitan` WHERE usuario=? AND clave=?";
		
		try {
			   stmt = con.prepareStatement(sql);
			    stmt.setString(1, this.getMail());
			    stmt.setString(2, this.getClave());
			    
			    
			    ResultSet resultados = stmt.executeQuery();


			    if (resultados.next()) {
			    	pe.MenuCapitan(this);

			        return true;
			        
			    } else {
			        return false;
			    }
		} catch (Exception e) {
			 e.printStackTrace();
			    JOptionPane.showMessageDialog(null, "Error en el inicio de sesión");
			    return false;
		}
		
		
	}
}

package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import datos.Conexion;
import pantallas.PantallaUsuario;
//import java.util.concurrent.atomic.AtomicInteger;

public class Cliente extends Persona {
	
	
	//private static final AtomicInteger indice = new AtomicInteger(0);
	
	private int idCliente;
	private LinkedList <Cliente> clientes = new LinkedList <>();
	

	
	public Cliente(int idCliente,String nombre, String apellido, String mail, String clave) {
		super(nombre, apellido, mail, clave);
		this.idCliente = idCliente;
	}
	
	public Cliente(String nombre, String apellido, String mail, String clave) {
		super(nombre, apellido, mail, clave);
	}
	
	
	
	public Cliente() {
		
	}
	

	public int getIdCliente() { 
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	

	public LinkedList<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(LinkedList<Cliente> clientes) {
		this.clientes = clientes;
	}

	
	

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", toString()=" + super.toString() + "]";
	}




	HistorialEnvio he = new HistorialEnvio (0, null);
	//Producto pr = new Producto (0, null, 0, null, null);
	
	Conexion conexion = new Conexion ();
	Connection con = conexion.conectar(); 
	PreparedStatement stmt;
	
	
	public boolean inicioSsesionCliente () {
		PantallaUsuario p= new PantallaUsuario ();
		
		String sql = "SELECT * FROM `cliente` WHERE usuario=? AND clave=?";

		try {
		    stmt = con.prepareStatement(sql);
		    stmt.setString(1, this.getMail());
		    stmt.setString(2, this.getClave());
		    
		    
		    ResultSet resultados = stmt.executeQuery();


		    if (resultados.next()==true) {
		    	p.run();

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
		
		
	
	public Cliente obtenerCliente(int idCliente) {
	    String sql = "SELECT * FROM `cliente` WHERE id_cliente=?";
	    Cliente cliente = null;

	    try (PreparedStatement stmt = con.prepareStatement(sql)) {
	        stmt.setInt(1, idCliente);

	        try (ResultSet resultados = stmt.executeQuery()) {
	            if (resultados.next()) {
	            	
	                int id = resultados.getInt("id_cliente");
	                String nombre = resultados.getString("nombre"); 
	                String apellido = resultados.getString("apellido"); 
	                String usuario = resultados.getString("usuario"); 
	                String clave = resultados.getString("clave"); 


	                
	                cliente = new Cliente(id, nombre, apellido, usuario, clave); 

	                return cliente;
	            } else {
	                return null;
	            }
	        }
		} catch (Exception e) {
		    e.printStackTrace();
		    JOptionPane.showMessageDialog(null, "Error en el inicio de sesión");
		    return null;
		}
	}

	
	
	public boolean guardar () {
		
		String sql = "INSERT INTO `cliente`( `nombre`, `apellido`, `usuario`, `clave`)  VALUES (?,?,?,?)";
		
		System.out.println(sql);
		System.out.println(stmt);
		
		try {
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, this.getNombre());
			stmt.setString(2, this.getApellido());
			stmt.setString(3, this.getMail());
			stmt.setString(4, this.getClave());
			stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
		
	}
	
	 public boolean solicitarEnvio(Producto producto, Divisa divisa) {
		    String sql = "INSERT INTO `producto` (`nombre_producto`, `fragilidad`, `peso`, `id_divisa`) VALUES (?,?,?,?)";

		    try {
		        stmt = con.prepareStatement(sql);
		        stmt.setString(1, producto.getNombre());
		        stmt.setString(2, producto.getFragil());
		        stmt.setLong(3, producto.getPeso());
		        stmt.setInt(4, divisa.getId_divisa());
		      
		        stmt.execute();
		        return true;
		    } catch (Exception e) {
		        return false;
		    }

		}

	
	public void infoEnvio(LinkedList<Envio> envios) {
		if (envios.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay envios para mostrar");
		}
		for (Envio envio : envios) {
			JOptionPane.showMessageDialog(null, envios +"\n");
		}
		
	}
	
	public LinkedList<Cliente> mostrarClientes() {
		
		LinkedList<Cliente> clientes = new LinkedList<>();

		String sql = "SELECT * from cliente";

		try {

			stmt = con.prepareStatement(sql);
			ResultSet resultados = stmt.executeQuery();

			while (resultados.next()) {

				int id = resultados.getInt(1);
				String nombre = resultados.getString(2);
				String apellido = resultados.getString(3);
				String usuario = resultados.getString(4);
				String clave = resultados.getString(5);

				clientes.add(new Cliente(id, nombre, apellido, usuario, clave));
				
			}

			if (clientes.isEmpty()) {

				String mensaje = "No hay clientes";
				System.out.println(mensaje);
				return null;

			} else {

				return clientes;
			}
		} catch (Exception e) {

			System.out.println("Error");
			return null;
		}

	}
	
	
	/*
	
	public void elegirFecha(Envio envio) {
		LocalDate fecha_envio = LocalDate.now();
	       
        Date fechaformatodate = (Date) Date.from(
                fecha_envio.atStartOfDay(
                        ZoneId.systemDefault())
                .toInstant());
       envio.setFecha_envio((java.sql.Date) fechaformatodate);
       
       String fecha_entrega=JOptionPane.showInputDialog("ingresar fecha");
       DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");

       
       
		    String sql ="INSERT INTO  'envio'('fecha_envio','fecha_entrega')VALUE (?,?)";
		
		    try {
		    	stmt = con.prepareStatement(sql);
		    	stmt.setDate(1,envio.getFecha_envio());
		    	stmt.setDate(2,envio.getFecha_entrega());
			} catch (Exception e) {
				// TODO: handle exception
			}
	}

*/
	
	
}

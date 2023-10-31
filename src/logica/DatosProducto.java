package logica;

import javax.swing.JOptionPane;

public interface DatosProducto {

    public default boolean nombrePorducto (String nombre) {

        if (nombre.isEmpty() || nombre.length()<=1  ||  nombre.contains("@")  || nombre.contains(".")   || nombre.contains("?")  || nombre.contains(",")) {

            JOptionPane.showMessageDialog(null, "Nombre de producto ingresado incorrecrtamente");
            return false;
        }else {
            return true;

        }
    }

    public default boolean pesoProducto (int peso) {

        if (peso==0) {
            JOptionPane.showMessageDialog(null, "Error en el peso ingresado");
        return false;
        }
        return true;

    }
}
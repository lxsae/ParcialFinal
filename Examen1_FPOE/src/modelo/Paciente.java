package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *          UNIVERSIDAD DEL VALLE 
 *         PARCIAL CLINICA UNIVALLE
 * @author Ivan Noriega 2126012-3743
 * 
 */

public class Paciente {
    private String nombre;
    private String apellido;
    private String telefono;
    private String identificacion;
    private String direccion;
    private List<String> alergias;

    public Paciente(String nombre, String apellido, String telefono, String identificacion, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.alergias = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(List<String> alergias) {
        this.alergias = alergias;
    }
}

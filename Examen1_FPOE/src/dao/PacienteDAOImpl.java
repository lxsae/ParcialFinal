package dao;

import modelo.Paciente;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *          UNIVERSIDAD DEL VALLE 
 *         PARCIAL CLINICA UNIVALLE
 * @author Ivan Noriega 2126012-3743
 * 
 */
public class PacienteDAOImpl implements PacienteDAO {
    @Override
    public void guardarPaciente(Paciente paciente) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("pacientes.txt", true))) {
            writer.write("Nombre: " + paciente.getNombre() + "\n");
            writer.write("Apellido: " + paciente.getApellido() + "\n");
            writer.write("Teléfono: " + paciente.getTelefono() + "\n");
            writer.write("Identificación: " + paciente.getIdentificacion() + "\n");
            writer.write("Dirección: " + paciente.getDireccion() + "\n");
            writer.write("Alergias: " + paciente.getAlergias() + "\n");
            writer.write("------------------------------------\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package controlador;

import dao.PacienteDAO;
import dao.PacienteDAOImpl;
import modelo.Paciente;
import vista.FormularioPaciente;

import java.util.ArrayList;
import java.util.List;

/**
 *          UNIVERSIDAD DEL VALLE 
 *         PARCIAL CLINICA UNIVALLE
 * @author Ivan Noriega 2126012-3743
 * 
 */

public class ControladorPaciente {
    private FormularioPaciente formularioPaciente;
    private PacienteDAO pacienteDAO;

    public ControladorPaciente() {
        formularioPaciente = new FormularioPaciente();
        pacienteDAO = new PacienteDAOImpl();

        formularioPaciente.getBtnGuardar().addActionListener(e -> guardarPaciente());
    }

    private void guardarPaciente() {
        String nombre = formularioPaciente.getNombre();
        String apellido = formularioPaciente.getApellido();
        String telefono = formularioPaciente.getTelefono();
        String identificacion = formularioPaciente.getIdentificacion();
        String direccion = formularioPaciente.getDireccion();

        Paciente paciente = new Paciente(nombre, apellido, telefono, identificacion, direccion);

        List<String> alergias = new ArrayList<>();
        for (int i = 0; i < formularioPaciente.getAlergiasSeleccionadas().length; i++) {
            alergias.add(formularioPaciente.getAlergiasSeleccionadas()[i]);
        }
        paciente.setAlergias(alergias);

        pacienteDAO.guardarPaciente(paciente);

        System.out.println("Paciente guardado correctamente:");
        System.out.println("Nombre: " + paciente.getNombre());
        System.out.println("Apellido: " + paciente.getApellido());
        System.out.println("Teléfono: " + paciente.getTelefono());
        System.out.println("Identificación: " + paciente.getIdentificacion());
        System.out.println("Dirección: " + paciente.getDireccion());
        System.out.println("Alergias: " + paciente.getAlergias());
    }

    public void iniciar() {
        formularioPaciente.mostrar();
    }
}


package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.TitledBorder;

/**
 *          UNIVERSIDAD DEL VALLE 
 *         PARCIAL CLINICA UNIVALLE
 * @author Ivan Noriega 2126012-3743
 * 
 */

public class FormularioPaciente extends JFrame {
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtTelefono;
    private JTextField txtIdentificacion;
    private JTextField txtDireccion;
    private JComboBox<String> comboBoxAlergias;
    private JButton btnGuardar;
    private JButton btnActualizar;
    private JButton btnAgregarAlergia;
    private JList<String> listaAlergias;
    private DefaultListModel<String> alergiasModel;

    public FormularioPaciente() {
        setTitle("GESTION PACIENTES");
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());

        JPanel panelDatosPaciente = new JPanel();
        panelDatosPaciente.setLayout(new GridLayout(5, 2));
        // Agregar título al panel de datos del paciente
        JLabel lblTituloDatosPaciente = new JLabel("Datos Paciente");
        lblTituloDatosPaciente.setFont(new Font("Arial", Font.BOLD, 12));
        panelDatosPaciente.setBorder(BorderFactory.createTitledBorder(lblTituloDatosPaciente.getBorder(), lblTituloDatosPaciente.getText(), TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, lblTituloDatosPaciente.getFont()));

        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(20);

        JLabel lblApellido = new JLabel("Apellido:");
        txtApellido = new JTextField(20);

        JLabel lblTelefono = new JLabel("Teléfono:");
        txtTelefono = new JTextField(20);

        JLabel lblIdentificacion = new JLabel("Identificación:");
        txtIdentificacion = new JTextField(20);

        JLabel lblDireccion = new JLabel("Dirección:");
        txtDireccion = new JTextField(20);

        panelDatosPaciente.add(lblIdentificacion);
        panelDatosPaciente.add(txtIdentificacion);
        panelDatosPaciente.add(lblNombre);
        panelDatosPaciente.add(txtNombre);
        panelDatosPaciente.add(lblApellido);
        panelDatosPaciente.add(txtApellido);
        panelDatosPaciente.add(lblTelefono);
        panelDatosPaciente.add(txtTelefono);
        panelDatosPaciente.add(lblDireccion);
        panelDatosPaciente.add(txtDireccion);
        panelPrincipal.add(panelDatosPaciente, BorderLayout.NORTH);

        JPanel panelAlergias = new JPanel();
        panelAlergias.setLayout(new GridLayout(3, 1));
        JLabel lblTituloAlergias = new JLabel("Alergias");
        lblTituloAlergias.setFont(new Font("Arial", Font.BOLD, 12));
        panelAlergias.setBorder(BorderFactory.createTitledBorder(lblTituloAlergias.getBorder(), lblTituloAlergias.getText(), TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, lblTituloAlergias.getFont()));

        JLabel lblAlergias = new JLabel("Alergias:");
        comboBoxAlergias = new JComboBox<>();
        comboBoxAlergias.setPreferredSize(new Dimension(150, 20));
        comboBoxAlergias.addItem("POLVO");
        comboBoxAlergias.addItem("MARISCOS");
        comboBoxAlergias.addItem("GATOS");

        btnAgregarAlergia = new JButton("Agregar Alergia");
        btnAgregarAlergia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarAlergia();
            }
        });

        alergiasModel = new DefaultListModel<>();
        listaAlergias = new JList<>(alergiasModel);

        JLabel lblListaAlergias = new JLabel("Alergias Seleccionadas:");

        panelAlergias.add(lblAlergias);
        panelAlergias.add(comboBoxAlergias);
        panelAlergias.add(btnAgregarAlergia);
        panelAlergias.add(lblListaAlergias);
        panelAlergias.add(new JScrollPane(listaAlergias));

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        
        JLabel lblTituloBotones = new JLabel("Controladores");
        lblTituloBotones.setFont(new Font("Arial", Font.BOLD, 12));

        
        panelBotones.setBorder(BorderFactory.createTitledBorder(lblTituloBotones.getBorder(), lblTituloBotones.getText(), TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, lblTituloBotones.getFont()));

        btnGuardar = new JButton("Guardar");
        btnActualizar = new JButton("Actualizar");
        btnGuardar.setPreferredSize(new Dimension(100, 30));
        btnActualizar.setPreferredSize(new Dimension(100, 30));

        panelBotones.add(btnGuardar);
        panelBotones.add(btnActualizar);
        

        panelPrincipal.add(panelAlergias, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.EAST);

        add(panelPrincipal);
    }

    public String getNombre() {
        return txtNombre.getText();
    }

    public String getApellido() {
        return txtApellido.getText();
    }

    public String getTelefono() {
        return txtTelefono.getText();
    }

    public String getIdentificacion() {
        return txtIdentificacion.getText();
    }

    public String getDireccion() {
        return txtDireccion.getText();
    }

    public String getAlergiaSeleccionada() {
        return comboBoxAlergias.getSelectedItem().toString();
    }

    public void agregarAlergia() {
        String alergia = JOptionPane.showInputDialog(this, "Ingrese una nueva alergia:");
        if (alergia != null && !alergia.isEmpty()) {
            alergiasModel.addElement(alergia);
        }
    }

    public String[] getAlergiasSeleccionadas() {
        int size = alergiasModel.getSize();
        String[] alergias = new String[size];
        for (int i = 0; i < size; i++) {
            alergias[i] = alergiasModel.getElementAt(i);
        }
        return alergias;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void mostrar() {
        setVisible(true);
    }
}

package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Arrays;
import javax.swing.*;

public class Ingreso extends JFrame {

    private static final long serialVersionUID = 1L;
    private JButton btnIngresar;
    private JProgressBar barra;
    private int intentosFallidos = 0;
    private long esperaSegundos = 20;
    private boolean bloqueoAnterior = false;
    private javax.swing.Timer timerBloqueo;

    public Ingreso() {
        setTitle("MEPSO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 210);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new BorderLayout(10, 15));
        panel.setBorder(
                BorderFactory.createEmptyBorder(20, 25, 20, 25));
        setContentPane(panel);

        JLabel titulo = new JLabel(
                "BIENVENIDO A MEPSO-SALUD OCUPACIONAL",
                SwingConstants.CENTER);
        panel.add(titulo, BorderLayout.NORTH);

        btnIngresar = new JButton("Ingresar");
        btnIngresar.addActionListener(e -> solicitarAcceso());
        JPanel panelBoton = new JPanel();
        btnIngresar.setPreferredSize(new java.awt.Dimension(280, 35));
        panelBoton.add(btnIngresar);
        panel.add(panelBoton, BorderLayout.CENTER);

        barra = new JProgressBar(0, 100);
        barra.setStringPainted(true);
        barra.setVisible(false);
        panel.add(barra, BorderLayout.SOUTH);
    }

    private void solicitarAcceso() {
        JTextField usuario = new JTextField();
        JPasswordField clave = new JPasswordField();

        JPanel formulario = new JPanel(new GridLayout(4, 1, 5, 5));
        formulario.add(new JLabel("Usuario:"));
        formulario.add(usuario);
        formulario.add(new JLabel("Contraseña:"));
        formulario.add(clave);

        int opcion = JOptionPane.showConfirmDialog(
                this, formulario, "Ingreso",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (opcion != JOptionPane.OK_OPTION) {
            return;
        }

        char[] ingresada = clave.getPassword();
        char[] esperada = {'1', '2', '3', '4', '5', '6'};

        boolean correcto =
                usuario.getText().trim().equals("admin")
                && Arrays.equals(ingresada, esperada);

        Arrays.fill(ingresada, '\0');
        Arrays.fill(esperada, '\0');
        clave.setText("");

        if (!correcto) {
            intentosFallidos++;

            if (bloqueoAnterior) {
                esperaSegundos *= 2;
                bloquearIngreso();
            } else if (intentosFallidos >= 3) {
                bloqueoAnterior = true;
                bloquearIngreso();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Usuario o contraseña incorrectos."
                        + "\nIntentos restantes: " + (3 - intentosFallidos));
            }

            return;
        }

        intentosFallidos = 0;
        esperaSegundos = 20;
        bloqueoAnterior = false;

        iniciarCarga();
        }

private void bloquearIngreso() {
    btnIngresar.setEnabled(false);

    long fin = System.nanoTime()
            + esperaSegundos * 1_000_000_000L;

    btnIngresar.setText(
            "Intentar en " + esperaSegundos + " segundos");

    if (timerBloqueo != null) {
        timerBloqueo.stop();
    }

    timerBloqueo = new javax.swing.Timer(200, e -> {
        long restante = fin - System.nanoTime();

        if (restante <= 0) {
            ((javax.swing.Timer) e.getSource()).stop();
            btnIngresar.setText("Ingresar");
            btnIngresar.setEnabled(true);
        } else {
            long segundos =
                    (restante + 999_999_999L) / 1_000_000_000L;

            btnIngresar.setText(
                    "Intentar en " + segundos + " segundos");
        }
    });

    timerBloqueo.start();

    JOptionPane.showMessageDialog(this,
            "¡Ya alcanzaste el límite de intentos!"
            + "\nIntenta en " + esperaSegundos + " segundos.");
}

    private void iniciarCarga() {
        btnIngresar.setEnabled(false);
        barra.setValue(0);
        barra.setVisible(true);

        long inicio = System.nanoTime();

        Timer timer = new Timer(40, e -> {
            long transcurrido =
                    (System.nanoTime() - inicio) / 1_000_000;

            int progreso = (int) Math.min(
                    100, transcurrido * 100 / 2000);

            barra.setValue(progreso);

            if (transcurrido >= 2000) {
                ((Timer) e.getSource()).stop();

                V1 ventana = new V1();
                ventana.setLocationRelativeTo(null);
                ventana.setVisible(true);
                dispose();
            }
        });

        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                () -> new Ingreso().setVisible(true));
    }
}

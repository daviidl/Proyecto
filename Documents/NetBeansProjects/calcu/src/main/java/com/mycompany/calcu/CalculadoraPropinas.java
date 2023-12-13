/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calcu;

/**
 *
 * @author David
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraPropinas {
    private JFrame frame;
    private JTextField precioTotalTextField;
    private JComboBox<String> porcentajeComboBox;
    private JLabel propinaLabel;
    private JLabel totalConPropinaLabel;

    public CalculadoraPropinas() {
        // Creación de frame
        frame = new JFrame("Calculadora de Propinas");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Creación de componentes
        precioTotalTextField = new JTextField();
        porcentajeComboBox = new JComboBox<>(new String[]{"Seleccione porcentaje", "5%", "10%", "15%"});
        propinaLabel = new JLabel("Propina: ");
        totalConPropinaLabel = new JLabel("Total con propina: ");

        JButton calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularPropina();
            }
        });

        JButton restaurarButton = new JButton("Restaurar");
        restaurarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restaurarValores();
            }
        });

        // Configuración del layout
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // Agregar componentes al frame
        frame.add(new JLabel("Precio total de la comida: "));
        frame.add(precioTotalTextField);
        frame.add(new JLabel("Seleccione el porcentaje de propina: "));
        frame.add(porcentajeComboBox);
        frame.add(calcularButton);
        frame.add(restaurarButton);
        frame.add(propinaLabel);
        frame.add(totalConPropinaLabel);
    }

    private void calcularPropina() {
        try {
            double precioTotal = Double.parseDouble(precioTotalTextField.getText());

            // Validar que el precio total sea mayor que 0
            if (precioTotal <= 0) {
                JOptionPane.showMessageDialog(frame, "Ingrese un precio total mayor que 0.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar que se haya seleccionado un porcentaje
            if (porcentajeComboBox.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(frame, "Seleccione un porcentaje válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String porcentajeSeleccionado = (String) porcentajeComboBox.getSelectedItem();
            double porcentaje = Double.parseDouble(porcentajeSeleccionado.replace("%", "")) / 100.0;

            double propina = precioTotal * porcentaje;
            double totalConPropina = precioTotal + propina;

            propinaLabel.setText("Propina: $" + propina);
            totalConPropinaLabel.setText("Total con propina: $" + totalConPropina);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Ingrese un valor válido para el precio total.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void restaurarValores() {
        precioTotalTextField.setText("");
        porcentajeComboBox.setSelectedIndex(0);
        propinaLabel.setText("Propina: ");
        totalConPropinaLabel.setText("Total con propina: ");
    }

    public void mostrarVentana() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        CalculadoraPropinas calculadora = new CalculadoraPropinas();
        calculadora.mostrarVentana();
    }
}


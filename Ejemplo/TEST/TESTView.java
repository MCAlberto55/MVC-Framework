package TEST;

import MVC.View;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class TESTView extends View {

    private JFrame frame;
    private JPanel panel;
    private JButton boton;
    private JTextArea respuesta;
    private JLabel label;

    public TESTView() {
        this.frame = new JFrame();
        this.panel = new JPanel();
        frame.setSize(400,550);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        initElements();
    }

    private void initElements() {
        boton = new JButton("¡Hola Mundo!");
        boton.setBounds(100,50,200,50);

        ActionListener presion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                communicate();
            }
        };
        boton.addActionListener(presion);

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        respuesta = new JTextArea();
        respuesta.setBounds(40,180,300,150);
        respuesta.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 0)));
        respuesta.setLineWrap(true);
        respuesta.setWrapStyleWord(true);
        respuesta.setEditable(false);

        label = new JLabel("Respuesta:");
        label.setBounds(40,150,150,30);

        panel.add(boton);
        panel.add(label);
        panel.add(respuesta);
    }

    @Override
    public void update() {
        String a = this.model.getData();
        System.out.println("he recibido como respuesta: " + a);
        respuesta.setText(a);
    }

    @Override
    public void display() {
        frame.setVisible(true);
    }
}

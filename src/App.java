import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;
import java.awt.*;

public class App extends JFrame implements ActionListener, ItemListener, ChangeListener {

    private JMenuBar mb;
    private JMenu menu1, menu2;
    private JMenuItem mitem1, mitem2, mitem3, mitem4, mitem5, mitem6;

    private JLabel jlabel1, jlabel2, jlabel3, jlabel4, jlabel5;
    private JButton jbtn, jbtn2;
    private JTextField jtf1;
    private JTextArea jta1;
    private JScrollPane jspan;
    private JComboBox<String> combo;
    private Color colorFondo;
    private JCheckBox check1, check2;
    private JRadioButton radio1, radio2;
    private ButtonGroup bg;

    public App() {
        setLayout(null);

        colorFondo = new Color(230, 255, 230);

        mb = new JMenuBar();
        setJMenuBar(mb);

        menu1 = new JMenu("Color");
        mb.add(menu1);

        mitem1 = new JMenuItem("Rojo");
        mitem1.addActionListener(this);
        menu1.add(mitem1);

        mitem2 = new JMenuItem("Verde");
        mitem2.addActionListener(this);
        menu1.add(mitem2);

        mitem3 = new JMenuItem("Azul");
        mitem3.addActionListener(this);
        menu1.add(mitem3);

        mitem4 = new JMenuItem("Blanco");
        mitem4.addActionListener(this);
        menu1.add(mitem4);

        menu2 = new JMenu("Tamaño");
        mb.add(menu2);

        mitem5 = new JMenuItem("Grande");
        mitem5.addActionListener(this);
        menu2.add(mitem5);

        mitem6 = new JMenuItem("Pequeño");
        mitem6.addActionListener(this);
        menu2.add(mitem6);

        jlabel1 = new JLabel("Nombre");
        jlabel1.setBounds(10, 20, 100, 30);
        add(jlabel1);

        jtf1 = new JTextField();
        jtf1.setBounds(80, 20, 100, 30);
        add(jtf1);

        jlabel2 = new JLabel("Nombre a mostrar");
        jlabel2.setBounds(10, 60, 300, 30);
        add(jlabel2);

        jbtn = new JButton("Click");
        jbtn.setBounds(10, 100, 100, 30);
        add(jbtn);
        jbtn.addActionListener(this);
        jbtn.setBackground(colorFondo);
        jbtn.setEnabled(true);

        jbtn2 = new JButton("No click");
        jbtn2.setBounds(120, 100, 100, 30);
        add(jbtn2);
        jbtn2.setEnabled(false);

        jta1 = new JTextArea();
        jta1.setBounds(10, 100, 200, 100);
        jta1.setLineWrap(true);
        jta1.setWrapStyleWord(true);

        jspan = new JScrollPane(jta1);
        jspan.setBounds(10, 140, 200, 100);
        add(jspan);

        combo = new JComboBox<String>();
        combo.setBounds(10, 260, 100, 30);
        add(combo);
        combo.addItem("Manzana");
        combo.addItem("Pera");
        combo.addItem("Melocotón");
        combo.addItemListener(this);

        jlabel3 = new JLabel("Elección: ");
        jlabel3.setBounds(10, 300, 140, 30);
        add(jlabel3);

        check1 = new JCheckBox("Inglés");
        check1.setBounds(10, 340, 100, 30);
        check1.addChangeListener(this);
        add(check1);

        check2 = new JCheckBox("Español");
        check2.setBounds(10, 380, 100, 30);
        check2.addChangeListener(this);
        add(check2);

        jlabel4 = new JLabel("...");
        jlabel4.setBounds(10, 420, 100, 30);
        add(jlabel4);

        bg = new ButtonGroup();

        radio1 = new JRadioButton("Hola");
        radio1.setBounds(10, 460, 100, 30);
        radio1.addChangeListener(this);
        add(radio1);
        bg.add(radio1);

        radio2 = new JRadioButton("Adiós");
        radio2.setBounds(110, 460, 100, 30);
        radio2.addChangeListener(this);
        add(radio2);
        bg.add(radio2);

        jlabel5 = new JLabel("...");
        jlabel5.setBounds(210, 460, 100, 30);
        add(jlabel5);

    }

    public static void main(String[] args) throws Exception {

        App miApp = new App();

        miApp.setBounds(10, 10, 450, 600);
        miApp.setVisible(true);
        miApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Container f = this.getContentPane();

        if (e.getSource() == jbtn) {
            String username = jtf1.getText();
            jlabel2.setText("Nombre: " + username);
        }

        if (e.getSource() == mitem1) {
            f.setBackground(new Color(255, 0, 0));
        }

        if (e.getSource() == mitem2) {
            f.setBackground(new Color(0, 255, 0));
        }

        if (e.getSource() == mitem3) {
            f.setBackground(new Color(0, 0, 255));
        }

        if (e.getSource() == mitem4) {
            f.setBackground(new Color(255, 255, 255));
        }

        if (e.getSource() == mitem5) {
            setSize(1920, 1080);
        }

        if (e.getSource() == mitem6) {
            setSize(640, 480);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == combo) {
            String opcionActual = (String) combo.getSelectedItem();
            jlabel3.setText("Elección: " + opcionActual);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (check1.isSelected() == true) {
            jlabel4.setText("No está mal");
        }
        if (check2.isSelected() == true) {
            jlabel4.setText("No está mal");
        }
        if (check1.isSelected() && check2.isSelected()) {
            jlabel4.setText("¡GENIAL!");
        }
        if (!check1.isSelected() && !check2.isSelected()) {
            jlabel4.setText("Mejorable... ");
        }

        if (radio1.isSelected()) {
            jlabel5.setText("¡Bienvenido!");
        }
        if (radio2.isSelected()) {
            jlabel5.setText("¡Hasta luego!");
        }

    }
}

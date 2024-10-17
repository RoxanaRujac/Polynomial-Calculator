package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

//butoane + titlu (0,0,128)
//background (100,149,237)
//scris pe butoane (173,216,230)
//scris pe background (0,0,128)

public class UserInterface extends JPanel {

    JTextField firstText;
    JTextField secondText;
    JTextField thirdText;

    //fields labels
    JLabel label1;
    JLabel label2;
    JLabel label3;

    //buttons
    JButton Add;
    JButton Subtract;
    JButton Multiply;
    JButton Divide;
    JButton Integrate;
    JButton Derivate;

    JButton Clear;
    Controller controller;

    public UserInterface() {
        setLayout();
        createElements();
        addToPanel();
        controller = new Controller(this, thirdText);
    }

    private void setLayout() {
        //create
        setLayout(null);
        setBackground(new Color(100, 149, 237));
        setBorder(BorderFactory.createBevelBorder(1, new Color(0, 0, 128), new Color(0, 0, 128), new Color(0, 0, 128), new Color(0, 0, 128)));
        setPreferredSize(new Dimension(550, 550));
    }

    private void createElements() {
        createTextFields();
        createLabels();
        createButtons();
    }

    private void createTextFields() {
        //create
        firstText = new JTextField();
        secondText = new JTextField();
        thirdText = new JTextField();

        //color
        firstText.setBackground(new Color(176, 224, 230));
        secondText.setBackground(new Color(176, 224, 230));
        thirdText.setBackground(new Color(176, 224, 230));

    }

    private void createLabels() {
        //add title
        JLabel titleLabel = new JLabel("Polynomial Calculator");
        titleLabel.setFont(new Font("TT Octosquares Trl", Font.BOLD, 25));
        titleLabel.setForeground(new Color(0, 0, 128));
        add(titleLabel);
        titleLabel.setBounds(130, 10, 400, 30);

        //texts
        label1 = new JLabel("first polynomial  = ");
        label1.setFont(new Font("TT Octosquares Trl", 0, 12));

        label2 = new JLabel("second polynomial  = ");
        label2.setFont(new Font("TT Octosquares Trl", 0, 12));

        label3 = new JLabel("result  = ");
        label3.setFont(new Font("TT Octosquares Trl", 0, 12));
    }

    private void createButtons() {
        Add = createStyledButton("add", new Color(0,0,128), new Color(173,216,230));
        Subtract = createStyledButton("subtract", new Color(0,0,128), new Color(173,216,230));
        Multiply = createStyledButton("multiply", new Color(0,0,128), new Color(173,216,230));
        Divide = createStyledButton("divide",  new Color(0,0,128), new Color(173,216,230));
        Integrate = createStyledButton("integrate",  new Color(0,0,128), new Color(173,216,230));
        Derivate = createStyledButton("derivate",  new Color(0,0,128), new Color(173,216,230));
        createKeyboard();
    }

    private void createKeyboard(){
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.add(createButtonWithAction("1"));
        buttonPanel.add(createButtonWithAction("2"));
        buttonPanel.add(createButtonWithAction("3"));
        buttonPanel.add(createButtonWithAction("4"));
        buttonPanel.add(createButtonWithAction("5"));
        buttonPanel.add(createButtonWithAction("6"));
        buttonPanel.add(createButtonWithAction("7"));
        buttonPanel.add(createButtonWithAction("8"));
        buttonPanel.add(createButtonWithAction("9"));
        buttonPanel.setPreferredSize(new Dimension(130, 130));
        add(buttonPanel);
        buttonPanel.setBounds(135, 380, 135, 130);

        JPanel buttonPanel2 = new JPanel();
        buttonPanel2.setLayout(new GridLayout(3,3));
        buttonPanel2.add(createButtonWithAction("0"));
        buttonPanel2.add(createButtonWithAction("."));
        buttonPanel2.add(createButtonWithAction(","));
        buttonPanel2.add(createButtonWithAction("+"));
        buttonPanel2.add(createButtonWithAction("-"));
        buttonPanel2.add(createButtonWithAction("*"));
        buttonPanel2.add(createButtonWithAction("/"));
        buttonPanel2.add(createButtonWithAction("^"));
        buttonPanel2.add(createButtonWithAction("c"));
        buttonPanel2.setPreferredSize(new Dimension(130, 130));
        add(buttonPanel2);
        buttonPanel2.setBounds(270, 380, 135, 130);
    }

    private JButton createButtonWithAction(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(173,216,230));
        button.setForeground(new Color(0,0,128));
        button.setFont(new Font("TT Octosquares Trl", 0, 12));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    if (text.equals("c")) {
                        firstText.setText("");
                        secondText.setText("");
                        thirdText.setText("");
                    }
                }
            });
        return button;
    }


    private JButton createStyledButton(String text, Color color1, Color color2) {
        JButton button = new JButton(text);
        button.setBackground(color1);
        button.setForeground(color2);
        button.setFont(new Font("TT Octosquares Trl", 0, 12));
        return button;
    }

    private void addToPanel() {
        //add
        add(firstText);
        add(secondText);
        add(thirdText);

        add(label1);
        add(label2);
        add(label3);

        add(Add);
        add(Subtract);
        add(Multiply);
        add(Divide);
        add(Derivate);
        add(Integrate);

        setCoordinates();
    }

    private void setCoordinates(){
        //coordinates
        firstText.setBounds(230, 80, 200, 30);
        secondText.setBounds(230, 130, 200, 30);
        thirdText.setBounds(230, 180, 200, 30 );

        label1.setBounds(110, 70, 200, 50);
        label2.setBounds(90, 120, 200, 50);
        label3.setBounds(170, 170, 200, 50);

        Add.setBounds(120, 250, 100, 50);
        Multiply.setBounds(220, 250, 100, 50);
        Derivate.setBounds(320,  250, 100, 50);
        Subtract.setBounds(120, 300, 100, 50);
        Divide.setBounds(220, 300, 100, 50);
        Integrate.setBounds(320, 300, 100, 50);
    }

}

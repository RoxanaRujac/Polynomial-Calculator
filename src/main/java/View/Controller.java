package View;

import Model.Polynomial;
import Controller.Operations;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private UserInterface view;
    private JTextField resultText;
    private Polynomial polynomial1;
    private Polynomial polynomial2;

    public Controller(UserInterface view, JTextField result) {
        this.view = view;
        this.resultText = result;

        view.Add.addActionListener(this);
        view.Subtract.addActionListener(this);
        view.Multiply.addActionListener(this);
        view.Divide.addActionListener(this);
        view.Integrate.addActionListener(this);
        view.Derivate.addActionListener(this);
    }


    public boolean isValid(String polynomial){
        for (char c : polynomial.toCharArray()) {
            if (Character.isLetter(c)) {
                //has any other letter besides x
                if (c != 'x') {
                    return false;
                }
                //has ony other signs besides ...
            } else if (!Character.isDigit(c) && c != '^' && c != '+' && c != '-' && c != ' ' && c != '.') {
                return false;
            }
        }
        return true;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String firstP = view.firstText.getText();
        String secondP = view.secondText.getText();

        //if the strings aren't valid polynomials
        if (!isValid(firstP) || !isValid(secondP)){
            JOptionPane.showMessageDialog(null, "One or both polynomials are invalid.", "Invalid Polynomials", JOptionPane.WARNING_MESSAGE);
        }

        polynomial1 = new Polynomial(firstP);
        polynomial2 = new Polynomial(secondP);
        Polynomial result = new Polynomial("0");

        Operations op = new Operations();

        if (e.getSource() == view.Add) {
           result = op.add(polynomial1, polynomial2);
        } else if (e.getSource() == view.Subtract) {
           result = op.subtract(polynomial1, polynomial2);
        } else if (e.getSource() == view.Multiply) {
            result = op.multiply(polynomial1, polynomial2);
        } else if (e.getSource() == view.Divide) {
            result = op.divide(polynomial1, polynomial2);
        } else if (e.getSource() == view.Derivate) {
            result = op.derivate(polynomial1);
        } else if (e.getSource() == view.Integrate) {
            result = op.integrate(polynomial1);
        }

        String resultStr = result.toString(result);
        resultText.setText(resultStr);
    }

}

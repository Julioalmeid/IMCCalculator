import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IMCCalculator extends JFrame {
    private JLabel weightLabel;
    private JTextField weightTextField;
    private JLabel heightLabel;
    private JTextField heightTextField;
    private JButton calculateButton;
    private JLabel resultLabel;
    private JLabel classificationLabel;

    public IMCCalculator() {
        setTitle("Calculadora IMC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        weightLabel = new JLabel("Peso (Kg):");
        weightTextField = new JTextField();
        heightLabel = new JLabel("Altura (cm):");
        heightTextField = new JTextField();
        calculateButton = new JButton("Calcular");
        resultLabel = new JLabel();
        classificationLabel = new JLabel();

        add(weightLabel);
        add(weightTextField);
        add(heightLabel);
        add(heightTextField);
        add(calculateButton);
        add(resultLabel);
        add(classificationLabel);

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateIMC();
            }
        });
    }

    private void calculateIMC() {
        double weight = Double.parseDouble(weightTextField.getText());
        double height = Double.parseDouble(heightTextField.getText()) / 100; // convertendo cm para metros

        double imc = weight / (height * height);

        String result;
        String classification;

        if (imc < 18.5) {
            result = "Abaixo do peso";
            classification = "Magreza";
        } else if (imc >= 18.5 && imc < 24.9) {
            result = "Peso normal";
            classification = "Normal";
        } else if (imc >= 25 && imc < 29.9) {
            result = "Acima do peso";
            classification = "Sobrepeso";
        } else if (imc >= 30 && imc < 34.9) {
            result = "Obesidade Grau I";
            classification = "Obesidade";
        } else if (imc >= 35 && imc < 39.9) {
            result = "Obesidade Grau II";
            classification = "Obesidade";
        } else {
            result = "Obesidade Grau III";
            classification = "Obesidade";
        }

        resultLabel.setText("Resultado: " + result);
        classificationLabel.setText("Classificação: " + classification);
    }

    public static void main(String[] args) {
        IMCCalculator calculator = new IMCCalculator();
        calculator.setSize(300, 150);
        calculator.setVisible(true);
    }
}

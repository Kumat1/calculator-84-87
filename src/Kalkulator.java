import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static jdk.nashorn.internal.objects.Global.Infinity;

public class Kalkulator extends JFrame {
    private JPanel panelUtama;
    private JTextField tfDisplay;
    private JPanel panelTombol;
    private Double display;
    private Double temp;

    private Boolean isOperatorPressed;
    private JButton buttonAngka1, buttonAngka2, buttonAngka3, buttonAngka4, buttonAngka5, buttonAngka6, buttonAngka7, buttonAngka8, buttonAngka9, buttonAngka0;
    private JButton buttonAdd, buttonMin, buttonMul, buttonDiv, buttonDel, buttonSD;
    private Font fontDisplay, fontButton;

    private ActionListener actionButton = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("buttonAdd")) {
                temp = temp + display;
                display = temp;
                updateDisplay();
                display = 0d;

            } else if (command.equals("buttonMin")) {
                temp = temp - display;
                display = temp;
                updateDisplay();
                display = 0d;

            } else if (command.equals("buttonMul")) {
                temp = temp * display;
                display = temp;
                updateDisplay();
                display = 0d;

            } else if (command.equals("buttonDiv")) {
                temp = temp / display;
                display = temp;
                updateDisplay();
                display = 0d;
            }
            else if (command.equals("buttonDel")) {
                String displayValueString = display.toString();

                if (isWholeDecimal(display)) {
                    displayValueString = displayValueString.substring(0, displayValueString.length() - 3);
                } else {
                    displayValueString = displayValueString.substring(0, displayValueString.length() - 2);
                }

                display = Double.parseDouble(displayValueString.isEmpty() ? "0.0" : displayValueString);
                updateDisplay();

            } else {
                display = display * 10 + Integer.parseInt(String.valueOf(command.charAt(6)));

                updateDisplay();
            }
        }
    };

    private Kalkulator() {
        this.setTitle("Kalkulator");
        this.setSize(350, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setFont(new JLabel().getFont());

        display = 0d;
        temp = 0d;

        fontDisplay = this.getFont().deriveFont(60f);
        fontButton = this.getFont().deriveFont(36f);

        panelUtama = (JPanel) this.getContentPane();
        panelUtama.setLayout(new BoxLayout(panelUtama, BoxLayout.Y_AXIS));

        tfDisplay = new JTextField();
        tfDisplay.setEditable(false);
        tfDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
        tfDisplay.setFont(fontDisplay);
        tfDisplay.setPreferredSize(new Dimension(this.getWidth(), 100));
        tfDisplay.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
        updateDisplay();

        panelUtama.add(tfDisplay);

        panelTombol = new JPanel();
        panelTombol.setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;

        buttonAngka1 = new JButton("1");
        buttonAngka1.setFont(fontButton);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        buttonAngka1.setActionCommand("button1");
        buttonAngka1.addActionListener(actionButton);
        panelTombol.add(buttonAngka1, gridBagConstraints);

        buttonAngka2 = new JButton("2");
        buttonAngka2.setFont(fontButton);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        buttonAngka2.setActionCommand("button2");
        buttonAngka2.addActionListener(actionButton);
        panelTombol.add(buttonAngka2, gridBagConstraints);

        buttonAngka3 = new JButton("3");
        buttonAngka3.setFont(fontButton);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        buttonAngka3.setActionCommand("button3");
        buttonAngka3.addActionListener(actionButton);
        panelTombol.add(buttonAngka3, gridBagConstraints);

        buttonAngka4 = new JButton("4");
        buttonAngka4.setFont(fontButton);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        buttonAngka4.setActionCommand("button4");
        buttonAngka4.addActionListener(actionButton);
        panelTombol.add(buttonAngka4, gridBagConstraints);

        buttonAngka5 = new JButton("5");
        buttonAngka5.setFont(fontButton);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        buttonAngka5.setActionCommand("button5");
        buttonAngka5.addActionListener(actionButton);
        panelTombol.add(buttonAngka5, gridBagConstraints);

        buttonAngka6 = new JButton("6");
        buttonAngka6.setFont(fontButton);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        buttonAngka6.setActionCommand("button6");
        buttonAngka6.addActionListener(actionButton);
        panelTombol.add(buttonAngka6, gridBagConstraints);

        buttonAngka7 = new JButton("7");
        buttonAngka7.setFont(fontButton);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        buttonAngka7.setActionCommand("button7");
        buttonAngka7.addActionListener(actionButton);
        panelTombol.add(buttonAngka7, gridBagConstraints);

        buttonAngka8 = new JButton("8");
        buttonAngka8.setFont(fontButton);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        buttonAngka8.setActionCommand("button8");
        buttonAngka8.addActionListener(actionButton);
        panelTombol.add(buttonAngka8, gridBagConstraints);

        buttonAngka9 = new JButton("9");
        buttonAngka9.setFont(fontButton);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        buttonAngka9.setActionCommand("button9");
        buttonAngka9.addActionListener(actionButton);
        panelTombol.add(buttonAngka9, gridBagConstraints);

        buttonAngka0 = new JButton("0");
        buttonAngka0.setFont(fontButton);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        panelTombol.add(buttonAngka0, gridBagConstraints);

        buttonSD = new JButton("=");
        buttonSD.setFont(fontButton);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 1;
        buttonSD.setActionCommand("buttonSD");
        buttonSD.addActionListener(actionButton);
        panelTombol.add(buttonSD, gridBagConstraints);

        buttonAdd = new JButton("+");
        buttonAdd.setFont(fontButton);
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 1;
        buttonAdd.setActionCommand("buttonAdd");
        buttonAdd.addActionListener(actionButton);
        panelTombol.add(buttonAdd, gridBagConstraints);

        buttonMin = new JButton("-");
        buttonMin.setFont(fontButton);
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        buttonMin.setActionCommand("buttonMin");
        buttonMin.addActionListener(actionButton);
        panelTombol.add(buttonMin, gridBagConstraints);

        buttonMul = new JButton("x");
        buttonMul.setFont(fontButton);
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        buttonMul.setActionCommand("buttonMul");
        buttonMul.addActionListener(actionButton);
        panelTombol.add(buttonMul, gridBagConstraints);

        buttonDiv = new JButton("/");
        buttonDiv.setFont(fontButton);
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;
        buttonDiv.setActionCommand("buttonDiv");
        buttonDiv.addActionListener(actionButton);
        panelTombol.add(buttonDiv, gridBagConstraints);

        buttonDel = new JButton("C");
        buttonDel.setFont(fontButton);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        buttonDel.setActionCommand("buttonDel");
        buttonDel.addActionListener(actionButton);
        panelTombol.add(buttonDel, gridBagConstraints);

        panelUtama.add(panelTombol);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Kalkulator();
    }

    private void updateDisplay() {
        String stringToDisplay = "";

        if (isWholeDecimal(display)) {
            stringToDisplay = ((Integer) display.intValue()).toString();
        } else {
            stringToDisplay = display.toString();
        }

        tfDisplay.setText(stringToDisplay);
    }

    private Boolean isWholeDecimal(Double value) {
        return (value == Math.floor(value)) && !Double.isInfinite(value);
    }
}

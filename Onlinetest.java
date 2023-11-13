package com.gainjava.knowledge;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Onlinetest extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    
    JLabel label;
    JRadioButton radioButton[] = new JRadioButton[5];
    JButton btnNext, btnBookmark;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int[] m = new int[10];

    
    Onlinetest(String s) {
        super(s);
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            radioButton[i] = new JRadioButton();
            add(radioButton[i]);
            bg.add(radioButton[i]);
        }
        btnNext = new JButton("next");
        btnBookmark = new JButton("bookmark");
        btnNext.addActionListener(this);
        btnBookmark.addActionListener(this);
        add(btnBookmark);
        add(btnNext);
        set();
        label.setBounds(30, 40, 450, 20);
        radioButton[0].setBounds(50, 80, 100, 20);
        radioButton[1].setBounds(50, 110, 100, 20);
        radioButton[2].setBounds(50, 140, 100, 20);
        radioButton[3].setBounds(50, 170, 100, 20);
        btnNext.setBounds(100, 240, 100, 30);
        btnBookmark.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(700, 450);
    }

   
    void set() {
        radioButton[4].setSelected(true);
        if (current == 0) {
            label.setText("1: who was developed java ?");
            radioButton[0].setText("van rossum");
            radioButton[1].setText("james gosling");
            radioButton[2].setText("dennis richie");
            radioButton[3].setText("none of above");
        }
        if (current == 1) {
            label.setText("2: number of primitive data type in java are..");
            radioButton[0].setText("6");
            radioButton[1].setText("7");
            radioButton[2].setText("8");
            radioButton[3].setText("9");
        }
        if (current == 2) {
            label.setText("3: which of this is not access modifier in java");
            radioButton[0].setText("public");
            radioButton[1].setText("void");
            radioButton[2].setText("protected");
            radioButton[3].setText("private");
        }
        if (current == 3) {
            label.setText("4: which of this cant be used as variable name in java ?");
            radioButton[0].setText("identifiers and keywords");
            radioButton[1].setText("keyword");
            radioButton[2].setText("identifier");
            radioButton[3].setText("none");
        }
        if (current == 4) {
            label.setText("5: wht is extension of java code files");
            radioButton[0].setText(".class");
            radioButton[1].setText(".js");
            radioButton[2].setText(".txt");
            radioButton[3].setText(".java");
        }
        if (current == 5) {
            label.setText("6: which of this is not oops concept");
            radioButton[0].setText("polymorphism");
            radioButton[1].setText("inheritance");
            radioButton[2].setText("compilation");
            radioButton[3].setText("encapsulation");
        }
        if (current == 6) {
            label.setText("7: which keyword use to define interface in java");
            radioButton[0].setText("intf");
            radioButton[1].setText("Intf");
            radioButton[2].setText("interface");
            radioButton[3].setText("Interface");
        }
        if (current == 7) {
            label.setText("8: which of this is not keywords in java");
            radioButton[0].setText("double");
            radioButton[1].setText("switch");
            radioButton[2].setText("then");
            radioButton[3].setText("instanceof");
        }
        if (current == 8) {
            label.setText("9: which if the following have higher precedence");
            radioButton[0].setText("()");
            radioButton[1].setText("++");
            radioButton[2].setText("*");
            radioButton[3].setText(">>");
        }
        if (current == 9) {
            label.setText("10: java language initially called as");
            {
                radioButton[0].setText("j++");
                radioButton[1].setText("pine");
                radioButton[2].setText("oak");
                radioButton[3].setText("c");
            }
            label.setBounds(30, 40, 450, 30);
            for (int i = 0, j = 0; i <= 90; i += 30, j++)
                radioButton[j].setBounds(50, 80 + i, 200, 20);
        }
    }

        boolean cheak() {
            if (current == 0)
                return (radioButton[1].isSelected());
            if (current == 1)
                return (radioButton[2].isSelected());
            if (current == 2)
                return (radioButton[1].isSelected());
            if (current == 3)
                return (radioButton[1].isSelected());
            if (current == 4)
                return (radioButton[3].isSelected());
            if (current == 5)
                return (radioButton[2].isSelected());
            if (current == 6)
                return (radioButton[2].isSelected());
            if (current == 7)
                return (radioButton[2].isSelected());
            if (current == 8)
                return (radioButton[0].isSelected());
            if (current == 9)
                return (radioButton[2].isSelected());
            return false;
        }
        public void actionPerformed (ActionEvent e){
            if (e.getSource() == btnNext) {
                if (cheak())
                    count += 1;
                current++;
                set();
                if (current == 9) {
                    btnNext.setEnabled(false);
                    btnBookmark.setText("result");
                }
            }
            if (e.getActionCommand().equals("bookmark")) {
                JButton bk = new JButton("bookmark" + x);
                bk.setBounds(480, 20 + 30 * x, 100, 30);
                add(bk);
                bk.addActionListener(this);
                m[x] = current;
                x++;
                current++;
                set();
                if (current == 9)
                    btnBookmark.setText("result");
                setVisible(false);
                setVisible(true);
            }
            for (int i = 0, y = 1; i < x; i++, y++) {
                if (e.getActionCommand().equals("bookmark" + y)) {
                    if (cheak())
                        count = count + 1;
                    now = current;
                    current = m[y];
                    set();
                    ((JButton) e.getSource()).setEnabled(false);
                    current = now;
                }

            }
            if (e.getActionCommand().equals("result")) {
                if (cheak())
                    count = count + 1;
                current++;
                JOptionPane.showMessageDialog(this, "correct answer=" + count);
                System.exit(0);
            }
        }


    public static void main(String[] args) {
        
        new Onlinetest("online test app");
    }
}
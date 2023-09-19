import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View  {
    static  JFrame frame;
    static JButton bZERO;

    static JButton bONE;
    static JButton bTWO;
    static JButton bTHREE;
    static JButton bFOUR;
    static JButton bFIVE;
    static JButton bSIX;
    static JButton bSEVEN;
    static JButton bEIGHT;
    static JButton bNINE;
    static JButton bRemainder;
    static JButton bCE;
    static JButton bC;
    static JButton bEqual;
    static JButton bPlus;
    static JButton bDel;
    static JButton bNegate;
    static JButton bMultiply;
    static JButton bMinus;
    static JButton bDot;
    static JButton bDivide;
    public static void main(String[] args){
        frame=initializeFrame();//creating instance of JFrame
        JTextField answerField = showAnswerBox("");
        JPanel panel = createPanel();
        JTextField historyField = showHistoryBox("");
        MyButtonClickListener clickListener = new MyButtonClickListener(answerField,historyField);
        bRemainder = createButton("%",Color.white,Color.decode("#0bcde4"));
        bCE = createButton("CE",Color.white,Color.decode("#0bcde4"));
        bC = createButton("C",Color.white,Color.decode("#0bcde4"));
        bDel = createButton("<--",Color.decode("#CAF0F0"),Color.decode("#0bcde4"));
        bZERO = createButton("0", Color.white, Color.decode("#0bcde4"));
        bONE = createButton("1", Color.white, Color.decode("#0bcde4"));
        bTWO = createButton("2", Color.white, Color.decode("#0bcde4"));
        bTHREE = createButton("3", Color.white, Color.decode("#0bcde4"));
        bFOUR = createButton("4", Color.white, Color.decode("#0bcde4"));
        bFIVE = createButton("5", Color.white, Color.decode("#0bcde4"));
        bSIX = createButton("6", Color.white, Color.decode("#0bcde4"));
        bSEVEN = createButton("7", Color.white, Color.decode("#0bcde4"));
        bEIGHT = createButton("8", Color.white, Color.decode("#0bcde4"));
        bNINE = createButton("9", Color.white, Color.decode("#0bcde4"));
        bMultiply = createButton("X",Color.decode("#CAF0F0"),Color.decode("#0bcde4"));
        bPlus = createButton("+",Color.decode("#CAF0F0"),Color.decode("#0bcde4"));
        bMinus = createButton("—",Color.decode("#CAF0F0"),Color.decode("#0bcde4"));
        bDot = createButton(".",Color.WHITE,Color.decode("#0bcde4"));
        bNegate = createButton("-/+",Color.white,Color.decode("#0bcde4"));
        bEqual = createButton("=",Color.decode("#CAF0F0"),Color.decode("#0bcde4"));
        bDivide = createButton("/",Color.decode("#CAF0F0"),Color.decode("#0bcde4"));
        JButton[] arrayOfButtons = {bRemainder,bCE,bDel,bDivide,bSEVEN,bEIGHT,bNINE,
                bMultiply,bFOUR,bFIVE,bSIX,bMinus,bONE,bTWO,bTHREE,bPlus,bZERO,bNegate,bDot,bEqual};


        for(int i = 0 ; i <arrayOfButtons.length ; i++) {
            panel.add(arrayOfButtons[i]);
            arrayOfButtons[i].addActionListener(clickListener);
        }
        Calculator calculator = new Calculator();


        frame.add(panel);
        frame.add(answerField);
        frame.add(historyField);
        frame.setVisible(true);//making the frame visible
    }

    public static JTextField showAnswerBox(String labelText){
        JTextField textField = new JTextField(labelText);
        textField.setBounds(1,70,386,50);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        textField.setOpaque(false);
        textField.setFont(setDefaultFont(30,Font.BOLD));
        textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        return textField;
    }
    public static Font setDefaultFont(int size,int style){
        Font font1 = new Font("SansSerif", style, size);

        return font1;
    }
    public static JPanel createPanel(){
        JPanel buttonPanel = new JPanel(new GridLayout(0,4,1,1));
        buttonPanel.setBackground(Color.decode("#f3f3f3"));
        buttonPanel.setBounds(4, 121, frame.getWidth()-21, frame.getHeight()-160);
        return buttonPanel; // Return the panel with buttons
    }
    public static JFrame initializeFrame(){
        frame=new JFrame("Abaya-Madrid-Arzaga Calculator");//creating instance of JFrame
        frame.setResizable(false);
        int frameWidth = 400;
        int frameHeight = 500;
        frame.setSize(frameWidth,frameHeight);
        frame.setLayout(null);//using no layout managers
        frame.getContentPane().setBackground(Color.decode("#f3f3f3"));
        return frame;
    }
    public static JButton createButton(String label,Color background,Color Foreground){
        JButton button = new JButton(label);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setOpaque(true);
       button.setBackground(background);
       button.setForeground(Foreground);
       button.setFont(setDefaultFont(20,Font.BOLD));
        return button;
    }
    public static JTextField showHistoryBox(String labelText){
        JTextField textField = new JTextField(labelText);
        textField.setBounds(1,35,386,40);

        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        textField.setText(labelText);
        textField.setOpaque(false);
        textField.setFont(setDefaultFont(15,Font.PLAIN));
        textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        return textField;
    }



    }


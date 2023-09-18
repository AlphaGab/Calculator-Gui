import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButtonClickListener implements ActionListener {
    private static JTextField textField ,historyField;

    private static Calculator calculator;
    private static boolean flag = true;
    private static String [] inputsAndOperation = new String[3];
    private static String fnum1 = "";
    private static String operator = "";
    private static String fnum2 = "";
    static int operationClicks = 0;
    MyButtonClickListener(JTextField answerField,JTextField historyField) {
        calculator = new Calculator();
        this.textField = answerField;
        this.historyField = historyField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object node = e.getSource();
        JButton b = (JButton) node;
        String appendString = b.getText();

        if(!isNum(appendString)){
            if(appendString.equals("<--")){
                removeLastDigit(textField.getText());
            }
            else if (appendString.equals("C")){
               reset();
            }
            else if(appendString.equals("CE")){
                reset();
            }
            else if(appendString.equals("=")) {
                perFormCalculation(fnum1,operator,fnum2);

            }else if(appendString.equals(".")){
                String num = textField.getText();
                if(!hasDot(num)) addToTextField(appendString);


                }
            else{

                if(fnum1.isEmpty()){
                    fnum1= textField.getText();
                    operator =appendString;
                    clearTextField();
                }
               else if(fnum2.isEmpty()){
                    fnum2= textField.getText();
                    clearTextField();
                    fnum1 = calculator.add(fnum1,fnum2);
                    textField.setText(fnum1);
                    fnum2 = "";
                    flag = false;
                }


            }

            }


        else {
            if(flag) {
                addToTextField(appendString);
            }else{
                clearTextField();
                addToTextField(appendString);
                flag=true;
            }


        }
        System.out.println(fnum1 + " "+operator + " " +fnum2);


    }

    public static void addToTextField(String input) {
        textField.setText(textField.getText() + input);
    }

    public static void clearTextField(){


        textField.setText("");
    }
    public static void clearHistoryField(){

    }
    public static void removeLastDigit(String text){
        if(!text.isEmpty()) {
            String newText = text.substring(0, text.length() - 1);
            System.out.println("Hello");
            textField.setText(newText);
        }

    }

    public static boolean isNum(String JbuttonValue) {
        try {
            Double.parseDouble(JbuttonValue);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static void perFormCalculation(String fnum, String Operator ,String fnums){

    }
    public static boolean hasDot(String num) {
        if(num.contains(".")) {
            return true;
    }
        return false;

    }
    public static void reset(){
        fnum1 ="";
        operator = "" ;
        fnum2 = "";
        clearTextField();
    }
}



/*
  inputsAndOperation[0] = textField.getText();
                inputsAndOperation[1] = appendString;
                if(inputsAndOperation[0].isEmpty() &&!inputsAndOperation[1].isEmpty()){
                    inputsAndOperation[1] = appendString;
                }
                if(!inputsAndOperation[0].isEmpty()) {
                    historyField.setText(inputsAndOperation[0] + "" + inputsAndOperation[1]);
                }
 */
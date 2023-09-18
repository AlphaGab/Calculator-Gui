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
    private static String temp = "";
    private static boolean flag2 = true;
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
                fnum2 = textField.getText();
                clearHistoryField();
                historyField.setText(fnum1 + " " + operator + " "+ fnum2 + " ="  );
                perFormCalculation(operator);
                textField.setText(fnum1);
                fnum2 = "";
                return;
            }else if(appendString.equals(".")){
                String num = textField.getText();
                if(!hasDot(num)) addToTextField(appendString);


                }
            else{

                if(fnum1.isEmpty()){
                    fnum1= textField.getText();
                    displayThenDelete();
                }
                else if(historyField.getText().contains("=")){
                    displayThenDelete();
                }
               else if(!fnum1.isEmpty()&&!operator.isEmpty()){
                    fnum2= textField.getText();
                    clearTextField();
                    perFormCalculation(operator);
                    textField.setText(fnum1);
                    historyField.setText(fnum1 + " " + operator);
                    fnum2 = "";
                    flag = false;

                }
                operator = appendString;
            }
            }


        else {
            if(flag) {
                addToTextField(appendString);
                System.out.println("true");
            }else{
                clearTextField();
                addToTextField(appendString);
                flag=true;
                System.out.println("false");
            }


        }
        historyField.setText(fnum1 + " " + operator);
        System.out.println(fnum1 + " " + operator);

    }

    public static void addToTextField(String input) {
        textField.setText(textField.getText() + input);
    }

    public static void clearTextField(){


        textField.setText("");
    }
    public static void clearHistoryField(){
        historyField.setText("");
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
    public static void perFormCalculation( String Operator){
        if(operator.equals("+")) fnum1 = calculator.add(fnum1,fnum2);
        else if (operator.equals("X")) fnum1 = calculator.multiply(fnum1,fnum2);
        else if (operator.equals("—")) fnum1 = calculator.subtract(fnum1,fnum2);
        else if (operator.equals("/")) fnum1 = calculator.Divide(fnum1,fnum2);
        else if(operator.equals("%"))fnum1 = calculator.modulo(fnum1,fnum2);


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
        historyField.setText("");
    }
    public static void displayThenDelete(){
        textField.setText(fnum1);
        flag =false;
    }
}




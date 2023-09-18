import javax.swing.*;
public class Calculator {
    public String add(String x,String y){
        return formatDouble(Double.parseDouble(x) + Double.parseDouble(y));
    }
    public static String subtract(String x , String y ){
        return  formatDouble(Double.parseDouble(x) - Double.parseDouble(y));
    }
    public static String multiply(String x , String y){
        return  formatDouble(Double.parseDouble(x) * Double.parseDouble(y));
    }
    public static String Divide(String x , String y){
        return  formatDouble(Double.parseDouble(x) / Double.parseDouble(y));
    }
    public static String formatDouble(double value) {
        if (value == (int) value) {
            // If the value is an integer, return it as an integer (no decimal point)
            return String.valueOf((int) value);
        } else {
            return String.valueOf(value);
        }
    }

}

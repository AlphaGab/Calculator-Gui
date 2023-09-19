
public class Calculator {
    public String add(String x,String y){
        return formatDouble(Double.parseDouble(x) + Double.parseDouble(y));
    }
    public  String subtract(String x , String y ){
        return  formatDouble(Double.parseDouble(x) - Double.parseDouble(y));
    }
    public  String multiply(String x , String y){
        return  formatDouble(Double.parseDouble(x) * Double.parseDouble(y));
    }
    public String Divide(String x , String y){
        return  formatDouble(Double.parseDouble(x) / Double.parseDouble(y));
    }
    public  String modulo(String x , String y){
        return  formatDouble(Double.parseDouble(x) % Double.parseDouble(y));
    }
    public String formatDouble(double value) {
        if (value == (int) value) {
            // If the value is an integer, return it as an integer (no decimal point)
            return String.valueOf((int) value);
        } else {
            return String.valueOf(value);
        }
    }
    public String negate(String x){
        if(x.contains("-")){
            return x.substring(1,x.length());
        }
        else
            return "-"+x;
    }
}

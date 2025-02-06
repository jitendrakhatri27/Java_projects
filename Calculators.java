/*Calculator program in Java */
 import javax.swing.*;
class Calculators
{
    public static void main(String[] args) {
        double n1, n2, ans;
        int op;
        n1=Double.parseDouble(JOptionPane.showInputDialog("Enter First Numbers: "));
        n2=Double.parseDouble(JOptionPane.showInputDialog("Enter Second Number: "));
        op=Integer.parseInt(JOptionPane.showInputDialog("Select Operation: "));
        switch (op) 
        {
            case 1:
                ans=n1+n2;
                System.out.println("Addition "+ans);
                break;
            case 2:
                ans=n1-n2;
                System.out.println("Substraction "+ans);
                break;
            case 3:
                ans=n1*n2;
                System.out.println("Multiplication "+ans);
                break;
            case 4:
                ans=n1/n2;
                System.out.println("Division "+ans);
                break;
            default:
                System.out.println("Invalid Operations");
        }
    }
}
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Calc calc = new Calc();
        calc.getOverpayment();
    }
}

class Calc {
    Scanner input = new Scanner(System.in);
    String inputText = input.nextLine();
    String[] inputArray = inputText.split(" ");
    private double credit = Double.parseDouble(inputArray[0]);
    private double payment = Double.parseDouble(inputArray[1]);
    private double percent = Double.parseDouble(inputArray[2]);
    private String person = inputArray[3];
    private double newCredit = credit;
    private double totalPayment = 0;

    public void getOverpayment(){
        int count = 0;

        switch (person){
            case "human":
                newCredit = newCredit * (percent / 100 + 1);
                break;
            case "business":
                break;
        }


        while (totalPayment < newCredit){
            totalPayment = totalPayment + payment;
            count++;
            if (totalPayment > newCredit){
                totalPayment = newCredit;
            }
            if (count > 11){
                newCredit = (newCredit - totalPayment) * (percent / 100 + 1) + totalPayment;
                count = 0;
            }
        }
        double result = Math.round(newCredit - credit);
        System.out.println(result);
    }
}
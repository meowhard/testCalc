import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        String inputText = input.nextLine();
        String[] inputArray = inputText.split(" ");

        Calc calc = new Calc(inputArray);
        calc.getOverpayment();
    }
}

class Calc {

    private double credit;
    private double payment;
    private double percent;
    private String person;

    public Calc(String[] inputArray){
        this.credit = Double.parseDouble(inputArray[0]);
        this.payment = Double.parseDouble(inputArray[1]);
        this.percent = Double.parseDouble(inputArray[2]);
        this.person = inputArray[3];
    }

    public void getOverpayment(){
        double newCredit = credit;
        double totalPayment = 0;
        int count = 0;

        switch (Person.valueOf(person.toUpperCase())){
            case HUMAN:
                newCredit = newCredit * (percent / 100 + 1);
                break;
            case BUSINESS:
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

enum Person {
    HUMAN,
    BUSINESS;
}


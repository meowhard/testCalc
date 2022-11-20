import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CalculatingException {

        Scanner input = new Scanner(System.in);
        String inputText = input.nextLine();
        String[] inputArray = inputText.split(" ");

        Calc calc = new Calc(inputArray);
        try {
        calc.getOverpayment();
        }
        catch (CalculatingException e){
            System.err.println(e);
        }
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

    public void getOverpayment() throws CalculatingException {
        double newCredit = credit;
        double totalPayment = 0;
        int count = 0;

        if (credit < 0){
            throw new CalculatingException("credit value cannot be negative");
        }
        if (payment < 0){
            throw new CalculatingException("payment value cannot be negative");
        }
        if (percent < 0){
            throw new CalculatingException("payment value cannot be negative");
        }
        if ((((credit * percent) - (payment * 12) ) * (percent / 100 + 1))>((credit * percent))){
            throw new CalculatingException("this loan cannot be repaid");
        }

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

class CalculatingException extends Exception {
    CalculatingException(String message){
        super(message);
    }
}


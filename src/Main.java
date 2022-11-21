import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {

        Scanner input = new Scanner(System.in);
        String inputText = input.nextLine();
        String[] inputArray = inputText.split(" ");

        CreditCalculator calc = new CreditCalculator(inputArray);
        try {
        calc.getOverpayment();
        }
        catch (CalculatingException e){
            System.err.println(e);
        }
    }
}


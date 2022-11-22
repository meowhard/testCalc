import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CalculatingException {

        Scanner input = new Scanner(System.in);
        String inputText = input.nextLine();
        String[] inputArray = inputText.split(" ");

        CreditData data = new CreditData(inputArray);
        CreditCalculator calc = new CreditCalculator();
        double result = calc.getOverpayment(data);
        System.out.println(result);
    }
}
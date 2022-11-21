public class Calc {

    private double credit;
    private double payment;
    private double percent;
    private String person;

    public Calc(String[] inputArray) {
        this.credit = Double.parseDouble(inputArray[0]);
        this.payment = Double.parseDouble(inputArray[1]);
        this.percent = Double.parseDouble(inputArray[2]);
        this.person = inputArray[3];
    }

    public void getOverpayment() throws CalculatingException {
        double newCredit = credit;
        double totalPayment = 0;
        double percentIndex = (percent / 100 + 1);
        int count = 0;

        if (credit < 0) {
            throw new CalculatingException("credit value cannot be negative");
        }
        if (payment < 0) {
            throw new CalculatingException("payment value cannot be negative");
        }
        if (percent < 0) {
            throw new CalculatingException("payment value cannot be negative");
        }
        if ((((credit * percentIndex) - (payment * 12)) * percentIndex) > ((credit * percentIndex))) {
            throw new CalculatingException("this loan cannot be repaid");
        }

        switch (Person.valueOf(person.toUpperCase())) {
            case HUMAN:
                newCredit = newCredit * percentIndex;
                break;
            case BUSINESS:
                break;
        }

        while (totalPayment < newCredit) {
            totalPayment = totalPayment + payment;
            count++;
            if (totalPayment > newCredit) {
                totalPayment = newCredit;
            }
            if (count > 11) {
                newCredit = (newCredit - totalPayment) * percentIndex + totalPayment;
                count = 0;
            }
        }
        double result = Math.round(newCredit - credit);
        System.out.println(result);
    }
}

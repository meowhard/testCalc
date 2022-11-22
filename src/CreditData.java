public class CreditData {

    private double credit;
    private double payment;
    private double percent;
    private String person;

    public CreditData(String[] inputArray) {
        this.credit = Double.parseDouble(inputArray[0]);
        this.payment = Double.parseDouble(inputArray[1]);
        this.percent = Double.parseDouble(inputArray[2]);
        this.person = inputArray[3];
    }

    public double getCredit() {
        return this.credit;
    }

    public double getPayment() {
        return this.payment;
    }

    public double getPercent() {
        return percent;
    }

    public String getPerson() {
        return person;
    }
}

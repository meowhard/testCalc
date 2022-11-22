public class CreditCalculator {

    public double getOverpayment(CreditData data) throws CalculatingException {

        double newCredit = data.getCredit();
        double totalPayment = 0;
        double index = (data.getPercent() / 100 + 1);
        int count = 0;

        if (data.getCredit() < 0) {
            throw new CalculatingException("credit value cannot be negative");
        }
        if (data.getPayment() < 0) {
            throw new CalculatingException("payment value cannot be negative");
        }
        if (data.getPercent() < 0) {
            throw new CalculatingException("payment value cannot be negative");
        }
        if ((((data.getCredit() * index) - (data.getPayment() * 12)) * index) > ((data.getCredit() * index))) {
            throw new CalculatingException("this loan cannot be repaid");
        }

        switch (Person.valueOf(data.getPerson().toUpperCase())) {
            case HUMAN:
                newCredit = newCredit * index;
                break;
            case BUSINESS:
                break;
        }

        while (totalPayment < newCredit) {
            totalPayment = totalPayment + data.getPayment();
            count++;
            if (totalPayment > newCredit) {
                totalPayment = newCredit;
            }
            if (count > 11) {
                newCredit = (newCredit - totalPayment) * index + totalPayment;
                count = 0;
            }
        }
        double result = Math.round(newCredit - data.getCredit());
        return result;
    }
}

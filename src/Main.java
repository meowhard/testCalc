public class Main {
    public static void main(String[] args){
        Calc calc = new Calc();
//        human.getOverPayment();
//        human.abc();
//        calc.human();
//        calc.business();
    }
}
class Calc{
    private double credit = 300000.0;
    private double payment = 10000.0;
    private double percent = 10.0;
    private double newCredit = credit;
    private double totalPayment = 0;
    private double result;

    public void hueta () {
        int count = 0;
        newCredit = credit * (percent / 100 + 1);
        while (newCredit > totalPayment) {
            count++;
            totalPayment = totalPayment + payment;
            if (totalPayment > newCredit) {
                totalPayment = newCredit;
                break;
            }
            if (count > 11) {
                newCredit = (newCredit - totalPayment) * (percent / 100 + 1) + totalPayment;
                System.out.println(newCredit);
                count = 0;
            }
        }
    }

    public void human(){
        int count = 0;
        while(newCredit > payment){
            newCredit = newCredit * (percent / 100 + 1);
            count = 0;
            while(newCredit > payment && count < 12) {
                newCredit = newCredit - payment;
                totalPayment = totalPayment + payment;
                count++;
            }
        }
        if (count == 12) {
            newCredit = newCredit * (percent / 100 + 1);
        }
        totalPayment = totalPayment + newCredit - credit;
        result = Math.round(totalPayment);
        System.out.println(result);
    }

    public void business(){
        int count;
        while(newCredit > payment){
            count = 0;
            while(newCredit > payment && count < 12) {
                newCredit = newCredit - payment;
                totalPayment = totalPayment + payment;
                count++;
            }
            if(newCredit>payment) {
                newCredit = newCredit * (percent / 100 + 1);
            }
        }
        totalPayment = totalPayment + newCredit - credit;
        result = Math.round(totalPayment);
        System.out.println(result);
    }

    public void abc () {
        int count;

        while(newCredit > payment){
            count = 0;
            while(newCredit > payment && count < 12) {
                newCredit = newCredit - payment;
                totalPayment = totalPayment + payment;
                count++;
            }
            newCredit = newCredit * (percent / 100 + 1);
        }


        totalPayment = totalPayment + newCredit - credit;
        result = Math.ceil(totalPayment);
        System.out.println(result);
    }

    public void humanTest() {
        int count = 0;
        newCredit = newCredit * (percent / 100 + 1);
        while (totalPayment < credit){
            totalPayment = totalPayment + payment;
            count++;
            if (count > 12){
                newCredit = newCredit * (percent / 100 + 1);
                count = 0;
            }
        }
        totalPayment = totalPayment + newCredit
    }
}
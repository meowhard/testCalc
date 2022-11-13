public class Main {
    public static void main(String[] args) {

    }
}
class Human{
    double rCredit;
    double credit;
    double payment;
    double percent;
    double totalPayment = 0;

    void abc () {
        while(credit > payment){
            credit = credit * (percent / 100 + 1);
            int count = 1;
            while(credit > payment || count <= 12) {
                credit = credit - payment;
                totalPayment = totalPayment + payment;
                count++;
            }
        }
        totalPayment = totalPayment + credit - rCredit;
        System.out.println(rCredit);

    }

}

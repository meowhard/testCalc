public class Main {
    public static void main(String[] args) {

    }
}
class Human{
    double credit;
    double payment;
    double percent;
    double totalPayment = 0;

    void abc () {
        while(credit > payment){
            int count = 1;
            while(credit > payment || count < 12) {
                credit = credit - payment;
                totalPayment = totalPayment + payment;
                count++;
            }
        }
    }

}

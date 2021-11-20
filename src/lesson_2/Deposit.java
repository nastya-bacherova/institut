package lesson_2;

import java.time.LocalDateTime;

//Подкласс – Депозит (Вид депозита: код, наименование, Процент, Срок депозита, Сумма, Перечисление процентов).
public class Deposit extends BankoyProduct{

    private ViewDepozit viewDepozit;

    private double percent;
    private int term; //Срок депозита
    private double sum;

    public Deposit(String bank, String fioClient, LocalDateTime dateOfIssue, ViewDepozit viewDepozit, double percent, int term, double sum) {
        super(bank, fioClient, dateOfIssue);
        this.viewDepozit = viewDepozit;
        this.percent = percent;
        this.term = term;
        this.sum = sum;
    }

    public Deposit(String bank, String fioClient, ViewDepozit viewDepozit, double percent, int term, double sum){
        super(bank, fioClient);
        this.viewDepozit = viewDepozit;
        this.percent = percent;
        this.term = term;
        this.sum = sum;
    }


    public ViewDepozit getViewDepozit() {
        return this.viewDepozit;
    }

    public void setViewDepozit(ViewDepozit viewDepozit) {
        this.viewDepozit = viewDepozit;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return String.valueOf(viewDepozit);
    }
}

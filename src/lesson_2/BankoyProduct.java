package lesson_2;

import java.util.Date;

//Базовый класс Банковский продукт (Банк, ФИО клиента, Дата выдачи).
public class BankoyProduct {
    private String bank;
    private String fioClient;
    private String dateOfIssue;

    public BankoyProduct(String bank, String fioClient, String dateOfIssue) {
        this.bank = bank;
        this.fioClient = fioClient;
        this.dateOfIssue = dateOfIssue;
    }

    public BankoyProduct(String bank, String fioClient, Date dateOfIssue) {
    }

    public BankoyProduct(String bank) {
        this.bank = bank;
    }

    public BankoyProduct(String bank, String fioClient) {
        this.bank = bank;
        this.fioClient = fioClient;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getFioClient() {
        return fioClient;
    }

    public void setFioClient(String fioClient) {
        this.fioClient = fioClient;
    }

    public String  getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String  dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }



}

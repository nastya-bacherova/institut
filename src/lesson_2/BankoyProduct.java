package lesson_2;

import java.time.LocalDateTime;

//Базовый класс Банковский продукт (Банк, ФИО клиента, Дата выдачи).
public class BankoyProduct {
    private String bank;
    private String fioClient;
    private LocalDateTime dateOfIssue;

    public BankoyProduct(String bank, String fioClient, LocalDateTime dateOfIssue) {
        this.bank = bank;
        this.fioClient = fioClient;
        this.dateOfIssue = dateOfIssue;
    }

    public BankoyProduct() {
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

    public LocalDateTime getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDateTime dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }
}

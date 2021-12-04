package lesson_2.pravki;

import java.time.LocalDateTime;

public class Product {
    private String nameProduct;
    private int term;
    private LocalDateTime dateManufacture;


    public Product(String nameProduct, int term, LocalDateTime dateManufacture) {
        this.nameProduct = nameProduct;
        this.term = term;
        this.dateManufacture = dateManufacture;
    }

    public Product() {
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public LocalDateTime getDateManufacture() {
        return dateManufacture;
    }

    public void setDateManufacture(LocalDateTime dateManufacture) {
        this.dateManufacture = dateManufacture;
    }

    @Override
    public String toString() {
        return "Название: '" + nameProduct + '\'' +
                ", Срок годности (дней): " + term +
                ", Дата изготовления: " + dateManufacture ;
    }
}

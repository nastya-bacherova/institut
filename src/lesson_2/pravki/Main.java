package lesson_2.pravki;
import java.time.LocalDateTime;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Product product1 = new Product("Масло",35,  LocalDateTime.of(2021,9,20,0,0));
        Product product2 = new Product("Молоко",7,  LocalDateTime.of(2021,12,8,0,0));
        //Product product3 = new Product("Хлеб",5,  LocalDateTime.of(2021,11,10,0,0));

        GroceryRepositoryImp grocery = new GroceryRepositoryImp();

        System.out.println(grocery.putProduct(product1));
        System.out.println(grocery.putProduct(product2));
        grocery.getRepository();

        System.out.println(grocery.giveProduct(product1));
        grocery.getRepository();

        System.out.println(grocery.changeProductTerm(product1));
        grocery.getRepository();

        grocery.writeОffProduct();
        grocery.getRepository();

        System.out.println(grocery.getInfoAvailability(product1));
        grocery.getRepository();
    }

}

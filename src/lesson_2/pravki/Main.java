package lesson_2.pravki;
import java.time.LocalDateTime;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Product product1 = new Product("Масло",35,  LocalDateTime.of(2021,9,20,0,0));
        Product product2 = new Product("Молоко",7,  LocalDateTime.of(2021,11,20,0,0));
        Product product3 = new Product("Хлеб",5,  LocalDateTime.of(2021,11,10,0,0));

        GroceryRepositoryImp grocery = new GroceryRepositoryImp();

        System.out.println(grocery.putProduct(product1));
        System.out.println(grocery.putProduct(product2));
        grocery.getRepository();

        System.out.println(grocery.giveProduct(product1));
        grocery.getRepository();

        System.out.println(grocery.changeProductTerm(product1));
        grocery.getRepository();




//        System.out.println(grocery.giveProduct(product2));

//        System.out.println(grocery.putProduct(product2));


//        Product[] product = new Product[2];
//        product[0] = new Product("Молоко",7,  LocalDateTime.of(2021,11,20,0,0));
//        product[1] = new Product("Хлеб",5,  LocalDateTime.of(2021,11,10,0,0));


//        GroceryRepositoryImp groceryRepository = new GroceryRepositoryImp();
//
//        groceryRepository.putProduct(product);
//
//        HashMap<Integer, Product> newRepo = groceryRepository.giveProduct(groceryRepository.putProduct(product));
//
//        HashMap<Integer, Product>  newRepo2 = groceryRepository.changeProductTerm(newRepo);
//
//        HashMap<Integer, Product>  newRepo3 = groceryRepository.writeОffProduct(newRepo2);
//
//        groceryRepository.getInfoAvailability(newRepo3);

    }

}

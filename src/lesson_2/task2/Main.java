package lesson_2.task2;

//Ведение многопродуктового хранилища: помещение продукта в
//хранилище, выдача продукта, изменение сортности продукта (срока
//годности), списание негодного продукта, получение информации о
//наличии продукта

import java.time.LocalDateTime;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Product[] product = new Product[3];
        product[0] = new Product("Молоко",7,  LocalDateTime.of(2021,12,20,0,0));
        product[1] = new Product("Хлеб",5,  LocalDateTime.of(2021,12,24,0,0));
        product[2] = new Product("Масло",35,  LocalDateTime.of(2021,12,17,0,0));

        GroceryRepositoryImp groceryRepository = new GroceryRepositoryImp();

        groceryRepository.putProduct(product);

        HashMap<Integer, Product>  newRepo = groceryRepository.giveProduct(groceryRepository.putProduct(product));

        groceryRepository.changeProductTerm(newRepo);



    }

}

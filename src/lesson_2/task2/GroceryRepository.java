package lesson_2.task2;

import java.util.HashMap;

public interface GroceryRepository {

    HashMap<Integer, Product> putProduct(Product[] product);

    HashMap<Integer, Product> giveProduct(HashMap<Integer, Product> repository);

    void changeProductTerm(HashMap<Integer, Product> repository);

    String writeОffProduct();

    String getInfoAvailability();

}

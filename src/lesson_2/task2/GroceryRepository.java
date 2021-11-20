package lesson_2.task2;

import java.util.HashMap;

public interface GroceryRepository {

    HashMap<Integer, Product> putProduct(Product[] product);

    HashMap<Integer, Product> giveProduct(HashMap<Integer, Product> repository);

    HashMap<Integer, Product> changeProductTerm(HashMap<Integer, Product> repository);

    HashMap<Integer, Product> writeОffProduct(HashMap<Integer, Product> repository);

    void getInfoAvailability(HashMap<Integer, Product> repository);

}

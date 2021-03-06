package lesson_2.task2;

import java.util.HashMap;

//Ведение многопродуктового хранилища: помещение продукта в
//хранилище, выдача продукта, изменение сортности продукта (срока
//годности), списание негодного продукта, получение информации о
//наличии продукта

public interface GroceryRepository {

    //замечания: Сделать дженерик к интерфейсу + передавать ОДИН ОБЪЕКТ в метод put. Возвращать тип boolean или String!
    //Пишем сервис! (потом работа может быть перенесена в БД).

    HashMap<Integer, Product> putProduct(Product[] product); //1 - объект

    HashMap<Integer, Product> giveProduct(HashMap<Integer, Product> repository);

    HashMap<Integer, Product> changeProductTerm(HashMap<Integer, Product> repository);

    HashMap<Integer, Product> writeОffProduct(HashMap<Integer, Product> repository);

    void getInfoAvailability(HashMap<Integer, Product> repository); // изменить тип, чтобы метод возвращал!

}

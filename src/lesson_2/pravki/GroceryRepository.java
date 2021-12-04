package lesson_2.pravki;
import lesson_2.pravki.Product;
import java.util.HashMap;

//Ведение многопродуктового хранилища: помещение продукта в
//хранилище, выдача продукта, изменение сортности продукта (срока
//годности), списание негодного продукта, получение информации о
//наличии продукта

public interface GroceryRepository<T>{
    //замечания: Сделать дженерик к интерфейсу + передавать ОДИН ОБЪЕКТ в метод put. Возвращать тип boolean или String!
    //Пишем сервис! (потом работа может быть перенесена в БД).

    String putProduct(T product); //1 - объект

    String giveProduct(T product);

    String changeProductTerm(T product);

    HashMap<Integer, Product> writeОffProduct(HashMap<Integer, Product> repository);

    void getInfoAvailability(HashMap<Integer, Product> repository); // изменить тип, чтобы метод возвращал!

    void getRepository();
}

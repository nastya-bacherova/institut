package lesson_2.pravki;

//Ведение многопродуктового хранилища: помещение продукта в
//хранилище, выдача продукта, изменение сортности продукта (срока
//годности), списание негодного продукта, получение информации о
//наличии продукта

public interface GroceryRepository<T>{

    String putProduct(T product);

    String giveProduct(T product);

    String changeProductTerm(T product);

    void writeОffProduct();

    String getInfoAvailability(T product);

    void getRepository();
}

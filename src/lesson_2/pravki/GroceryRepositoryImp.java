package lesson_2.pravki;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.*;

public class GroceryRepositoryImp<T> implements GroceryRepository<T> {
    HashMap<Integer, T> repository = new HashMap<>();

    //помещение продуктов в хранилище
    @Override
    public String putProduct(T product) {
        int key;

        if (repository.size() == 100) {
            return "----------------------------------------------\nХранилище заполнено!";
        }

        do {
            key = (int) ( Math.random() * 100 );
        }
        while (repository.containsKey(key));

        repository.put(key, product);
        return "----------------------------------------------\nПродукт помещен в хранилище! \nДанные о продукте: \n"+ product ;
    }

    //выдача продукта (выдали -> удалили из хранилища)
    @Override
    public String giveProduct(T product) {
        System.out.print("Впишите код продукта, который необходимо выдать: ");

        try {
            Scanner scanner = new Scanner(System.in);
            int kodProd = scanner.nextInt();

            if (repository.containsKey(kodProd)) {
                repository.remove(kodProd);
                return "Продукт с кодом - \"" + kodProd + "\" успешно выдан!";
            } else {
                return "Продукта с кодом - \"" + kodProd + "\" не было найдено.";
            }
        } catch (InputMismatchException e) {
            return "Введеный код не соответствует требованиям!";
        }
    }

    //изменение срока годости продукта
    @Override
    public String changeProductTerm(T product) {
        System.out.println("----------------------------------------------");
        if (repository.containsValue(product)) {
        if (product instanceof Product) {
            System.out.print("Впишите новый срок годности для продукта \"" + (((Product) product).getNameProduct()) + "\": ");
            try {
                Scanner scanner = new Scanner(System.in);
                int newTerm = scanner.nextInt();
                ((Product) product).setTerm(newTerm);
            } catch (InputMismatchException e) {
                return "Введеный срок годности невалиден!";
            }
            return "Срок годности у продукта успешно изменён!";
        } else {
            return "Продукт не соответсвует параметрам!";
        }} else {
            return "Продукта \"" + (((Product) product).getNameProduct()) + "\" не было найдено в хранилище!" ;
        }
    }

    //списание негодного продукта
    @Override
    public void writeОffProduct() {
        System.out.println("----------------------------------------------");
        System.out.println("Процесс списания продуктов с хранилища: ");
        int count = 0;

        if (repository.isEmpty()) {
            System.out.println("В хранилище нет продуктов!");
        } else {
            Iterator<Map.Entry<Integer, T>> iterator1 = repository.entrySet().iterator();
            while (iterator1.hasNext()) {
                Map.Entry<Integer, T> o = iterator1.next();
                LocalDateTime newDateManufacture = ((Product) o.getValue()).getDateManufacture();
                if ((newDateManufacture.plusDays(((Product) o.getValue()).getTerm())).isBefore(LocalDateTime.now())) {
                    System.out.println("Продукт \"" + ((Product) o.getValue()).getNameProduct() + "\" списан. Срок годности истек " + newDateManufacture.plusDays(((Product) o.getValue()).getTerm()));
                    iterator1.remove();
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("В хранилище нет продуктов для списания!");
        }
    }

    //получение информации о наличии продукта
    @Override
    public String getInfoAvailability(T product) {
        System.out.println("----------------------------------------------");
        System.out.print("Впишите код продукта для получения информации о его наличии: ");

        try {
            Scanner scanner = new Scanner(System.in);
            int kodProd = scanner.nextInt();

            if (repository.containsKey(kodProd)) {
                return "Продукт с кодом - \"" + kodProd + "\" имеется в хранилище!";
            } else {
                return "Продукта с кодом - \"" + kodProd + "\" не было найдено в хранилище.";
            }
        } catch (InputMismatchException e) {
            return "Введеный код не соответствует требованиям!";
        }
    }

    @Override
    public void getRepository() {
        System.out.println("----------------------------------------------");

        if (repository.size() == 0) {
            System.out.println("В хранилище пусто.");
        } else {
            System.out.println("Состояние хранилища:");

            Iterator iterator = repository.entrySet().iterator();

            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    }
}

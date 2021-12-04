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
            Product p = new Product();
            System.out.println("----------------------------------------------");
            System.out.print("Впишите новый срок годности для продукта \""+ p.getNameProduct() + "\"");

        try {
            Scanner scanner = new Scanner(System.in);
            int newTerm = scanner.nextInt();
            p.setTerm(newTerm);
        } catch (InputMismatchException e) {
            return "Введеный срок годности невалиден!";
        }
        return "Срок годности у продукта успешно изменён!";
    }

    //списание негодного продукта
    @Override
    public HashMap<Integer, Product> writeОffProduct(HashMap<Integer, Product> repository) {
        System.out.println("----------------------------------------------");
        System.out.println("Состояние хранилища: ");
        Iterator iterator = repository.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("----------------------------------------------");
        System.out.println("Процесс списания продуктов с хранилища: ");

        Iterator<Map.Entry<Integer, Product>> iterator1 = repository.entrySet().iterator();
        while (iterator1.hasNext()) {
            Map.Entry<Integer, Product> o = iterator1.next();
            LocalDateTime newDateManufacture = o.getValue().getDateManufacture();
            if ((newDateManufacture.plusDays(o.getValue().getTerm())).isBefore(LocalDateTime.now())) {
                System.out.println("Продукт \"" + o.getValue().getNameProduct() + "\" списан. Срок годности истек " + newDateManufacture.plusDays(o.getValue().getTerm()));
                iterator1.remove();
            }
        }

        System.out.println("----------------------------------------------");
        System.out.println("Хранилище после списания негодных продуктов: ");

        if (repository.isEmpty()) {
            System.out.println("В хранилище нет продуктов!");
        } else {
            Iterator iterator2 = repository.entrySet().iterator();
            while (iterator2.hasNext()) {
                System.out.println(iterator2.next());
            }
        }
        return repository;
    }

    //получение информации о наличии продукта
    @Override
    public void getInfoAvailability(HashMap<Integer, Product> repository) {
        System.out.println("----------------------------------------------");
        System.out.println("Состояние хранилища: ");
        if (repository.isEmpty()) {
            System.out.println("В хранилище нет продуктов!");
        } else {
            Iterator iterator = repository.entrySet().iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }

        System.out.println("----------------------------------------------");
        System.out.print("Впишите код продукта для получения информации о его наличии: ");

        try {
            Scanner scanner = new Scanner(System.in);
            int kodProd = scanner.nextInt();

            if (repository.containsKey(kodProd)) {
                System.out.println("Продукт с кодом - \"" + kodProd + "\" имеется в хранилище!");
            } else {
                System.out.println("Продукта с кодом - \"" + kodProd + "\" не было найдено в хранилище.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Введеный код не соответствует требованиям!");
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

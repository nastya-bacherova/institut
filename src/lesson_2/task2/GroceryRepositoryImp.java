package lesson_2.task2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

//Ведение многопродуктового хранилища: помещение продукта в
//хранилище, выдача продукта, изменение сортности продукта (срока
//годности), списание негодного продукта, получение информации о
//наличии продукта
public class GroceryRepositoryImp implements GroceryRepository {
    HashMap<Integer, Product> repository = new HashMap<>();

    //помещение продуктов в хранилище
    @Override
    public HashMap<Integer, Product> putProduct(Product[] product) {
        for (int i = 0; i < product.length; i++) {
            repository.put(i, product[i]);
        }
        return repository;
    }

    //выдача продукта (выдали -> удалили из хранилища)
    @Override
    public HashMap<Integer, Product> giveProduct(HashMap<Integer, Product> repository) {
        Iterator iterator = repository.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("----------------------------------------------");
        System.out.print("Впишите код продукта, который необходимо выдать: ");

        try {
            Scanner scanner = new Scanner(System.in);
            int kodProd = scanner.nextInt();

            if (repository.containsKey(kodProd)) {
                System.out.println("Продукт с кодом - \"" + kodProd + "\" успешно выдан!");
                repository.remove(kodProd);
            } else {
                System.out.println("Продукта с кодом - \"" + kodProd + "\" не было найдено.");
            }

            System.out.println("----------------------------------------------");
            System.out.println("Хранилище после выдачи продукта: ");
            Iterator iterator1 = repository.entrySet().iterator();
            while (iterator1.hasNext()) {
                System.out.println(iterator1.next());
            }
        } catch (InputMismatchException e) {
            System.out.println("Введеный код не соответствует требованиям!");
        }
        return repository;
    }

    //изменение срока годости продукта
    @Override
    public HashMap<Integer, Product> changeProductTerm(HashMap<Integer, Product> repository) {
        System.out.println("----------------------------------------------");
        System.out.println("Состояние хранилища: ");
        Iterator iterator = repository.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("----------------------------------------------");
        System.out.print("Впишите код продукта, у которого необходимо изменить срок годности: ");

        try {
            Scanner scanner = new Scanner(System.in);
            int kodProd = scanner.nextInt();

            if (repository.containsKey(kodProd)) {
                System.out.print("Впишите новый срок годности: ");

                int newTerm = scanner.nextInt();

                Product product = repository.get(kodProd);
                product.setTerm(newTerm);
                repository.put(kodProd, product);

                System.out.println("----------------------------------------------");
                System.out.println("Хранилище после изменения срока годности продуктов: ");
                Iterator iterator1 = repository.entrySet().iterator();
                while (iterator1.hasNext()) {
                    System.out.println(iterator1.next());
                }
            } else {
                System.out.println("Продукта с кодом - \"" + kodProd + "\" не было найдено.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Введеный код не соответствует требованиям!");
        }
        return repository;
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
}

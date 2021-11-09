package lesson_2;

import java.util.Scanner;

public class Main {
    /*Базовый класс Банковский продукт (Банк, ФИО клиента, Дата выдачи).
     Подкласс – Депозит (Вид депозита: код, наименование, Процент, Срок депозита, Сумма, Перечисление процентов).
     Вывести список депозитов, оформленных на заданного клиента. Получить сумму оформленных депозитов заданного вида.
    */
    public static void main(String[] args) {

        //Вид депозита (в класс)
        ViewDepozit viewDepozit1 = new ViewDepozit("13468", "Двойной доход");
        ViewDepozit viewDepozit2 = new ViewDepozit("13462", "Солидный процент");
        ViewDepozit viewDepozit3 = new ViewDepozit("23777", "Накопительный счет");
        ViewDepozit viewDepozit4 = new ViewDepozit("23777", "Cберегателный счет");


        BankoyProduct[] bankoyProductsArr = new BankoyProduct[12];
        bankoyProductsArr[0]  = new BankoyProduct("Сбербанк", "Андерсон Алексей Андреевич", "2020-12-12");
        bankoyProductsArr[1]  = new BankoyProduct("ПБС", "Аксенов Алексей Дмитриевич", "2021-09-04");
        bankoyProductsArr[2]  = new BankoyProduct("Таврический банк", "Плотонова Арина Алексеевна", "2019-04-07");
        bankoyProductsArr[3]  = new BankoyProduct("Таврический банк", "Плотонова Арина Алексеевна", "2020-04-07");
        bankoyProductsArr[4]  = new BankoyProduct("Сбербанк", "Аксенов Алексей Дмитриевич", "2019-06-06");
        bankoyProductsArr[5]  = new BankoyProduct("ПБС", "Плотонова Арина Алексеевна", "2018-04-07");

        bankoyProductsArr[6]  = new Deposit("Сбербанк","Андерсон Алексей Андреевич", viewDepozit1, 6.7, 367, 1000000);
        bankoyProductsArr[7]  = new Deposit("ПБС","Аксенов Алексей Дмитриевич", viewDepozit2, 7.25, 91, 30000);
        bankoyProductsArr[8]  = new Deposit("Таврический банк","Плотонова Арина Алексеевна", viewDepozit3, 4.5, 31, 30000);
        bankoyProductsArr[9]  = new Deposit("Сбербанк", "Аксенов Алексей Дмитриевич", viewDepozit4, 3.5, 91, 40000);
        bankoyProductsArr[10] = new Deposit("ПБС","Плотонова Арина Алексеевна", viewDepozit2, 6.25, 122, 1000000);
        bankoyProductsArr[11] = new Deposit("ПБС","Плотонова Арина Алексеевна", viewDepozit2, 6.21, 30, 300000);


        getListDeposits(bankoyProductsArr);
    }


    //метод вывода списка депозитов у заданного пользователя
    public static void getListDeposits (BankoyProduct[] bankoyProductsArr) {

        System.out.print("Введите ФИО клиента для получения его оформленных депозитов: ");
        Scanner scanner = new Scanner(System.in);
        String fio = scanner.nextLine();

        int x = bankoyProductsArr.length;
        int check = 0;

        //проверка на существование юзера в системе
        for (int i = 0; i < x; i++) {
            if (fio.equals(bankoyProductsArr[i].getFioClient())) {
                check++;
            }
        }
        if (check == 0) {
            System.out.println("Пользователь с ФИО - " + fio + " не найден.");
        } else {

            System.out.println("Депозиты клиента - " + fio + ":");

            for (int i = 0; i < x; i++) {
                if (fio.equals(bankoyProductsArr[i].getFioClient())) {
                    boolean b = bankoyProductsArr[i] instanceof Deposit;
                    if (b == true) {
                        System.out.println(((Deposit) bankoyProductsArr[i]).getViewDepozit());
                    }
                }
            }
            //Получить сумму оформленных депозитов заданного вида
            System.out.print("Введите вид депозита для получения их суммы у клиента - " + fio + ": ");
            String dep = scanner.nextLine();
            double sum = 0;
            check = 0;

            //проверка на существование вида депозита на заданного клиента
            for (int i = 0; i < x; i++) {
                if (fio.equals(bankoyProductsArr[i].getFioClient())) {
                    boolean b = bankoyProductsArr[i] instanceof Deposit;
                    if (b == true) {
                        if (dep.equals(((Deposit) bankoyProductsArr[i]).getViewDepozit().getNameDepozit()))
                            check ++;
                    }
                }
            }

            if (check == 0) {
                System.out.println("Оформленный Вид депозита \"" + dep + "\" на клента - " + fio + " не найден.");
            } else {
                for (int i = 0; i < x; i++) {
                    if (fio.equals(bankoyProductsArr[i].getFioClient())) {
                        boolean b = bankoyProductsArr[i] instanceof Deposit;
                        if (b == true) {
                            if (dep.equals(((Deposit) bankoyProductsArr[i]).getViewDepozit().getNameDepozit()))
                                sum = ((Deposit) bankoyProductsArr[i]).getSum() + sum;
                        }
                    }
                }
                System.out.println("Клиент - " + fio + " оформил депозит вида \"" + dep + "\" на сумму " + sum);
            }
        }
    }
}
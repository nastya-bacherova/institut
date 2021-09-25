package lesson_1.task2;

import java.util.ArrayList;
import java.util.Scanner;

//4.2.	Даны два одномерных массива Xn и Yk. Сформировать новый массив Zm, состоящий из элементов массива Xn
//      с нечетными номерами и отрицательных элементов массива Yk с четными номерами. - использовать процедуру
//Функция возвращает значение, а процедура просто выполняет команды.
public class TwoMassive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива Xn: ");
        int sizeXn = scanner.nextInt();
        int[] arrayXn = new int[sizeXn];

        System.out.print("Введите размер массива Yk: ");
        int sizeYk = scanner.nextInt();
        int[] arrayYk = new int[sizeYk];

        writeArrays(arrayXn, arrayYk);
    }

    public static void writeArrays (int[] arrayXn, int[] arrayYk) {
        ArrayList<Integer> arrayZn = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Заполните массив Xn");
        for (int i = 0; i < arrayXn.length; i++) {
            System.out.print("X[" + i + "]: ");
            arrayXn[i] = scanner.nextInt();
            if (arrayXn[i] % 2 != 0) arrayZn.add(arrayXn[i]);
        }

        System.out.println("Заполните массив Yk");
        for (int k = 0; k < arrayYk.length; k++) {
            System.out.print("Y[" + k + "]: ");
            arrayYk[k] = scanner.nextInt();
            if (arrayYk[k] < 0) arrayZn.add(arrayYk[k]);
        }
        System.out.println("Сформированный массив Zm: " + arrayZn);
    }

}

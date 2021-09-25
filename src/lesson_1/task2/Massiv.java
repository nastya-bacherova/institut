package lesson_1.task2;

// 4.1.	Дан одномерный массив Xn. Найти количество четных элементов массива - использовать функцию
//Функция возвращает значение, а процедура просто выполняет команды.
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Massiv {

    public static void main(String[] args) {
        try {
            System.out.print("Введите размер массива: ");

            Scanner scanner = new Scanner(System.in);
            int size = scanner.nextInt();
            int[] array = generateArray(size);

            System.out.println("Сгенерированный массив: " + Arrays.toString(array));
            System.out.println("Количство четных элементов в массиве: " + findAmounthElements(array));
        } catch (NegativeArraySizeException e) {
            System.out.println("Размер массива не может быть отрицательным!");
        } catch (InputMismatchException e) {
            System.out.println("Размер массива задается только числом!");
        }
    }

    public static int[] generateArray(int size) {
        int arr[] = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * (99 - 1) + 1);
        }
        return arr;
    }

    public static int findAmounthElements(int[] arr) {
        int amounth = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                amounth++;
            }
        }
        return amounth;
    }
}

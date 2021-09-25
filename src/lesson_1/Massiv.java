package lesson_1;

// 4.1.	Дан одномерный массив Xn. Найти количество четных элементов массива - использовать функцию
//4.2.	Даны два одномерных массива Xn и Yk. Сформировать новый массив Zm, состоящий из элементов массива Xn
//      с нечетными номерами и отрицательных элементов массива Yk с четными номерами. - использовать процедуру
//Функция возвращает значение, а процедура просто выполняет команды.
import java.util.Arrays;
import java.util.Scanner;

public class Massiv {

    public static void main(String[] args) {
        System.out.print("Введите размер массива: ");

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = generateArray(size);

        System.out.println("Сгенерированный массив: " + Arrays.toString(array));
        System.out.println("Количство четных элементов в массиве: " + findAmounthElements(array));

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

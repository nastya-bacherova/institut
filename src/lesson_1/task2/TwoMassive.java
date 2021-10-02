package lesson_1.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

//4.2.	Даны два одномерных массива Xn и Yk. Сформировать новый массив Zm, состоящий из элементов массива Xn
//      с нечетными номерами и отрицательных элементов массива Yk с четными номерами. - использовать процедуру
//Функция возвращает значение, а процедура просто выполняет команды.
public class TwoMassive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите размер массива Xn: ");
            int sizeXn = scanner.nextInt();
            String[] arrayXn = new String[sizeXn];

            System.out.print("Введите размер массива Yk: ");
            int sizeYk = scanner.nextInt();
            String[] arrayYk = new String[sizeYk];

            int[] newArrXn = writeArraysXn(arrayXn);
            int[] newArrYk = writeArraysYk(arrayYk);
            makeArraysZm(newArrXn,newArrYk);


        } catch (NegativeArraySizeException e) {
            System.out.println("Размер массива не может быть отрицательным!");
        } catch (InputMismatchException e) {
            System.out.println("На вход принимаются только цифры!");
        }
    }

    //с нечетными номерами
    public static int[] writeArraysXn(String[] arrayXn) {
        Scanner scanner = new Scanner(System.in);
        int newSizeArrXn = 0;

        System.out.println("Заполните массив Xn");
        for (int n = 0; n < arrayXn.length; n++) {
            System.out.print("X[" + n + "]: ");
            arrayXn[n] = String.valueOf(scanner.nextInt());
            if (n % 2 != 0) {
                newSizeArrXn++;
            } else {
                arrayXn[n] = "*";
            }
        }

        int[] newArrXn = new int[newSizeArrXn];
        int m = 0;
        for (int n = 0; n < arrayXn.length; n++) {
            if (!(String.valueOf(arrayXn[n])).equals("*")) {
                for (int j = m; j < newArrXn.length; j++) {
                    newArrXn[j] = (Integer.parseInt(arrayXn[n]));
                    m++;
                    break;
                }
            }
        }
        return newArrXn;
    }

    //c отрицательными элементами массива Yk с четными номерами
    public static int[] writeArraysYk(String[] arrayYk) {
        Scanner scanner = new Scanner(System.in);
        int newSizeArrYk = 0;

        System.out.println("Заполните массив Yk");
        for (int k = 0; k < arrayYk.length; k++) {
            System.out.print("Y[" + k + "]: ");
            arrayYk[k] = String.valueOf(scanner.nextInt());
            if ((k % 2 == 0) && (Integer.parseInt(arrayYk[k]) < 0)) {
                newSizeArrYk++;
            } else {
                arrayYk[k] = "*";
            }
        }

        int[] newArrYk = new int[newSizeArrYk];
        int m = 0;
        for (int k = 0; k < arrayYk.length; k++) {
            if (!(String.valueOf(arrayYk[k])).equals("*")) {
                for (int j = m; j < newArrYk.length; j++) {
                    newArrYk[j] = (Integer.parseInt(arrayYk[k]));
                    m++;
                    break;
                }
            }
        }
        return newArrYk;
    }

    public static void makeArraysZm(int[] newArrXn, int[] newArrYk) {
        int newSizeArrZm = newArrXn.length + newArrYk.length;
        int[] arrZm = new int[newSizeArrZm];
        int j = 0;

        for (int m = 0; m < newArrXn.length; m++) {
            arrZm[m] = newArrXn[m];
            j++;
        }
        for (int m = 0; m < newArrYk.length; m++) {
            arrZm[j] = newArrYk[m];
            j++;
        }
        System.out.println(Arrays.toString(arrZm));
    }
}



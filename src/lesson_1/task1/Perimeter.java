package lesson_1.task1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Perimeter {
    //Вычислить периметр равностороннего треугольника
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите длинну стороны у равностороннего треугольника: ");
            int side = scanner.nextInt();
            Perimeter.calculate(side);

        } catch (InputMismatchException e) {
            System.out.println("На вход принимаются только цифры!");
        } catch (NoNullExceptionRec e) {
            System.out.println("Сторона треугольника не может быть менее 1!");
//          e.printStackTrace();
        }
    }

    private static void calculate(int side) throws NoNullExceptionRec{
        if (side < 1) {
            throw new NoNullExceptionRec("Сторона треугольника не может быть менее 1");
        } else {
            System.out.println ("Каждая сторона у раностороннего треугольника будет равняться: " + side);
            System.out.println("Периметр равностороннего треугольника равен: " + side * 3);
        }
    }
}

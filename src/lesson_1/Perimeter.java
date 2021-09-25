package lesson_1;

import java.util.Scanner;

public class Perimeter {
    //Вычислить периметр равностороннего треугольника
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длинну стороны у равностороннего треугольника: ");
        int side = scanner.nextInt();
        System.out.println ("Каждая сторона у раностороннего треугольника будет равняться: " + side);
        Perimeter.calculate(side);
    }

    private static void calculate(int side) {
        System.out.println("Периметр равностороннего треугольника равен: " + side * 3);
    }

}

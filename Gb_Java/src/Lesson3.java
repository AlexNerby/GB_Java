import java.util.Random;
import java.util.Scanner;

public class Lesson3 {

    public static void main(String[] args) {

        /*1. Написать программу, которая загадывает случайное число от 0 до 9,
        и пользователю дается 3 попытки угадать это число. При каждой попытке компьютер должен сообщить
        больше ли указанное пользователем число чем загаданное, или меньше. После победы или проигрыша
        выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).*/

        guesNumber(3, 0, 9);
    }

    static void guesNumber(int trying, int minNumber, int maxNumber ) {
        int condition;
        do {
            int answer = random(maxNumber + 1);
            while (trying > 0) {
                trying--;

                System.out.printf("Угадайте число от %d до %d%n", minNumber, maxNumber);
                int userAnswer = scanner();

                if (userAnswer == answer) {
                    System.out.println("Правильный ответ");
                    break;
                } else if (userAnswer < answer && userAnswer >= minNumber && userAnswer <= maxNumber) {
                    System.out.printf("Загаданное число больше, оставшиеся попытки: %d%n", trying);
                } else if (userAnswer > answer && userAnswer >= minNumber && userAnswer <= maxNumber) {
                    System.out.printf("Загаданное число меньше, оставшиеся попытки: %d%n", trying);
                } else {
                    System.out.printf("Вы ввели выходящее за условие число, оставшиеся попытки: %d%n", trying);
                }
            }
            trying = 3;
            System.out.println("========================================");
            System.out.println("Повторить игру еще раз? 1 - да / 0 - нет");
            condition = scanner();
        }while (condition == 1);
        System.out.println("Спасибо за игру!");
    }

    static int scanner () {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    static int random (int countRandom) {
        Random random = new Random();
        return random.nextInt(countRandom);
    }
}
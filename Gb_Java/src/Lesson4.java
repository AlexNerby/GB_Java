import java.util.Random;
import java.util.Scanner;

public class Lesson4 {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        int count = 0;
        final char playerSign = 'X';
        final char computerSign = '0';

        char[][] field = initField();
        String winnerName = null;

        drawField(field);

        do {
            // Ход игрока
            doPlayerMove(field, playerSign);
            // Перерисовка поля, чтобы увидеть поставленные фишки
            drawField(field);

            // Проверка на победу
            if (checkWin(field, playerSign)) {
                winnerName = "Player";
                break;
            }
            // TODO Проверка на ничью
            //т.к. сдаю не своевременно и видел решение в последнем вебинаре (хотя наверно сам решил бы так же),
            //то решил по своему, сократил код, он тупо считает общее кол-во ходов и т.к. они конечны,
            //то по условиям, если нет победителя и был последний ход, результатом будет ничья.
            if (checkDraw(count)) {
                break;
            }
            count++;

            // Ход компьютера
            // TODO Task 5*** Блокировка хода игрока
            if (aiBlockPlayerMove(field, playerSign, computerSign)) {
                System.out.println("Computer's block you move");
            }else
                doAIMove(field, computerSign);

            // Перерисовка поля, чтобы увидеть поставленные фишки
            drawField(field);

            // Проверка на победу
            if (checkWin(field, computerSign)) {
                winnerName = "Computer";
                break;
            }
        } while (true);
        if (winnerName == "Computer" || winnerName == "Player") {
            System.out.println("Sir, congratulations!");
            System.out.println("You are winner Mr. " + winnerName);
        }else
            System.out.println("Draw!");
    }

    static void textXY(int x, int y) {
        System.out.println("Computer's move...");
        System.out.println(String.format("Computer's X-value: %s", x));
        System.out.println(String.format("Computer's Y-value: %s", y));
    }

    static boolean checkDraw(int count) {
        return count >= 4;
    }

    static void doAIMove(char[][] field, char computer) {
        Random random = new Random();
        System.out.println("Computer's move...");
        // Вводим координаты Х, Y
        int xVal = random.nextInt(3);
        int yVal = random.nextInt(3);

        // Если значение по координатам занято, то делаем перегенерацию координат, пока не найдем свободные
        while (field[xVal][yVal] != '-') {
            xVal = random.nextInt(3);
            yVal = random.nextInt(3);
        }

        System.out.println(String.format("Computer's X-value: %s", xVal));
        System.out.println(String.format("Computer's Y-value: %s", yVal));

        field[xVal][yVal] = computer;
    }

    static void doPlayerMove(char[][] field, char player) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sir, you move...");

        // Вводим координаты Х, Y
        System.out.println("Please enter X-value [1-3]");
        int xVal = scanner.nextInt() - 1;
        System.out.println("Please enter Y-value [1-3]");
        int yVal = scanner.nextInt() - 1;

        // TODO проверка на диапазон значений, чтобы не выйти за пределы массива
        while (xVal >= 3 || yVal >= 3) {
            System.out.println(String.format("Field[%s][%s] incorrect value", xVal + 1, yVal + 1));
            System.out.println("Please enter X-value [1-3]");
            xVal = scanner.nextInt() - 1;

            System.out.println("Please enter Y-value [1-3]");
            yVal = scanner.nextInt() - 1;
        }
        // Если значение по координатам занято, то повторяем ввод координат, пока не найдем свободные
        while (field[xVal][yVal] != '-') {
            System.out.println(String.format("Field[%s][%s] is already occupied", xVal + 1, yVal + 1));
            System.out.println("Please enter X-value [1-3]");
            xVal = scanner.nextInt() - 1;

            System.out.println("Please enter Y-value [1-3]");
            yVal = scanner.nextInt() - 1;
        }

        field[xVal][yVal] = player;
    }

    static boolean aiBlockPlayerMove(char[][] field, char player, char computer) {
        for (char i = 0; i < 3; i++) {
            //Блок по горизонтали
            if (field[i][0] == player && field[i][1] == player && field[i][2] == '-') {
                field[i][2] = computer;
                textXY(i + 1, 2 + 1);
                return true;
            } else if (field[i][1] == player && field[i][2] == player && field[i][0] == '-') {
                field[i][0] = computer;
                textXY(i + 1, 0 + 1);
                return true;
            } else if (field[i][0] == player && field[i][2] == player && field[i][1] == '-') {
                field[i][1] = computer;
                textXY(i + 1, 1 + 1);
                return true;
                //Блок по вертикали
            } else if (field[0][i] == player && field[1][i] == player && field[2][i] == '-') {
                field[2][i] = computer;
                textXY(2 + 1, i + 1);
                return true;
            } else if (field[1][i] == player && field[2][i] == player && field[0][i] == '-') {
                field[0][i] = computer;
                textXY(0 + 1, i + 1);
                return true;
            } else if (field[0][i] == player && field[2][i] == player && field[1][i] == '-') {
                field[1][i] = computer;
                textXY(1 + 1, i + 1);
                return true;
                //Блок по диагонали
                //1 диагональ
            } else if (field[0][0] == player && field[1][1] == player && field[2][2] == '-') {
                field[2][2] = computer;
                textXY(2 + 1, 2 + 1);
                return true;
            } else if (field[1][1] == player && field[2][2] == player && field[0][0] == '-') {
                field[0][0] = computer;
                textXY(0 + 1, 0 + 1);
                return true;
            } else if (field[0][0] == player && field[2][2] == player && field[1][1] == '-') {
                field[1][1] = computer;
                textXY(1 + 1, 1 + 1);
                return true;
                //2 диагональ
            } else if (field[2][0] == player && field[1][1] == player && field[0][2] == '-') {
                field[0][2] = computer;
                textXY(0 + 1, 2 + 1);
                return true;
            } else if (field[1][1] == player && field[0][2] == player && field[2][0] == '-') {
                field[2][0] = computer;
                textXY(2 + 1, 0 + 1);
                return true;
            } else if (field[2][0] == player && field[0][2] == player && field[1][1] == '-') {
                field[1][1] = computer;
                textXY(1 + 1, 1 + 1);
                return true;
            }
        }
        return false;
    }

    // Проверка победы
    static boolean checkWin(char[][] field, char sign) {
        // По горизонтали
        for (int i = 0; i < field.length; i++) {
            if (field[i][0] == sign && field[i][1] == sign && field[i][2] == sign) {
                return true;
                // TODO По вертикали
            }else if (field[0][i] == sign && field[1][i] == sign && field[2][i] == sign) {
                return true;
                // TODO По диагонали
            }else if (field[0][0] == sign && field[1][1] == sign && field[2][2] == sign) {
                return true;
            }else if (field[2][0] == sign && field[1][1] == sign && field[0][2] == sign) {
                return  true;
            }
        }
        return false;
    }

    // Отрисока поля как матрицы
    static void drawField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    static char[][] initField() {
        return new char[][]{
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'},
        };
    }
}



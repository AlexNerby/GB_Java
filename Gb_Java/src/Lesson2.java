public class Lesson2 {

    public static void main(String[] args) {
        /*1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;*/
        int[] task1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        revers(task1);
        printArray("task 1: ", task1);

        /*2. Задать пустой целочисленный массив размером 8.
        С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;*/
        int[] task2 = new int[8];
        filling(task2);
        printArray("task 2: ", task2);

        /*3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
        и числа меньшие 6 умножить на 2;*/
        int[] task3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        min6x2(task3);
        printArray("task 3: ", task3);

        /*4. Создать квадратный двумерный целочисленный массив
        (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
         */
        int[][] task4 = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        draw1(task4);

        /*5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);*/
        int[] task5 = {5, 1, 10, -7, 18, 31};
        minMax(task5);

        /*6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
        метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
        граница показана символами ||, эти символы в массив не входят.*/

        int[] task6 = {1, 7, 2, 1, 11};
        printArray("task 6: ", task6);
        System.out.println(checkBalance(task6));

        /*7. **** Написать метод, которому на вход подается одномерный массив и число n
         (может быть положительным, или отрицательным), при этом метод должен сместить все элементымассива на n позиций.
          Для усложнения задачи нельзя пользоваться вспомогательными массивами.*/

    }

    static boolean checkBalance(int[] arr) {
        boolean trueFalse = false;
        int sum = 0;
        int sumI = 0;
        int sumJ = 0;
        int result;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        result = sum / 2;
        for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
            if (sumJ == result || sumI == result)
                break;
            sumI += arr[i];
            sumJ += arr[j];
        }
        trueFalse = true;
        return trueFalse;
    }

    static void minMax (int[] mas){
        System.out.println("===============");
        System.out.println("task 5: ");
        min(mas);
        max(mas);
    }

    static void max (int[] mas){
        int max = mas[0];
        for (int i = 1; i < mas.length; i++) {
            if (max < mas[i])
                max = mas[i];
        }
        System.out.println("Максимальный элемент: " + max);
    }

    static void min (int[] mas){
        int min = mas[0];
        for (int i = 1; i < mas.length; i++) {
            if (min > mas[i])
                min = mas[i];
        }
        System.out.println("Минимальный элемент: " + min);
    }

    static void revers ( int[] mas){
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == 0) {
                mas[i] = 1;
            } else
                mas[i] = 0;
        }
    }

    static void filling ( int[] mas){
        int num = 0;
        for (int i = 0; i < mas.length; i++) {
            mas[i] = num;
            num += 3;
        }
    }

    static void min6x2 ( int[] mas){
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < 6)
                mas[i] *= 2;
        }
    }

    static void printArray (String task, int[] mas){
        System.out.println("===============");
        System.out.print(task);
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
        System.out.println();
    }

    static void draw1 (int[][] mas){
        System.out.println("===============");
        int dia = -1;
        int dia2 = 5;
        System.out.println("task 4: ");
        for (int i = 0; i < mas.length; i++) {
            dia++;
            dia2--;
            for (int j = 0; j < mas[i].length; j++) {
                if (j == dia || j == dia2)
                    mas[i][j] = 1;
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }
    }
}

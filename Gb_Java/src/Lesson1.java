public class Lesson1 {
    //1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
    public static void main(String[] args) {

        //2. Создать переменные всех пройденных типов данных, и инициализировать их значения;

        byte byt = 100;
        short shrt = 10000;
        int in = 1000000000;
        long ln = 1000000000000000000L;
        double dbl = 10.0d;
        float flt = 10.1f;
        char chr = 1;
        boolean yes = true;

        /*3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
        где a, b, c, d – входные параметры этого метода;*/
        System.out.println("task 3: " + task3(5, 10, 15, dbl));

        /*4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах
         от 10 до 20(включительно), если да – вернуть true, в противном случае – false;*/
        System.out.println("task 4: " + task4(10, 10));

        /*5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать
         в консоль положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.*/
        task5(5);

        /*6. Написать метод, которому в качестве параметра передается целое число,
         метод должен вернуть true, если число отрицательное;*/
        System.out.println("task 6: " + task6(-5));

        /*7. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
         метод должен вывести в консоль сообщение «Привет, указанное_имя!»*/
        task7("Алексей");

        /*8.* Написать метод, который определяет является ли год високосным, и выводит
        сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го,
        при этом каждый 400-й – високосный.*/
        task8 (2021);
    }

    static double task3 (double a, double b, double c, double d) {
        double result = a * (b + (c / d));
        return result;
    }

    static boolean task4 (int a, int b) {
        if ((a + b) >= 10 && (a + b) <= 20 ) {
            return true;
        }else
            return  false;
    }

    static void task5(int a) {
        if (a >= 0) {
            System.out.println("task 5: Положительное число");
        }else
            System.out.println("task 5: Отрицательное число");
    }

    static boolean task6 (int a) {
        if (a < 0) {
            return true;
        }else
            return  false;
    }

    static void task7 (String name) {
        System.out.println("Привет " + name);
    }

    static void task8 (int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 100 == 0 && year % 400 == 0) {
            System.out.println("task 8* Год является високосным");
        }else
            System.out.println("task 8* Год не високосный");
    }
}

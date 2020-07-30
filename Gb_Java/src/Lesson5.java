public class Lesson5 {
    public static void main(String[] args) {

        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mail.ru",
                89533748960L, 50000, 30);
        empArray[1] = new Employee("Petrov Petr", "Engineer", "petrptr@mail.ru",
                89536432303L, 70000, 40);
        empArray[2] = new Employee("Smirnov Sergey", "Manager", "smrnsergey@mail.ru",
                89557458162L, 100000, 45);
        empArray[3] = new Employee("Goncharov Grigoriy", "General Manager", "gendirgrig@mail.ru",
                89533337755L, 250000, 35);
        empArray[4] = new Employee("Semenov Aleksandr", "Chief Engineer", "semaleksand@mail.ru",
                89607602585L, 150000, 50);

        //С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        ageFilterInfoOlder(40, empArray);
    }

    static void ageFilterInfoOlder(int olderAge, Employee[] empArray) {
        for (int i = 0; i < empArray.length; i++ ) {
            if (olderAge < empArray[i].getAge()) {
                empArray[i].info();
            }
        }
    }
}

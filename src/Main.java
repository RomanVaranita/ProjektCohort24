import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    // пишем меню для приложения
    // программа должна уметь:
    // показывать список задач
    // запоминать задачи
    // добавлять и удаллять задачи при необходимости
    // план работы
    // меню
    // список функций
    // создать классы для каждой функции
    // сделать класс задача добавить компаратор
    // добавить enum для команд меню

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ToDoList toDoList = new ToDoList("tasks.txt");

        while (true) {
            System.out.println("\u001B[31m============================\u001B");
            System.out.println("\u001B[35m1.Добавить новую задачу:\u001B");
            System.out.println("\u001B[35m2.Добавить новую задачу с датой:\u001B");
            System.out.println("\u001B[35m3.Удалить задачу:\u001B");
            System.out.println("\u001B[33m4.Просмотреть список задач:");
            System.out.println("\u001B[36m5.Выйти из программы:\u001B[0m");
            System.out.println("== Выберите опцию ==");

            int option = Integer.parseInt(br.readLine());

            switch (option) {
                case 1:
                    System.out.print("Введите задачу: ");
                    String task = br.readLine();
                    Date date = null;
                    toDoList.addTask(task, null);
                    break;
                case 2:
                    System.out.print("Введите задачу: ");
                    String taskWithDate = br.readLine();
                    System.out.print("Введите дату в формате dd.MM.yyyy: ");
                    String dateString = br.readLine();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                    date = dateFormat.parse(dateString);
                    toDoList.addTask(taskWithDate, date);
                    break;
                case 3:
                    System.out.print("Укажите позицию задачи в списке: ");
                    int index = Integer.parseInt(br.readLine());
                    toDoList.removeTask(index);
                    break;
                case 4:
                    toDoList.printTasks();
                    break;
                case 5:
                    System.out.println("Хорошего дня!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный ввод: " + option);
                    break;
            }
        }
    }
}

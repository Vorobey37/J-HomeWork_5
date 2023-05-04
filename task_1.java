import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.Stack;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * task_1/*
         * 1) Реализуйте структуру телефонной книги с помощью HashMap, учитывая, 
         * что 1 человек может иметь несколько телефонов.


Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. 
Отсортировать по убыванию популярности.
         */

 
public class task_1 {

    public static void main(String[] args) {

        HashMap<Integer, String> phoneBook = CreatePhoneBook();
        System.out.println(phoneBook);
        HashMap<String, Integer> repetitions = HowManyRepititions(phoneBook);
        System.out.println(repetitions);
        Sort(repetitions);

    }
    public static HashMap<Integer, String> CreatePhoneBook() {
        HashMap<Integer, String> phoneBook = new HashMap<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Введите количество записей в телефонной книге: ");
        int number = input.nextInt();
        for (int i = 0; i < number; i++) {
            
            System.out.println("Введите номер телефона: ");
            Integer phoneNumber = input.nextInt();
            System.out.println("Введите имя пользователя этим номером: ");
            String name = input.next();
            phoneBook.put(phoneNumber, name);
        }
        input.close();
        return phoneBook;
    }
    public static HashMap<String, Integer> HowManyRepititions (HashMap<Integer, String> phoneBook){
        HashMap<String, Integer> repititions = new HashMap<>();
        for (Map.Entry<Integer,String> element : phoneBook.entrySet()) {
            String name = element.getValue();
            if(repititions.containsKey(name))
            {
                Integer count = repititions.get(name) + 1;
                repititions.put(name, count);
            } else {
                repititions.put(name, 1);
            }  
        }
        return repititions;
    }

    // Так и не смог сам додумать, пришлось найти решение в интернете...
    public static void Sort(HashMap<String, Integer> map) {
        Map<String, Integer> sortedMap = map.entrySet().stream()
        .sorted(Comparator.comparingInt(e -> -e.getValue())) 
        .collect(Collectors.toMap( 
        Map.Entry::getKey, 
        Map.Entry::getValue, 
        (a, b) -> { throw new AssertionError(); }, 
         LinkedHashMap::new 
        )); 
 
        System.out.println(sortedMap.entrySet());

}
}
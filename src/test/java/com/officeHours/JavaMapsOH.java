package com.officeHours;

import java.util.*;

public class JavaMapsOH {

    /*

        dequeue - double sided
        we can add and retrieve elements from dequeue from
        both sides (head, end)

     */

    public static void main(String[] args) {

        Deque<Integer> numbers = new ArrayDeque<>();
        numbers.addFirst(20);
        numbers.addFirst(30);
        numbers.addFirst(50);
        System.out.println(numbers);
        numbers.addLast(90);
        System.out.println(numbers);
        numbers.add(33);
        System.out.println(numbers);
        Integer num = numbers.pollFirst(); //return and delete first element
        System.out.println(num);
        System.out.println(numbers);
        System.out.println(numbers.getLast() + " peek: " + numbers.peekLast());
        //peek() -> returnes the value (similar to get())
        //poll() -> returns the value and remove it from the Queue
        System.out.println("dequeue after peek: "  + numbers);

    /*
            What collections you are using in your project?
            describe all different collections (List, Queue, Set)
            explain the difference between them

            List -> ArrayList most of the times, bcs I would usually
            just need to store some values.
            I would use LinkedList if I know I will need to manipulate my date
            (consistently add, remove, etc.)

            Set -> HashSet - for unique values
                    TreeSet - for unique sorted values

            Queue -> if I need to check FIFO logic in my project
     */

    /*
            Map Interface: does not accept any duplicate keys
                - HashMap - key/value, can accept null
                - HashTable - synchronized/ no null values
                -LinkedHashMap extends the HashMap,  slower than Hashmap
                            linked
                - TreeMap - sorted, no null values
     */

        HashMap <String, String> user1 = new HashMap<>();

        user1.put("First Name", null);
        user1.put("Last Name", "Smith");
        user1.put("Account Number", "A6345165");
        user1.put("DOB", "02.20.1980");

        System.out.println(user1);

        LinkedHashMap<String, String> user2 = new LinkedHashMap<>();
        user2.put("First Name", "John");
        user2.put("Last Name", null);
        user2.put("Last Name", "White");
        user2.put("Last Name", "Green");
        user2.put("Account Number", "A50564");
        user2.put("DOB", "12.02.1964");

        System.out.println(user2);
        HashMap <String, String> user3 = new HashMap<>(user1);
        user3.put("Account Number", "A50564431");
        user3.put("DOB", "12.08.1990");

        List <HashMap<String, String>> users = new ArrayList<>();
        //LinkedHashMap extends HashMap
        users.add(user1);
        users.add(user2);
        users.add(user3);

        //print account number for all users along with last name

        System.out.println("====LIST==== \n" + users);
        /*
        [{Account Number=A6345165, DOB=02.20.1980, First Name=null, Last Name=Smith},
        {First Name=John, Last Name=Green, Account Number=A50564, DOB=12.02.1964},
         {First Name=null, Account Number=A50564431, Last Name=Smith, DOB=12.08.1990}]
         */
        for (HashMap<String, String> user:
             users) {
            System.out.println("Account number: " + user.get("Account Number")
                    + " | Last Name: " + user.get("Last Name"));
        }

        int i = 1;
        for (HashMap<String, String> user:
                users) {
            System.out.println("User " + i);
            Iterator <String> keys = user.keySet().iterator();
            while (keys.hasNext()){
                String key = keys.next();
                System.out.println(key + ":" + user.get(key));
            }
            i++;
        }




    }



}

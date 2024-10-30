package main;

import model.FamilyTree;
import model.Person;

import java.util.Scanner;

public class CommandManager {
//    private FamilyTree<Person> familyTree;
//    private Scanner scanner;
//
//    public CommandManager(FamilyTree<Person> familyTree, Scanner scanner) {
//        this.familyTree = familyTree;
//        this.scanner = new Scanner(System.in);
//    }
//
//    public void start() {
//        while (true) {
//            System.out.println("Введите любую команду, например - add, list, sortByName, sortByBirthYear, exit:");
//            String command = scanner.nextLine();
//            switch (command) {
//                case "add":
//                    addPerson();
//                    break;
//                case "list":
//                    listPeople();
//                    break;
//                case "sortByName":
//                    familyTree.sortByName();
//                    listPeople();
//                    break;
//                case "sortByBirthYear":
//                    familyTree.sortByBirthYear();
//                    listPeople();
//                    break;
//                case "exit":
//                    return;
//                default:
//                    System.out.println("Неизвестная команда");
//            }
//        }
//    }
//
//    private void addPerson() {
//        System.out.println("Введите имя:");
//        String name = scanner.nextLine();
//        System.out.println("Введите дату рождения:");
//        int birthYear = scanner.nextInt();
//        familyTree.addPerson(new Person(name, birthYear));
//    }
//    private void listPeople(){
//        for (Person p :
//                familyTree.getPeople()) {
//            System.out.println(p);
//        }
//    }
}

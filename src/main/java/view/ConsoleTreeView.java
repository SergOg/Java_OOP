package view;

import model.Person;
import presenter.TreePresenter;

import java.util.List;
import java.util.Scanner;

public class ConsoleTreeView implements TreeView {
    private Scanner scanner;
    private TreePresenter presenter;

    public ConsoleTreeView() {
        this.scanner = new Scanner(System.in);
    }

//    public void start() {
//        while (true) {
//            System.out.println("Select operation: ");
//            System.out.println("1. add Person");
//            System.out.println("2. displayPersons");
//            System.out.println("3. findPersonByName");
//            System.out.println("4. exit");
//            String choice = scanner.nextLine();
//
//            switch (choice) {
//                case "1":
//                    System.out.println("Enter name:");
//                    String name = scanner.nextLine();
//                    System.out.println("Enter birthYear:");
//                    int age = Integer.parseInt(scanner.nextLine());
//                    treePresenter.addPerson1(name, age);
//                    break;
//                case "2":
//                    treePresenter.displayPersons();
//                    break;
//                case "3":
//                    treePresenter.getUserInput();
//                    break;
//                case "4":
//                    System.out.println("Good bye!");
//                    return;
//                default:
//                    System.out.println("Not exist!");
//            }
//        }
//    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayPersons(List<Person> persons) {
        for (Person p :
                persons) {
            System.out.println(p);
        }
    }

    @Override
    public String getUserInput() {
        return scanner.nextLine();
    }

    @Override
    public void setPresenter(TreePresenter presenter) {
        this.presenter = presenter;
    }
}

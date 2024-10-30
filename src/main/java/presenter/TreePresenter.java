package presenter;

import model.FamilyTree;
import model.Person;
import service.FileOperations;
import service.FileOperationsImpl;
import view.TreeView;

import java.io.IOException;

public class TreePresenter {
    private TreeView view;
    private FileOperations<Person> fileOperations;
    private FamilyTree<Person> familyTree;

    public TreePresenter(FamilyTree<Person> familyTree, TreeView view, FileOperationsImpl<Person> fileOperations) {
        this.view = view;
        this.familyTree = familyTree;
        this.fileOperations = fileOperations;
        //this.view.setPresenter(this);
    }

    public void addPerson1(String name, int age) {
        familyTree.addPerson1(name, age);
        view.displayMessage("Person added!");
    }

    public void showAllPersons() {
        view.displayPersons(familyTree.getPeople());
    }

    public void sortPersonsByName() {
        familyTree.sortByName();
        view.displayMessage("Persons sorted by name:");
        showAllPersons();
    }

    public void sortPersonsByBirthYear() {
        familyTree.sortByBirthYear();
        view.displayMessage("Persons sorted by birth year:");
        showAllPersons();
    }

    public void saveTree(String fileName) {
        try {
            fileOperations.saveToFile(familyTree, fileName);
            view.displayMessage("Family tree saved to " + fileName);
        } catch (IOException e) {
            view.displayMessage("Error saving family tree: " + e.getMessage());
        }
    }

    public void loadTree(String fileName) {
        try {
            familyTree = fileOperations.loadFromFile(fileName);
            view.displayMessage("Family tree loaded from " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            view.displayMessage("Error loading family tree: " + e.getMessage());
        }
    }

    public void handleCommand(String command) {
    //public void choiceInput() {
//        while (true) {
//            view.displayMessage("Enter command (1 add, 2 list, 3 sortByName, 4 sortByBirthYear, 5 save, 6 load, 7 exit):");
//            String command = view.getUserInput();
            switch (command) {
                case "1":
                    view.displayMessage("Enter name:");
                    String name = view.getUserInput();
                    view.displayMessage("Enter birth year:");
                    int birthYear = Integer.parseInt(view.getUserInput());
                    addPerson1(name, birthYear);
                    break;
                case "2":
                    showAllPersons();
                    break;
                case "3":
                    sortPersonsByName();
                    break;
                case "4":
                    sortPersonsByBirthYear();
                    break;
                case "5":
                    view.displayMessage("Enter file name:");
                    saveTree(view.getUserInput());
                    break;
                case "6":
                    view.displayMessage("Enter file name:");
                    loadTree(view.getUserInput());
                    break;
                case "7":
                    //return;
                    System.exit(0);
                default:
                    view.displayMessage("Unknown command");
            }
//        }
    }
}

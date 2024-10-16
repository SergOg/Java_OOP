import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree();

        Person nic = new Person("Nic", 1928);
        Person margo = new Person("Margo", 1937);
        Person max = new Person("Max", 1998);
        Person serg = new Person("Serg", 1968);
        Person mary = new Person("Mary", 2003);
        Person tema = new Person("Tema", 2020);

        establishRelations(nic, margo, serg, max, mary, tema);

        // Добавляем людей в семейное древо
        familyTree.addPerson(nic, margo, serg, max, mary, tema);

//        nic.addChild(serg);
//        margo.addChild(serg);
//        serg.setMother(margo);
//        serg.setFather(nic);
//        serg.addChild(max);
//        serg.addChild(mary);
//        max.setFather(serg);
//        mary.setFather(serg);
//        tema.setFather(max);
//        max.addChild(tema);

//        familyTree.addPerson(nic);
//        familyTree.addPerson(margo);
//        familyTree.addPerson(serg);
//        familyTree.addPerson(max);
//        familyTree.addPerson(mary);
//        familyTree.addPerson(tema);

        ///System.out.println(familyTree.findPersonByName("Nic"));

        for (Person p :
                familyTree.getPeople()) {
            System.out.println(p);
        }

//        List<Person> nicChildren = familyTree.getChildren(nic);
//        for (Person child : nicChildren) {
//            System.out.println("Nic's child: " + child.getName());
//        }
//        List<Person> sergChildren = familyTree.getChildren(serg);
//        for (Person child : sergChildren) {
//            System.out.println("Serg's child: " + child.getName());
//        }
//        List<Person> maxChildren = familyTree.getChildren(max);
//        for (Person child : maxChildren) {
//            System.out.println("Max's child: " + child.getName());
//        }
//        List<Person> sergParents = new ArrayList<>();
//        sergParents.add((Person) serg.getMother());
//        sergParents.add((Person) serg.getFather());
//        for (Person child : sergParents) {
//            System.out.println("Serg's parents: " + child.getName());
//        }
        // Выводим всех детей и родителей с помощью методов
        printChildren(familyTree, nic);
        printChildren(familyTree, serg);
        printChildren(familyTree, max);
        printParents(serg);

/**
 * Создаем объект для работы с файлами
 */
        FileOperations fileOps = new FileOperationsImpl();
        try {
            fileOps.saveToFile(familyTree, "familyTree.dat");
            System.out.println("Family tree saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
/**
 *Загружаем генеалогическое древо из файла
 */
        FamilyTree loadedFamilyTree = null;
        try {
            loadedFamilyTree = fileOps.loadFromFile("familyTree.dat");
            System.out.println("Family tree loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
/**
 * Проверка после загрузки
  */
        if (loadedFamilyTree != null) {
            for (Person p :
                    loadedFamilyTree.getPeople()) {
                System.out.println(p);
            }
        }
    }


    // Метод для установления родственных связей
    private static void establishRelations(Person nic, Person margo, Person serg,
                                           Person max, Person mary, Person tema) {
        nic.addChild(serg);
        margo.addChild(serg);
        serg.setMother(margo);
        serg.setFather(nic);

        serg.addChild(max);
        serg.addChild(mary);
        max.setFather(serg);
        mary.setFather(serg);

        tema.setFather(max);
        max.addChild(tema);
    }

    // Метод для вывода детей
    private static void printChildren(FamilyTree familyTree, Person person) {
        List<Person> children = familyTree.getChildren(person);
        for (Person child : children) {
            System.out.println(person.getName() + "'s child: " + child.getName());
        }
    }

    // Метод для вывода родителей
    private static void printParents(Person person) {
        if (person.getMother() != null) {
            System.out.println(person.getName() + "'s mother: " + person.getMother().getName());
        }
        if (person.getFather() != null) {
            System.out.println(person.getName() + "'s father: " + person.getFather().getName());
        }
    }
}

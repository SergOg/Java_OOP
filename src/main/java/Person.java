import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Класс Люди
 */
public class Person implements Serializable {
    private String name;
    private int birthYear;
    private Person mother;
    private Person father;
    private List<Person> children;
    private static final long serialVersionUID = 1L;

    public void addChild(Person child) {
        this.children.add(child);
    }

    /**
     * Это конструктор
     * @param name Имя
     * @param birthYear День рождения
     */
    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", mother=" + mother +
                ", father=" + father +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return birthYear == person.birthYear && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthYear);
    }
}

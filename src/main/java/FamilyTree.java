import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Tree
 */
public class FamilyTree implements Serializable {

    private List<Person> people;
    private static final long serialVersionUID = 1L;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    void addPerson(Person person) {
        this.people.add(person);
    }

    public Person getPerson(int i) {
        return people.get(i);
    }

    public List<Person> getPeople(){
        return people;
    }

    /**
     * поможет находить человека по имени
     */
    public Person findPersonByName(String name) {
        for (Person p :
                people) {
            if (p.getName().equals(name))
                return p;
        }
        return null;
    }

    /**
     * получить список детей для конкретного человека
     *
     * @return
     */
    public List<Person> getChildren(Person person) {
        return person.getChildren();
    }

}

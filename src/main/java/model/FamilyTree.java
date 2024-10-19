package model;

import model.Person;

import java.io.Serializable;
import java.util.*;

/**
 * Tree
 */
public class FamilyTree implements Serializable, Iterable<Person> {

    private List<Person> people;
    private static final long serialVersionUID = 1L;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person... person) {
        this.people.addAll(Arrays.asList(person));
    }

    public List<Person> getPeople() {
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

    @Override
    public Iterator<Person> iterator() {
        return people.iterator();
    }

    public void sortByName() {
        Collections.sort(people, (p1, p2) ->
                p1.getName().compareTo(p2.getName()));
    }

    public void sortByBirthYear() {
        Collections.sort(people, (p1, p2) ->
                Integer.compare(p1.getBirthYear(), p2.getBirthYear()));
    }
}

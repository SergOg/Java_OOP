package model;

import java.io.Serializable;
import java.util.*;

/**
 * Tree
 */
public class FamilyTree<T> implements Serializable, Iterable<T> {

    private List<Person> people;
    private static final long serialVersionUID = 1L;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person... person) {
        this.people.addAll(Arrays.asList(person));
    }
    public void addPerson1(String name, int age){
        Person person = new Person(name, age);
        this.people.add(person);
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
            if (p.toString().equals(name))
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
    public Iterator<T> iterator() {
        return (Iterator<T>) people.iterator();
    }

    public void sortByName() {
        Collections.sort(people, (p1, p2) ->
                p1.toString().compareTo(p2.toString()));
    }

    public void sortByBirthYear() {
        //if (people.get(0) instanceof Person)
        Collections.sort(people, (p1, p2) ->
                Integer.compare(((Person) p1).getBirthYear(), ((Person) p2).getBirthYear()));
    }
}

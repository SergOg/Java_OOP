package model;

import java.io.Serializable;
import java.util.*;

/**
 * Tree
 */
public class FamilyTree<T> implements Serializable, Iterable<T> {

    private List<T> people;
    private static final long serialVersionUID = 1L;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addPerson(T... person) {
        this.people.addAll(Arrays.asList(person));
    }

    public List<T> getPeople() {
        return people;
    }

    /**
     * поможет находить человека по имени
     */
    public T findPersonByName(String name) {
        for (T p :
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
        return people.iterator();
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

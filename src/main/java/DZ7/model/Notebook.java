package DZ7.model;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
//Класс Notebook должен управлять списком записей и
//обеспечивать логику работы с классом Note, не занимаясь выводом данных или
//взаимодействием с пользователем

public class Notebook<T> implements Serializable, Iterable<T> {
    private List<Note> notes;

    public Notebook() {
        this.notes = new ArrayList<>();
    }

    public void addNote(LocalDateTime data, String info) {
        Note note = new Note(data, info);
        this.notes.add(note);
    }

    public List<Note> getNote() {
        return notes;
    }

    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>) notes.iterator();
    }

    public void sortByInfo() {
        Collections.sort(notes, (n1, n2) ->
                n1.toString().compareTo(n2.toString()));
    }

    public void sortByData() {
        if (notes.get(0) != null)
            notes.sort(Comparator.comparing(n -> ((Note) n).getData()));
    }

    //Метод для получения записей по дате getNotesForDay()
    public List<Note> getNotesForDay(LocalDateTime dateTime) {
        return notes.stream()
                .filter(note -> note.getData().toLocalDate().isEqual(dateTime.toLocalDate()))
                .sorted(Comparator.comparing(Note::getData))
                .collect(Collectors.toList());
    }

    //Метод для получения записей по неделе getNotesForWeek()
    public List<Note> getNotesForWeek(LocalDateTime startOfWeek) {
        LocalDateTime endOfWeek = startOfWeek.plusWeeks(1);
        return notes.stream()
                .filter(note -> !note.getData().isBefore(startOfWeek) && !note.getData().isAfter(endOfWeek))
                .sorted(Comparator.comparing(Note::getData))
                .collect(Collectors.toList());
    }

    public void saveToFile(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Note note : notes) {
                writer.write(note.toString());
                writer.newLine();
            }
        }
    }

    public void loadFromFile(String fileName) throws IOException {
        notes.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ", 2);
                LocalDateTime data = LocalDateTime.parse(parts[0]);
                String info = parts[1];
                notes.add(new Note(data, info));
            }
        }
    }

    public Note findNoteByInfo(String info) {
        for (Note n :
                notes) {
            if (n.toString().equals(info))
                return n;
        }
        return null;
    }
}

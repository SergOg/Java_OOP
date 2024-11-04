package DZ7.view;

import DZ7.model.Note;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ConsoleNotebookView implements NotebookView {
    private Scanner scanner;

    public ConsoleNotebookView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void showNotes(List<Note> notes) {
        for (Note n :
                notes) {
            System.out.println(n);
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public LocalDateTime getDateTimeInput() {
        LocalDateTime time = LocalDateTime.now();
        System.out.println("Введите дату в формате: " + time);
        String input = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        return LocalDateTime.parse(input, formatter);
    }

    @Override
    public String getDescriptionInput() {
        return scanner.nextLine();
    }

    @Override
    public String getFileNameInput() {
        return scanner.nextLine();
    }
}

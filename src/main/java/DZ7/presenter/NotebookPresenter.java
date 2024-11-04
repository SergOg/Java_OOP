package DZ7.presenter;

import DZ7.model.Note;
import DZ7.model.Notebook;
import DZ7.view.NotebookView;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class NotebookPresenter {
    private NotebookView notebookView;
    private Notebook<Note> notebookModel;

    public NotebookPresenter(NotebookView notebookView, Notebook<Note> notebook) {
        this.notebookView = notebookView;
        this.notebookModel = notebook;
    }

    public void addNote(LocalDateTime data, String info) {
        notebookModel.addNote(data, info);
        notebookView.showMessage("Note added!");
    }

    public void showNotes() {
        notebookView.showNotes(notebookModel.getNote());
    }

    public void showNotesForDay() {
        LocalDateTime dateTime = notebookView.getDateTimeInput();
        List<Note> notes = notebookModel.getNotesForDay(dateTime);
        notebookView.showNotes(notes);
    }

    public void showNotesForWeek() {
        LocalDateTime startOfWeek = notebookView.getDateTimeInput();
        List<Note> notes = notebookModel.getNotesForWeek(startOfWeek);
        notebookView.showNotes(notes);
    }

    public void sortNotesByInfo() {
        notebookModel.sortByInfo();
        notebookView.showMessage("Notes sorted by info:");
        showNotes();
    }

    public void sortNoteByData() {
        notebookModel.sortByData();
        notebookView.showMessage("Notes sorted by data:");
        showNotes();
    }

    public void saveNotes() {
        System.out.println("Enter fileName: ");
        String fileName = notebookView.getFileNameInput();
        try {
            notebookModel.saveToFile(fileName);
            notebookView.showMessage("Notes saved to " + fileName);
        } catch (IOException e) {
            notebookView.showMessage("Failed to save notes: " + e.getMessage());
        }
    }

    public void loadNotes() {
        System.out.println("Enter fileName from: ");
        String fileName = notebookView.getFileNameInput();
        try {
            notebookModel.loadFromFile(fileName);
            notebookView.showMessage("Notes loaded from " + fileName);
        } catch (IOException e) {
            notebookView.showMessage("Failed to load notes: " + e.getMessage());
        }
    }

    public void choiceInput() {
        while (true) {
            notebookView.showMessage("Enter command (1 add, 2 list, 3 sortByInfo, 4 sortByData, 5 forDay, 6 forWeek, 7 save, 8 load, 9 exit):");
            String command = notebookView.getDescriptionInput();
            switch (command) {
                case "1":
                    //notebookView.showMessage("Enter data:");
//                    int data = Integer.parseInt(notebookView.getDescriptionInput());
                    LocalDateTime data = notebookView.getDateTimeInput();
                    notebookView.showMessage("Enter info:");
                    String info = notebookView.getDescriptionInput();
                    addNote(data, info);
                    break;
                case "2":
                    showNotes();
                    break;
                case "3":
                    sortNotesByInfo();
                    break;
                case "4":
                    sortNoteByData();
                    break;
                case "5":
                    showNotesForDay();
                    break;
                case "6":
                    showNotesForWeek();
                    break;
                case "7":
                    saveNotes();
                    break;
                case "8":
                    loadNotes();
                    break;
                case "9":
                    System.exit(0);
                default:
                    notebookView.showMessage("Unknown command");
            }
        }
    }
}


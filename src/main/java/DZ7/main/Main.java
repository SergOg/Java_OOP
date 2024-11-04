package DZ7.main;

import DZ7.model.Note;
import DZ7.model.Notebook;
import DZ7.presenter.NotebookPresenter;
import DZ7.view.ConsoleNotebookView;

//Проект содержит интерфейсы, реализован с использованием MVP паттерна,
//удовлетворяет всем принципам SOLID. Создать проект с записной книжкой. Идея
//в том, что пользователь может делать записи на различные дни (например в
//19:00 стоматолог), читать записи, сохранять и загружать в файл, сортировать,
//искать записи на конкретный день или неделю.
//Приложение должно быть консольным
public class Main {
    public static void main(String[] args) {
        Notebook<Note> notebook = new Notebook<>();
        ConsoleNotebookView view = new ConsoleNotebookView();

//        FileOperationsImpl<Person> fileOperations = new FileOperationsImpl<>();
        NotebookPresenter presenter = new NotebookPresenter(view, notebook);
//        CommandHandler commandHandler = new CommandHandler(presenter, view);
        //presenter.choiceInput();
        presenter.choiceInput();
    }
}

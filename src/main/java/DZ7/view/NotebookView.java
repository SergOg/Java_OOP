package DZ7.view;
//Интерфейс NotebookView позволяет отделить представление (вывод данных) от логики приложения

import java.time.LocalDateTime;

public interface NotebookView extends ShowMessView, ShowNotesView{
    LocalDateTime getDateTimeInput();
    String getDescriptionInput();
    String getFileNameInput();
}

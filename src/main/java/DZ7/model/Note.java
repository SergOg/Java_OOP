package DZ7.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

//класс Note должен только хранить данные о записи
public class Note implements Serializable {
    private LocalDateTime data;
    private String info;
    private static final long serialVersionUID = 1L;

    public Note(LocalDateTime data, String info) {
        this.data = data;
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public LocalDateTime getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Note{" +
                "info='" + info + '\'' +
                ", data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(info, note.info) && Objects.equals(data, note.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(info, data);
    }
}

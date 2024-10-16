import java.io.IOException;

/**
 * Интерфейс для операций с файлами
 */
interface FileOperations {
    void saveToFile(FamilyTree familyTree, String fileName) throws IOException;

    FamilyTree loadFromFile(String fileName) throws IOException, ClassNotFoundException;
}

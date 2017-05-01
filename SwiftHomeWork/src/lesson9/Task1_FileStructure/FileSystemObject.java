package lesson9.Task1_FileStructure;

/**
 * Created by aizeeck on 30.04.17.
 */
public abstract class FileSystemObject {

    private FileSystemObject parent;
    private String name;

    public FileSystemObject(FileSystemObject parent, String name) {
        this.parent = parent;
        this.name = name;
    }

    public FileSystemObject getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }
}

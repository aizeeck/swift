package lesson9.Task1_FileStructure;

import java.util.ArrayList;

/**
 * Created by aizeeck on 30.04.17.
 */
public class FolderObject extends FileSystemObject {

    ArrayList<FileSystemObject> children = new ArrayList<>();

    public FolderObject(FileSystemObject parent, String name, FileSystemObject children) {
        super(parent, name);
    }

    public void addChildred(FileSystemObject fileSystemObject) {
        children.add(fileSystemObject);
    }

    public ArrayList<FileSystemObject> getChildren() {
        return children;
    }
}

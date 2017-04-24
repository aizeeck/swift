package lesson7.Task3_FileManagement;

import java.time.LocalDateTime;

/**
 * Created by aizeeck on 22.04.17.
 */
public class ContentFile extends File {
    private String content;
    private LocalDateTime lastModifiedDate;

    public ContentFile(String name, String location, String content) {
        super(name, location);
        this.content = content;
        lastModifiedDate = LocalDateTime.now();
    }

    public String getContent() {
        return content;
    }

    public void modify() {
        lastModifiedDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return super.toString() + "\nLast modification date: " + lastModifiedDate;
    }
}

package lesson7.Task3_FileManagement;

/**
 * Created by aizeeck on 22.04.17.
 */
public class MediaContentFile extends ContentFile {

    public MediaContentFile(String name, String location, String content) {
        super(name, location, content);
    }

    @Override
    public void execute() {
        if (this.isDeleted()) {return;}

        System.out.println("♫♫♫" + this.getFullName()+ "\n"
                + this.getContent() + "\n");
    }
}

package Classes;

import java.io.File;
import java.net.URI;

public class FileMain extends File{
    String strFilePath;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStrFilePath() {
        return strFilePath;
    }

    public void setStrFilePath(String strFilePath) {
        this.strFilePath = strFilePath;
    }

    public FileMain(String pathname) {
        super(pathname);
    }

    public FileMain(String parent, String child) {
        super(parent, child);
    }

    public FileMain(File parent, String child) {
        super(parent, child);
    }

    public FileMain(URI uri) {
        super(uri);
    }
}

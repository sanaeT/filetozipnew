package MainRun;

import Classes.FileMain;
import Classes.MainLogic;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MainLogic go=new MainLogic();
        FileMain file=go.FileCreation();
        go.ZipInformation(file);
    }
}

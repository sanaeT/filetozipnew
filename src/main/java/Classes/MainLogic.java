package Classes;

import java.io.IOException;

public class MainLogic {
    public FileMain FileCreation() {
        InputData input = new InputData();
        //создание файла
        String strpathname = null;
        String strname = null;
        do {
            if (strpathname == null) {
                System.out.println("Введите корректный путь !");
                strpathname = input.getPath();
            }
            if (strname == null) {
                System.out.println("Введите корректное имя");
                strname = input.getFilename();
            }
        } while ((strpathname == null) || (strname == null));

        FileMain filetozip = new FileMain(strpathname+'/'+strname);
        filetozip.strFilePath=strpathname;
        filetozip.name=strname;
        FileActions fileact = new FileActions();
        try {
            fileact.FileInfo(filetozip);
        } catch (IOException e) {
            System.out.println("Проблеммы с файлом! Файл не найден");
        }
        return filetozip;
    }
        public void ZipInformation(FileMain file ) throws IOException {
            InputData input=new InputData();
            FileActions fact=new FileActions();
            fact.FileCompress(file, input.getZipName(), input.getCompressionLevel());
        }

}

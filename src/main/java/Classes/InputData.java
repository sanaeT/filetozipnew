package Classes;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputData {

    public String getPath() {
        System.out.println("Введите адрес файла");
        Scanner in = new Scanner(System.in);
        String filePath;
        filePath = in.nextLine();
        if ((filePath.isEmpty()) || (filePath.equals('*'))){
            System.out.println("Выход");
            System.exit(0);
        }
        else{
            System.out.println(filePath);
            if (checkPath(filePath)==null){
                System.out.println("Неудача!");
                return null;
            }
        }
        return checkPath(filePath);
    }

    public String checkPath(String strFilePath) {
        FileMain testFile=new FileMain(strFilePath);
        testFile.setStrFilePath(strFilePath);
        if (testFile.exists()){
            System.out.println("Адрес валидный");
            return strFilePath;
        }
        else {
            System.out.println("Директория или файл не существует");
            System.out.println("Попробуйте еще или введите * для выхода");
            getPath();
            return null;
        }
    }

    public String getZipName(){
        System.out.println("Введите имя создаваемого zip");
        Scanner in = new Scanner(System.in);
        String strZipName=in.nextLine();
        if (strZipName.isEmpty() || strZipName.equals('*')) {
            System.out.println("Выход");
            System.exit(0);
        }
        else{
            String zipnameregel = "[A-Za-z0-9]+";
            Pattern pattern = Pattern.compile(zipnameregel);
            Matcher matcher = pattern.matcher(strZipName);
            if (matcher.find()) {
                System.out.println("Название принято");
            } else {
                System.out.println("Невалидное имя");
                getZipName();
            }
        }
        return strZipName;
    }

    public int getCompressionLevel() {
        System.out.println("Укажите уровень компрессии файла от 1 до 9");
        Scanner in = new Scanner(System.in);
        int strCompLevel=0;
        try{
                 strCompLevel = in.nextInt();

        }
        catch (InputMismatchException e){
            System.out.println("Это должна быть цифра!");
            getCompressionLevel();
        }
        if  ((strCompLevel<1) ||  (strCompLevel>9)) return getCompressionLevel();
        return strCompLevel;
    }

    public String getFilename() {
        System.out.println("Введите имя файла");
        Scanner in = new Scanner(System.in);
        String strFileName=in.nextLine();
        if (strFileName.isEmpty() || strFileName.equals('*')) {
            System.out.println("Выход");
            System.exit(0);
        }
        String zipnameregel = "[A-Za-z0-9]+.[A-Za-z0-9]+";
        Pattern pattern = Pattern.compile(zipnameregel);
        Matcher matcher = pattern.matcher(strFileName);
        if (!matcher.find()) {
            System.out.println("Невалидное имя");
            return null;
        }
        System.out.println("Название принято " + strFileName);
        return strFileName;
        }
    }


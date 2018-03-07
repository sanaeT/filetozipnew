package Classes;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class FileActions {
    public FileActions() {
    }

    public void FileInfo (FileMain myfilecheck) throws IOException {
        Path p = myfilecheck.toPath();
        System.out.println(p);

        String probeContentType = Files.probeContentType(p);
        System.out.println("type "+ probeContentType );

        try {
            BasicFileAttributes attr = Files.readAttributes(p, BasicFileAttributes.class);
            System.out.println("creationTime: " + attr.creationTime());
            System.out.println("lastAccessTime: " + attr.lastAccessTime());
            System.out.println("lastModifiedTime: " + attr.lastModifiedTime());

            System.out.println("isDirectory: " + attr.isDirectory());
            System.out.println("isOther: " + attr.isOther());
            System.out.println("isRegularFile: " + attr.isRegularFile());
            System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
            System.out.println("length: " + attr.size());
            System.out.println("size: " + myfilecheck.length());
        }
    catch (NoSuchFileException enofile){
            System.out.println("Файла не существует");
        }
            }

    public void FileCompress(FileMain file, String zipname, Integer complevel) throws IOException {
                  // input file
        FileInputStream in = new FileInputStream(file);

        // out put file
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipname));

        // name the file inside the zip  file
        out.setLevel(complevel);
        ZipEntry zipfile=new ZipEntry("zippedjava.txt");
        out.putNextEntry(zipfile);

        // buffer size
        byte[] b = new byte[1024];
        int count;

        while ((count = in.read(b)) > 0) {
            out.write(b, 0, count);
        }


        out.close();
        in.close();
    }

    }

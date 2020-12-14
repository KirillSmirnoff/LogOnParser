package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileToString {
    public String fileToString(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        StringBuilder stringBuilder = new StringBuilder();
        byte[] bytes = new byte[10];
        while (fileInputStream.read(bytes) != -1){
            stringBuilder.append(new String(bytes));
            bytes = new byte[10];
        }
        fileInputStream.close();
        return stringBuilder.toString();
    }
}

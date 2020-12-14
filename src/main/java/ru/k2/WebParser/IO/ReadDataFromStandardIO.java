package IO;

import java.io.IOException;
import java.util.Scanner;

/*Класс предназначен для чтения данных из стандартного ввода вывода*/
public class ReadDataFromStandardIO {

    /*данные со стандартного ввода преобразуем в строку - String*/
    public String inToString() throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String input = null;

         while (sc.hasNextLine()) {
            input= sc.nextLine();
            sb.append(input);
            if (input.equals(""))
                break;
        }
        System.out.println("==================== Данные прочитаны =======================");
        return sb.toString();
    }
}

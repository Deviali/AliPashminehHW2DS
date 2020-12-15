import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Publisher publisher = new Publisher("Folder");
        Subscriber subscriber = new Subscriber("Folder");
        

        System.out.println("Insert the folder location");
        Scanner s = new Scanner(System.in);
        File f = new File(s.nextLine());
        if (f.exists() && f.isDirectory()) publisher.publishFromFile(f);
            else System.err.println("File Not Found");
    }
}

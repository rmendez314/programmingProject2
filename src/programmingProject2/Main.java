package programmingProject2;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {
    public static Array[] stores = new Array[];
    public static Array[] queries = new Array[];

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        int i = 0;
        Scanner scnr = new Scanner(new File("WhataburgerData.csv"));
        Scanner scnr2 = new Scanner(new File("Queries.csv"));

        scnr.useDelimiter(",");
        scnr.useDelimiter(",");

        while (scnr.hasNext()) { //returns a boolean value
            //Store store = new Store()
            System.out.print(scnr.next());  //find and returns the next complete token from this scanner
            i++;
        }
        scnr.close();  //closes the scanner

        while (scnr2.hasNext()) { //returns a boolean value
            System.out.print(scnr2.next());  //find and returns the next complete token from this scanner
        }
        scnr2.close();  //closes the scanner
        scnr.close();  //closes the scanner
    }
}


package programmingProject2;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Store> storeList;
    public static ArrayList<Query> queryList;

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        int i = 0;
        storeList = new ArrayList<>();
        queryList = new ArrayList<>();

        loadStores("WhataburgerData.csv");
        loadQueries("Queries.csv");
    }

    public static void loadStores(String fileName){
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line1 = "";
            while( (line1 = br.readLine()) != null ) { //loops through a .csv file until it reaches a null line
                String [] array = line1.split(",");
                Store s = new Store (Integer.getInteger(
                        array[0]),
                        array[1],
                        array[2],
                        array[3],
                        Integer.getInteger(array[4]),
                        Double.parseDouble(array[5]),
                        Double.parseDouble(array[6])
                ); //creates a new zone object
                addStore(s);
            }
        } catch (IOException e) { // if file is not found
            e.printStackTrace();
        }
    }

    public static void addStore(Store store){
        storeList.add(store);
    }

    public static void loadQueries(String fileName){
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line1 = "";
            while( (line1 = br.readLine()) != null ) { //loops through a .csv file until it reaches a null line
                String [] array = line1.split(",");
                Query q = new Query (
                        Double.parseDouble(array[0]),
                        Double.parseDouble(array[1]),
                        Integer.getInteger(array[2])
                ); //creates a new zone object
                addQuery(q);
            }
        } catch (IOException e) { // if file is not found
            e.printStackTrace();
        }
    }

    public static void addQuery(Query query){
        queryList.add(query);
    }
}


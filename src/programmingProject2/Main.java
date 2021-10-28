package programmingProject2;
import java.io.*;
import java.util.ArrayList;
import static java.lang.Double.*;

public class Main {
    public static ArrayList<Store> storeList;
    public static ArrayList<Query> queryList;

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub

        storeList = new ArrayList<>();
        queryList = new ArrayList<>();
        setStoreList(storeList);
        setQueryList(queryList);

        loadStores("WhataburgerData.csv");
        loadQueries("Queries.csv");

        //printStoreList(storeList);
        //printQueryList(queryList);
    }

    public static void setStoreList(ArrayList<Store> stores){
        storeList=stores;
    }

    public ArrayList <Store> getStoreList(){
        return storeList;
    }

    public static void setQueryList(ArrayList<Query> queries){
        queryList=queries;
    }

    public ArrayList<Query> getQueryList (){
        return queryList;
    }

    public static void loadStores(String fileName){
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line1;
            br.readLine();
            while( (line1 = br.readLine()) != null ) { //loops through a .csv file until it reaches a null line
                String [] array = line1.split(",");
                Store s = new Store (
                        Integer.parseInt(array[0]),
                        array[1],
                        array[2],
                        array[3],
                        Integer.parseInt(array[4]),
                        parseDouble(array[5]),
                        parseDouble(array[6])
                ); //creates a new store object
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
            String line1;
            br.readLine();
            while( (line1 = br.readLine()) != null ) { //loops through a .csv file until it reaches a null line
                String [] array = line1.split(",");
                Query q = new Query (
                        parseDouble(array[0]),
                        parseDouble(array[1]),
                        Integer.parseInt(array[2])
                ); //creates a new query object
                addQuery(q);
            }
        } catch (IOException e) { // if file is not found
            e.printStackTrace();
        }
    }

    public static void addQuery(Query query){
        queryList.add(query);
    }

    public static void printStoreList(ArrayList<Store> list){
        for (Store s : list) {
            System.out.println(
                    s.getStoreID() + ", "
                            + s.getAddress() + ", "
                            + s.getAddress() + ", "
                            + s.getCity() + ", "
                            + s.getState() + ", "
                            + s.getZipCode() + ", "
                            + s.getLatitude() + ", "
                            + s.getLongitude()
            );
        }
    }

    public static void printQueryList(ArrayList<Query> list){
        for (Query q : list) {
            System.out.println(
                    q.getqLatitude() + ", "
                            + q.getqLongitude() + ", "
                            + q.getNumberOfStores() + ", "
            );
        }
    }
}


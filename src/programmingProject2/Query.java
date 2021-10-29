//Algorithms Project 2 Written by Ramiro Mendez & Matthew Farnsworth
package programmingProject2;
import java.util.ArrayList;
import java.util.Random;

public class Query {
    public double qLatitude;
    public double qLongitude;
    public int numberOfStores;
    public ArrayList<Store> storeList;

    public Query(double theQLatitude, double theQLongitude, int theNumStores) {
        setqLatitude(theQLatitude);
        setqLongitude(theQLongitude);
        setNumberOfStores(theNumStores);
        storeList = new ArrayList<Store>();
        setQueryList(storeList);
    }

    public void setqLatitude(double lat) {
        this.qLatitude = lat;
    }

    public double getqLatitude() {
        return this.qLatitude;
    }

    public void setqLongitude(double otherlong) {
        this.qLongitude = otherlong;
    }

    public double getqLongitude() {
        return this.qLongitude;
    }

    public void setNumberOfStores(int numberOfStores1) {
        this.numberOfStores = numberOfStores1;
    }

    public int getNumberOfStores() {
        return this.numberOfStores;
    }

    public void setQueryList(ArrayList<Store> stores) {
        this.storeList = stores;
    }

    public void randomSelect(ArrayList<Store> stores, int low, int high) {
            Random rand= new Random();
            int pivot = rand.nextInt(high-low)+low;

            Store temp= stores.get(pivot);
            stores.set(pivot, stores.get(high));
            stores.set(high, temp);
    }
    public int randomPartition(ArrayList<Store> stores, int low, int high) {
        randomSelect(stores,low,high);
        double pivot = stores.get(high).distance;
        int i = (low-1);

        for (int j = low; j < high; j++) {
            Store s = stores.get(j);
            s.computeDistance(this.qLatitude, this.qLongitude);
            if (s.distance < pivot) {
                i++;
                Store temp = stores.get(i);
                stores.set(i, stores.get(j));
                stores.set(j, temp);
            }
        }
        Store temp = stores.get(i + 1);
        stores.set(i + 1, stores.get(high));
        stores.set(high, temp);

        return i+1;
    }

    public void quickSort(ArrayList<Store> stores, int low, int high) {
        if (low < high) {
            int pivot = randomPartition(stores, low, high);

            quickSort(stores, low, pivot-1);
            quickSort(stores, pivot+1, high);
        }
        this.storeList=stores;
    }

    public void printStoreList(){
        System.out.println("The " + this.numberOfStores + " closest Whataburgers to (" + this.qLatitude + ", " + this.qLongitude + ")");
        for (int i =0; i < this.numberOfStores; i++) {
            Store s = this.storeList.get(i);
            if(s.distance > 0) {
                System.out.println("Whataburger " +
                        s.getStoreID() + ", "
                        + s.getAddress() + ", "
                        + s.getAddress() + ", "
                        + s.getCity() + ", "
                        + s.getState() + ", "
                        + s.getZipCode() + ", - "
                        + String.format("%,.2f", s.distance)
                        + " miles"
                );
            }
        }
        System.out.println();
    }
}


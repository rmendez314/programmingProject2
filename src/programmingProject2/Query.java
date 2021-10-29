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

    public ArrayList<Store> getStoreList() {
        return this.storeList;
    }

    public void addStore(Store store){
        storeList.add(store);
    }

    public void randomSelect(ArrayList<Store> stores,int low,int high) {
            Random rand= new Random();
            int pivot = rand.nextInt(high-low)+low;
            Store temp1= stores.get(pivot);
            stores.set(pivot, stores.get(high));
            stores.set(high, temp1);
        }

        /* This function takes last element as pivot,
        places the pivot element at its correct
        position in sorted array, and places all
        smaller (smaller than pivot) to left of
        pivot and all greater elements to right
        of pivot */
        public int partition(ArrayList<Store> stores, int low, int high) {
            // pivot is chosen randomly
            randomSelect(stores,low,high);
            double pivot = stores.get(high).distance;
            int i = (low-1); // index of smaller element
            for (int j = low; j < high; j++) {
                Store s = stores.get(j);
                s.computeDistance(this.qLatitude, this.qLongitude);
                // If current element is smaller than or
                // equal to pivot
                if (s.distance < pivot) {
                    i++;
                    // swap arr[i] and arr[j]
                    Store temp = stores.get(i);
                    stores.set(i, stores.get(j));
                    stores.set(j, temp);
                }
            }
            // swap arr[i+1] and arr[high] (or pivot)
            Store temp = stores.get(i + 1);
            stores.set(i + 1, stores.get(high));
            stores.set(high, temp);

            return i+1;
        }

        /* The main function that implements QuickSort()
        arr[] --> Array to be sorted,
        low --> Starting index,
        high --> Ending index */
        public void sort(ArrayList<Store> stores, int low, int high) {
            if (low < high) {
            /* pi is partitioning index, arr[pi] is
            now at right place */
                int pi = partition(stores, low, high);

                // Recursively sort elements before
                // partition and after partition
                sort(stores, low, pi-1);
                sort(stores, pi+1, high);
            }
            this.storeList=stores;
        }

    public void printStoreList(){
        System.out.println("The " + this.numberOfStores + " closest Whataburgers to (" + this.qLatitude + ", " + this.qLongitude + ")");
        for (int i =0; i < this.numberOfStores; i++) {
            Store s = this.storeList.get(i);
            System.out.println("Whataburger "+
                      s.getStoreID() + ", "
                    + s.getAddress() + ", "
                    + s.getAddress() + ", "
                    + s.getCity() + ", "
                    + s.getState() + ", "
                    + s.getZipCode() + ", - "
                    + s.distance
                    + " miles"
            );
        }
        System.out.println();
    }
}


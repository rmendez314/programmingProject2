package programmingProject2;
import java.util.ArrayList;

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
}


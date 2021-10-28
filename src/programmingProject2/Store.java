package programmingProject2;

public class Store {
    public int storeID;
    public String address;
    public String city;
    public String state;
    public int zipCode;
    public double latitude;
    public double longitude;
    public double distance;

    public Store(int theID, String theAddress, String theCity, String theState, int theZipCode, double theLat, double theLong) {
        storeID = theID;
        address = theAddress;
        city = theCity;
        state = theState;
        zipCode = theZipCode;
        latitude = theLat;
        longitude = theLong;
        distance = -1;
    }

    public void computeDistance(double otherLat, double otherLong) {
        double radiusOfEarthInMiles = 3958.8;

        double lat1 = Math.toRadians(this.latitude);
        double lat2 = Math.toRadians(otherLat);
        double long1 = Math.toRadians(this.longitude);
        double long2 = Math.toRadians(otherLong);

        double a = Math.pow(Math.sin((lat2 - lat1) / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin((long2 - long1) / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        distance = radiusOfEarthInMiles * c;
    }
}
package joris;

public class Calculator {
    private String country;
    private String commodity;
    private String transportMode;
    private String measure;

    public Calculator(String country, String commodity, String transportMode, String measure) {
        this.country = country;
        this.commodity = commodity;
        this.transportMode = transportMode;
        this.measure = measure;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public String getTransportMode() {
        return transportMode;
    }

    public void setTransportMode(String transportMode) {
        this.transportMode = transportMode;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

}

public class Vehicle {
    private String brand;
    private int year;

    public Vehicle() {
    }

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }


    protected void setBrand(String brand) {
        this.brand = brand;
    }

    protected void setYear(int year) {
        this.year = year;
    }
}
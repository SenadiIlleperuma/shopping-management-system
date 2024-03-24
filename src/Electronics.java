public class Electronics extends Product {
    private String Brand;//Brand of the electronic item
    private String Warranty;//Warranty period of the item

    public Electronics(String brand, String warranty) {
        this.Brand = brand;
        this.Warranty = warranty;
    }

    public Electronics(String productID, String Name, String No, Double Price, String brand, String warranty) {
        super(productID, Name, No, Price,brand);
        this.Brand = brand;
        this.Warranty = warranty;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        this.Brand = brand;
    }

    public String getWarranty() {
        return Warranty;
    }

    public void setWarranty(String warranty) {
        this.Warranty = warranty;
    }
    public  String toString(){
        return  "01. Brand      : " + Brand + '\n' +
                "02. Warranty   : " + Warranty + '\n';
    }

}

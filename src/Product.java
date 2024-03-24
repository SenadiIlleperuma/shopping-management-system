public abstract class Product {

    private  String ProductID;// Product Id
    private String ProductName;//Name of the product
    private String AvailableNo;//No of available items of the products
    private double ProductPrice;//Price of the product


    Product(){
        //No args constructor
    }
    public Product( String productID, String Name,String No,Double Price,String Info){
        this.ProductID=productID;
        this.ProductName=Name;
        this.AvailableNo=No;
        this.ProductPrice=Price;
        
    }//full args constructor

    public String getProduct_ID(){
        return ProductID;
    }
    public void setProduct_ID(String id) {
        this.ProductID = id;
    }
    public String getProduct_Name(){
        return ProductName;
    }
    public void setProduct_Name(String name) {
        this.ProductName = name;
    }
    public String getAvailableNo(){
        return AvailableNo;
    }
    public void setAvailableNo(String item_avai) {
        this.AvailableNo = item_avai;
    }

    public double getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(double productPrice) {
        this.ProductPrice = productPrice;
    }


    @Override
    public String toString() {
        return  "01) ProductID     : " + ProductID + '\n' +
                "02) ProductName   : " + ProductName + '\n' +
                "03) AvailableNo   : " + AvailableNo + '\n' +
                "04) ProductPrice  : " + ProductPrice + '\n' ;
    }



}

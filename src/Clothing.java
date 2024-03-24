public class Clothing extends Product {


    private String ClothSize; //The size of the cloth
    private String ClothColor;//The color of the cloth needed

    public Clothing( String ProductID, String ProductName, String AvailableNo,Double ProductPrice,String ClothSize, String ClothColor ) {
        super( ProductID,ProductName,AvailableNo,ProductPrice,ClothSize );
        this.ClothSize=ClothSize;
        this.ClothColor=ClothColor;

    }
    public String getClothColor(){
        return ClothColor;

    }
    public String getClothSize(){
        return ClothSize;

    }

    public void setClothSize(String clothSize) {
        ClothSize = clothSize;
    }

    public void setClothColor(String clothColor) {
        ClothColor = clothColor;
    }

    @Override
    public String toString() {
        return  "01. Size  : " + ClothSize + '\n' +
                "02. Color : " + ClothColor + '\n' ;
    }
}

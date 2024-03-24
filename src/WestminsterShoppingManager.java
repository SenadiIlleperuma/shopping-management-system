import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WestminsterShoppingManager implements ShoppingManager {
    public static final ArrayList<Product> Product_Array = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static List<Electronics> electronics = new ArrayList<>();
    public static List<Clothing> clothing = new ArrayList<>();

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        WestminsterShoppingManager WSC = new WestminsterShoppingManager();
        boolean Start = true;

        do {
            System.out.println("\n                    Westminster Shopping Manager                      ");
            System.out.println("|======================================================================|");
            System.out.println("|                                 Menu                                 |");
            System.out.println("|======================================================================|");
            System.out.println();
            System.out.println("|                          01) Add a new product                       |");
            System.out.println("|                          02) Delete a product                        |");
            System.out.println("|                          03) Print the list of products              |");
            System.out.println("|                          04) Save products in a file                 |");
            System.out.println("|                          05) Open GUI                                |");
            System.out.println("|                          06) Exit                                    |");
            System.out.println();
            System.out.println("|======================================================================|");
            System.out.print("\nEnter your option : ");

            String input = scanner.next();
            switch (input) {
                case "1" -> {
                    WSC.add_New_Product();
                }
                case "2" -> {
                    WSC.delete_Product();
                }
                case "3" -> {
                    WSC.print_Product_list();
                }
                case "4" -> {
                    WSC.saveFile();
                }

                case "5" -> {
                    new GUI();
                }
                case "6" -> {
                    System.out.println("Exiting the program...");
                    Start = false;
                }
                default -> {
                    System.out.println("\nInvalid Input...\nPLease Try Again...");
                }

            }

        } while (Start);
    }

    public String ProductDetails() {
        String run = "Stop";
        for (Product product : Product_Array) {
            run = "Start";
            System.out.println();
            System.out.println("|    Product ID             : " + product.getProduct_ID());
            System.out.println("|    Product Name           : " + product.getProduct_Name());
            System.out.println("|    Available Items        : " + product.getAvailableNo());
            System.out.println("|    Price of the Product   : " + product.getProductPrice());
        }
        return run;
    }

    @Override
    //Adding a new product to the system
    public void add_New_Product() {
        boolean Start = true;

        if (50> Product_Array.size())
    {
            System.out.println("|======================================================================|");
            System.out.println("|                               Add a product                          |");
            System.out.println("|======================================================================|");
            System.out.println();
            System.out.println("|                             1) Electronics                           |");
            System.out.println("|                             2) Clothing                              |");
            System.out.println("|                             3) Back                                  |");
            System.out.println();
            System.out.println("|======================================================================|");
            System.out.println();
            System.out.print("\nEnter your option : ");
            int option1 = scanner.nextInt();
            System.out.println();
            switch (option1) {
                case 1: {
                    add_Electronics();
                }
                case 2: {
                    add_Clothing();
                }
                case 3: {
                    mainMenu();
                }
            }
        }else
        {
            System.out.println("Maximum 50 products can be added...");
        }
    }

    /*private void add_Electronics() {
        System.out.println("|======================================================================|");
        System.out.println("|                        Add a Electronic Product                      |");
        System.out.println("|======================================================================|");
        System.out.print("Enter product ID  : ");
        String id = scanner.next();
        System.out.print("Enter product name  : ");
        String name = scanner.next();
        System.out.print("Enter Available No :");
        String no = scanner.next();
        System.out.print("Enter Price : £ ");
        Double price = scanner.nextDouble();
        System.out.print("Enter the brand : ");
        String brand = scanner.next();
        System.out.print("Enter warranty period  : ");
        String warranty = scanner.next();

        Electronics E1 = new Electronics(id, name, no, price, brand, warranty);
        electronics.add(E1);
        Product_Array.add(E1);
        System.out.println();
        System.out.println("Product added successfully...");
        add_New_Product();
    }

    private void add_Clothing() {
        System.out.println("|======================================================================|");
        System.out.println("|                        Add a Clothing Product                        |");
        System.out.println("|======================================================================|");
        System.out.print("Enter product ID : ");
        String id = scanner.next();
        System.out.print("Enter product name : ");
        String name = scanner.next();
        System.out.print("Enter Available No : ");
        String no = scanner.next();
        System.out.print("Enter Price : £ ");
        Double price = scanner.nextDouble();
        System.out.print("Enter the size :  ");
        String size = scanner.next();
        System.out.print("Enter the color : ");
        String color = scanner.next();

        Clothing C1 = new Clothing(id, name, no, price, size, color);
        clothing.add(C1);
        Product_Array.add(C1);
        System.out.println();
        System.out.println("Product added successfully...");

        add_New_Product();
    }*/

    //Adding an electronic product to the system
    private void add_Electronics() {
        System.out.println("|======================================================================|");
        System.out.println("|                        Add an Electronic Product                     |");
        System.out.println("|======================================================================|");

        String id;
        do {
            System.out.print("Enter product ID  : ");
            id = scanner.next();
            if (!Regex.isTextFieldValid(TextFeilds.ELECTRONIC_ID, id)) {
                System.out.println("Error: Invalid product ID. Please enter a valid ID.");
            }
        } while (!Regex.isTextFieldValid(TextFeilds.ELECTRONIC_ID, id));

        String name;
        do {
            System.out.print("Enter product name  : ");
            name = scanner.next();
            if (!Regex.isTextFieldValid(TextFeilds.STRING_VALUES, name)) {
                System.out.println("Error: Invalid product name. Please enter a valid name.");
            }
        } while (!Regex.isTextFieldValid(TextFeilds.STRING_VALUES, name));

        String no;
        do {
            System.out.print("Enter Available No : ");
            no = scanner.next();
            if (!Regex.isTextFieldValid(TextFeilds.NUMBERS, no)) {
                System.out.println("Error: Invalid available quantity. Please enter a valid number.");
            }
        } while (!Regex.isTextFieldValid(TextFeilds.NUMBERS, no));

        Double price;
        do {
            System.out.print("Enter Price : £ ");
            price = scanner.nextDouble();
            if (!Regex.isTextFieldValid(TextFeilds.PRICE, String.valueOf(price))) {
                System.out.println("Error: Invalid price. Please enter a valid price.");
            }
        } while (!Regex.isTextFieldValid(TextFeilds.PRICE, String.valueOf(price)));

        String brand;
        do {
            System.out.print("Enter the brand : ");
            brand = scanner.next();
            if (!Regex.isTextFieldValid(TextFeilds.STRING_VALUES, brand)) {
                System.out.println("Error: Invalid brand. Please enter a valid brand.");
            }
        } while (!Regex.isTextFieldValid(TextFeilds.STRING_VALUES, brand));

        String warranty;
        do {
            System.out.print("Enter warranty period  : ");
            warranty = scanner.next();
            if (!Regex.isTextFieldValid(TextFeilds.WARRENTY, warranty)) {
                System.out.println("Error: Invalid warranty period. Please enter a valid period.");
            }
        } while (!Regex.isTextFieldValid(TextFeilds.WARRENTY, warranty));

        Electronics E1 = new Electronics(id, name, no, price, brand, warranty);
        electronics.add(E1);
        Product_Array.add(E1);
        System.out.println();
        System.out.println("Product added successfully...");
        add_New_Product();
    }

    //Adding a clothing product to the system
    private void add_Clothing() {
        System.out.println("|======================================================================|");
        System.out.println("|                        Add a Clothing Product                        |");
        System.out.println("|======================================================================|");

        String id;
        do {
            System.out.print("Enter product ID : ");
            id = scanner.next();
            if (!Regex.isTextFieldValid(TextFeilds.CLOTHING_ID, id)) {
                System.out.println("Error: Invalid product ID. Please enter a valid ID.");
            }
        } while (!Regex.isTextFieldValid(TextFeilds.CLOTHING_ID, id));

        String name;
        do {
            System.out.print("Enter product name : ");
            name = scanner.next();
            if (!Regex.isTextFieldValid(TextFeilds.STRING_VALUES, name)) {
                System.out.println("Error: Invalid product name. Please enter a valid name.");
            }
        } while (!Regex.isTextFieldValid(TextFeilds.STRING_VALUES, name));

        String no;
        do {
            System.out.print("Enter Available No : ");
            no = scanner.next();
            if (!Regex.isTextFieldValid(TextFeilds.NUMBERS, no)) {
                System.out.println("Error: Invalid available quantity. Please enter a valid number.");
            }
        } while (!Regex.isTextFieldValid(TextFeilds.NUMBERS, no));

        Double price;
        do {
            System.out.print("Enter Price : £ ");
            price = scanner.nextDouble();
            if (!Regex.isTextFieldValid(TextFeilds.PRICE, String.valueOf(price))) {
                System.out.println("Error: Invalid price. Please enter a valid price.");
            }
        } while (!Regex.isTextFieldValid(TextFeilds.PRICE, String.valueOf(price)));

        String size;
        do {
            System.out.print("Enter the size :  ");
            size = scanner.next();
            if (!Regex.isTextFieldValid(TextFeilds.STRING_VALUES, size)) {
                System.out.println("Error: Invalid size. Please enter a valid size.");
            }
        } while (!Regex.isTextFieldValid(TextFeilds.STRING_VALUES, size));

        String color;
        do {
            System.out.print("Enter the color : ");
            color = scanner.next();
            if (!Regex.isTextFieldValid(TextFeilds.STRING_VALUES, color)) {
                System.out.println("Error: Invalid color. Please enter a valid color.");
            }
        } while (!Regex.isTextFieldValid(TextFeilds.STRING_VALUES, color));

        Clothing C1 = new Clothing(id, name, no, price, size, color);
        clothing.add(C1);
        Product_Array.add(C1);
        System.out.println();
        System.out.println("Product added successfully...");

        add_New_Product();
    }

    //Deleting a product in the system
    public void delete_Product() {

        System.out.println("|======================================================================|");
        System.out.println("|                            Delete a product                          |");
        System.out.println("|======================================================================|");
        System.out.println();
        System.out.println("|                             1) Electronics                           |");
        System.out.println("|                             2) Clothing                              |");
        System.out.println("|                             3) Back                                  |");
        System.out.println();
        System.out.println("|======================================================================|");
        System.out.println();
        System.out.println("\nEnter your option : ");
        int choice = scanner.nextInt();
        System.out.println();
        switch (choice) {
            case 1: {
                delete_Electronics();
            }
            case 2: {
                delete_Clothing();
            }
            case 3: {
                mainMenu();
                break;
            }
            default:
                System.out.println("Invalid Choice...");
                delete_Product();
        }
    }

    //Deleting an electronic product in the system
    private void delete_Electronics() {
        System.out.println("Enter the  product ID :");
        String id = scanner.next();
        for (int i = 0; i < electronics.size(); i++) { //Getting the product from electronics array

            if (id.equals(electronics.get(i).getProduct_ID())) {
                System.out.println("|======================================================================|");
                System.out.println("|                   Details of Removed Product                         |");
                System.out.println("|======================================================================|");
                System.out.println("Product Type       : Electronics");
                System.out.println("Product ID         :" + electronics.get(i).getProduct_ID());
                System.out.println("Name               :" + electronics.get(i).getProduct_Name());
                System.out.println("Available No       :" + electronics.get(i).getAvailableNo());
                System.out.println("Price              :" + electronics.get(i).getProductPrice());
                System.out.println("Brand              :" + electronics.get(i).getBrand());
                System.out.println("Warranty           :" + electronics.get(i).getWarranty());

                electronics.remove(i);

                for (int x = 0; x < Product_Array.size(); x++) {
                    if (id.equals(Product_Array.get(x).getProduct_ID())) {
                        Product_Array.remove(x);
                    }
                }
                System.out.println("Product Removed sucessfully");
                System.out.println();
                System.out.println(Product_Array.size() + "Products left in the system");
                System.out.println(electronics.size() + "Electronic Products left in the system");

                delete_Product();
            }//Getting the details of the relevant product in the array

        }

    }

    //Deleting a clothing product in the system
    private void delete_Clothing() {
        System.out.println("Enter the  product ID :");
        String id = scanner.next();
        for (int i = 0; i < clothing.size(); i++) { //Getting the product from electronics array

            if (id.equals(clothing.get(i).getProduct_ID())) {
                System.out.println("|======================================================================|");
                System.out.println("|                   Details of Removed Product                         |");
                System.out.println("|======================================================================|");
                System.out.println("Product Type       : Clothing");
                System.out.println("Product ID         :" + clothing.get(i).getProduct_ID());
                System.out.println("Name               :" + clothing.get(i).getProduct_Name());
                System.out.println("Available No       :" + clothing.get(i).getAvailableNo());
                System.out.println("Price              :" + clothing.get(i).getProductPrice());
                System.out.println("Size               :" + clothing.get(i).getClothSize());
                System.out.println("Color              :" + clothing.get(i).getClothColor());

                clothing.remove(i);

                for (int x = 0; x < Product_Array.size(); x++) {
                    if (id.equals(Product_Array.get(x).getProduct_ID())) {
                        Product_Array.remove(x);

                    }
                }
                System.out.println("Product Removed sucessfully");
                System.out.println();
                System.out.println(Product_Array.size() + "Products left in the system");
                System.out.println(clothing.size() + "Clothing Products left in the system");

                delete_Product();
            }//Getting the details of the relevant product in the array
        }
    }

    //printing all the list of products with all the information
    @Override
    public void print_Product_list() {
        System.out.println("Electronics :" + electronics.size());
        System.out.println("Clothing :" + clothing.size());
        System.out.println("Product :" + Product_Array.size());

        System.out.println("|======================================================================|");
        System.out.println("|                                Product List                          |");
        System.out.println("|======================================================================|");

        for (int x = 0; x < clothing.size(); x++) {
            System.out.println("Product Type       : Clothing");
            System.out.println("Product ID         :" + clothing.get(x).getProduct_ID());
            System.out.println("Name               :" + clothing.get(x).getProduct_Name());
            System.out.println("Available No       :" + clothing.get(x).getAvailableNo());
            System.out.println("Price              :" + clothing.get(x).getProductPrice());
            System.out.println("Size               :" + clothing.get(x).getClothSize());
            System.out.println("Color              :" + clothing.get(x).getClothColor());
            System.out.println();
            System.out.println();
        }

        for (int i = 0; i < electronics.size(); i++) {
            System.out.println("Product Type       : Electronics");
            System.out.println("Product ID         :" + electronics.get(i).getProduct_ID());
            System.out.println("Name               :" + electronics.get(i).getProduct_Name());
            System.out.println("Available No       :" + electronics.get(i).getAvailableNo());
            System.out.println("Price              :" + electronics.get(i).getProductPrice());
            System.out.println("Brand              :" + electronics.get(i).getBrand());
            System.out.println("Warranty           :" + electronics.get(i).getWarranty());
            System.out.println();
            System.out.println();
        }
    }


    @Override
    //Saving all the products to a text file
    public void saveFile() {
        try {
            BufferedWriter TextFile=new BufferedWriter(new FileWriter("Product List.txt"));
            for(Product product : Product_Array){
                TextFile.write(product.getProduct_ID() + "\n" + product.getProduct_Name() + "\n" + product.getAvailableNo() + "\n" + product.getProductPrice() + "\n");

            }
            System.out.println("Successfully saved data to the file...");
            TextFile.close();
        } catch (IOException e) {
            System.out.println("Error....");
        }


    }
  /*  public void loadFile(){
        try{String LDdetails;
            ArrayList<String> LDarray = new ArrayList<>();
            BufferedReader temp = new BufferedReader(new FileReader("Product List.txt"));
            while ((LDdetails = temp.readLine()) != null) {
                if (LDdetails.equals("")) {
                    continue;
                }else {
                    LDarray.add(LDdetails);
                }
            }
            for (int x = 0; x <= (LDarray.size() / 6); x++) {
                if (Product_Array.size() == 0) {
                    Product_Array.add(LDarray.get(0));
                    LDarray.subList(0, 6).clear();
                }else {
                    if (Product_Array.size() <= 50) {
                        boolean read = true;
                        for (int y = 0; y <= (LDarray.size() / 6); y++) {
                            for (Product product : Product_Array) {
                                if (product.getProduct_ID().equals(LDarray.get(4))) {
                                    read = false;
                                    LDarray.subList(0, 6).clear();
                                }else {
                                    read = true;
                                }
                            }
                        }

            }
            System.out.println("Data Loaded Successfully....");
            temp.close();
        }catch (IOException e) {
            System.out.println("No Data Found....");
        }

        }
*/
    }









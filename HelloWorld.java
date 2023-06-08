/*
Name: Shivam Kumar
College: Meerut Institute of Engineering and Technology
Year of passing: 2023
Phone Number: 7009035854
email: shivam70090@gmail.com
*/

import java.util.*;

//shopping class
class Shopping{
    private String productName;
    private int price;
    private int gst;
    private int quantity;
    
    //constructor
    public Shopping(String productName, int price, int gst, int quantity) {
        this.productName = productName;
        this.price = price;
        this.gst = gst;
        this.quantity = quantity;
    }
    public Shopping() {
    }
    
    //tostring method
    public String toString(){
        return  "ProductName='" + productName + '\'' +
                ", price=" + price +
                ", gst=" + gst +
                ", quantity=" + quantity;
    }
        
    //getter setter
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getGst() {
        return gst;
    }

    public void setGst(int gst) {
        this.gst = gst;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}


class HelloWorld {
    
  
    public static double totalAmount(ArrayList<Shopping> cart){
        double amount=0;
        
        for(Shopping item : cart){
            
            //check if product have discount
            double discount = 0;
            if(item.getPrice() >= 500){
                discount = 0.05;
            }
            
            //calculate amount with discount
            double currentAmount = (item.getPrice() - (item.getPrice() * discount) ) * item.getQuantity();
            
            currentAmount = currentAmount + (currentAmount * item.getGst() / 100);
            
            // System.out.println(currentAmount);
            
            amount += currentAmount;
        }
        
        return amount;
        
    }
  
  
    
    public static String maxGstProduct(ArrayList<Shopping> cart){
        
        Shopping maxGstItem = new Shopping();
        double maxGstAmount = 0;
        
        for(Shopping item : cart){
            
            //check if product have discount
            double discount = 0;
            if(item.getPrice() >= 500){
                discount = 0.05;
            }
            
            //calculate amount with gst
            double currentGstAmount = (item.getGst() * (item.getPrice() - (item.getPrice() * discount)) * item.getQuantity())/100;
            
            
            if(maxGstAmount < currentGstAmount){
                maxGstAmount = currentGstAmount;
                maxGstItem = item;
            }
        }
        return "Item is: " + maxGstItem +" Gst Amount is: "+maxGstAmount;
        
    }
    
  
  
  
    public static void main(String[] args) {
        
        Shopping item1 = new Shopping("Leather Wallet",1100,18,1);
        Shopping item2 = new Shopping("Umbrella",900,12,4);
        Shopping item3 = new Shopping("Cigarette",200,28,3);
        Shopping item4 = new Shopping("Honey",100,0,2);
        
        ArrayList<Shopping> cart= new ArrayList<>();
        
        cart.add(item1);
        cart.add(item2);
        cart.add(item3);
        cart.add(item4);
        
        String maxGstItem = maxGstProduct(cart);
        
        System.out.println(maxGstItem);
        
        double totalAmount = totalAmount(cart);
        
        System.out.println("Net total Amount to be Paid = " + totalAmount);
    }
}

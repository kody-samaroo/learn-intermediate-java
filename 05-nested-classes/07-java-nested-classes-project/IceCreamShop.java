import java.util.Scanner;

class ShopItems {
  int totalCount;

  class Vegan {
    int smoothieCount;
    int slushieCount;
    int totalCount;

    public void increaseCount(int type, int count){
      if(type == 3) {
        smoothieCount += count;
        ShopItem.this.totalCount += count;
      } else if (type == 4) {
        slushieCount += count;
        ShopItems.this.totalCount += count;
      } else {
        System.out.println("The type input was incorrect.");
      }
    }
  }

 class NonVegan {
    int iceCreamCount;
    int shakeCount;
    int totalCount;
    
    public void increaseCount(int type, int count){
      if(type == 1) {
        iceCreamCount += count;
        ShopItems.this.totalCount += count;
      } else if (type == 2){
        shakeCount += count;
        ShopItems.this.totalCount += count;
      } else {
        System.out.println("The type input was incorrect.");
      }
    }
  }
}

public class IceCreamShop {

  public static void main(String[] args) {
    int orderType = 0;
    Scanner input = new Scanner(System.in);
    int itemCount = 0;
    String itemName;

    System.out.println("Hello! Welcome to the ice cream shop. We are ready to take your order. For ice-cream type 1, for shakes type 2, for smoothies type 3, and for slushies type 4. If you are done ordering type 0.");
    orderType = input.nextInt();

    while(orderType != 0) {
      System.out.println("How many items of this item would you like to order?");
      itemCount = input.nextInt();
      if(orderType == 1){
        itemName = "ice cream";
      } else if(orderType == 2) {
        itemName = "shake";
      } else if(orderType == 3) {
        itemName = "smoothie";
      } else if(orderType == 4) {
        itemName = "slushie";
      } else {
        break;
      }

      System.out.println("Adding " + itemCount + " of the item "+ itemName + " to your order!");

      System.out.println("Type a number for the next item in your order:\n1: Ice cream\n2: Shake\n3: Smoothie\n4: Slushie\n");
      orderType = input.nextInt();
    }
  }
}
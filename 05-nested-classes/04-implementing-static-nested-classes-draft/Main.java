class VendingMachine{
  
    static class ChocolateBar {
      public String getName(){
        return "Milky Way";
      };
      public double getPrice(){
        return 2.99;
      }
    }
  
    static class BagOfChips {
      public String getName(){
        return "Pringles";
      };
      public double getPrice(){
        return 1.99;
      }
    }
  }
  
  public class Main{
    public static void main(String[] args){
      VendingMachine.ChocolateBar mikesChocolateBar = new VendingMachine.ChocolateBar();
      VendingMachine.BagOfChips gabbysBagOfChips = new VendingMachine.BagOfChips();
  
      System.out.println("Mike's "+mikesChocolateBar.getName()+" chocolate bar costs "+mikesChocolateBar.getPrice());
      System.out.println("Gabby's "+gabbysBagOfChips.getName()+" bag of chips costs "+gabbysBagOfChips.getPrice());
    };
  }
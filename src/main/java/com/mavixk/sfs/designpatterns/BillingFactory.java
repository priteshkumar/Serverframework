package com.mavixk.sfs.designpatterns;

public class BillingFactory {

  static interface Bill {

    void getBill();
  }

  static class AirFreightBill implements Bill {

    private int amount;

    public AirFreightBill(int amount) {
      this.amount = amount;
    }

    public void getBill() {
      System.out.println("this is air freight bill");
    }
  }

  static class SeaFreightBill implements Bill {

    private int amount;

    public SeaFreightBill(int amount) {
      this.amount = amount;
    }

    public void getBill() {
      System.out.println("this is sea freight bill");
    }
  }

  static class Factory {

    public static Bill getBill(String billType) {
      Bill bill = null;
      switch (billType) {
        case "air":
          bill = new AirFreightBill(20);
          break;
        case "sea":
          bill = new SeaFreightBill(30);
          break;
        default:
          System.out.println("no matching bill type");
      }
      return bill;
    }
  }

  public static void main(String[] args) {
    System.out.println(System.getProperty("os.name"));
    Bill bill = Factory.getBill("air");
    bill.getBill();
    bill = Factory.getBill("sea");
    bill.getBill();
  }
}

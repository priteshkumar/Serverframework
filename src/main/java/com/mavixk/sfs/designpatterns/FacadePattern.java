package com.mavixk.sfs;

public class FacadePattern {
  static class TravelPackage{
    public void bookFlightickets(){
      System.out.println("book flight tickets");
    }

    public void bookHotelStay(){
      System.out.println("book hotel stay");
    }

    public void bookSightseeing(){
      System.out.println("book sight seeing");
    }
  }

  /**
   * this class acts as a facade to TravelPackage class
   * it provides a single bookTravel() function to
   * arrange all travel things.
   * acts as a high level interface to user for getting travel package.
   */
  static class TravelAgent {

    private TravelPackage travelPkg;

    public TravelAgent() {
      this.travelPkg = new TravelPackage();
    }

    public void bookTravel() {
      this.travelPkg.bookFlightickets();
      this.travelPkg.bookHotelStay();
      this.travelPkg.bookSightseeing();
    }
  }

  public static void main(String[] args){
    TravelAgent agent = new TravelAgent();
    agent.bookTravel();
  }
}

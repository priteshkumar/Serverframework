package com.mavixk.sfs.designpatterns;
import java.util.*;

public class FlipKartNotify {

  /**
   * Product extends java.util.Observable builtin
   * implements addObserver,deleteObserver,notifyObservers methods
   */
  static class Product extends Observable{
    private String name;
    private String type;
    private boolean availability;
    private ArrayList<Observer> observers = new ArrayList<>();

    public Product(String name,String type,boolean availability){
      this.name = name;
      this.type = type;
      this.availability = availability;
    }

    public void setAvailability(boolean availability){
      if(this.availability == false && availability == true){
        this.availability = availability;
        setChanged();
        notifyObservers(availability);
      }
    }

    public void addObserver(Observer observer){
      this.observers.add(observer);
    }

    public void deleteObserver(Observer observer){
      observers.remove(observer);
    }

    public void notifyObservers(boolean availability){
      if(hasChanged()){
        for(Observer observer:observers){
          observer.update(this,availability);
        }
        clearChanged();
      }
    }
  }

  static class Customer implements Observer{
    private String name;
    private String cid;

    public Customer(String name,String cid){
      this.name = name;
      this.cid = cid;
    }

    @Override
    public void update(Observable o, Object arg) {
      System.out.println("Hey " + name + " product is available");
    }
  }

  public static void main(String[] args){
    Product product = new Product("Samsung Galaxy10","SmartPhone",false);
    Customer customer1 = new Customer("Mavixk","1023");
    Customer customer2 = new Customer("Casper","1024");
    product.addObserver(customer1);
    product.addObserver(customer2);
    product.setAvailability(true);
  }
}

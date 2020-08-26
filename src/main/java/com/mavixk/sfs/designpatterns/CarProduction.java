package com.mavixk.sfs.designpatterns;

public class CarProduction {
  static interface Builder{
    void setType(Type type);
    void setSeats(int seats);
    void setEngine(String engine);
  }

  static enum Type{
    CITY_CAR,SPORTS_CAR,SUV
  }

  static class CarBuilder implements Builder{
    private Type type;
    private int seats;
    private String engine;

    @Override
    public void setType(Type type) {
      this.type = type;
    }

    @Override
    public void setSeats(int seats) {
      this.seats = seats;
    }

    @Override
    public void setEngine(String engine) {
      this.engine = engine;
    }

    public Car build(){
      return new Car(this.type,this.seats,this.engine);
    }
  }

  static class Car{
    private Type type;
    private int seats;
    private String engine;
    public Car(Type type,int seats,String engine){
      this.type = type;
      this.seats = seats;
      this.engine = engine;
    }

    public void displayStats(){
      System.out.println("Car type: " + this.type + "\n" + "Car engine: " + this.engine);
    }
  }

  static class Director{
    public void buildSportsCar(Builder builder){
      builder.setType(Type.SPORTS_CAR);
      builder.setSeats(2);
      builder.setEngine("Sports");
    }

    public void buildCityCar(Builder builder){
      builder.setType(Type.CITY_CAR);
      builder.setSeats(4);
      builder.setEngine("Sedan");
    }
  }

  public static void main(String[] args){
    Director director = new Director();
    CarBuilder builder = new CarBuilder();
    director.buildSportsCar(builder);
    Car car = builder.build();
    car.displayStats();
  }

}

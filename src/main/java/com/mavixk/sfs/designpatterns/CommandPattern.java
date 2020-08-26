package com.mavixk.sfs.designpatterns;

import java.util.HashMap;

public class CommandPattern {

  /**
   * Receiver object: executes action needed by command
   */
  static class Light{
    private static Light lightObj;
    private Light(){}

    public static Light getInstance(){
      if(lightObj == null)
        lightObj = new Light();
      return lightObj;
    }

    public void turnRed(){
      System.out.println("turn on red light");
    }

    public void turnYellow(){
      System.out.println("turn on yellow light");
    }

    public void turnGreen(){
      System.out.println("turn on green light");
    }
  }

  /**
   * generic command interface
   */
  static interface Command{
    void execute();
  }

  /**
   * Command object : encapsulates turnGreen command
   * holds Light object
   */
  static class GreenLight implements Command{
    private Light light;
    public GreenLight(Light light){
      this.light = light;
    }

    public void execute(){
      this.light.turnGreen();
    }
  }

  /**
   * Command object: encapsulates turnYellow command
   */
  static class YellowLight implements Command{
    private Light light;
    public YellowLight(Light light){
      this.light = light;
    }

    public void execute(){
      this.light.turnYellow();
    }
  }

  /**
   * Command object: encapsulates turnRed command
   */
  static class RedLight implements Command{
    private Light light;
    public RedLight(Light light){
      this.light = light;
    }

    public void execute(){
      this.light.turnRed();
    }
  }

  /**
   * Invoker object
   * instructs command object to act
   */
  static class Invoker{
    public void submit(Command command){
      command.execute();
    }
  }

  /**
   * Client object: holds invoker object and command objects
   * communicates with receiver object
   */
  static class Client{
    private Invoker invoker;
    private HashMap<String,Command> cmdMap;
    private Light lightObj;
    public Client(){
      this.invoker = new Invoker();
      this.cmdMap = new HashMap<>();
      this.lightObj = Light.getInstance();
      cmdMap.put("green",new GreenLight(this.lightObj));
      cmdMap.put("yellow",new YellowLight(this.lightObj));
      cmdMap.put("red",new RedLight(this.lightObj));
    }

    public void runCommand(String cmd){
      Command command = this.cmdMap.get(cmd);
      if(command != null)
        this.invoker.submit(command);
      else
        System.out.println("invalid command");
    }
  }

  public static void main(String[] args){
    Client client = new Client();
    client.runCommand("green");
    client.runCommand("yellow");
    client.runCommand("blue");
  }
}

package com.mavixk.sfs;

import java.util.ArrayList;

public class ObserverPattern {
  static abstract class Observer{
    protected Subject subject;
    public abstract void update();
  }

  /**
   * Observer class: gets notified by Subject class
   * observer can be registered client with subject
   * e.g. user email in jenkins build complete
    */
  static class Message extends Observer{
    private Subject subject;
    public Message(Subject subject){
      this.subject = subject;
      this.subject.add(this);
    }

    public void update(){
      System.out.println("messages received..");
    }
  }

  /**
   * Subject class : tracks changes in state of subject
   * e.g. : jenkins build completion state
   * phone message status change
   */
  static class Subject{
    private ArrayList<Observer> observers;
    private int state;
    public Subject(){
      this.observers = new ArrayList<>();
      this.state = 0;
    }

    public void add(Observer observer){
      this.observers.add(observer);
    }

    public int getState(){
      return this.state;
    }

    public void setState(int value){
      this.state = value;
      notifyClients();
    }

    public void notifyClients(){
      for(Observer observer:observers){
        observer.update();
      }
    }
  }

  public static void main(String[] args){
    Subject subject = new Subject();
    Message msg = new Message(subject);
    subject.setState(100);
  }

}

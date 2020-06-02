package com.mavixk.sfs.designpatterns.factory;

import java.util.ArrayList;

public abstract class Website {
  protected ArrayList<WebPage> pages = new ArrayList<>();

  public Website(){
    this.createWebsite();
  }

  public ArrayList<WebPage> getPages(){
    return this.pages;
  }

  public abstract void createWebsite();
}

package com.mavixk.sfs.designpatterns.factory;

public class Shop extends Website{

  @Override
  public void createWebsite() {
    this.pages.add(new CartPage());
  }
}

package com.mavixk.sfs.designpatterns.factory;

public class Blog extends Website{

  @Override
  public void createWebsite() {
    this.pages.add(new PostPage());
    this.pages.add(new AboutPage());
    this.pages.add(new ContactPage());
  }
}

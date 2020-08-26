package com.mavixk.sfs.designpatterns.factory;

class WebsiteFactory {
  public static Website getWebsite(WebsiteType type){
    switch(type){
      case BLOG : return new Blog();
      case SHOP : return new Shop();
      default:return null;
    }
  }
}

public class TestWebSiteFactory{
  public static void main(String[] args){
   Website website = WebsiteFactory.getWebsite(WebsiteType.BLOG);
   System.out.println(website.getPages());
  }
}
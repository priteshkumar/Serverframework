package com.mavixk.sfs;
import java.util.*;

public class JavaObserverDemo {
  static class NewsAgency extends Observable{
    private String news;

    public void setNews(String news){
      this.news = news;
      setChanged();
      notifyObservers(this.news);
    }
  }

  static class NewsChannel implements Observer{
    @Override
    public void update(Observable o, Object arg) {
      System.out.println(arg);
    }
  }

  public static void main(String[] args){
    NewsAgency newsagency = new NewsAgency();
    Observer observer = new NewsChannel();
    newsagency.addObserver(observer);
    newsagency.setNews("code java");
  }
}

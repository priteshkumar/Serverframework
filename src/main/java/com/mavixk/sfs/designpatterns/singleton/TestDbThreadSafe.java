package com.mavixk.sfs.designpatterns.singleton;

public class TestDbThreadSafe {

  static class Thread1 implements Runnable {

    @Override
    public void run() {
      DbThreadSafe dbS = DbThreadSafe.getDbConnection();
      System.out.println(dbS);
    }
  }

  static class Thread2 implements Runnable {

    @Override
    public void run() {
      DbThreadSafe dbS = DbThreadSafe.getDbConnection();
      System.out.println(dbS);
    }
  }

  public static void main(String[] args) {
    Thread t1 = new Thread(new Thread1());
    Thread t2 = new Thread(new Thread2());
    t1.start();
    t2.start();
  }
}

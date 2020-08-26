package com.mavixk.sfs.designpatterns.observer;

import java.util.Observable;
import java.util.Observer;

public class GitPush {

  static class GitPushNotifier extends Observable {

    public void gitpushEvent(String commit) {
      setChanged();
      notifyObservers(commit);
    }
  }

  static abstract class CiTool {

    private static GitPushNotifier gitPushNotifier;

    public abstract void runBuildJob(String commit);
  }

  static class Jenkins extends CiTool implements Observer{

    @Override
    public void runBuildJob(String commit) {
      System.out.println("starting build on commit " + commit);
    }

    @Override
    public void update(Observable o, Object arg) {
      runBuildJob((String) arg);
    }
  }

  public static void main(String[] args) {
    GitPushNotifier gitPushNotifier = new GitPushNotifier();
    Jenkins ci = new Jenkins();
    gitPushNotifier.addObserver(ci);
    gitPushNotifier.gitpushEvent("19b5603");
  }
}

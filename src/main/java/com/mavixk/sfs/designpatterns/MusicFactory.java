package com.mavixk.sfs.designpatterns;

interface IMusic {

  void playMusic();
}

class RockMusic implements IMusic {

  public void playMusic() {
    System.out.println("play rock music");
  }
}

class TranceMusic implements IMusic {

  public void playMusic() {
    System.out.println("play trance music");
  }
}

/**
 * Factory pattern example
 * a single interface is provided to user
 * user uses commands exposed by factory interface to create genre objects
 * user is unaware of actual creation of genre objects
 */
public class MusicFactory {

  public static IMusic getMusic(String genre) {
    IMusic music = null;
    switch (genre) {
      case "rock":
        music = new RockMusic();
        break;
      case "trance":
        music = new TranceMusic();
        break;
      default:
        System.out.println("no matched genre");
    }
    return music;
  }

  public static void main(String[] args) {
    IMusic music = MusicFactory.getMusic("rock");
    music.playMusic();
  }
}
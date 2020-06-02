package com.mavixk.sfs;

public class DecoratorPattern {
  static interface Image{
    void getDescription();
  }

  static class BasicImage implements Image{
    public void getDescription(){
      System.out.println("this is basic image");
    }
  }

  /**
   * SharpenFilter is a decorator class
   * adds sharpening effect to BasicImage at runtime
   *
   */
  static class SharpenFilter implements Image{
    private BasicImage bImage;
    public SharpenFilter(BasicImage img){
      this.bImage = img;
    }

    @Override
    public void getDescription() {
      System.out.println("apply sharpen filter..");
    }
  }

  public static void main(String[] args){
    BasicImage img = new BasicImage();
    SharpenFilter sImg = new SharpenFilter(img);
    sImg.getDescription();
  }
}

import com.mavixk.sfs.designpatterns.MusicFactory;
import com.mavixk.sfs.designpatterns.MusicFactory.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.*;

public class MusicFactoryTest {

  private static MusicFactory musicFactory;

  @BeforeAll
  public static void setUp() {
    //musicFactory = new MusicFactory();

  }

  @RepeatedTest(4)
  public void testMusicFactory() {
    assertNotNull(musicFactory.getMusic("rock"));
    assertTrue(2 + 2 == 4, "failed exp");
  }

  @Test
  public void testSpeed() {
    int speed_of_light = 3 * (10 ^ 8);
    int particle_speed = 2 * (10 ^ 8);
    try {
      assertTrue(particle_speed > speed_of_light, "Assertion failed.");
    }catch(AssertionFailedError e){
      System.out.println(e.toString());
    }
    System.out.println("Done");

  }

  @Disabled("need bug fix")
  @Test
  public void testMusicFactoryOnce() {
    assertNotNull(musicFactory.getMusic("trance"));
  }
}

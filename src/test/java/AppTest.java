import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Triangle finder");
  }

  @Test
  public void isEntering(){
    goTo("http://localhost:4567/");
    fill("#side_1").with("2");
    fill("#side_2").with("2");
    fill("#side_3").with("2");
    submit(".btn");
    assertThat(pageSource()).contains("Your Triangle is Equilateral");

  }
}

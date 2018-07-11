package se.su.it.logging;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
class Lanterman extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(Lanterman.class);
  }

  @RequestMapping("/")
  String home() {
    return "My log hears things I cannot hear. But my log tells me about the sounds, about the new words. Even though it has stopped growing larger, my log is aware.\n";
  }

  public static void main(String[] args) throws Exception {
    SpringApplication.run(Lanterman.class, args);
  }
}

package se.su.it.logging;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.*;
import java.beans.Statement;

@RestController
@SpringBootApplication
public class Lanterman extends SpringBootServletInitializer {

  private static final java.util.logging.Logger JUL = java.util.logging.Logger.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
  private static final org.apache.commons.logging.Log JCL = org.apache.commons.logging.LogFactory.getLog(Thread.currentThread().getStackTrace()[1].getClassName());
  private static final org.apache.logging.log4j.Logger log4j2 = org.apache.logging.log4j.LogManager.getLogger();
  private static final org.apache.log4j.Logger log4j = org.apache.log4j.Logger.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
  private static final org.slf4j.Logger slf4j = org.slf4j.LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(Lanterman.class);
  }

  @RequestMapping("/")
  String home() throws Exception {
    Object[] loggers = {
      JUL,
      JCL,
      log4j2,
      log4j,
      slf4j,
    };
    for (Object logger : loggers) {
      String[] messages = {"Hello from " + logger.getClass().getName()};
      new Statement(logger, "info", messages).execute();
    }
    System.out.println("Hello from STDOUT");
    System.err.println("Hello from STDERR");
    return "My log hears things I cannot hear. But my log tells me about the sounds, about the new words. Even though it has stopped growing larger, my log is aware.\n";
  }

  public static void main(String[] args) throws Exception {
    SpringApplication.run(Lanterman.class, args);
  }
}

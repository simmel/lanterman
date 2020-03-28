package se.su.it.logging;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.*;
import java.beans.Statement;
import java.util.HashMap;
import java.util.Map;

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
    Map<Object, String[]> loggers = new HashMap<>();
    loggers.put(JUL, new String[] {"finest", "finer", "config", "info", "warning", "severe"});
    loggers.put(JCL, new String[] {"trace", "debug", "info", "warn", "error", "fatal"});
    loggers.put(log4j2, new String[] {"trace", "debug", "info", "warn", "error", "fatal"});
    loggers.put(log4j, new String[] {"trace", "debug", "info", "warn", "error", "fatal"});
    loggers.put(slf4j, new String[] {"trace", "debug", "info", "warn", "error"});

    for (Map.Entry<Object, String[]> entry : loggers.entrySet()) {
      Object logger = entry.getKey();
      String[] levels = entry.getValue();
      String[] messages = {"Hello from " + logger.getClass().getName()};
      for (String level : levels) {
        new Statement(logger, level, messages).execute();
      }
    }
    System.out.println("Hello from STDOUT");
    System.err.println("Hello from STDERR");
    return "My log hears things I cannot hear. But my log tells me about the sounds, about the new words. Even though it has stopped growing larger, my log is aware.\n";
  }

  public static void main(String[] args) throws Exception {
    SpringApplication.run(Lanterman.class, args);
  }
}

package se.su.it.logging.lanterman;
import java.beans.Statement;
import java.util.HashMap;
import java.util.Map;

public class Lanterman {

  private static final java.util.logging.Logger JUL = java.util.logging.Logger.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
  private static final org.apache.commons.logging.Log JCL = org.apache.commons.logging.LogFactory.getLog(Thread.currentThread().getStackTrace()[1].getClassName());
  private static final org.apache.logging.log4j.Logger log4j2 = org.apache.logging.log4j.LogManager.getLogger();
  private static final org.apache.log4j.Logger log4j = org.apache.log4j.Logger.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
  private static final org.slf4j.Logger slf4j = org.slf4j.LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

  static String tellMeAboutTheSounds() throws Exception {
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
      try {
        throw new RuntimeException("Hello RuntimeException from " + logger.getClass().getName());
      }
      catch(Exception ex) {
        // JUL "level methods" doesn't accept Exception objects.
        if (logger instanceof java.util.logging.Logger) {
          new Statement(logger, "log", new Object[] {java.util.logging.Level.SEVERE, "Exception from " + logger.getClass().getName(), ex}).execute();
        }
        else {
          new Statement(logger, levels[levels.length-1], new Object[] {"Exception from " + logger.getClass().getName(), ex}).execute();
        }
      }
    }
    System.out.println("Hello from STDOUT");
    System.err.println("Hello from STDERR");
    return "My log hears things I cannot hear. But my log tells me about the sounds, about the new words. Even though it has stopped growing larger, my log is aware.\n";
  }
}

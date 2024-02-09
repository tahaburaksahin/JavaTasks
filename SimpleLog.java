// GLK-SimpleLog/SimpleLog.java
 
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.logging.Handler;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;
import java.util.logging.Logger;
import java.util.logging.Level;

public class SimpleLog {
    private static Logger logger   = null;
    private static Handler handler = null;

    public static void main(String[] argv) {
        logger  = Logger.getLogger("SimpleLog");
        try {
              // if 'true' (default), parent loggers
              // will also log messages to their handlers
              // (e.g., connected to the console).
              // Parent (which goes to the console) will
              // only print WARNING and higher
            logger.setUseParentHandlers(true);
            logger.getParent().setLevel(Level.WARNING);
            logger.getParent().getHandlers()[0].
                               setLevel(Level.WARNING);

            handler = new FileHandler("SimpleLog.log");
            handler.setEncoding("UTF-8");
            handler.setFormatter(new SimpleFormatter());
            // or handler.setFormatter(new XMLFormatter());

              // logger and handler will print everything
            logger.setLevel(Level.ALL);
            handler.setLevel(Level.ALL);
            logger.addHandler(handler);
        } catch(IOException e) {
            System.err.println("Handler cannot be open");
            System.exit(1);
        }

        logger.info("Starting the program");

        Reader ir      = null;
        String namBad  = "Nonexistent.log";
        String namGood = "SimpleLog.java";
        try {
            ir = new FileReader(namBad);
            logger.info("Opening " + namBad + ".");
        } catch (FileNotFoundException e) {
            logger.warning(namBad + " not found. " +
                           "Trying " + namGood);
            try {
                ir = new FileReader(namGood);
                logger.info("Opening " + namGood + ".");
            } catch(FileNotFoundException ee) {
                logger.log(Level.SEVERE,
                           namGood + " not found either. " +
                           "Quitting",ee);
                handler.close();
                System.exit(1);
            }
        }

        logger.fine("Executing the program happily");

        logger.info("Closing the file");
        try { if (ir != null) ir.close(); }
        catch(IOException ignore) {       }

        logger.info("Quitting");
        handler.close();
    }
}

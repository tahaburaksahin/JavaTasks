// LSQ-TimeZones/Zones.java
 
import java.util.Date;
import java.util.TimeZone;

public class Zones {
    public static void main(String[] args) {

        String[] allZones = TimeZone.getAvailableIDs();
        for (String s : allZones) System.out.println(s);

        TimeZone ny =
                TimeZone.getTimeZone("America/New_York");
        TimeZone hk =
                TimeZone.getTimeZone("Asia/Hong_Kong");
        long now = new Date().getTime();
        double offNY = ny.getOffset(now)/3600000.0;
        double offHK = hk.getOffset(now)/3600000.0;

        System.out.printf(
            "Time zone 1: %16s offset: %4.1f hours%n"+
            "Time zone 2: %16s offset: %4.1f hours%n",
            ny.getID(),offNY,hk.getID(),offHK
        );
    }
}

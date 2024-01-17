// ACH-SwitchEnum/SwitchEnum.java
// taha burak sahin pjatk

public class SwitchEnum {
    enum Country {FRANCE, GERMANY, MEXICO, CANADA, CHINA};
    public static void main (String[] args) {
        Country c = Country.CANADA;

        var continent = switch(c) {
            case  FRANCE, GERMANY -> "Europe";
            case  MEXICO, CANADA  -> "America";
            case CHINA            -> "Asia";
        };
        System.out.println("Continent: " + continent);
    }
}

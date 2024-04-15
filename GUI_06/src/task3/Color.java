package task3;

public enum Color {

    YELLOW, BLUE, RED, GREEN, ORANGE, VIOLET;

    public static Color mixColors(Color a, Color b) {
        return switch (a.ordinal() + b.ordinal()) {
            case 1 -> Color.GREEN;
            case 2 -> Color.ORANGE;
            case 3 -> Color.VIOLET;
            default -> null;
        };

    }
}

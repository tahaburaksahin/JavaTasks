public abstract class Singer {

    private String name;
    private int id;
    private static int counter;

    public Singer(String name) {
        this.name = name;
        id = ++counter;
    }

    public abstract String sing();

    private static int count(Singer singer){
        int count = 0;
        for(char c : singer.sing().toCharArray())
            if (Character.isUpperCase(c))
                count++;
        return count;
    }

    public static Singer loudest(Singer[] singers){
        Singer loudest = singers[0];

        for (int i = 1; i < singers.length; i++)
            if (count(loudest) < count(singers[i]))
                loudest = singers[i];

        return loudest;
    }

    @Override
    public String toString() {
        return "(" + id + ") " + name + ": " + sing();
    }
}

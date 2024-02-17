// AYE-TryCatchEnum/WhatIsIt.java
 
public class WhatIsIt {

    private EType type;

    private int    argint;
    private double argdouble;
    private String argstring;

    public WhatIsIt(String s) {

        if (s == null) {
            type = EType.N;
            return;
        }

        s = s.trim();

        if (s.equals("")) {
            type = EType.E;
            return;
        }

        try {
            argint = Integer.parseInt(s);
            type = EType.I;
            return;
        } catch (NumberFormatException ignore) { };

        try {
            argdouble = Double.parseDouble(s);
            type = EType.R;
            return;
        } catch (NumberFormatException ignore) { };

        argstring = s;
        type      = EType.S;
    }

    public EType  getType()   { return type; }
    public int    getInt()    {
        if (type == EType.I) return argint;
        throw new UnsupportedOperationException();
    }
    public double getDouble() {
        if (type == EType.R) return argdouble;
        throw new UnsupportedOperationException();
    }
    public String getString() {
        if (type == EType.S) return argstring;
        throw new UnsupportedOperationException();
    }
}

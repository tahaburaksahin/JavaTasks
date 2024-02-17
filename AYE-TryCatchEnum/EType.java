// AYE-TryCatchEnum/EType.java
 
public enum EType {
    I {public String toString() { return "INTEGER";} },
    R {public String toString() { return "DOUBLE"; } },
    S {public String toString() { return "STRING"; } },
    E {public String toString() { return "EMPTY";  } },
    N {public String toString() { return "NULL";   } }
}

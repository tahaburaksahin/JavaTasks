// FUG-AnnotRoles/RoleDataBase.java
 
import java.util.Map;
import java.util.TreeMap;

final public class RoleDataBase {
    final private static Map<String,String>
                roles = new TreeMap<String,String>();
    static {
        roles.put("smith",  "ADMIN");
        roles.put("doe",    "GUEST");
        roles.put("miller", "BOSS");
        roles.put("werner", "USER");
    }

    public static String get(String user) {
        String role = roles.get(user);
        return  role != null ? role : "GUEST";
    }
}

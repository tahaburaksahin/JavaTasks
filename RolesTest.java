// FUG-AnnotRoles/RolesTest.java
 
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class RolesTest {
    public static void main(String[] args) {
        RolesTest rolesTest = new RolesTest();

        rolesTest.methodA();
        rolesTest.methodB(25);
        rolesTest.methodC("Penelope Cruz");
        rolesTest.methodD(25,"Penelope Cruz");
    }

    private boolean checkMethod(String method,
                                Class... args) {
        Method the_method = null;
        try {
            the_method =
                getClass().getMethod(method,args);
        } catch(NoSuchMethodException e) {
            e.printStackTrace();
            System.exit(1);
        }

        String user = System.getProperty("user.name");
        String userRole = RoleDataBase.get(user);

        System.err.println("\nChecking method\n\"" +
               the_method + "\"\nfor user " + user +
                          " with role " + userRole);

        Role annot = the_method.getAnnotation(Role.class);
        if (annot == null) {
            System.err.println("NOT ANNOTATED method");
            return true;
        }
        System.err.println("Annotation for method '" +
                            the_method + "': " + annot);

        String role = annot.role();
        if (userRole.equals(role)) return true;
        return false;
    }

    @Role(role="ADMIN")
    public void methodA() {
        boolean b = checkMethod("methodA",
                                (Class[])null);
        System.err.println("=== MethodA invoked " +
                          (b ? "legally" : "illegally"));
    }

    @Role(role="BOSS")
    public void methodB(int i) {
        boolean b = checkMethod("methodB",
                                int.class);
        System.err.println("=== MethodB invoked " +
                          (b ? "legally" : "illegally"));
        System.out.println("=== arg was " + i);
    }

    @Role(role="USER")
    public void methodC(String s) {
        boolean b = checkMethod("methodC",
                                String.class);
        System.err.println("=== MethodC invoked " +
                          (b ? "legally" : "illegally"));
        System.out.println("=== arg was " + s);
    }

    public void methodD(int i, String s) {
        boolean b = checkMethod("methodD",
                                int.class,String.class);
        System.err.println("=== MethodD invoked " +
                          (b ? "legally" : "illegally"));
        System.out.println("=== args were " + i + " " + s);
    }
}

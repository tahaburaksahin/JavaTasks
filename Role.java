// FUG-AnnotRoles/Role.java
 
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
    Annotation targets
        enumeration constants of enum ElementType
            ANNOTATION_TYPE - annotates other annotation
            PACKAGE
            TYPE - classes and itrefaces
            METHOD
            CONSTRUCTOR
            FIELD
            PARAMETER
            LOCAL_VARIABLE - local variables

    Annotation policies:
        enumeration constants of enum RetentionPolicy
            RetentionPolicy.SOURCE
            RetentionPolicy.CLASS
            RetentionPolicy.RUNTIME
*/
@Target(ElementType.METHOD)         // annotates fields
@Retention(RetentionPolicy.RUNTIME) // seen at run time
public @interface Role {
    String role();
}

// FUB-Annotat/ButProps.java
// taha burak sahin pjatk

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

@Target(ElementType.FIELD)          // annotates fields
@Retention(RetentionPolicy.RUNTIME) // seen at run time
public @interface ButProps {
    int panel();
    int   red() default 255;
    int green() default 255;
    int  blue() default   0;
    String message();
}

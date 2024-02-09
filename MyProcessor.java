// FUI-AnnoProc/MyProcessor.java
 
package myprocessor;

import static javax.lang.model.util.ElementFilter.fieldsIn;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;
import javax.tools.JavaFileObject;

@SupportedAnnotationTypes("myprocessor.MyBean")
@SupportedSourceVersion(SourceVersion.RELEASE_7)

public class MyProcessor extends AbstractProcessor {
    @Override
    public boolean process(
            Set<? extends TypeElement> annotations,
            RoundEnvironment roundEnv) {
        for (TypeElement t : annotations) {
            for (Element e :
                    roundEnv.getElementsAnnotatedWith(t)) {
                ElementKind kind = e.getKind();
                if (e.getKind() != ElementKind.CLASS) {
                    System.err.println(e.getKind() +
                                       " not a class");
                    System.exit(1);
                }
                TypeElement te = (TypeElement)e;
                List<VariableElement> fields =
                        fieldsIn(te.getEnclosedElements());
                String skel =
                        te.getQualifiedName().toString();
                System.out.println("processing " + skel);
                String qname = skel.substring(0,
                                skel.lastIndexOf("Skel"));
                String pck = "";
                String clz = qname;
                if (clz.contains(".")) {
                        pck = clz.substring(0,
                                  clz.lastIndexOf('.'));
                        clz = clz.substring(
                                  clz.lastIndexOf('.')+1);
                }
                System.err.println("Creating file " +
                                    qname + ".java");
                PrintWriter out = null;
                try {
                    // processingEnv is automatically
                    // created at construction by init()
                    // from AbstractProcessor.
                    // Another possibility: createResource
                    // (javax.annotation.processing.Filer).
                    JavaFileObject sourceFile =
                        processingEnv.getFiler().
                        createSourceFile(qname);
                    out = new PrintWriter(sourceFile.
                                          openWriter());
                } catch(IOException exc) {
                    System.err.println(
                            "File could not be created");
                    System.exit(1);
                }
                generateJavaSourceFile(out,pck,clz,fields);
                out.close();
            }
        }
        return true;
    }

    private void generateJavaSourceFile(
            PrintWriter out, String pck, String clz,
            List<VariableElement> fields) {

        out.println("package " + pck + ";\n");
        out.println("public class " + clz + " {");
        for (VariableElement field : fields) {
            TypeMirror fieldType = field.asType();
            String fieldName     = field.toString();
            String fieldTypeName = fieldType.toString();
            String capName       = Character.toUpperCase(
                    fieldName.charAt(0)) + fieldName.
                                           substring(1);
            System.out.println("Processing field: " +
                    fieldTypeName + " " + fieldName + ";");
            out.println("    private " + fieldTypeName +
                    " " + fieldName + ";");
            out.println("    public " + fieldTypeName +
                    " get" +  capName + "() {\n"  +
                    "        return " + fieldName +
                    ";\n    }");
            out.println("    public void set" +  capName +
                    "(" + fieldTypeName + " val) {\n     " +
                    "   " + fieldName + " = val;\n    }\n");
        }
        out.println("}");
    }
}

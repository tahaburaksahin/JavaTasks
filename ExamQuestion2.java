//taha burak sahin pjatk
// Write a recursive function (no loops allowed), which takes an array of “ints”, an integer value
//“val” and an index “from” and returns “true”, if, and only if, there is an element with value “val” in
//the part of the array starting from the element with index “from”
public class ExamQuestion2 {
   public static boolean find(int []a,int val,int from){
       
       if(from>=a.length) {
           return false;
       } else if (a[from]>=a.length) {
           return true;

           
       }else{
           return find(a,val,from+1);
       }
   }
}

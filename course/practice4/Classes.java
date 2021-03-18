package practice4;

public class Classes {
    private String a;

    public void setA(String a){
        this.a = a;
    }

    public void testVar(){
        var t = "TEste";
        System.out.println(t);
    }

    public static void main(String[] args) {
        Classes c = new Classes();
        c.testVar();
        System.out.println(Classes.testStatic());

    }
    

    public static String testStatic(){
        return "AIAIAI";
    }
}

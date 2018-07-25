package Exception.B;

public class B1 extends Exception {

    public B1 () {
        super ("Root Object has to be set explicitly with '@'," +
                " and all objects that remains in the root scope need a alias id");
    }
}

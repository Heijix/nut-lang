package Exception.B;

public class B3 extends Exception {

    public B3 () {
        super ("You cannot add fields in the object, " +
                "because it doesn't exist in the Data Type Definition of the object you want to create");
    }

}

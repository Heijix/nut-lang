import org.junit.*;

public class TestNut{

    @Test
    public void main() {
        Assert.assertEquals("must return 0",Nut.main(new String[0]),0);
    }

}
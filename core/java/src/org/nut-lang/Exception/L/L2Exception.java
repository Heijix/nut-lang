package Exception.L;

public class L2Exception extends Exception {

    public L2Exception() {
        super("Any explicit Unicode Character need to be followed by 4 hexadecimal characters in [0-9] or [a-f] or [A-F]");
    }

}

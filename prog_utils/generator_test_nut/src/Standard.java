public static class Standard{

    /* Ignorable characters */

    public static String ignore_util_nl() {
        return "# ceci est un test commentaire \n";
    }

    /* Miscellaneous simple tokens */

    public static String ascii_char() {
        int charac = random.nextInt(52) + 65;
        if (charac > 90)
            charac += 6;
        return String.valueOf((char) charac);
    }

    public static String zero() {
        return "0";
    }

    public static String digit19() {
        return String.valueOf(random.nextInt(9) + 1);
    }

    public static String _digit() {
        if (random.nextInt(2) == 0)
            return zero();
        return digit19();
    }

    public static String _std_char() {
        if (random.nextInt(2) == 0)
            return ascii_char();
        return _digit();
    }

    /* STRING */

    public static String fourHexNumber() {
        String ret = _digit();
        ret += String.valueOf((char) random.nextInt(6) + 65);
        ret += String.valueOf((char) random.nextInt(6) + 97);
        return ret + _digit();
    }

    public static String _char() {
        switch (random.nextInt(8)) {
        case 0:
            return "\\\\";

        case 1:
            return "\\/";

        case 2:
            return "\\b";

        case 3:
            return "\\f";

        case 4:
            return "\\n";

        case 5:
            return "\\r";

        case 6:
            return "\\t";

        case 7:
            return "\\u" + fourHexNumber();

        default:
            return "";
        }
    }

    public static String unicodeCharactExcept(int execptString) {
        int charac = 0;
        do {
            charac = random.nextInt(maxChar - 32) + 32;
        } while (charac == execptString || charac == backslash_ascii || charac == 127 /* DELET Control */);
        return String.valueOf((char) charac);
    }

    public static String _char_d() {
        switch (random.nextInt(3)) {
        case 0:
            return "\"";

        case 1:
            return _char();

        case 2:
            return unicodeCharactExcept(doubleQuote_ascii);

        default:
            return "";
        }
    }

    public static String _chars_d() {
        if (random.nextInt(2) == 0)
            return "";
        return _char_d() + _chars_d();
    }

    public static String _char_s() {
        switch (random.nextInt(3)) {
        case 0:
            return "\'";

        case 1:
            return _char();

        case 2:
            return unicodeCharactExcept(singleQuote_ascii);

        default:
            return "";
        }
    }

    public static String _chars_s() {
        if (random.nextInt(2) == 0)
            return "";
        return _char_s() + _chars_s();
    }

    public static String string() {
        if (random.nextInt(2) == 0)
            return "\"" + _chars_d() + "\"";
        return "\'" + _chars_s() + "\'";
    }

    /* NAME */

    public static String _std_char_next() {
        if (random.nextInt(2) == 0)
            return "";
        return _std_char() + _std_char_next();
    }

    public static String name() {
        return _std_char() + _std_char_next();
    }

    /* ID ALIAS */

    public static String id_alias_next() {
        if (random.nextInt(2) == 0)
            return "";
        return _std_char() + id_alias_next();
    }

    public static String id_alias() {
        return ascii_char() + id_alias_next();
    }
}
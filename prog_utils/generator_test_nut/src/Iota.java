public class Iota{


    /********** IOTA GRAMMAR ***********/

    public static String import_command() {
        return "Import " + string();
    }

    public static String iota_command() {
        if (random.nextInt(2) == 0)
            return "";
        return import_command() + "\n" + iota_command();
    }


}
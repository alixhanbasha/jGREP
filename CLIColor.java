public class CLIColor {
    
    public static String RED = "", GREEN = "", BLUE = "", YELLOW = "", DEFAULT = "";

    // if the os is unix like, allow terminal colors
    // if os is windows, dont support colors ( needs 3rd party libraries ... )
    public static void getColors(){
        String OS = System.getProperty( "os.name" ).toLowerCase();
        if( 
            OS.indexOf( "nix" ) >= 0 || OS.indexOf( "nux" ) >= 0 || 
            OS.indexOf( "aix" ) >= 0 || OS.indexOf( "mac" ) >= 0 ||
            OS.indexOf( "sunos" ) >= 0 
        ){
            RED   = "\033[0;31m";
            GREEN = "\033[0;32m";
            YELLOW = "\033[0;33m";
            BLUE  = "\033[0;34m";
            DEFAULT = "\033[0m";
        }
    }

    public static String toRed( String str ){ return RED + str + DEFAULT; }
    public static String toGreen( String str ){ return GREEN + str + DEFAULT; }
    public static String toBlue( String str ){ return BLUE + str + DEFAULT; }
    public static String toYellow( String str ){ return YELLOW + str + DEFAULT; }
}

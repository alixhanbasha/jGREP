import java.util.HashMap;
public class Options {
    private static HashMap<String, String> _options_ = new HashMap<>();
    static {
        _options_.put( "pattern", null );
        _options_.put( "text", null );
        _options_.put( "file", null );
        _options_.put( "debug", "false" );
        _options_.put( "case_sensitive", "true" );
    }

    public static String get( String opt ){
        if( _options_.containsKey( opt ) )
            return _options_.get( opt );
        throw new RuntimeException("NO_SUCH_KEY in the options");
    }

    public static void setOption( String key, String val ){
        if( _options_.containsKey( key ) )
            _options_.put( String.valueOf(key), String.valueOf(val) );
    }

    public static void print_dbg( String s ){
        if( Options.get("debug").equals( "true" ) )
            System.out.println( CLIColor.toYellow( "[ dbg ]: " + s ) );
    }
    public static void print_info( String s ){
        System.out.println( CLIColor.toBlue( "[ inf ]: " + s ) );
    }
    public static void print_error( String s ){
        System.out.println( CLIColor.toRed( "[ err ]:" + s ) );
    }
}

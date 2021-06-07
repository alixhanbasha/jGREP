import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ArgumentParser {

    private static void PrintHelp(){
        System.out.println( "▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄" );
        System.out.println( "███▄██░▄▄░██░▄▄▀██░▄▄▄██░▄▄░██" );
        System.out.println( "███░██░█▀▀██░▀▀▄██░▄▄▄██░▀▀░██" );
        System.out.println( "█░▀░██░▀▀▄██░██░██░▀▀▀██░█████" );
        System.out.println( "▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀" );
        System.out.println( "by: https://github.com/alixhanbasha/\n" );
        System.out.println( "\n-d | --debug\t\t\tPrint more information while the program is operating " );
        System.out.println( "-c | --case-insensitive\t\tSearch the source text with case insensitive pattern " );
        System.out.println( "-p | --pattern\t\t\tThe pattern is the text or regex that will be searched in the source text " );
        System.out.println( "-t | --text\t\t\tThe source text will be searched for the pattern or regex. It can be a string !" );
        System.out.println( "-f | --file\t\t\tSelect a file to be read. It then overides the -t option with the file content ( if the file exists ! )" );
        System.out.println( "-h | -? | --help\t\tPrint this screene\n" );
    }

    public static void Parse( String args[] ){
        if( args.length == 0 ){
            PrintHelp();
            System.exit(1);
        }
    
        for( int i=0; i<args.length; i++ ){
            switch( args[i] ){
                case "-d":
                case "--debug":
                    Options.setOption( "debug", "true" );
                    break;

                case "-c":
                case "--case-insensitive":
                    Options.setOption( "case_sensitive", "false" );
                    break;

                case "-p":
                case "--pattern":
                    Options.setOption( "pattern", args[++i] );
                    break;

                case "-t":
                case "--text":
                    Options.setOption( "text", args[++i] );
                    break;

                case "-f":     // file overwrites the -t, since the text inside the file
                case "--file": // is taken, if of course the file exists
                    Options.setOption( "file", args[++i] ); // this will hold the path/filename
                    // read the file, and then setOption text to the file string
                    try {
                        File f = new File( Options.get( "file" ) );
                        if( f.exists() ){
                            FileInputStream fis = new FileInputStream( f );
                            BufferedReader br = new BufferedReader( new InputStreamReader(fis, StandardCharsets.UTF_8) );
                            StringBuilder sb = new StringBuilder(); String l = "";
                            
                            while( (l=br.readLine()) != null)
                                sb.append( l + System.lineSeparator() );

                            Options.setOption( "text", sb.toString() );
                        } else {
                            System.err.println( "No such file exists !" );
                            System.exit(2);
                        }
                    }catch( Exception e ){ e.printStackTrace(); }
                    break;

                case "-h":
                case "-?":
                case "--help":
                    PrintHelp();
                    System.exit(0);
                    break;
                default:
                    System.out.println( "[ " + args[i] + " ] is not an option !\nTry re-runing the program with the -h | --help option" );
                    System.exit(1);
                    break;
            }
        }
    }
}

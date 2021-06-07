public class jGREP {

    public static void main(String args[]) {
        CLIColor.getColors();
        ArgumentParser.Parse( args );
        Options.print_dbg(
            "\n\tPattern: " + CLIColor.toRed( Options.get("pattern") ) + 
            "\n\tText: " + CLIColor.toGreen( Options.get("text") ) + 
            "\n\tCase Sensitive: " + CLIColor.toBlue(Options.get("case_sensitive") ) + "\n" 
        );

        Search search = new Search( Options.get("pattern"), Options.get("text") ) // the main searching API
                        .isCaseSensitive( Boolean.parseBoolean( Options.get("case_sensitive") ) )
                        .setFileName( Options.get( "file" ) );
    
        if( search.startSearch() ) 
            System.out.println( search.getResult() );
        else 
            Options.print_error( "Failed to find pattern !" );
    
    }

}
/* TODO
 *      - Add a counter that reports the amount of times the pattern repeats.
 *      - Refactor and clean the code / Write more comments for future refference
 *      - Enrich the API with better naming, cleaner/clearer code !
 *      - Upload code to github
 *      
 *      
 *      
 *      
 *      - Make a REPL for the fuck of it. ( This REPL can have its own commands amd sub-commands as well as sessions !!!! )
 */

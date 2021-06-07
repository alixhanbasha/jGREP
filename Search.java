import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.HashMap;

class Search {
    private String searchPattern = null;
    private String text = null, fileName = null;

    private Pattern regexPattern = null;
    private Matcher regexMatch = null;
    
    private boolean CASE_SENSITIVE = false;
    public boolean foundMatch = false;

    public Search(){
        this.searchPattern = null;
        this.text = null;
    }

    public Search( String sp, String t ){
        this.searchPattern = sp;
        this.text = t;
    }

    // -------------    OPTIONS    ------------- //
    public Search createPattern( String pattern ){
        this.searchPattern = pattern;
        return this;
    }
    public Search setText( String txt ){
        this.text = txt;
        return this;
    }
    public Search isCaseSensitive( boolean opt ){
        this.CASE_SENSITIVE = opt;
        return this;
    }
    public Search setFileName( String fn ){ this.fileName = fn; return this; }

    // -------------    FUNCTIONALITY    ------------- //
    public boolean startSearch(){
        Utils.Timer timer = new Utils.Timer();
        // FIXME
        //      If searchPattern has regex symbols, the replace functionality adds the symbols to the end result !
        //      So something like "Hello World" with pattern "^Hello", becomes "^Hello World"
        timer.startTime();
        if( this.searchPattern == null ) throw new RuntimeException( "[ error ]: Search object requires a pattern !" );
        if( this.text == null ) throw new RuntimeException( "[ error ]: Search object requires a text to search !" );

        int _caseInsensitive_ = this.CASE_SENSITIVE ? 0 : Pattern.CASE_INSENSITIVE ;
        
        Options.print_dbg( "Searching for -> '" + this.searchPattern + "'" );
        
        regexPattern = Pattern.compile( this.searchPattern , _caseInsensitive_ );
        regexMatch = regexPattern.matcher( this.text );

        if( regexMatch.find() ) {
            String REPLACE = CLIColor.toGreen( this.searchPattern ); // the problematic part, somehow i need to preserve the search, while removing regex symbols !
            this.foundMatch = true;
            this.text = regexMatch.replaceAll( REPLACE ); // replace all the occurances of the pattern, with the green version of itself
        } else this.foundMatch = false;
        
        timer.stopTime(); // gives a report of how long this op took !

        return this.foundMatch;
    }

    public String getResult(){ return this.text; }
}

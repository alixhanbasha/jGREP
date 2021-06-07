public class Utils {
    
    static class Timer {
        private static long currentTime = 0;

        public static void startTime(){
            Options.print_dbg( "Getting current time..." );
            currentTime = System.currentTimeMillis();
            Options.print_dbg( "Current time in milliseconds is set as: " + currentTime );
        }

        public static long stopTime(){
            Options.print_dbg( "Stopping timer..." );
            long newTime = System.currentTimeMillis();
            Options.print_dbg( "Current time in milliseconds is set as: " + newTime );
            Options.print_dbg( "Operation took " + ( newTime - currentTime ) + "ms" );
            currentTime = newTime;
            return currentTime;
        }
    }

}

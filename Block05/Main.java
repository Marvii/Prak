public class Main {
    public static void main(String[] args) {
        String input = "This is a test string for searching things and also this is a thin test string for searching things";
        String search = "thin";
        // START STOPWATCH
        long start = System.currentTimeMillis();
        // RUN BRUTEFORCE
        System.out.println(PatternMatch.bruteForce(input, search, true));
        long finish = System.currentTimeMillis();
        long runtime = finish - start;
        // STOPWATCH EVALUATION
        System.out.println("Runtime in millis for bruteforce: " + runtime);
        
        // RESTART STOPWATCH
        long startKMP = System.currentTimeMillis();
        // RUN KMP
        System.out.println(PatternMatch.kmp(input, search, PatternMatch.prefixAnalysis(input)));
        long finishKMP = System.currentTimeMillis();
        long runtimeKMP = finishKMP - startKMP;
        // STOPWATCH EVALUATION
        System.out.println("Runtime in millis for Knuth-Morris-Pratt: " + runtimeKMP);
        
        
    }
}

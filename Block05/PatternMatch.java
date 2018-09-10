import java.util.ArrayList;

public class PatternMatch {
    
    static ArrayList<Integer> bruteForce(String input, String search, boolean cs) {
        
        ArrayList match = new ArrayList<Integer>();
        
        if (input.contains(search)) {
            if (!cs) {
                input = input.toLowerCase();
                search = search.toLowerCase();
            }
            
            for (int from = 0; from != -1; from++) {
                
                from = input.indexOf(search, from);
                if (from != -1) {
                    match.add(from);
                } else break;
            }
        }
        System.out.println("Number of hits: " + match.size());
        return match;
    }
    
    static int[] prefixAnalysis(String input) {
        int n = input.length();             // set boundaries
        int[] prefTable = new int[n];       // create a prefix table with size of input array
        int i = 0, j = -1;                  // set counters+pointers
        prefTable[i] = j;
        while (i < n - 1) {
            while (j >= 0 && input.charAt(j) != input.charAt(i)) {
                j = prefTable[j];
            }
            i++;
            j++;
            prefTable[i] = j;
        }
        return prefTable;
    }
    
    static ArrayList<Integer> kmp(String input, String search, int[] prefTable) {
        ArrayList match = new ArrayList<Integer>();
        int m = input.length(), n = search.length();             // set boundaries
        int i = 0, j = 0;                                        // set search counters/pointers
        while (i < m) {                                          // check if inside the source string
            while (j >= 0 && input.charAt(i) != search.charAt(j)) {     // check for NOT A MATCH
                j = prefTable[j];                                       // reset pointer inside the prefix table
            }
            i++;                                                 // else if char at [N] matches, go on for [N+1] in source
            j++;                                                 // also go for [N+1] in prefix
            if (j == n) {                                        // check for MATCH
                match.add(i - n);                                // write down the index of match relative to source
                j = prefTable[j - 1];                            // go on with the prefix table
            }
        }
        System.out.println("Number of hits: " + match.size());
        return match;
    }
}


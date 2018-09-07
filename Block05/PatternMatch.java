import java.util.ArrayList;

public class PatternMatch {
    
    static ArrayList<Integer> bruteForce(String input, String search, boolean cs) {
        
        ArrayList match = new ArrayList<Integer>();
        // int i = input.indexOf(search);
        if (input.contains(search)) {
            if (!cs) {
                input = input.toLowerCase();
                search = search.toLowerCase();
            }
            
            for (int from = 0; from != -1; from++) {
                
                from = input.indexOf(search, from);
                if (from != -1) {
                    match.add(from);
                }
                else break;
            }
        }
        System.out.println("Number of hits: " + match.size());
        return match;
    }
    
    
}


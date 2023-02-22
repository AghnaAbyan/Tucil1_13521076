import java.util.ArrayList;
import java.util.List;
import java.util.function.IntBinaryOperator;

class card {
    public static int convertCardToInt(String rank) {
        switch(rank){
            case "A" : return 1; case "2" : return 2; case "3" : return 3; case "4" : return 4; case "5" : return 5; case "6" : return 6; case "7" : return 7;
            case "8" : return 8; case "9" : return 9; case "10": return 10; case "J" : return 11; case "Q" : return 12; case "K" : return 13; default  : return 0;
        }
    }
}

class DuaPuluhEmpat {
    private static final List<IntBinaryOperator> operators = new ArrayList<IntBinaryOperator>();
    private static final List<Character> opnames = new ArrayList<Character>();

    public DuaPuluhEmpat() {
        operators.add((a, b) -> a + b); opnames.add('+');
        operators.add((a, b) -> a - b); opnames.add('-');
        operators.add((a, b) -> a * b); opnames.add('*');
        operators.add((a, b) -> (b != 0 && a % b == 0) ? a / b : Integer.MIN_VALUE); opnames.add('/');
    }

    public List<String> solusi(String[] num) {
        List<Integer> digits = new ArrayList<Integer>();
        digits.add(card.convertCardToInt(num[0]));
        digits.add(card.convertCardToInt(num[1]));
        digits.add(card.convertCardToInt(num[2]));
        digits.add(card.convertCardToInt(num[3]));
        ArrayList<String> solutions = new ArrayList<String>();
        for (int a = 0; a < 4; a++) {
            for (int b = 0; b < 4; b++) {
                for (int c = 0; c < 4; c++) {
                    for (int d = 0; d < 4; d++) {
                        if ((a == b) || (a == c) || (a == d) || (b == c) || (b == d) || (c == d)) {continue;}
                        for (int i = 0; i < 4; i++) {
                            for (int j = 0; j < 4; j++) {
                                for (int k = 0; k < 4; k++) {
                                    if (operators.get(j).applyAsInt(operators.get(i).applyAsInt(digits.get(a), digits.get(b)), operators.get(k).applyAsInt(digits.get(c), digits.get(d))) == 24) {
                                        String sol_str = "(%d %s %d) %s (%d %s %d)";
                                        sol_str = String.format(sol_str, digits.get(a), opnames.get(i), digits.get(b), opnames.get(j), digits.get(c), opnames.get(k), digits.get(d));
                                        solutions.add(sol_str);
                                    }
                                    if (operators.get(k).applyAsInt(operators.get(j).applyAsInt(operators.get(i).applyAsInt(digits.get(a), digits.get(b)), digits.get(c)), digits.get(d)) == 24) {
                                        String sol_str = "((%d %s %d) %s %d) %s %d";
                                        sol_str = String.format(sol_str, digits.get(a), opnames.get(i), digits.get(b), opnames.get(j), digits.get(c), opnames.get(k), digits.get(d));
                                        solutions.add(sol_str);
                                    }
                                    if (operators.get(k).applyAsInt(operators.get(i).applyAsInt(digits.get(a), operators.get(j).applyAsInt(digits.get(b), digits.get(c))), digits.get(d)) == 24) {
                                        String sol_str = "(%d %s (%d %s %d)) %s %d";
                                        sol_str = String.format(sol_str, digits.get(a), opnames.get(i), digits.get(b), opnames.get(j), digits.get(c), opnames.get(k), digits.get(d));
                                        solutions.add(sol_str);
                                    }
                                    if (operators.get(i).applyAsInt(digits.get(a), operators.get(k).applyAsInt(operators.get(j).applyAsInt(digits.get(b), digits.get(c)), digits.get(d))) == 24) {
                                        String sol_str = "%d %s ((%d %s %d) %s %d)";
                                        sol_str = String.format(sol_str, digits.get(a), opnames.get(i), digits.get(b), opnames.get(j), digits.get(c), opnames.get(k), digits.get(d));
                                        solutions.add(sol_str);
                                    }
                                    if (operators.get(i).applyAsInt(digits.get(a), operators.get(j).applyAsInt(digits.get(b), operators.get(k).applyAsInt(digits.get(c), digits.get(d)))) == 24) {
                                        String sol_str = "%d %s (%d %s (%d %s %d))";
                                        sol_str = String.format(sol_str, digits.get(a), opnames.get(i), digits.get(b), opnames.get(j), digits.get(c), opnames.get(k), digits.get(d));
                                        solutions.add(sol_str);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(solutions.size() + " Solutions found");
        if(solutions.size() > 0) {
            for (String solution : solutions) {
                System.out.println(solution);
            }
        } else {System.out.println("No solution found");}
    return solutions;
    }
} 
public class brute {
}
package expressionRefactoring;

@SuppressWarnings("ALL")
public class MessyExpressions {
    /**
     * Returns the sum of 0 + 1 + 2 + 3 + ... + n.
     *
     * YOUR TASK: Remove all unnecessary parentheses.
     */
    public static int sumUpTo(int n) {
        return n * (n + 1) / 2;
    }

    /**
     * Returns true if the given text contains any exclamation points.
     *
     * YOUR TASK:
     *   (1) Do this without the == operator.
     *   (2) Now also do it without any conditionals, and without using the
     *       words “true” or “false” at all in your code.
     */
    public static boolean isEmphatic(String text) {
        return text.contains("!");
    }

    /**
     * If the given text is surrounded with a pair of parentheses, removes them;
     * otherwise leaves the text unchanged.
     *
     * YOUR TASK: Do this without the && operator, using nested conditionals instead.
     */
    public static String trimParentheses(String text) {

        if (!text.isBlank()){
            if (text.charAt(0) == '('){
                if (text.charAt(text.length()-1) == ')'){
                    return text.substring(1, text.length() - 1);
                }
            }

        }
        return text;
    }

    /**
     * Returns true if x is in the range [min...max] (inclusive).
     *
     * YOUR TASK: Do this in one expression, with no “if” statements at all.
     *
     * This is the opposite of the previous exercise. What are the advantages of
     * each style? In what situations would one style be better vs. the other?
     * Discuss with your partner.
     */
    public static boolean isInBounds(int x, int min, int max) {

        return (x >= min && x <= max);
    }

    /**
     * Returns the next element in the Collatz sequence: half of x if x is even,
     * and 3x + 1 if x is odd.
     *
     * YOUR TASK:
     *   (1) This code unnecessarily repeats the modulus operation, which makes
     *       it harder to read — and more brittle. Use an “else” instead.
     *   (2) Now return the result immediately from each branch of the
     *       conditional, which will allow you to remove the “newx” variable.
     */
    public static int nextCollatz(int x) {

        if(x % 2 == 0) {
            return x / 2;
        }
        else {
            return 3 * x + 1;
        }
    }

    /**
     * Returns true if the given string contains nothing but the letter A,
     * exclamation points, and spaces.
     *
     * YOUR TASK: Split each of the 4 steps into its own intermediate variable:
     *   the first step goes in a variable called upperCaseText, then the second
     *   step goes in a variable called... (You take it from here.)
     */
    public static boolean isJustScreaming(String text) {
        String upperCaseText = text.toUpperCase();
        String withoutA = upperCaseText.replace("A", "");
        String withoutExclamation = withoutA.replace("!", "");
        boolean isEmpty = withoutExclamation.isBlank();

        return isEmpty;
    }

    /**
     * Removes acute accents from lowercase Roman vowels in the given text.
     *
     * YOUR TASK: Do this all in one return statement, with no assignments at all.
     *
     * Once again, this is the opposite of the previous exercise. What are the
     * advantages of each style? In what situations would one style be better
     * vs. the other? Discuss with your partner.
     */
    public static String removeAccents(String text) {
        return text
                .replace("á", "a")
                .replace("é", "e")
                .replace("í", "i")
                .replace("ó", "o")
                .replace("ú", "u");

    }

    /**
     * Returns true if the given strength contains the numerals for its own
     * length, e.g. "th15 one does!!" because it contains the string “15”.
     *
     * YOUR TASK: Refactor this method to make it as unneccessarily complicated
     *   as you possibly can (without changing the result)!
     */
    public static boolean containsOwnLength(String text) {
        return text.contains(
            String.valueOf(
                text.length()));
    }
}

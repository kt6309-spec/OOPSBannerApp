/**
 * OOPS Banner App - UC7
 * 
 * Demonstrates usage of:
 * - Inner Static Class
 * - Encapsulation
 * - Arrays of Objects
 * - StringBuilder
 * - OOPS Principles
 * 
 * Displays the word "OOPS" in banner format.
 */
public class BannerApp {

    /**
     * Inner Static Class
     * 
     * Encapsulates a character and its 7-line banner pattern.
     */
    public static class CharacterPatternMap {

        private final char character;
        private final String[] pattern;

        /**
         * Constructor to initialize character and its pattern.
         * 
         * @param character the character to store
         * @param pattern the 7-line banner representation
         */
        public CharacterPatternMap(char character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        /**
         * Returns the character.
         * 
         * @return stored character
         */
        public char getCharacter() {
            return character;
        }

        /**
         * Returns the banner pattern of the character.
         * 
         * @return 7-line pattern array
         */
        public String[] getPattern() {
            return pattern;
        }
    }

    /**
     * Utility method to get pattern for a given character.
     * 
     * @param ch character to search
     * @param patterns array of CharacterPatternMap objects
     * @return pattern array if found, otherwise empty pattern
     */
    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] patterns) {
        for (CharacterPatternMap cp : patterns) {
            if (cp.getCharacter() == ch) {
                return cp.getPattern();
            }
        }
        return new String[7]; // fallback
    }

    /**
     * Displays banner text for given word.
     * 
     * @param word word to display
     * @param patterns array of CharacterPatternMap objects
     */
    public static void displayBanner(String word, CharacterPatternMap[] patterns) {

        for (int row = 0; row < 7; row++) {
            StringBuilder sb = new StringBuilder();

            for (char ch : word.toCharArray()) {
                String[] pattern = getCharacterPattern(ch, patterns);
                sb.append(pattern[row]).append("  ");
            }

            System.out.println(sb.toString());
        }
    }

    /**
     * Main method – Program execution starts here.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {

        // Pattern for O
        String[] O = {
                " ***** ",
                "*     *",
                "*     *",
                "*     *",
                "*     *",
                "*     *",
                " ***** "
        };

        // Pattern for P
        String[] P = {
                " ******",
                "*     *",
                "*     *",
                " ******",
                "*      ",
                "*      ",
                "*      "
        };

        // Pattern for S
        String[] S = {
                " ******",
                "*      ",
                "*      ",
                " ***** ",
                "      *",
                "      *",
                " ******"
        };

        // Array of CharacterPatternMap objects
        CharacterPatternMap[] patterns = {
                new CharacterPatternMap('O', O),
                new CharacterPatternMap('P', P),
                new CharacterPatternMap('S', S)
        };

        // Display OOPS banner
        displayBanner("OOPS", patterns);
    }
}
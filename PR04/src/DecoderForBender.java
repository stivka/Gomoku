public class DecoderForBender {
    /**

     * Entry point of the program.
     * @param args Arguments from command line.
     */
    public static void main(String[] args) {
        decode("22ab");
        decode("b12acrt15a");

    }

    /**
     * Decode input message.
     * @param codedMessage message to decode
     * @return decoded message
     */
    public static String decode(String codedMessage) {
        if (codedMessage == null) {
            return null;
        }
        if (codedMessage.equals("")) {
            return "";
        }
        String stringMultiDigit = "";
        int multiCounter = 0;
        String decodedMessage = "";
        //TODO: implement decoding logic here
        // Hint: Loop through the message,
        // determine if current character is a number or a letter,
        // and add it to output string.
        // Pro tip: Collect multi-digit numbers to a string
        // and convert it to an Integer to find out
        // how many letters are needed.
        for (int i = 0; i < codedMessage.length(); i++) {
            if (Character.isDigit(codedMessage.charAt(i))) {
                stringMultiDigit += codedMessage.charAt(i);
                multiCounter++;
            }
            if (Character.isLetter(codedMessage.charAt(i)) && multiCounter > 0) {
                // In case there is any number, multi-digit or one digit, preceding the character. It will produce the
                // suitable string. Also it resets the multi-digit counter and multi-digit string.
                for (int j = 0; j < Integer.parseInt(stringMultiDigit); j++) {
                    decodedMessage += codedMessage.charAt(i);
                }
                multiCounter = 0;
                stringMultiDigit = "";
            }
            if (Character.isLetter(codedMessage.charAt(i)) && multiCounter < 1 ) {
                // if the preceding character is either another character, or there isn't a preceding character.
                decodedMessage += codedMessage.charAt(i);
            }
        }
        System.out.println(decodedMessage);
        return decodedMessage;
    }
}

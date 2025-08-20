//Time Complexity: O(1) average per shouldPrintMessage.
//Space Complexity: O(U) where U is the number of distinct messages.

//Maintain a HashMap<String,Integer> mapping message → last printed timestamp.
//On each call, get the last time; if absent or timestamp - last ≥ 10, update the map and return true.
//Otherwise, return false (do not print); memory grows with unique messages.

class Logger {
    private final Map<String, Integer> lastPrinted;

    public Logger() {
        lastPrinted = new HashMap<>();
    }

    // Returns true if the message should be printed in the given timestamp, otherwise false.
    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer last = lastPrinted.get(message);
        if (last == null || timestamp - last >= 10) {
            lastPrinted.put(message, timestamp);
            return true;
        }
        return false;
    }
}

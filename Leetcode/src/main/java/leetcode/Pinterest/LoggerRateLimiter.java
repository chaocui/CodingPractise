package leetcode.Pinterest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2017/7/3.
 */
public class LoggerRateLimiter {

    /** Initialize your data structure here. */
    Map<String, Integer> messages;
    public LoggerRateLimiter() {
        messages = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (messages.containsKey(message)) {
            int preTime = messages.get(message);
            if (timestamp - preTime >= 10) {
                messages.put(message, timestamp);
                return true;
            }
            return false;
        }
        messages.put(message, timestamp);
        return true;
    }
}

# Title: Valid Parentheses
# Submission ID: 1846052756
# Status: Accepted
# Date: December 3, 2025 at 09:40:02 PM GMT+5:30

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');

        for (char c : s.toCharArray()) {
            if (mapping.containsValue(c)) {
                stack.push(c);
            } else if (mapping.containsKey(c)) {
                if (stack.isEmpty() || mapping.get(c) != stack.pop()) {
                    return false;
                }
            }
        }

        return stack.isEmpty();        
    }
}
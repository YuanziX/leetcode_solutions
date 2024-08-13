class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isStarting(ch))
                stack.push(ch);
            else if (stack.isEmpty() || stack.pop() != bracketLookup(ch))
                    return false;
        }
        return stack.isEmpty();
    }

    boolean isStarting(char ch) {
        if (ch == '[' || ch == '{' || ch == '(')
            return true;
        return false;
    }

    char bracketLookup(char ch) {
        if (ch == ')')
            return '(';
        else if (ch == '}')
            return '{';
        else if (ch == ']')
            return '[';
        return 'N';
    }
}

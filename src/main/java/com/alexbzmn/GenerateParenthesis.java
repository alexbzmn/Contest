package com.alexbzmn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            char[] chars = new char[n * 2];
            generate(result, n, 0, 0, 0, chars);
            return result;
        }

        public void generate(List<String> list, int n, int i, int open, int close, char[] chars) {
            if (close == n) {
                list.add(String.valueOf(chars));
                return;
            }

            if (open > close) {
                chars[i] = ')';
                generate(list, n, i + 1, open, close + 1, chars);
            }

            if (open < n) {
                chars[i] = '(';
                generate(list, n, i + 1, open + 1, close, chars);
            }
        }
    }

}

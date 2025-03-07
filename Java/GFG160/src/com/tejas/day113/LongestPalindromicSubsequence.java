package com.tejas.day113;

public class LongestPalindromicSubsequence {
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Base case: Every single character is a palindrome of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Build the DP table
        for (int len = 2; len <= n; len++) { // len is the length of substring
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; // Ending index
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1]; // The longest palindromic subsequence for the full string
    }

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println("Length of Longest Palindromic Subsequence: " + longestPalindromeSubseq(s));
    }
}

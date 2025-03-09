package com.tejas.day115;




class PalindromeSubstring {
    public static int countPS(String s) {
        // code here
        int n= s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        
        
        // Iterate over substring lengths (gap = j-1)
        for(int gap = 0;gap<n;gap++)
        {
            for(int i = 0,j=gap;j<n;i++,j++)
            {
                if(gap == 0)
                {
                    dp[i][j] = true;
                }else if(gap ==1){
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }else{
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i+1][j-1];
                }
            
                if(dp[i][j] && gap>0)
                {
                    count++;
                }
                
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
		System.out.println(countPS("abbaeae"));
	}
}
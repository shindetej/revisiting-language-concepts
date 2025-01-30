package com.tejas.day077;

import java.util.ArrayList;

public class NQueenProblem {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> result =  nQueen(4);
		for(ArrayList<Integer> list :result)
			System.out.println(list);
	}
	public static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        
        ArrayList<ArrayList<Integer>> result =  new  ArrayList<>();
        int[] queens = new int[n];
        solveNQueen(result,queens,0,n);
        return  result;
    }
    
    static void solveNQueen(ArrayList<ArrayList<Integer>> result,int[] queens,int row,int n){
        if(row == n){
            // all queens placed fill the positions to return result
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i = 0;i<n;i++){
                ans.add(queens[i]+1);
            }
            result.add(ans);
            return ;
        }
        
        for(int col = 0;col <n;col++){
            if(isSafe(queens,row,col)){
                queens[row] = col;
                solveNQueen(result,queens,row+1,n);
            }
        }
    }
    
    static boolean isSafe(int[] queens,int row,int col){
       for(int i= 0;i<row;i++){
        if(queens[i] == col || Math.abs(queens[i]-col) == Math.abs(i-row)){
            return false;
        }
       }
       return true;
    }
}

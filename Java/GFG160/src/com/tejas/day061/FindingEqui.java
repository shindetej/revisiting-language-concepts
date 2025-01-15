package com.tejas.day061;

public class FindingEqui {

    public static int findEquilibriumPoint(int[] arr) {
        int totalSum = 0;
        int leftSum = 0;

        // Calculate total sum of the array
        for (int num : arr) {
            totalSum += num;
        }

        // Traverse the array and check for equilibrium
        for (int i = 0; i < arr.length; i++) {
            totalSum -= arr[i];  // Right sum is total sum minus the current element

            if (leftSum == totalSum) {
                return i;  // Found the equilibrium point
            }

            leftSum += arr[i];  // Update left sum for the next iteration
        }

        return -1;  // No equilibrium point found
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 3};
        System.out.println("Equilibrium "+findEquilibriumPoint(arr));  // Output: 2
    }
}

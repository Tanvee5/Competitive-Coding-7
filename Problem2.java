// Problem 2 : Kth Smallest Element in a Sorted Matrix
// Usuing the max heap 
// Time Complexity : O(n^2 log k) n is the size of the matrix
// Space Complexity : O(log k )
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // initialize the priority queue ie. max heap by defining the custom comparator
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        // get the length of matrix
        int size = matrix.length;
        // loop through the matrix
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // add the matrix[i][j] to the priority queue
                pq.add(matrix[i][j]);
                // if the size of the priority queue is greater than k then remove the top element of the priority queue
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        // return the top element of the priority queue which is kth smallest element
        return pq.poll();
    }
}

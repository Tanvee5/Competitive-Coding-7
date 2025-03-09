# Problem 2 : Kth Smallest Element in a Sorted Matrix
# Using Binary Search approach 
# Time Complexity : 
'''
O(n* log(max - min)) where n is length of the matrix, max is the 
maximum number in matrix and min is the minimum number in the matrix
''' 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
Took lot of time to come up with this binary search solution.
'''

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        # function to count number of elements which are lesser than middle
        # return true if the count if greater than or equal to k else return false
        def isCountOfElementsGreater(matrix: List[List[int]], k: int, mid: int) -> bool:
            # start  top-right corner of the matrix is matrix[0][col]
            row = 0
            col = size - 1
            # initialize the count variable
            count = 0
            # loop till the row and col are in the matrix boundary
            while(col >= 0 and row < size):
                # check if the value of matrix at row and col position is less than middle
                # here we want kth small element so we are count the element which are smaller than the middle element
                if matrix[row][col] <= mid:
                    # if it is means that all the elements before this element in the row will also be less than the middle 
                    # so add col + 1 to count to get the total number of elements less than middle till now
                    count += col + 1
                    # increment the row to go to next row 
                    row += 1
                else:
                    # if the value is greater than middle then it means all other values in that column will also be greater than middle
                    # so decrement the col
                    col -= 1
            # return the result of the condition 
            return count >= k
        # get the size of the matrix
        size = len(matrix)
        # get the smallest value which is matrix[0][0] since rows and cols are sorted
        low = matrix[0][0]
        # get the largest value which is matrix[m][m] since rows and cols are sorted
        high = matrix[size-1][size-1]
        # run binary search on values of matrix element to get the kth smallest value
        # here loop till low < high
        while low < high:
            # get the middle value
            middle = (high + low) // 2
            # check if the count of the elements less than the middle is greater than k 
            if isCountOfElementsGreater(matrix, k, middle):
                # if it is greater then update the range by setting high to middle
                high = middle
            else:
                # else set the low to middle + 1
                low = middle + 1
        # at the end low will have kth smallest value
        return low
// Problem 1 : Meeting Rooms II
// Time Complexity : O(nlog n) where n is the number of interval
// Space Complexity : O(n) where n is the number of interval
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public int minMeetingRooms(int[][] intervals) {
    // checking the base that if the intervals variable is null or the length is zero then return 0
    if (intervals == null || intervals.length == 0) return 0;
    // initialize a priority queue for min heap and it will store meeting end time
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    // sort the interval based on meeting start time
    Arrays.sort(intervals, Comparator.comparingInt(a-> a[0]));
    // loop through intervals list to consider one meeting at a time
    for (int i = 0; i < intervals.length; i++) {
        // if the queue is empty means there is nothing to check so add that meeting end time directly to the priority queue
        if(pq.isEmpty()) {
            pq.add(intervals[i][1]);
        } else {
            // if there is any entry in priority queue then get the meeting of the top entry in min heap which will give smallest end time
            int endLastMeeting = pq.peek();
            // check that end time with the start time of the current meeting
            if (intervals[i][0] > endLastMeeting) {
                // remove the meeting with smallest end time
                pq.poll();
            }
            // add the current meeting end time 
            pq.add(intervals[i][0]);
        }
    }
    // return the size of the priority queue which will give the minimum number of the meeting rooms
    return pq.size();
}
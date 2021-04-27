package com.puru.random;

import java.util.Arrays;

/**
 * #################################################################
 * Let’s look at a basic task scheduling problem for some CPU:
 * * Every task has an ID, a start time, and a duration to run.
 * * When the core needs a new task at time T, it:
 * * Looks at all tasks that haven’t been run yet with start time <= T.
 * * Selects the task with the lowest duration and runs it for that amount of time.
 * <p>
 * Write a function that, given (ID, start, duration) tuples will print the order the tasks are run.
 * ##################################################################
 * Example:
 * Tasks: [{id1, 0, 10}, {id2, 3, 7}, {id3, 6, 3}]
 * Output: id1, id3, id2
 * <p>
 * Tasks: [{id1, 0, 1}, {id2, 3, 7}, {id3, 6, 3}]
 * Output: id1, id2, id3
 */
public class TaskSchedulingForCpu {

    public static void main(String[] args) {
        /*Task[] tasks = {new Task(1, 0, 1),
                new Task(2, 3, 7), new Task(3, 6, 3)};

        Task[] tasks2 = {new Task(1, 0, 1),
                new Task(2, 3, 7), new Task(3, 6, 3)};

        new TaskSchedulingForCpu().getScheduledTasks(tasks2);

        System.out.println(Arrays.toString(tasks));*/

    }

    public void getScheduledTasks(Task[] tasks) {
        Arrays.sort(tasks, (task1, task2) -> Integer.compare(task1.getEndTime(), task2.getEndTime()));
    }
    public int binarySearchLastOcc(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int h = nums.length - 1;
        int right = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
            if (nums[mid] == target) {
                right = mid;
            }
        }
        return right;
    }
    public int searchElement(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int h = nums.length - 1;
        int left = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] >= target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
            if (nums[mid] == target) {
                left = mid;
            }
        }
        return left;
    }
}

class Task {
    protected int id;
    private int starTime;
    private int endTime;

    public Task(int id, int starTime, int endTime) {
        this.id = id;
        this.starTime = starTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStarTime() {
        return starTime;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", starTime=" + starTime +
                ", endTime=" + endTime +
                '}';
    }

    public void setStarTime(int starTime) {
        this.starTime = starTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

}

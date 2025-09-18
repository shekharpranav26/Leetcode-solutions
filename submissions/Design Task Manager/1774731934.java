# Title: Design Task Manager
# Submission ID: 1774731934
# Status: Accepted
# Date: September 18, 2025 at 01:02:58 PM GMT+5:30

import java.util.*;

class TaskManager {
    // Maps taskId -> [userId, priority]
    private Map<Integer, int[]> taskMap;
    // Max heap for (taskId, priority)
    private PriorityQueue<int[]> maxHeap;

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        // Comparator: priority DESC, then taskId DESC
        maxHeap = new PriorityQueue<>((a, b) -> 
            a[1] != b[1] ? Integer.compare(b[1], a[1]) : Integer.compare(b[0], a[0])
        );

        for (List<Integer> t : tasks) {
            int userId = t.get(0), taskId = t.get(1), priority = t.get(2);
            taskMap.put(taskId, new int[]{userId, priority});
            maxHeap.offer(new int[]{taskId, priority});
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskMap.put(taskId, new int[]{userId, priority});
        maxHeap.offer(new int[]{taskId, priority});
    }

    public void edit(int taskId, int newPriority) {
        int userId = taskMap.get(taskId)[0];
        taskMap.put(taskId, new int[]{userId, newPriority});
        maxHeap.offer(new int[]{taskId, newPriority}); // lazy update
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId); // lazy delete
    }

    public int execTop() {
        while (!maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            int taskId = top[0], priority = top[1];

            if (taskMap.containsKey(taskId) && taskMap.get(taskId)[1] == priority) {
                int userId = taskMap.get(taskId)[0];
                taskMap.remove(taskId);
                return userId;
            }
        }
        return -1;
    }
}

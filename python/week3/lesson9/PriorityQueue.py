import heapq

tasks = []

heapq.heappush(tasks, (3, "Low priority"))
heapq.heappush(tasks, (1, "High priority"))
heapq.heappush(tasks, (2, "Medium priority"))

while tasks:
    priority, task = heapq.heappop(tasks)
    print(priority, task)
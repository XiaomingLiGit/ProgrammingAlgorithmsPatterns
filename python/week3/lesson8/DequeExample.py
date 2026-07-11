from collections import deque


def print_state(message, data):
    print(f"{message}: {data}")


# ==================================================
# 1. Create a deque
# ==================================================

empty_queue = deque()

names = deque(["Alice", "Bob", "Charlie"])

print_state("Initial deque", names)


# ==================================================
# 2. append()
# Add an element to the right side
# ==================================================

names.append("David")

print_state("After append", names)


# ==================================================
# 3. appendleft()
# Add an element to the left side
# ==================================================

names.appendleft("Zara")

print_state("After appendleft", names)


# ==================================================
# 4. extend()
# Add multiple elements to the right side
# ==================================================

names.extend(["Emily", "Frank"])

print_state("After extend", names)


# ==================================================
# 5. extendleft()
# Add multiple elements to the left side
# The input order is reversed
# ==================================================

names.extendleft(["Tom", "Jerry"])

print_state("After extendleft", names)


# ==================================================
# 6. pop()
# Remove and return the rightmost element
# ==================================================

last_name = names.pop()

print("Removed from right:", last_name)
print_state("After pop", names)


# ==================================================
# 7. popleft()
# Remove and return the leftmost element
# ==================================================

first_name = names.popleft()

print("Removed from left:", first_name)
print_state("After popleft", names)


# ==================================================
# 8. insert()
# Insert an element at a specific position
# ==================================================

names.insert(1, "Grace")

print_state("After insert", names)


# ==================================================
# 9. remove()
# Remove the first matching value
# ==================================================

names.remove("Bob")

print_state("After remove", names)


# ==================================================
# 10. count()
# Count the number of matching elements
# ==================================================

scores = deque([10, 20, 10, 30, 10])

number_of_tens = scores.count(10)

print("Number of 10s:", number_of_tens)


# ==================================================
# 11. index()
# Find the index of the first matching element
# ==================================================

position = scores.index(30)

print("Index of 30:", position)


# ==================================================
# 12. reverse()
# Reverse the deque in place
# ==================================================

scores.reverse()

print_state("After reverse", scores)


# ==================================================
# 13. rotate()
# Positive values rotate to the right
# Negative values rotate to the left
# ==================================================

letters = deque(["A", "B", "C", "D", "E"])

letters.rotate(2)

print_state("After rotate(2)", letters)

letters.rotate(-2)

print_state("After rotate(-2)", letters)


# ==================================================
# 14. copy()
# Create a shallow copy
# ==================================================

original = deque(["Alice", "Bob", "Charlie"])
copied = original.copy()

copied.append("David")

print_state("Original", original)
print_state("Copied", copied)


# ==================================================
# 15. clear()
# Remove all elements
# ==================================================

temporary = deque(["A", "B", "C"])

temporary.clear()

print_state("After clear", temporary)


# ==================================================
# 16. maxlen
# Create a bounded deque
# ==================================================

recent_items = deque(maxlen=3)

recent_items.append("A")
recent_items.append("B")
recent_items.append("C")

print_state("Bounded deque", recent_items)

recent_items.append("D")

print_state("After appending D", recent_items)

recent_items.appendleft("Z")

print_state("After appendleft Z", recent_items)

print("Maximum length:", recent_items.maxlen)


# ==================================================
# 17. len()
# Get the number of elements
# ==================================================

names = deque(["Alice", "Bob", "Charlie"])

print("Size:", len(names))


# ==================================================
# 18. Membership test
# ==================================================

print("Contains Bob:", "Bob" in names)
print("Contains David:", "David" in names)


# ==================================================
# 19. Indexed access
# ==================================================

print("First element:", names[0])
print("Last element:", names[-1])
print("Element at index 1:", names[1])


# ==================================================
# 20. Update an element by index
# ==================================================

names[1] = "Bobby"

print_state("After indexed update", names)


# ==================================================
# 21. Delete an element by index
# ==================================================

del names[1]

print_state("After indexed deletion", names)


# ==================================================
# 22. Forward iteration
# ==================================================

print("Forward iteration:")

for name in names:
    print(name)


# ==================================================
# 23. Explicit iterator
# ==================================================

iterator = iter(names)

print("First item from iterator:", next(iterator))

for name in iterator:
    print("Next item:", name)


# ==================================================
# 24. Reverse iteration
# ==================================================

print("Reverse iteration:")

for name in reversed(names):
    print(name)


# ==================================================
# 25. Convert deque to list
# ==================================================

name_list = list(names)

print("Converted list:", name_list)


# ==================================================
# 26. Add two deques
# ==================================================

first = deque(["A", "B"])
second = deque(["C", "D"])

combined = first + second

print_state("Combined deque", combined)


# ==================================================
# 27. Repeat a deque
# ==================================================

repeated = deque(["A", "B"]) * 3

print_state("Repeated deque", repeated)
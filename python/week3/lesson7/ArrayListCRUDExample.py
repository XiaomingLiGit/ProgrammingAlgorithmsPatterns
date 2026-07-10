students = []

# Create
students.append("Alice")
students.append("Bob")
students.append("Charlie")
students.insert(1, "David")
print("After adding:", students)

# Read
student = students[2]
print("Student at index 2:", student)
exists = "Bob" in students
print("Contains Bob:", exists)
index = students.index("Charlie")
print("Index of Charlie:", index)
print("All students:")

for name in students:
    print(name)

# Update
students[1] = "Emily"
print("After updating:", students)

# Delete by value
students.remove("Bob")
print("After removing Bob:", students)
# Delete by index
students.pop(0)
print("After removing index 0:", students)
# Delete all elements
students.clear()
print("After clearing:", students)
print("Is empty:", len(students) == 0)
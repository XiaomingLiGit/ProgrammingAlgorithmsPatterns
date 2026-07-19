students = {
    "Alice": 90,
    "Bob": 85
}

students["Charlie"] = 95
students["Alice"] = 92

print(students.get("David", 0))

for name, score in students.items():
    print(name, score)

students.pop("Bob")


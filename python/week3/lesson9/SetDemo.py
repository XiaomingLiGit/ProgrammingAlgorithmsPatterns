cities = set()

# Add elements
cities.add("New York")
cities.add("Paris")
cities.add("Tokyo")
cities.add("Paris")  # Duplicate

print("Cities:", cities)

# Check membership
print("Contains Tokyo:", "Tokyo" in cities)

# Remove an element
cities.remove("New York")
print("After removal:", cities)

# Add multiple elements
cities.update(["London", "Beijing", "Toronto"])
print("After update:", cities)

# Iterate over the set
print("All cities:")

for city in cities:
    print(city)

# Get the number of elements
print("Set size:", len(cities))

# Remove all elements
cities.clear()
print("After clear:", cities)
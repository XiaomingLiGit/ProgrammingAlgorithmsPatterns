class Singleton:
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            print("Creating the singleton object...")
            cls._instance = super().__new__(cls)
        return cls._instance

    def __init__(self):
        print("Initializing...")



s1 = Singleton()
s2 = Singleton()

print(s1 is s2)
print(id(s1))
print(id(s2))
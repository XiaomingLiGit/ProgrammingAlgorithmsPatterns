from collections.abc import Iterator, Iterable


class Book:
    def __init__(self, title: str, author: str):
        self.title = title
        self.author = author

    def __str__(self):
        return f"{self.title} by {self.author}"


# Concrete Iterator
class BookIterator(Iterator):
    def __init__(self, books):
        self._books = books
        self._position = 0

    def __next__(self):
        if self._position >= len(self._books):
            raise StopIteration

        book = self._books[self._position]
        self._position += 1
        return book


# Concrete Aggregate / Iterable Collection
class BookCollection(Iterable):
    def __init__(self):
        self._books = []

    def add_book(self, book):
        self._books.append(book)

    def __iter__(self):
        return BookIterator(self._books)


# Client code
library = BookCollection()

library.add_book(Book("Python Crash Course", "Eric Matthes"))
library.add_book(Book("Clean Code", "Robert C. Martin"))
library.add_book(Book("Design Patterns", "Gang of Four"))

for book in library:
    print(book)
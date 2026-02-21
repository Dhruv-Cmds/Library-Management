# LIBRARY

class Book:
    def __init__(self, book_id, title, author, copies):
        self.book_id = book_id
        self.title = title
        self.author = author
        self.copies = copies

    def is_available(self):
        return self.copies > 0

    def borrow(self):
        if self.copies <= 0:
            raise Exception("Book not available")
        self.copies -= 1

    def return_book(self):
        self.copies += 1

class User:
    def __init__(self, user_id, name, role):
        self.user_id = user_id
        self.name = name
        self.role = role
        self.borrowed_books = []

    def borrow_book(self, book_id):
        if book_id in self.borrowed_books:
            raise Exception("Book already borrowed")
        self.borrowed_books.append(book_id)

    def return_book(self, book_id):
        if book_id not in self.borrowed_books:
            raise Exception("Book not borrowed")
        self.borrowed_books.remove(book_id)

class Library:
    def __init__(self):
        self.books = []
        self.users = []

    def add_book(self, book):
        self.books.append(book)

    def find_book(self, book_id):
        for book in self.books:
            if book.book_id == book_id:
                return book
        return None

    def show_books(self):
        if not self.books:
            print("No books available")
            return

        for book in self.books:
            print(
                f"ID: {book.book_id} | "
                f"Title: {book.title} | "
                f"Author: {book.author} | "
                f"Copies: {book.copies}"
            )

    def add_user(self, user):
        self.users.append(user)

    def find_user(self, user_id):
        for user in self.users:
            if user.user_id == user_id:
                return user
        return None

    def show_users(self):
        if not self.users:
            print("No users registered")
            return

        for user in self.users:
            print(
                f"ID: {user.user_id} | "
                f"Name: {user.name} | "
                f"Role: {user.role} | "
                f"Borrowed: {user.borrowed_books}"
            )

    def borrow_book(self, user_id, book_id):
        user = self.find_user(user_id)
        book = self.find_book(book_id)
    
        if user is None:
            raise Exception("User not found")
        if book is None:
            raise Exception("Book not found")

        book.borrow()
        user.borrow_book(book_id)

    def return_book(self, user_id, book_id):
        user = self.find_user(user_id)
        book = self.find_book(book_id)

        if user is None or book is None:
            raise Exception("Invalid user or book")

        user.return_book(book_id)
        book.return_book()

def generate_id(prefix):
    return prefix + str(len(prefix) * 100 + len(prefix))

library = Library()

def menu():
    while True:
        print("\n--- LIBRARY MENU ---") 
        print("1. Add Book (Admin)")
        print("2. Add User")
        print("3. Show Books")
        print("4. Show Users")
        print("5. Borrow Book")
        print("6. Return Book")
        print("7. Exit")


        choice = input("Choose: ")

        try:
            if choice == "1":
                title = input("Title: ")
                author = input("Author: ")
                copies = int(input("Copies: "))
                book_id = generate_id("B")
                library.add_book(Book(book_id, title, author, copies))
                print("Book added with ID:", book_id)

            elif choice == "2":
                name = input("Name: ")
                role = input("Role (admin/member): ").lower()
                user_id = generate_id("U")
                library.add_user(User(user_id, name, role))
                print("User added with ID:", user_id)

            elif choice == "3":
                library.show_books()

            elif choice == "4":
                library.show_users()

            elif choice == "5":
                uid = input("User ID: ")
                bid = input("Book ID: ")
                library.borrow_book(uid, bid)
                print("Book borrowed")

            elif choice == "6":
                uid = input("User ID: ")
                bid = input("Book ID: ")
                library.return_book(uid, bid)
                print("Book returned")

            elif choice == "7":
                print("Goodbye 👋")
                break

            else:
                print("Invalid choice")

        except Exception as e:
            print("Error:", e)
menu()
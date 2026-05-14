# SI_2026_lab2_225132


Hristijan Tonevski 225132

<img width="566" height="488" alt="cfg_searchBookByTitle png" src="https://github.com/user-attachments/assets/b2744847-fa2f-4376-a29d-a3bcd8aceaf4" />
<img width="553" height="449" alt="cfg_borrowBook1 png" src="https://github.com/user-attachments/assets/78597571-4dc0-46b1-8b2d-de006e80155a" />
<img width="469" height="244" alt="cfg_borrowBook2 png" src="https://github.com/user-attachments/assets/78b6cb5c-b8de-4a40-8b68-c176ccd9858a" />


searchBookByTitle — M = 4
borrowBook — M = 4

searchBookByTitle

TC1: title = ""
     → IllegalArgumentException 

TC2: title = "Clean Code", книгата постои и НЕ е изнајмена
     → result != null 
     → result.size() == 1 
     → result.get(0).getTitle() == "Clean Code" 

TC3: title = "Harry Potter", не постои во библиотека
     → result == null 

borrowBook


TC1: title = "", author = "Robert C. Martin"
     → IllegalArgumentException 

TC2: title = "Непостоечка книга", author = "Непознат автор"
     → RuntimeException: Book not found 

TC3: title = "The Hobbit", author = "J.R.R. Tolkien", книгата НЕ е изнајмена
     → Borrowed successfully 

TC4: title = "The Hobbit", author = "J.R.R. Tolkien", книгата Е изнајмена
     → RuntimeException: Book is already borrowed 


searchBookByTitle

TC1: equalsIgnoreCase=true,  isBorrowed=false → result != null 
TC2: equalsIgnoreCase=true,  isBorrowed=true  → result == null 
TC3: equalsIgnoreCase=false, isBorrowed=false → result == null 
TC4: equalsIgnoreCase=false, isBorrowed=true  → result == null 

borrowBook

TC1: title.isEmpty=true,  author.isEmpty=true  → IllegalArgumentException 
TC2: title.isEmpty=true,  author.isEmpty=false → IllegalArgumentException 
TC3: title.isEmpty=false, author.isEmpty=true  → IllegalArgumentException 
TC4: title.isEmpty=false, author.isEmpty=false → RuntimeException: Book not found 

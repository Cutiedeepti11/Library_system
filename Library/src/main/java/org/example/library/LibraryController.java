package org.example.library;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class LibraryController {

    // Our core backend system
    private final Library myLibrary = new Library();

    public LibraryController() {
        // Add some default data so the dropdowns aren't empty!
        myLibrary.registerBook(new Book("978-0134685991", "Effective Java", "Joshua Bloch", 2018));
        myLibrary.registerBook(new Book("978-0132350884", "Clean Code", "Robert C. Martin", 2008));
        myLibrary.registerPatron(new Patron("P001", "Alice Smith"));
        myLibrary.registerPatron(new Patron("P002", "Bob Jones"));
    }

    // This shows the main web page
    @GetMapping("/")
    public String showMainPage(Model model) {
        // We fetch all books to populate the dropdown
        List<Book> allBooks = myLibrary.findBooks(new TitleSearchStrategy(), "");
        model.addAttribute("books", allBooks);

        return "index"; // This tells Spring to look for index.html
    }

    // This handles the form submission when you click "Borrow"
    @PostMapping("/borrow")
    public String borrowBook(@RequestParam String isbn, @RequestParam String patronId, RedirectAttributes redirectAttributes) {
        myLibrary.borrowBook(isbn, patronId);

        // This adds a temporary message that will appear once the page reloads!
        redirectAttributes.addFlashAttribute("message", "Success! The book has been checked out.");
        return "redirect:/"; // Reload the page
    }

    // This handles the form submission to add a new book
    @PostMapping("/addBook")
    public String addBook(@RequestParam String isbn, @RequestParam String title,
                          @RequestParam String author, @RequestParam int year,
                          RedirectAttributes redirectAttributes) {
        myLibrary.registerBook(new Book(isbn, title, author, year));

        // Let's add a success message for adding a book too!
        redirectAttributes.addFlashAttribute("message", "Success! Added '" + title + "' to the inventory.");
        return "redirect:/";
    }

    // This handles the form submission when you click "Return"
    @PostMapping("/return")
    public String returnBook(@RequestParam String isbn, RedirectAttributes redirectAttributes) {
        myLibrary.returnBook(isbn);

        // Add a success message
        redirectAttributes.addFlashAttribute("message", "Success! The book has been returned to the library.");
        return "redirect:/";
    }
}
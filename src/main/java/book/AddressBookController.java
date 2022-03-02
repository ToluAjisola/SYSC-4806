package book;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddressBookController {
    @Autowired
    AddressBookRepository repository;

    @GetMapping("/addressbook")
    public String addressBookForm(Model model) {
        model.addAttribute("addressBook", new AddressBook());
        return "address";
    }

    @PostMapping("/addressbook")
    public String addressBookSubmit(@ModelAttribute AddressBook book,Model model) {
        AddressBook addressBook = new AddressBook();
        repository.save(addressBook);
        model.addAttribute("newAddressBook", addressBook);
        return "addressBookResult";
    }
}

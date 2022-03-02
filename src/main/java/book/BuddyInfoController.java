package book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BuddyInfoController {
    @Autowired
    AddressBookRepository bookRepo;
    @Autowired
    BuddyInfoRepository repository;

    @GetMapping("/buddy")
    public String buddyInfoForm(Model model) {
        model.addAttribute("buddy1", new BuddyInfo());
        return "buddyInfo";
    }

    @PostMapping("/buddy")
    public String buddyInfoSubmit(@RequestParam(value = "id") long id,
                                  @ModelAttribute BuddyInfo buddy, Model model) {
        AddressBook book = bookRepo.findById(id);
        //BuddyInfo buddyInfo = buddy;
        buddy.setId(null);
        book.addBuddy(buddy);
        //book.addBuddy(buddy);

        System.out.println(buddy.getId());
        bookRepo.save(book);
        System.out.println(buddy.getId());
        //repository.save(buddy);
        List<BuddyInfo> infos = bookRepo.findById(id).getInfos();
        buddy = infos.get(infos.size()-1);
        model.addAttribute("addressbook", book);
        model.addAttribute("buddy", buddy);
        //model.addAttribute("buddy", buddy);
        return "buddyInfoResult";
    }
}

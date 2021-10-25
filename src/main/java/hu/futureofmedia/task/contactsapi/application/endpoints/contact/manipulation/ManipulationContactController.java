package hu.futureofmedia.task.contactsapi.application.endpoints.contact.manipulation;

import hu.futureofmedia.task.contactsapi.application.services.contact.manipulation.ManipulationContactService;
import hu.futureofmedia.task.contactsapi.models.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contactsapi/contact/manipulation")
public class ManipulationContactController {

    private final ManipulationContactService service;

    @Autowired
    public ManipulationContactController(ManipulationContactService service) { this.service = service; }

    @PostMapping("")
    public ResponseEntity<Object> addContact(@RequestBody Contact contact) {

        Contact newContact;
        try {
            newContact = service.addContact(contact);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST + ": " + e.getMessage());
        }

        return ResponseEntity.ok(newContact);
    }

}

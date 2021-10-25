package hu.futureofmedia.task.contactsapi.application.endpoints.contact.query;

import hu.futureofmedia.task.contactsapi.application.services.contact.query.QueryContactService;
import hu.futureofmedia.task.contactsapi.models.dto.ContactDto;
import hu.futureofmedia.task.contactsapi.models.others.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contactsapi/contact/query")
public class QueryContactController {

    private final QueryContactService service;

    @Autowired
    public QueryContactController(QueryContactService service) { this.service = service; }

    @PostMapping("/active")
    public ResponseEntity<List<ContactDto>> findAllActive(@RequestBody Page page) {
        return ResponseEntity.ok(service.findAllActive(page));
    }

}

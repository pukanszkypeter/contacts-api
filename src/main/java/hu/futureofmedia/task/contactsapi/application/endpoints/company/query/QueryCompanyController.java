package hu.futureofmedia.task.contactsapi.application.endpoints.company.query;

import hu.futureofmedia.task.contactsapi.application.services.company.query.QueryCompanyService;
import hu.futureofmedia.task.contactsapi.models.entities.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contactsapi/company/query")
public class QueryCompanyController {

    private final QueryCompanyService service;

    @Autowired
    public QueryCompanyController(QueryCompanyService service) { this.service = service; }

    @GetMapping("")
    public ResponseEntity<List<Company>> findAll() {
        return ResponseEntity.ok(service.findALl());
    }

}

package hu.futureofmedia.task.contactsapi.application.endpoints.blocklist.query;

import hu.futureofmedia.task.contactsapi.application.services.blocklist.query.QueryBlockListService;
import hu.futureofmedia.task.contactsapi.models.entities.BlockList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contactsapi/blocklist/query")
public class QueryBlockListController {

    private final QueryBlockListService service;

    @Autowired
    public QueryBlockListController(QueryBlockListService service) { this.service = service; }

    @GetMapping("")
    public ResponseEntity<List<BlockList>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

}

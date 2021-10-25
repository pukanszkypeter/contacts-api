package hu.futureofmedia.task.contactsapi.application.repositories.blocklist;

import hu.futureofmedia.task.contactsapi.models.entities.BlockList;
import org.springframework.data.repository.CrudRepository;

public interface BlockListRepository extends CrudRepository<BlockList, Long> {
}

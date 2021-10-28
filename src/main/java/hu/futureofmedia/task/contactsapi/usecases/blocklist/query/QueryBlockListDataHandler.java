package hu.futureofmedia.task.contactsapi.usecases.blocklist.query;

import hu.futureofmedia.task.contactsapi.models.entities.BlockList;

import java.util.List;

public interface QueryBlockListDataHandler {

    List<BlockList> findAll();

}

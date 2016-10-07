package nl.getthere.model.respositories;

import nl.getthere.model.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jasper.dejong on 4-10-2016.
 */
public interface EventRepository extends CrudRepository<Event, Long> {

}

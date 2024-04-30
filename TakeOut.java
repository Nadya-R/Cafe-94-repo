
/**
*The TakeOut class provides methods for creating and managing takeout orders.
 * It extends the Order class and includes functionality for specifying collection time.
 * 
 * @author Ty Bors
 * @version 1.0
 */
import java.time.LocalTime;

public class TakeOut extends Order {

    // local fields
    private LocalTime collectionTime;

    public TakeOut() {
        super();
    }

    public LocalTime getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(LocalTime collectionTime) {
        this.collectionTime = collectionTime;
    }
}

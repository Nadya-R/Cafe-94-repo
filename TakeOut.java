import java.time.LocalTime;

public class TakeOut extends Order {
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

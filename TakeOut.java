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


// logic of the system and still code the cotnroleer file for the order class java fx
// food orderiing app changed to diffent types of orders
// take away and delviery
// java fx of takeawya and delivery and use the scenbuilder an dseeting up a launh to these buttons
// tkae th ehwole of th emenu items and the use th enode to take the time to creat  takeoout javafx
// take out order repalcee fo the order clas in the menu and anothe code to prearepa the scne c time of taking of th efood and then add the time to tkae on how lonf it will be done for the chef

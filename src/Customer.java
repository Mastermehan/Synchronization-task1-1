public class Customer implements Runnable {
    CarShop carShop;

    public Customer(CarShop carShop) {
        this.carShop = carShop;
    }

    @Override
    public void run() { //стандартный вид реализации Runnable из пред презентаци
        carShop.sellCar();
    }
}

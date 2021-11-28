public class Main {
    public static void main(String[] args) {

        CarShop carShop = new CarShop();
        Manufacturer manufacturer = new Manufacturer(carShop);
        Customer customer = new Customer(carShop);

        new Thread(null, customer, "Сердючка").start();
        new Thread(null, customer, "Дикий").start();
        new Thread(null, customer, "Рваный").start();
        new Thread(null, customer,"Хромой" ).start();

        new Thread(null, manufacturer, "Производитель").start();

    }
}

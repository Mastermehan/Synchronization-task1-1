import java.text.MessageFormat;
import java.util.*;

public class CarShop {
    private static final int TIME_TO_SELL = 100; //время на продажу
    Manufacturer manufacturer = new Manufacturer(this);
    List<Car> carList = new ArrayList<>();

    public List<Car> getCarList() {
        return carList;
    }

    public synchronized void sellCar() { //стандартный вид синхронизации
        try {
            Thread.sleep(TIME_TO_SELL);
            while (carList.size() == 0) {
                System.out.println("В магазине отсутствуют автомобили!");
                wait(); //Приостанавливаем работу потока до поступления новых автомобилей
            }
            System.out.println(MessageFormat.format("{0}: купил новую - {1}",
                    Thread.currentThread().getName(), Model.Lada));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public synchronized void getNewCar() {
        try {
            Thread.sleep(Manufacturer.TIME_TO_PRODUCT_MILLIS);
            System.out.println("В магазине новый автомобиль от производителя");
            carList.add(new Car(Model.Lada, manufacturer));
            notify(); //Пробуждаем поток покупателя. Уведомляем, что поступила новая партия атомобилей
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}




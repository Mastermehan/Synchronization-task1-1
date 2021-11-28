import java.text.MessageFormat;

public class Manufacturer implements Runnable{ // это абстрактная работа,с предыдущей презентации

    public static final long TIME_TO_PRODUCT_MILLIS = 1000;
    private static final int AMOUNT_OF_CARS = 5; // производим n автомобилей
    private  CarShop carShop;

    public Manufacturer(CarShop carShop) {
        this.carShop = carShop;
    }

    @Override
    public void run() {
        for (int i = 0; i < AMOUNT_OF_CARS; i++) {
            try {
                //поток производителя, эмуляция производства
                System.out.println(MessageFormat.format("{0}: произвожу новый автомобиль.",
                        Thread.currentThread().getName()));
                Thread.sleep(TIME_TO_PRODUCT_MILLIS); // усыпляем поток для производства
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            carShop.getNewCar(); // отправляем на продажу новый авто
        }
    }
}

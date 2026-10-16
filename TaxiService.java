import java.util.Random;

public class TaxiService {
    public static void main(String[] args) {
        Random random = new Random();
        int total = 0; //всего денег с таксапарка

        for (int i = 1; i <= 16; i++) { //16 машин
            Car car; //ворона)
            int price;

            if (i % 2 == 0) { //четные бизнеес, нечет эконом
                price = random.nextInt(151) + 450; //cколько час
                car = new BusinessCar(price);
            } else {
                price = random.nextInt(151) + 150;
                car = new EconomCar(price);
            }

            int income = 0; //за неделю доход
            for (int day = 1; day <= 5; day++) {
                int hours = random.nextInt(9); //сколько часов в день отработала машина
                income += car.calculate(hours);
            }

            total += income;
            System.out.println("Машина " + i + ": доход за неделю = " + income + " руб.");
        }

        System.out.println("Доход таксопарка за неделю: " + total + " руб.");
    }
}

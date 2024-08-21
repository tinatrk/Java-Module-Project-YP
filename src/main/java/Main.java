import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Список машин-участников
        ArrayList<RacingCar> carList = new ArrayList<>();
        // Список машин-победителей (на случай, если их будет несколько)
        ArrayList<RacingCar> winner = new ArrayList<>();
        // Сет имен машин (используется для проверки уникальности имени очередной машины)
        HashSet<String> uniqNames = new HashSet<>();
        // количество машин-участников
        int countCars = 3;
        // максимальная допустимая скорость (км/ч)
        double maxSpeed = 250;

        // Инициализация списка машин данными пользователя
        for (int i = 0; i < countCars; i++){
            String name = "";
            double speed = -1;

            // Считываем название машины
            while(true){
                System.out.println("- Введите название машины №" + (i + 1) + ":");
                name = scanner.next();
                System.out.print("\n");
                boolean isUniq = uniqNames.add(name);
                if (isUniq){
                    break;
                } else {
                    System.out.println("- Машина с именем '" + name + "' уже зарегистрирована.");
                }
            }

            // Считываем скорость машины
            while(true){
                System.out.println("- Введите скорость машины №" + (i + 1)
                        + " в пределах (0, 250] км/ч:");
                if (scanner.hasNextDouble()){
                    speed = scanner.nextDouble();
                    System.out.print("\n");
                    if (speed == 0) {
                        System.out.println("- Кажется, машина №" + (i + 1) + " сдалась без боя!");
                    } else if (speed < 0) {
                        System.out.println("- Кажется, машина №" + (i + 1)
                                + " поехала в другую сторону!");
                    } else if (speed > maxSpeed) {
                        System.out.println("- Кто бы мог подумать, что на гонках может быть"
                                + " превышение скорости?");
                    } else {
                        // Скорость введена корректно
                        break;
                    }
                } else {
                    System.out.print("\n");
                    System.out.println("- Пожалуйста, используйте только численные значения." +
                            "\n- Если значение не целое, используйте ',' в качестве разделителя.");
                    String badData = scanner.next();
                }
            }

            //Данные пользователя корректные, создаем объект машины и добавляем его в список машин
            carList.add(new RacingCar(name, speed));
        }
        // Очищаем список уникальных имен машин, чтобы не занимать память
        uniqNames.clear();

        Race race = new Race();

        // Определяем победителя
        race.defineWinner(carList);
        winner = race.getWinner();

        // Выводим пользователю имена победителей
        int countWinners = winner.size();
        if (countWinners == 0){
            System.out.println("Что-то пошло не так. Не удалось определить победителя.");
        } else {
            System.out.println("Победителем становится:");
            for (int i = 0; i < countWinners; i++){
                System.out.println(winner.get(i).getName());
            }
        }
    }
}
import java.util.ArrayList;

public class Race {

    private final int hours;
    private final ArrayList<RacingCar> winner;

    public Race(){
        this.hours = 24;
        this.winner = new ArrayList<>();
    }

    public void defineWinner(ArrayList<RacingCar> cars){
        // Определяем количество участников в гонке
        int countCars = cars.size();
        // Массив, пройденных дистанций
        double distance[] = new double[countCars];
        // Максимальная дистанция
        double maxDist = -1;

        // Вычисление дистанции, пройденной каждой машиной и поиск максимальной дистанции
        for (int i = 0; i < countCars; i++){
            distance[i] = hours*cars.get(i).getSpeed();
            if (distance[i] > maxDist){
                maxDist = distance[i];
            }
        }

        // Формирование списка победителей (обработка ситуации, когда победителей несколько)
        for (int i = 0; i < countCars; i++){
            if (distance[i] == maxDist){
                this.winner.add(cars.get(i));
            }
        }
    }

    public ArrayList<RacingCar> getWinner(){
        return this.winner;
    }
}

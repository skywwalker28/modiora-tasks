package skyww.modiora.block5.Task5.interfaces;

public interface Feedable {
    void feed(String foodType, double amount);
    double getDailyFoodAmount();
    String getPreferredFood();
}


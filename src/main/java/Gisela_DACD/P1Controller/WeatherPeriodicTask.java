package Gisela_DACD.P1Controller;

import java.util.TimerTask;

public class WeatherPeriodicTask extends TimerTask {
    private final WeatherController weatherController;

    public WeatherPeriodicTask(WeatherController weatherController) {
        this.weatherController = weatherController;
    }

    @Override
    public void run() {
        weatherController.execute();
    }
}
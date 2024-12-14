package Task15;

public enum Seasons {
    WINTER("Зима", "Холодно", "НГ"),
    SPRING("Весна", "Тепло", "8 марта"),
    SUMMER("Лето", "Жарко", "День Детей"),
    AUTUMN("Осень", "Дожди", "1 сентября");

    private final String seasonName;
    private final String weather;
    private final String Holiday;

    Seasons(String seasonName, String weather, String Holiday){
        this.seasonName = seasonName;
        this.weather = weather;
        this.Holiday = Holiday;
    }

    public String getHoliday() {
        return Holiday;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getWeather() {
        return weather;
    }

    @Override
    public String toString() {
        return seasonName + " " + weather + " " + Holiday;
    }
}

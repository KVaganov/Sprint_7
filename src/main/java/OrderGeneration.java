public class OrderGeneration {
    static String[] colors;

    public static Orders getDefault() {
        return new Orders("Уважаемый",
                "Рьвьюер",
                "Yandex",
                1,
                "89998887766",
                5,
                "2025-04-02",
                "Зачтите работу пожалуйста",
                colors);
    }
}

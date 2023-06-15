interface Strategy {
    void download(String file);
}
class DownloadAutoStrategy implements Strategy {
    public void download(String file) {
        System.out.println("Загрузить карту автомобильных дорог: " + file);
    }
}
class DownloadBicycleStrategy implements Strategy {
    public void download(String file) {
        System.out.println("Загрузить карту велосипедных дорожек: " + file);
    }
}
class Context {
    private Strategy strategy;
    public Context(Strategy strategy){
        this.strategy = strategy;
    }
    public void download(String file){
        strategy.download(file);
    }
}

public class StrategyTest {//тест
    public static void main(String[] args) {
        Context context = new Context(new DownloadAutoStrategy());
        context.download("file.txt");
        context = new Context(new DownloadBicycleStrategy());
        context.download("file.txt");
    }
}
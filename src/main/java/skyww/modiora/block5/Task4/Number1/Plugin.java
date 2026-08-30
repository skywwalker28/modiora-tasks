package skyww.modiora.block5.Task4.Number1;

public interface Plugin {
    String getName();
    String getVersion();
    String execute(String data);
    boolean isEnabled();


    default String getDescription() {
        return "Плагин: " + getName() + " v" + getVersion();
    }
}

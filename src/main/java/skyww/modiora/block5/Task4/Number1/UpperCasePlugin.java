package skyww.modiora.block5.Task4.Number1;

public class UpperCasePlugin implements Plugin {
    private final String name;
    private final String version;
    private final boolean enable;


    public UpperCasePlugin(String name, String version, boolean enable) {
        this.name = name;
        this.version = version;
        this.enable = enable;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public String execute(String data) {
        return data.toUpperCase();
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }

    @Override
    public String toString() {
        return "Имя: " + getName() + " | версия: " + getVersion() + " | Доступен: " + isEnabled();
    }
}

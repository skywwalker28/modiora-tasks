package skyww.modiora.block5.Task4.Number1;

public class PluginManager {
    private final Plugin[] plugins = new Plugin[100];
    private int index = 0;

    public void addPlugin(Plugin plugin) {
        plugins[index++] = plugin;
    }

    public String[] executeAll(String data) {
        String[] result = new String[index];
        int idx = 0;

        for (int i = 0; i < index; i++) {
            if (plugins[i].isEnabled()) {
                result[idx++] = plugins[i].execute(data);
            } else {
                result[idx++] = "Плагин отключен";
            }
        }

        return result;
    }

    public Plugin findByName(String name) {

        for (int i = 0; i < index; i++) {
            if (plugins[i].getName().equals(name)) {
                return plugins[i];
            }
        }

        return null;
    }

    public void printAll() {
        for (int i = 0; i < index; i++) {
            System.out.println(plugins[i].getDescription());
        }
    }
}

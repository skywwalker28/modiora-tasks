package skyww.modiora.block5.Task5.interfaces;

public interface Trainable {
    boolean train(String command);
    String[] getLearnedCommands();
    int getTrainingLevel();
}


package Duke;

public class Parser {
    private static int task_stringIndex_After_taskWord = 0;

    public static String[] parse(String fullCommand){
        String[] cli = new String[100];
        cli = fullCommand.split(" ");
        return cli;
    }
}

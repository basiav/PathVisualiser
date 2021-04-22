import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class PropertiesLoader {
    private int boardRowsNumber;
    private int boardColumnsNumber;
    private int delay;
    private int chosenAlgorithm;
    private int generateObstaclesRandomly;
    private int obstaclesNumber;
    private int startRowsNumber;
    private int startColumnsNumber;
    private int endRowsNumber;
    private int endColumnsNumber;

    static public PropertiesLoader loadPropFromFile() throws FileNotFoundException,IllegalArgumentException {
        Gson gson = new Gson();
        File f = new File("");
        System.out.println(f.getAbsolutePath());
        PropertiesLoader properties =  (PropertiesLoader)gson.fromJson(new FileReader("src\\Config.json"), PropertiesLoader.class);
        return properties;
    }

    public int getBoardRowsNumber() { return boardRowsNumber; }
    public int getBoardColumnsNumber() { return boardColumnsNumber; }
    public int getDelay() { return delay; }
    public int getChosenAlgorithm() { return chosenAlgorithm; }
    public int getGenerateObstaclesRandomly() { return generateObstaclesRandomly; }

    public int getObstaclesNumber() { return obstaclesNumber; }
    public int getStartRowsNumber() { return startRowsNumber; }
    public int getStartColumnsNumber() { return startColumnsNumber; }
    public int getEndRowsNumber() { return endRowsNumber; }
    public int getEndColumnsNumber() { return endColumnsNumber; }

}

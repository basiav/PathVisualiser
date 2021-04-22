import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args){

        try{
            PropertiesLoader properties = PropertiesLoader.loadPropFromFile();

            Object[] defaultSimulationProperties = {
                    properties.getBoardRowsNumber(),
                    properties.getBoardColumnsNumber(),
                    properties.getDelay(),
                    properties.getChosenAlgorithm(),
                    properties.getGenerateObstaclesRandomly(),
                    properties.getObstaclesNumber(),
                    properties.getStartRowsNumber(),
                    properties.getStartColumnsNumber(),
                    properties.getEndRowsNumber(),
                    properties.getEndColumnsNumber()
            };

            SimulationStarter starter = new SimulationStarter();
            starter.startSimulation(defaultSimulationProperties);

        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
            return;
        }
        catch (FileNotFoundException ex) {
            System.out.println(ex);
            return;
        }
    }
}

import java.util.concurrent.ThreadLocalRandom;

public class SimulationStarter {

    public void startSimulation(Object[] defaultSimulationProperties) {
        int boardRowsNumber = (int) defaultSimulationProperties[0];
        int boardColumnsNumber = (int) defaultSimulationProperties[1];
        int delay = (int) defaultSimulationProperties[2];
        int chosenAlgorithmNumber = (int) defaultSimulationProperties[3];
        int generateObstaclesRandomly = (int) defaultSimulationProperties[4];
        int obstaclesNumber = (int) defaultSimulationProperties[5];
        int startRowsNumber = (int) defaultSimulationProperties[6];
        int startColumnsNumber = (int) defaultSimulationProperties[7];
        int endRowsNumber = (int) defaultSimulationProperties[8];
        int endColumnsNumber = (int) defaultSimulationProperties[9];

        PathAlgo chosenAlgorithm = PathAlgo.DFS;
        if (chosenAlgorithmNumber == 0)
            chosenAlgorithm = PathAlgo.DFS;
        if (chosenAlgorithmNumber == 1)
            chosenAlgorithm = PathAlgo.BFS;
        if (chosenAlgorithmNumber == 2)
            chosenAlgorithm = PathAlgo.AStar;

        NodeGrid nodeGrid = new NodeGrid(boardRowsNumber, boardColumnsNumber);
        nodeGrid.initialise();

        Point start = new Point(startRowsNumber, startColumnsNumber);
        Point end = new Point(endRowsNumber, endColumnsNumber);
        nodeGrid.setStartAndEnd(start, end);

        if (generateObstaclesRandomly == 1){
            generateObstaclesRandomly(nodeGrid, obstaclesNumber);
        }

        else {
            nodeGrid.setObstacle(1, 1);
            nodeGrid.setObstacle(40, 1);
            nodeGrid.setObstacle(9, 9);
            nodeGrid.setObstacle(40, 9);
            nodeGrid.setObstacle(1, 5);
            nodeGrid.setObstacle(8, 1);
            nodeGrid.setObstacle(20, 20);
            nodeGrid.setObstacle(39,39);
        }


        SimulationFrame simulationFrame = new SimulationFrame(nodeGrid, delay, chosenAlgorithm);
        simulationFrame.startSimulation();
    }

    public void generateObstaclesRandomly(NodeGrid nodeGrid, int obstaclesNumber){
        for (int i = 0; i < obstaclesNumber; i++){
            int randomRow = ThreadLocalRandom.current().nextInt(nodeGrid.rows);
            int randomColumn = ThreadLocalRandom.current().nextInt(nodeGrid.columns);
            if (nodeGrid.isInGridBounds(randomRow, randomColumn) && randomRow != nodeGrid.start.getRowCoordinate()
            && randomColumn != nodeGrid.start.getColumnCoordinate() && randomRow != nodeGrid.end.getRowCoordinate()
            && randomColumn != nodeGrid.end.getColumnCoordinate() && !nodeGrid.nodeGrid[randomRow][randomColumn].obstacle){
                nodeGrid.setObstacle(randomRow, randomColumn);
            }
        }
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationFrame implements ActionListener{
    BoardPanel boardPanel;
    NodeGrid nodeGrid;
    public int delay;
    public JFrame frame;
    public Timer timer;
    PathAlgo pathAlgo;
    BFS bfs;
    DFS dfs;
    AStar aStar;

    public SimulationFrame(NodeGrid nodeGrid, int delay, PathAlgo pathAlgo){
        this.nodeGrid = nodeGrid;
        this.delay = delay;
        this.pathAlgo = pathAlgo;

        bfs = new BFS(this.nodeGrid);
        dfs = new DFS(this.nodeGrid, this);
        aStar = new AStar(this.nodeGrid);
        this.timer = new Timer(delay, this);

        this.boardPanel = new BoardPanel(this.nodeGrid, this);

        frame = new JFrame("Pathfinder Visualiser");
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.add(this.boardPanel);
    }

    public void startSimulation(){

        this.timer.start();
        switch (this.pathAlgo){
            case BFS:
                bfs.runBFS();
                break;
            case DFS:
                dfs.runDFS();
                break;
            case AStar:
                aStar.runAStar();
                break;
        }
    }

    public void showPrimalBoard(){
        this.boardPanel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e){

        this.boardPanel.repaint();
        switch (this.pathAlgo) {
            case BFS:
                this.bfs.oneRoundRunning = true;
                break;
            case DFS:
                this.dfs.oneRoundRunning = true;
                break;
            case AStar:
                this.aStar.oneRoundRunning = true;
        }
    }

}

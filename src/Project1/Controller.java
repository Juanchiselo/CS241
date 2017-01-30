package Project1;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

import java.awt.*;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Controller
{
    @FXML
    private Pane gridPaneTreeView;

    @FXML
    private BorderPane borderPaneMain;

    @FXML
    private TextField textFieldSequence;

    @FXML
    private Button buttonClear;

    ArrayList<StackPane> nodes = new ArrayList<StackPane>();
    ArrayList<Line> links = new ArrayList<Line>();
    ArrayList<Integer> integers = new ArrayList<Integer>();
    ArrayList<String> strings = new ArrayList<String >();

    private double nodeRadius = 100;
    private Color nodeColor = Color.BLUE;
    private Font nodeFont = new Font("Times New Roman", 38);

    public void createBinarySearchTree() throws Exception
    {
        integers = Project1.parseStringToInteger(textFieldSequence.getText(), " ");

        for(int i = 0; i < integers.size(); i++)
        {
            nodes.add(createNode(integers.get(i)));
            positionNodes();
            connectNodes();
        }

        drawTree();
    }

    public void clearBinarySearchTree()
    {
        integers.clear();
        links.clear();
        gridPaneTreeView.getChildren().clear();
    }

    public StackPane createNode(int data)
    {
        StackPane nodePane = new StackPane();
        Circle nodeCircle = new Circle(nodeRadius, nodeColor);
        nodeCircle.setStroke(Color.WHITE);
        Label nodeLabel = new Label(Integer.toString(data));
        nodeLabel.setFont(nodeFont);
        nodeCircle.radiusProperty().bind(nodeLabel.widthProperty());
        nodePane.getChildren().addAll(nodeCircle, nodeLabel);
        return nodePane;
    }

    public void positionNodes()
    {
        nodes.get(0).setLayoutX(borderPaneMain.getWidth() / 2);
        nodes.get(0).setLayoutY(100);


        for(int i = 1; i < nodes.size(); i++)
        {
            if(i % 2 == 1)
            {
                nodes.get(i).setLayoutX(nodes.get(0).getLayoutX() - 20);
                nodes.get(i).setLayoutY(nodes.get(0).getLayoutY() + 50);
            }
            else
            {
                nodes.get(i).setLayoutX(nodes.get(0).getLayoutX() + 20);
                nodes.get(i).setLayoutY(nodes.get(0).getLayoutY() + 50);
            }
        }

    }

    public void connectNodes()
    {
        for(int i = 0; i < nodes.size() - 1; i++)
        {
            Line line = new Line();
            line.setStroke(Color.WHITE);
            line.setStrokeWidth(2);
            links.add(line);

            if(i % 2 == 1 || i == 0)
            {
                Circle circle = (Circle) nodes.get(i).getChildren().get(0);
                line.setStartX(nodes.get(i).getLayoutX());
                line.setStartY(nodes.get(i).getLayoutY());
                //line.startXProperty().bind(circle.centerXProperty());
                //line.startYProperty().bind(circle.centerYProperty());

                circle = (Circle) nodes.get(i + 1).getChildren().get(0);
                //line.endXProperty().bind(circle.centerXProperty());
                //line.endYProperty().bind(circle.centerYProperty());
                line.setEndX(nodes.get(i + 1).getLayoutX());
                line.setEndY(nodes.get(i + 1).getLayoutY());
            }
            else if(i % 2 == 0 && i != 0)
            {
                Circle circle = (Circle) nodes.get(i).getChildren().get(0);
                line.setStartX(nodes.get(i - 1).getLayoutX());
                line.setStartY(nodes.get(i - 1).getLayoutY());
                //line.startXProperty().bind(circle.centerXProperty());
                //line.startYProperty().bind(circle.centerYProperty());

                circle = (Circle) nodes.get(i + 1).getChildren().get(0);
                //line.endXProperty().bind(circle.centerXProperty());
                //line.endYProperty().bind(circle.centerYProperty());
                line.setEndX(nodes.get(i + 1).getLayoutX());
                line.setEndY(nodes.get(i + 1).getLayoutY());
            }


        }
    }

    public void drawTree()
    {
        buttonClear.fire();

        for (Line link: links)
            gridPaneTreeView.getChildren().add(link);

        for (StackPane node: nodes)
            gridPaneTreeView.getChildren().add(node);
    }
}

import java.util.LinkedList;

public interface ISearchAlgorithm {


     LinkedList<Node> generateChildren(Node node);
     public Node search(Node node);
    public boolean isGoal(Node node);
    public boolean isValid(Node node);
     public boolean  isExist(Node node);
     public static ISearchAlgorithm creat(){
         return new SearchAlgorithm();



     }






}

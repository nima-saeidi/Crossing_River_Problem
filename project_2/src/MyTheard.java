import java.util.LinkedList;

public class MyTheard implements Runnable{
     LinkedList<Node> unexpandedNodes=new LinkedList<>();
    LinkedList<Node> expandedNodes=new LinkedList<>();
      Node target;


    public MyTheard(LinkedList<Node> a,LinkedList<Node> b,Node start){

        unexpandedNodes.addAll(a);
        expandedNodes.addAll(b);

            unexpandedNodes.add(start);



        }
    @Override
    public void run() {

        search( );


    }
    public Node search( ){

        SearchAlgorithm searchAlgorithm=new SearchAlgorithm();
        while (unexpandedNodes.size()!=0) {

            target = unexpandedNodes.removeLast();

            if ( searchAlgorithm.isExist(target)) {
                continue;
            }
            if (searchAlgorithm.isGoal(target)) {
                return target;
            }

            if (!searchAlgorithm.isValid(target)) {
                expandedNodes.add(target);
                continue;
            }




            LinkedList<Node> children =searchAlgorithm. generateChildren(target);
            unexpandedNodes.addAll(children);
        }

        return null;


    }







}

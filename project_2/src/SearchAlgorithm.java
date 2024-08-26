import java.util.LinkedList;

public class SearchAlgorithm   implements ISearchAlgorithm{

    private LinkedList<Node> expandedNodes=new LinkedList<>();
    private  LinkedList<Node> unexpandedNodes=new LinkedList<>();
       private Node target;

//0 : boat / 1 : father / 2 : mother / 3 : police / 4 : thief / 5 : son1 / 6 : son2 / 7 : dauther1 / 8 : dauther2


    @Override
    public boolean isGoal(Node node) {
        return node.getState()[0]&&node.getState()[1]&&node.getState()[2]&&node.getState()[3]&&node.getState()[4]&&
                node.getState()[5]&&node.getState()[6]&&node.getState()[7]&&
                node.getState()[8];
    }

    @Override
    public boolean isValid(Node node) {


        boolean father = node.getState()[1];
        boolean mother = node.getState()[2];
        boolean police = node.getState()[3];
        boolean thief = node.getState()[4];
        boolean son1 = node.getState()[5];
        boolean son2 = node.getState()[6];
        boolean dauther1 = node.getState()[7];
        boolean dauther2 = node.getState()[8];

        boolean flag1,flag2,flag3;
        if (((!father) && (mother) && (!dauther1 ||!dauther2))||((father)&&(!mother)&&(dauther1||dauther2))){
            flag1=false;
        }
        else{
            flag1=true;
        }
        if (((!mother)&&(father)&&(!son1||!son2))||((mother)&&(!father)&&(son2||son1))){
            flag2=false;
        }
        else {
            flag2=true;
        }
        if( (
                ((!police)&&(thief)&&((mother)||(father)||(son1)||(son2)||(dauther2)||(dauther1)))
        )
                ||
                (
                        ((police)&&(!thief))&&((!mother)||(!father)||(!son1)||(!son2)||(!dauther1)||(!dauther2))
                )
        )
            flag3=false;



        else {
            flag3=true;
        }

        return flag1 && flag2 && flag3;



    }




    @Override
    public LinkedList<Node> generateChildren(Node node) {

        LinkedList<Node> childrenNodes = new LinkedList<>();
         for (int i = 1; i < node.getState().length; i++) {

             boolean[] state1=new boolean[9];
             for (int j = 0; j <state1.length ; j++) {
                state1[j]=node.getState()[j];
            }
             state1[0] = !node.getState()[0];  //boat
             if (node.getState()[i] == node.getState()[0]) {
                 state1[i] = ! state1[i];
            } else {
                continue;
            }

             Node child1 = new Node();
             child1.setFatherNode(node);
             child1.setState(state1);

             if ( i==1 || i==3 || i==2) {
                childrenNodes.add(child1);
            }

            for (int j = i + 1; j < node.getState().length; j++) {

                boolean[] state2 = new boolean[9];

                System.arraycopy(state1, 0, state2, 0, state2.length);


                if (node.getState()[j] == node.getState()[0]) {
                     state2[j] = ! state2[j];
                } else {
                    continue;
                }

                Node child2 = new Node();
                child2.setFatherNode(node);
                child2.setState( state2);

                if ((i==1 || i==3 || i==2) || ( j==1 || j==3 || j==2)) {
                    childrenNodes.add(child2);
                }
            }
        }
        return childrenNodes;
    }

    @Override
    public Node search(Node starterNode) {
        MyTheard myTheard=new MyTheard(unexpandedNodes,expandedNodes,starterNode);
        synchronized (unexpandedNodes){
            unexpandedNodes.add(starterNode);
        }
        Thread a= new Thread(myTheard);

        a.start();
        Thread b= new Thread(myTheard);
        b.start();
        Thread c= new Thread(myTheard);
        c.start();
        Thread d= new Thread(myTheard);
        d.start();

/*
        if (unexpandedNodes.size()==0){
            System.out.println("we cant solve it !!!!");
            return null;

        }

        while (unexpandedNodes.size()!=0) {

             target = unexpandedNodes.removeLast();

            if ( isExist(target)) {
                continue;
            }
            if (isGoal(target)) {
                return target;
            }

            if (!isValid(target)) {
                expandedNodes.add(target);
                continue;
            }*/
          synchronized (expandedNodes){
              expandedNodes.add(target);
          }

        return null;
    }


@Override
    public boolean  isExist(Node node) {
    for (Node expandedNode : expandedNodes) {
        if (node.equals(expandedNode)) {
            return true;
        }
    }
        return false;
    }
}

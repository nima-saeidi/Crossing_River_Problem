public class Node implements INode {
    // NIMA SAEIDI / SANA GHORBANI / SANA GHOLINAVAZ / BITA RAZPOOR
    //0 : boat / 1 : father / 2 : mother / 3 : police / 4 : thief / 5 : son1 / 6 : son2 / 7 : dauther1 / 8 : dauther2
    private Node fatherNode;
    private boolean[] state;

        INode h=INode.creat(search.Node);
 @Override
    public boolean equals(Node targetNode) {

        for (int i = 0; i < state.length; i++) {
            if (state[i] != targetNode.state[i]) {
                return false;
            }
        }
        return true;
    }
       @Override
    public String toString(Node node) {
        if (node.getFatherNode()!=null) {
            System.out.println("boat latest transfer :");
            boolean[] booleans = node.getFatherNode().getState();
            boolean[] r = node.getState();


            if (booleans[1] != r[1]) {
                System.out.println("father");
            }
            if (booleans[2] != r[2]) {
                System.out.println("mother");
            }
            if (booleans[5] != r[5]) {
                System.out.println("son1");
            }
            if (booleans[6] != r[6]) {
                System.out.println("son2");
            }
            if (booleans[3] != r[3]) {
                System.out.println("police");
            }
            if (booleans[4] != r[4]) {
                System.out.println("thief");
            }
            if (booleans[7] != r[7]) {
                System.out.println("duather1");
            }
            if (booleans[8] != r[8]) {
                System.out.println("duather2");
            }

            System.out.println("________________________________________");

            System.out.println("region 1 :");


            if (!state[3]) {
                System.out.println("police");
            }
            if (!state[4]) {
                System.out.println("thief");
            }
            if (!state[1]) {
                System.out.println("father");
            }
            if (!state[5]) {
                System.out.println("son1");
            }
            if (!state[6]) {
                System.out.println("son2");
            }
            if (!state[2]) {
                System.out.println("mother");
            }
            if (!state[7]) {
                System.out.println("dauther1");
            }
            if (!state[8]) {
                System.out.println("dauther2");
            }


            System.out.println("________________________________________");

            System.out.println("region 2 :");


            if (state[3]) {
                System.out.println("police");
            }
            if (state[4]) {
                System.out.println("thief");
            }
            if (state[1]) {
                System.out.println("father");
            }
            if (state[5]) {
                System.out.println("son1");
            }
            if (state[6]) {
                System.out.println("son2");
            }
            if (state[2]) {
                System.out.println("mother");
            }
            if (state[7]) {
                System.out.println("dauther1");
            }
            if (state[8]) {
                System.out.println("dauther2");
            }
            System.out.println("________________________________________");

            System.out.println("boat locatoin :");
            if (state[0]) {
                System.out.println("region 2 ");
            } else {
                System.out.println("region 1 ");
            }
        }
        else {
            System.out.println("boat latest transfer :");
            System.out.println("________________________________________");
                System.out.println("region 1 :");
                System.out.println("police");
                System.out.println("thief");
                System.out.println("father");
                System.out.println("son1");
                System.out.println("son2");
                System.out.println("mother");
                System.out.println("dauther1");
                System.out.println("dauther2");
            System.out.println("________________________________________");
                System.out.println("region 2 :");
                System.out.println("________________________________________");
            System.out.println("boat locatoin :");
            System.out.println("region 1 ");
        }

         return null;
    }
         @Override
    public Node Clone() {
        Node cloneNode = new Node();
        cloneNode.state = this.state.clone();
        cloneNode.fatherNode = this.fatherNode;
        return cloneNode;
    }
    @Override
    public boolean[] getState() {
        return state;
    }
    @Override
    public void setState(boolean[] State) {

        this. state = State.clone();
    }
    @Override
    public void setFatherNode(Node node) {
        fatherNode = node;
    }
    @Override
    public Node getFatherNode(){
        return fatherNode;
    }
}

public class Main {

    private static int transferIndex=0;

    private static Node initialNode(){
         Node initial=new Node();
        boolean[] state= {false,false,false,false,false,false,false,false,false};

        initial.setState(state);
        initial.setFatherNode(null);


     return initial;

    }

    private static void show(Node node){


        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("transfer index :");
        System.out.println(transferIndex);
        System.out.println("________________________________________");
        node.toString(node);

        transferIndex++;


    }


    private static void showPath(Node node){


        show(node);

        if (node.getFatherNode() != null) {
            showPath(node.getFatherNode());

        }

    }








    public static void main(String[] args) {
        SearchAlgorithm Search = new SearchAlgorithm();

        Node result= Search.search(initialNode());
        showPath(result);

    }


    }

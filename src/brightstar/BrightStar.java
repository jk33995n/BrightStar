
package brightstar;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BrightStar {
    
    public static void generateSolution(ArrayList<MeshClient> rClient, ArrayList<MeshNode> rNode, String filename) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        double origSize = rClient.size();
        int i = 0;
        while(i < rNode.size()){
            bw.write("\n");
            //System.out.println(rNode.get(i).toString());
            rNode.get(i).selectClients(rClient);
            rNode.get(i).nodeSummary();
            rNode.get(i).displayClients();
            rClient = rNode.get(i).removeClients(rClient);
            //System.out.println("CLIENTS REMAINING " + rClient.size());
            bw.write(rNode.get(i).toString()+"\n");
            bw.write("\t CLIENTS REMAINING " + rClient.size()+ "\n");
            bw.write("\t Number of Clients: " + Double.toString(origSize) + "\n");
            bw.write("\t Remaining Clients: " + Double.toString(rClient.size()) + "\n");
            bw.write("\n");
            bw.write("\t Clients NOT COVERED Percentage " + rClient.size()/origSize + "\n");
            i++;
        }
        bw.close();
    }

    public static void main(String[] args) {
        System.out.println("START Simulation");
        
        ArrayList<MeshClient> rClient = ClientFactory.generateClients(48,639);
        ArrayList<MeshNode> rNode = NodeFactory.generateNodes(16,639);
        double[] centerCoords = MeshSupport.getClientCenter(rClient);
        double[] maxCoords = MeshSupport.getClientOutlier(rClient);
        double[] minCoords = MeshSupport.getClosestClient(rClient);
        System.out.println("Client Center located at " + centerCoords[0] + "," + centerCoords[1]);
        System.out.println("Most Remote Client located at " + maxCoords[0] + "," + maxCoords[1]);
        System.out.println("Nearest Client located at " + minCoords[0] + "," + minCoords[1]);
        try {
            generateSolution(rClient,rNode,"C:\\Users\\Locklear\\Documents\\NetBeansProjects\\BrightStar\\src\\brightstar\\Solution");
            //generateSolution(rClient,rNode,"/BrightStar/src/brightstar/Solution");
        } catch (IOException ex) {
            Logger.getLogger(BrightStar.class.getName()).log(Level.SEVERE, null, ex);
        }   
               
        System.out.println("END Simulation");
        
    }
    
}


package brightstar;

import com.sun.security.ntlm.Client;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MeshNode {
    
    private String name;
    private int xCoord;
    private int yCoord;
    private ArrayList<MeshClient> clients;
    public static int nodeCount = 0;

    public MeshNode(int xCoord, int yCoord, ArrayList<MeshClient> clients) {
        this.name = "N0-"+nodeCount;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.clients = clients;
        nodeCount++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public ArrayList<MeshClient> getClients() {
        return clients;
    }

    public void setClients(ArrayList<MeshClient> clients) {
        this.clients = clients;
    }
    
    public int getClientCount(){
        return this.clients.size();
    }
    
    public void displayClients(){
        for(MeshClient c: this.clients){
            System.out.println(c.toString());
        }
    }
    
    public void nodeSummary(){
        System.out.println(this.name + " is serving " + this.getClientCount() + " clients ");
    }
    
    public void printClientsToFile(String filename){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            for(MeshClient c: this.clients){
                bw.write(c.toString());
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(MeshNode.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void selectClients(ArrayList<MeshClient> clientlist){
        for(MeshClient c: clientlist){
            if(MeshSupport.euclidean(this, c) < 50){
                this.clients.add(c);
            }
        }        
        
    }
    
    public void removeAllClients(){
        this.clients.removeAll(this.getClients());
    }
    
    public ArrayList<MeshClient> removeClients(ArrayList<MeshClient> clients){
        ArrayList<MeshClient> x = new ArrayList<>();
        for(MeshClient c: clients){
            if(!this.clients.contains(c)){
                x.add(c);
            }
        }
        return x;
    }
    @Override
    public String toString() {
        return "MeshNode{" + "name = " + name + ", xCoord = " + xCoord + ", yCoord = " + yCoord + ", clients = " + clients.size() + "}";
    }
    
    
    
    
}//END CLASS

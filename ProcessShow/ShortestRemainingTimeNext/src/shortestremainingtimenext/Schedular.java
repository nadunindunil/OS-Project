 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shortestremainingtimenext;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author Gimhani
 */
public class Schedular {
  PriorityQueue<Process> waitingQueue  =new PriorityQueue<Process>();
  PriorityQueue<Process> readyQueue  =new PriorityQueue<Process>();
  
    ArrayList<Process> processlist = new ArrayList<Process>();
     ArrayList<String> timelist = new ArrayList<String>();
     
     public void shedule(){
        int minServTime, minServInd, time=0, i;
        while(processlist.size()>0){
            minServTime=Integer.MAX_VALUE;
            minServInd=-1;
            i=0;
            while(i<processlist.size()){
                if(processlist.get(i).getServiceTime()==0) {
                    processlist.remove(i);
                    continue;
                }
                if(processlist.get(i).getStartTime()<=time){
                    if(processlist.get(i).getServiceTime()<minServTime || (processlist.get(i).getServiceTime()==minServTime && minServInd>i)){
                    minServTime=processlist.get(i).getServiceTime();
                    minServInd=i; 
                    }
                }
                i++;
            }
            if(minServInd>=0) {
                timelist.add((processlist.get(minServInd).getProcessId()));
                processlist.get(minServInd).setServiceTime((processlist.get(minServInd).getServiceTime())-1);
            }
            else timelist.add("Null");
            time++;
        }
        for(int k=0;k<timelist.size();k++){
            System.out.print(timelist.get(k)+" "); 
        }
     }
}


 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shortestremainingtimenext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;


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
     public void sheduleFCFS(){
         Process newprocess=new Process();
         Process min=newprocess;
         int Ttime=0;
         
         while(processlist.size()>0){
             if(min==newprocess){
          for(int i=0;i<processlist.size()-1;i++){
             if(processlist.get(i).getStartTime()<=processlist.get(i+1).getStartTime()){
                 min=processlist.get(i);}
             else{
                 min=processlist.get(i+1);
             }
         }
         }
         
             if(min.getServiceTime()==0){
                 if(min!=newprocess){
                 processlist.remove(min);
                 min=newprocess;
                 }
             }
             
             else if(min.getServiceTime()>0 ){
                 if(min.getStartTime()<=Ttime){
                 timelist.add(min.getProcessId());
                 min.setServiceTime(min.getServiceTime()-1);
             }
                 else{
                     timelist.add("Null");
                 }
             }
         
             
             Ttime++;
     }
         for(int k=0;k<timelist.size();k++){
            System.out.print(timelist.get(k)+" "); 
        }
     }
     public void scheduleRoundRobin(){
          // Sorts the array list using comparator according to the starttime
        Collections.sort(processlist, new Process());
         int timeQuantum=2;
         int tempQuantum=timeQuantum;
         int time=0;
         int i=0;
         while (processlist.size()>0){
             if (processlist.get(i).getStartTime()<=time){ //if the process has arrived at the time
                if (tempQuantum==0){                        //if the timequantum allocated has finished for the recently executed process
                    Process temp = processlist.remove(i);   // add that process to the end of the queue
                    processlist.add(temp);
                    tempQuantum=timeQuantum;            
                   
                }
                else {    
                    processlist.get(i).setServiceTime((processlist.get(i).getServiceTime())-1); //execute the process 
                    tempQuantum--;
                  
                    timelist.add(processlist.get(i).getProcessId());        
                }
                if (processlist.get(i).getServiceTime()==0){    //check if the process currenly has finished
                            processlist.remove(i);
                            tempQuantum=timeQuantum;
                          
                }
            
             }
        time++;                   
             
             
        } 
         for(int k=0;k<timelist.size();k++){
            System.out.print(timelist.get(k)+" "); 
        }
              
         
    }
             
             
             
         } 
         
         
         
         
         
         
         
         
      
     
     
     
     



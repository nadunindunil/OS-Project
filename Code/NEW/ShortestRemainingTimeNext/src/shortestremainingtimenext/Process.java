/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shortestremainingtimenext;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Gimhani
 */
public  class Process {
    private String name;
    private String processId;
    private int serviceTime;
    private int remainingTime;
    private int runningTime;
    private int startTime;
    private String endTime;
    boolean inprocess;
    
    Process(){
    remainingTime=serviceTime;};
    

    public Process(String name, String processId, int serviceTime, int startTime) {
        this.name = name;
        this.processId = processId;
        this.serviceTime = serviceTime;
        this.startTime = startTime;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    
    public Process(String processId, int serviceTime) {
        this.processId = processId;
        this.serviceTime = serviceTime;
        this.remainingTime = serviceTime;
        this.runningTime=0;
    }
    
    
    
    public String getProcessId() {
          return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
    public void calculateRemainingTime(){
        remainingTime=remainingTime-runningTime;

    }
    public void start(){
        String CurrentTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        //this.startTime=CurrentTime;    
    }

    public boolean isInprocess() {
        return inprocess;
    }

    public void setInprocess(boolean inprocess) {
        this.inprocess = inprocess;
    }
    
    
     
    
    
    
}

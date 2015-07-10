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
public abstract class Process {
    private String processId;
    private int serviceTime;
    private int remainingTime;
    private int runningTime;
    private String startTime;
    private String endTime;

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
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
        this.startTime=CurrentTime;    
    }
    
    
     
    
    
    
}

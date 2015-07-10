 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortestremainingtimenext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 *
 * @author Gimhani
 */
public class Schedular {

    ArrayList<Process> processlist = new ArrayList<Process>();
    ArrayList<Process> timelist = new ArrayList<Process>();

    public void SPN() {
        int minServTime, runingI, time = 0, i;
        runingI = Integer.MAX_VALUE;
        while (processlist.size() > 0) {
            minServTime = Integer.MAX_VALUE;
            i = 0;
            while (i < processlist.size()) {
                if (processlist.get(i).getServiceTime() < minServTime && processlist.get(i).getStartTime() <= time) {
                    runingI = i;
                    minServTime = processlist.get(i).getServiceTime();
                }
                i++;

            }
            while (minServTime > 0) {
                timelist.add(processlist.get(runingI));
                time++;
                minServTime--;

            }
            processlist.remove(runingI);

        }

        for (int k = 0; k < timelist.size(); k++) {
            System.out.print(timelist.get(k) + " ");
        }

    }

    public void shedule() {
        int minServTime, minServInd, time = 0, i;
        while (processlist.size() > 0) {
            minServTime = Integer.MAX_VALUE;
            minServInd = -1;
            i = 0;
            while (i < processlist.size()) {
                if (processlist.get(i).getServiceTime() == 0) {
                    processlist.remove(i);
                    continue;
                }
                if (processlist.get(i).getStartTime() <= time) {
                    if (processlist.get(i).getServiceTime() < minServTime || (processlist.get(i).getServiceTime() == minServTime && minServInd > i)) {
                        minServTime = processlist.get(i).getServiceTime();
                        minServInd = i;
                    }
                }
                i++;
            }
            if (minServInd >= 0) {
                timelist.add((processlist.get(minServInd)));
                processlist.get(minServInd).setServiceTime((processlist.get(minServInd).getServiceTime()) - 1);
            } else {
                timelist.add(null);
            }
            time++;
        }
        for (int k = 0; k < timelist.size(); k++) {
            System.out.print(timelist.get(k) + " ");
        }
    }

    public void sheduleFCFS() {
        Process newprocess = new Process();
        Process min = newprocess;
        int Ttime = 0;

        while (processlist.size() > 0) {
            if (min == newprocess) {
                for (int i = 0; i < processlist.size() - 1; i++) {
                    if (processlist.get(i).getStartTime() <= processlist.get(i + 1).getStartTime()) {
                        min = processlist.get(i);
                    } else {
                        min = processlist.get(i + 1);
                    }
                }
            }

            if (min.getServiceTime() == 0) {
                if (min != newprocess) {
                    processlist.remove(min);
                    min = newprocess;
                }
            } else if (min.getServiceTime() > 0) {
                if (min.getStartTime() <= Ttime) {
                    timelist.add(min);
                    min.setServiceTime(min.getServiceTime() - 1);
                } else {
                    timelist.add(null);
                }
            }

            Ttime++;
        }
        for (int k = 0; k < timelist.size(); k++) {
            System.out.print(timelist.get(k) + " ");
        }
    }

    public void feedback() {
        Queue[] queue_set = new Queue[5];//let 5 priority feedback levels
        boolean isProcessesOver = false;
        
        int time = 0;
        while (isProcessesOver != true) {
            if(!processlist.isEmpty()){
            for (Process p : processlist) {
                if (time == p.getStartTime()) {
                    System.out.println(p.getProcessId());
                    queue_set[0].add(p);
                }
            }
            }
            for (int j = 0; j < 5; j++) {
                if (queue_set[j].peek() != null) {
                    Process p = (Process) queue_set[j].poll();
                    if (p.getStartTime() <= time) {
                        timelist.add(p);
                        p.setServiceTime(p.getServiceTime() - 1);
                        if (p.getServiceTime() > 0) {
                            if (j != 4) {
                                queue_set[j + 1].add(p);
                            } else {          //if last queue add to same queue as in round robin
                                queue_set[j].add(p);
                            }
                        }
                    } else {
                        timelist.add(null);
                    }
                }
            }

            time++;
        }
        for (int k = 0; k < timelist.size(); k++) {
            System.out.print(timelist.get(k) + " ");
        }
    }
}

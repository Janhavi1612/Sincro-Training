package com.sincro.practice.callCentre;

import java.util.concurrent.Semaphore;

public class Agents {
    private Semaphore agentSemaphore;
    private AgentRank agentRank;

    public Agents(int numberOfAgents, AgentRank agentRank){
        agentSemaphore = new Semaphore(numberOfAgents);
        this.agentRank = agentRank;
    }

    public boolean checkIfFreeAndAssignCall(){
        boolean agentAvailable = agentSemaphore.tryAcquire();
        if(agentAvailable){
            System.out.println("Customer: "+Thread.currentThread()+" call attended by "+agentRank.toString());

            endCall();
        }

        return agentAvailable;
    }



    public void endCall(){
        try {
            Thread.currentThread().sleep(50);
        } catch (InterruptedException e) {
            System.out.println("Error occurred while disconnecting");
            Thread.currentThread().interrupt();
        }
        agentSemaphore.release(1);
    }

}

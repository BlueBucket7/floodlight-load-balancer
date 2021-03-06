/**
 *    Copyright 2013, Big Switch Networks, Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License"); you may
 *    not use this file except in compliance with the License. You may obtain
 *    a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *    WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *    License for the specific language governing permissions and limitations
 *    under the License.
 **/

package net.floodlightcontroller.loadbalancer;

import java.util.ArrayList;
import java.util.Random;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import net.floodlightcontroller.loadbalancer.LoadBalancer.IPClient;

/**
 * Data structure for Load Balancer based on
 * Quantum proposal http://wiki.openstack.org/LBaaS/CoreResourceModel/proposal 
 * 
 * @author KC Wang
 */


@JsonSerialize(using=LBPoolSerializer.class)
public class LBPool {
    protected String id;
    protected String name;
    protected String tenantId;
    protected String netId;
    protected short lbMethod;
    protected byte protocol;
    protected ArrayList<String> members;
    protected ArrayList<String> monitors;
    protected short adminState;
    protected short status;
    
    protected String vipId;
    
    protected int previousMemberIndex;    
    
    protected boolean dynamic;    
    
    public LBPool() {
        id = String.valueOf((int) (Math.random()*10000));
        name = null;
        tenantId = null;
        netId = null;
        lbMethod = 0;
        protocol = 0;
        members = new ArrayList<String>();
        monitors = new ArrayList<String>();
        adminState = 0;
        status = 0;
        previousMemberIndex = -1;
        
        //NEW
        dynamic = false;
        //END
    }
    
    public String pickMember(IPClient client) {
        // simple round robin for now; add different lbmethod later
    	
        if (members.size() > 0) {
            previousMemberIndex = (previousMemberIndex + 1) % members.size();
            return members.get(previousMemberIndex);
        } else {
            return null;
        }
    }
    
    public String pickMemberDynamically(IPClient client, ArrayList<Integer> weights) {    	
    	
    	//At this point, its guaranteed that members is bigger than 0 and the total of all member weights in the pool equals to 100.    	
    	boolean recall = true;
    	int selection = 0;
    	
    	for (int i=0; i<weights.size(); i++) {
    		if (new Random().nextInt(100) <= (weights.get(i)-1) ) {
    			selection = i;
    			recall = false;
    			break;
    		}
    	}    	
    	
    	if (recall) {
    		return pickMemberDynamically(client, weights);
    	} else {
    		return members.get(selection);
    	}   	
    }
    
//    public String pickCertainServer (IPClient client) {
//    	
//    	if (members.size() > 0) {            
//            return members.get(0);
//        } else {
//            return null;
//        }
//    }
    
    public boolean checkWeightDist (ArrayList<Integer> weights) {
    	int totalWeight = 0;
    	for (int i=0; i<weights.size(); i++) {
    		totalWeight += weights.get(i);
    	}
    	
    	if (totalWeight == 100)
    		return true;
    	
		return false;
    }

}

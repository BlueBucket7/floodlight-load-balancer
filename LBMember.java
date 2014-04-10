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

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Data structure for Load Balancer based on
 * Quantum proposal http://wiki.openstack.org/LBaaS/CoreResourceModel/proposal 
 * 
 * @author KC Wang
 */

@JsonSerialize(using=LBMemberSerializer.class)
public class LBMember {
    protected String id;
    protected int address;
    protected String addressStr;
    protected short port;
    protected String macString;
    
    protected int connectionLimit;
    protected short adminState;
    protected short status;

    protected String poolId;
    protected String vipId;
        
    protected int weight;
    //protected boolean dynamic;
    
    
    public LBMember() {
        id = String.valueOf((int) (Math.random()*10000));
        address = 0;
        addressStr = null;
        macString = null;
        port = 0;
        
        connectionLimit = 0;
        adminState = 0;
        status = 0;
        poolId = null;
        vipId = null;   
       
        weight  = 0;
        //dynamic = false;
    }
}

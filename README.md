floodlight-load-balancer
========================

package: net.floodlightcontroller.loadbalancer

|---------------------------------------------------------------------------------------------------------------------|
SUMMARY:

This branch will serve as milestone 1. Dynamic load balncing functionality and related frameworks complete.
|---------------------------------------------------------------------------------------------------------------------|

|---------------------------------------------------------------------------------------------------------------------|
FUNCTIONALITIES:

1. Deletion of pool enabled
2. Deletion of member enabled
3. Dynamic load balnciing enabled. Weighted round robin algorithm applied using recursion.
4. Loadbalacing options provided. No longer defaults to round robin. Framework now takes a loadbalancing method as a parameter.
|---------------------------------------------------------------------------------------------------------------------|

|---------------------------------------------------------------------------------------------------------------------|
TO DO:

1. Test uri locally (mile stone 1.2)
2. Integrate with node.js scripts (mile stone 1.3)
|---------------------------------------------------------------------------------------------------------------------|

|---------------------------------------------------------------------------------------------------------------------|
QUESTIONS/CONCERNS (please add and commit to this section if you have answers):

1. Can ICMP ping request alone accurately describe the state of the servers? It's possible the servers are overloaded by other protocol requests, but still reply to ICMP pings.
|---------------------------------------------------------------------------------------------------------------------|

|---------------------------------------------------------------------------------------------------------------------|
BRIEF LOOK AT MILESTONE 2:

Milestone 2 will enable load balancing for different protocols. Proposed protocols are: UDP, TCP, and DHCP.
|---------------------------------------------------------------------------------------------------------------------|

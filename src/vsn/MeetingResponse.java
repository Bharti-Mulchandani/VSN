/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sony
 */
public class MeetingResponse {

    public enum MeetingResponses {

        Available, Busy, Upgradable
    }

    HashMap<String, MeetingResponses> MeetingRespMap = new HashMap<String, MeetingResponses>();

    //AGENTNAME##SLOTNO

    public MeetingResponse(int startSlot, int endSlot, ArrayList<Person> Attendees, HashMap<Person, Agent> pa) {
        Utilities utils = new Utilities();
        for (Person p : Attendees) {
            Agent a = utils.getAgentByPerson(pa, p);
            for (int i = startSlot; i <= endSlot; i++) {
                MeetingRespMap.put(a.getName() + "##" + i, MeetingResponses.Available);
            }
        }
    }
    
    public MeetingResponses getMeetingResponse(String AgentSlot){
        for (Map.Entry<String, MeetingResponses> entry : MeetingRespMap.entrySet()) {
            if (AgentSlot.equals(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }
//    public void setMeetingResponse(int startSlot, int endSlot, Agent a, String response)
}

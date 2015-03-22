/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsn;

import java.util.*;

/**
 *
 * @author Sony
 */
public class Person {

    private String Name;
    private ArrayList<Meeting> meetingsInitiated; //meetings the person has initiated
    private ArrayList<Meeting> meetingsInvited; //meetings he has been invited to
//    private int Priority;

    /*
     Functions to create
     Call Agent
     */
    public Person(String Name/*, int Priority*/){
        this.Name = Name;
//        this.Priority = Priority;
    }
//    private HashMap<Person, Agent> AgentMapper;
//    private Agent MyAgent;
//    public Person(String Name/*, HashMap<Person, Agent> AgentMapper, Agent MyAgent*/) {
//        this.Name = Name;
//        this.AgentMapper = AgentMapper;
//        this.MyAgent = MyAgent;
//    }
//    public Agent getAgentByPerson(Person p) {
//        return this.AgentMapper.get(p);
//    }
//    public Agent getMyAgent() {
//        return MyAgent;
//    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }
    
    public ArrayList<Meeting> getMeetingsInitiated(){
        return meetingsInitiated;
    }
    public void setMeetingInitiated(Meeting meet){
        meetingsInitiated.add(meet);
    }
    
    public ArrayList<Meeting> getMeetingsInvited(){
        return meetingsInvited;
    }
    
    public void setMeetingInvited(Meeting meet){
        meetingsInvited.add(meet);
    }
    
}

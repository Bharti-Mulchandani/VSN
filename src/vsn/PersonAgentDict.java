/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsn;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 *
 * @author Sony
 */
public class PersonAgentDict {

    private HashMap<Person, Agent> PAMapper = new HashMap<>();

    public PersonAgentDict(ArrayList<Person> pArr) {
        for (Person p : pArr) {
            PAMapper.put(p, new Agent("A"+p.getName()));
        }
    }

    public HashMap<Person, Agent> getMapper() {
        return PAMapper;
    }
    
//    public Agent getAgentByPerson(Person p){
//        for(Entry<Person,Agent> entry : PAMapper.entrySet()){
//            if(p.equals(entry.getKey())){
//                return entry.getValue();
//            }
//        }
//        return null;
//    }
}

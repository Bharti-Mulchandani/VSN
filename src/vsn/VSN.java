/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsn;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Sony
 */
public class VSN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println(Math.ceil((double)48/15));
//        TimeSlots ts = new TimeSlots();
//        Date d = ts.getDate(95);
//        int slot = ts.getTimeSlot("21/03/2015 05:15 AM");
//        System.out.println("GET TIME"+d.getHours()+":"+d.getMinutes());
//        System.out.println("GET SLOT"+ slot);
//        System.exit(0);
        ArrayList<Person> personArray = new ArrayList<Person>();
        Utilities utils = new Utilities();
        ArrayList<Meeting> meetingArray = new ArrayList<Meeting>();
        
        int MeetingCount = 0;
        int GroupStrength = 0;
        int MaxAttendees = 0;
        int MinAttendees = 0;
        int MinDuration = 0;
        int MaxDuration = 0;
//        int AvgDuration = 0;
        int MinMeetingP = 0;
        int MaxMeetingP = 0;
        int delta = 0;
//        int MinPersonP = 0;
//        int MaxPersonP = 0;
        Random mPPRand = new Random();
        
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Number of Meetings to be Scheduled:");
        MeetingCount = in.nextInt();
        
        System.out.println("Enter Number of Persons in a Group:");
        GroupStrength = in.nextInt();
        
        System.out.println("Enter Maximum Members in a Meeting:");
        MaxAttendees = in.nextInt();
        
        System.out.println("Enter Minimum Members in a Meeting:");
        MinAttendees = in.nextInt();
        
        System.out.println("Enter Minimum Duration of a Meeting in Minutes:");
        MinDuration = in.nextInt();
        
        System.out.println("Enter Maximum Duration of a Meeting in Minutes:");
        MaxDuration = in.nextInt();
        
//        System.out.println("Enter Maximum Priority of a Person : ");
//        MaxPersonP = in.nextInt();
        
//        System.out.println("Enter Minimum Priority of a Person : ");
//        MinPersonP = in.nextInt();
        
        System.out.println("Enter Minimum Priority of a Meeting : ");
        MinMeetingP = in.nextInt();
        
        System.out.println("Enter Maximum Priority of a Meeting : ");
        MaxMeetingP = in.nextInt();
        
        System.out.println("Enter Estimated time (int Minutes) for negotiation (Delta):");
        delta = in.nextInt();
        
        /*Generating Person Objects based on Group Strength*/
        personArray = utils.generatePersonArrayList(GroupStrength);
        
        /*Generate Person Agent Mapper*/
        PersonAgentDict pAD = new PersonAgentDict(personArray);
        HashMap<Person,Agent> PersonAgentMapper = pAD.getMapper();
        
//        utils.getAgentByPerson(PersonAgentMapper,personArray.get(2));
        
        
        // Start Generate Meeting List.
        meetingArray = utils.generateMeetings(MeetingCount, personArray, MaxAttendees, MinAttendees, MinDuration, MaxDuration, MinMeetingP, MaxMeetingP, delta, PersonAgentMapper);
        
    }

}

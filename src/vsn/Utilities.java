/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsn;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

/**
 *
 * @author Sony
 */
public class Utilities {

    public ArrayList<Person> generatePersonArrayList(int GroupStrength) {
        Random mPPRand = new Random();
        ArrayList<Person> personArray = new ArrayList<>();
        for (int gs = 0; gs < GroupStrength; gs++) {
            String PersonName = "P" + (gs + 1);
//            int Priority = mPPRand.nextInt((MaxPersonP - MinPersonP) + 1) + MinPersonP;
            personArray.add(new Person(PersonName/*, Priority*/));
        }
        return personArray;

    }

    public Agent getAgentByPerson(HashMap<Person, Agent> pa, Person p) {
        for (Entry<Person, Agent> entry : pa.entrySet()) {
            if (p.equals(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

    public ArrayList<Meeting> generateMeetings(int MeetingCount, ArrayList<Person> person, int MaxAttendees,
            int MinAttendees, int MinDuration, int MaxDuration, int MinMeetingP, int MaxMeetingP, int delta,
            HashMap<Person,Agent> personAgentMapper) {
        ArrayList<Meeting> meetings = new ArrayList<>();
        Random randAll = new Random();
        TimeSlots ts = new TimeSlots();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
        for (int i = 0; i < MeetingCount; i++) {
            int CurrentSlot = ts.getTimeSlot(sdf.format(new Date()));
            Meeting meet = new Meeting();
            meet.setStartTime(randAll.nextInt((95 - CurrentSlot) + 1) + CurrentSlot);
            meet.setActualStartTime(99);
            meet.setMinDuration(randAll.nextInt((MaxDuration - MinDuration) + 1) + MinDuration);
            int MinDurationSlot = ConvertDurationToSlots(meet.getMinDuration());
            meet.setMaxDuration(randAll.nextInt((MaxDuration - meet.getMinDuration()) + 1) + meet.getMinDuration());
            int MaxDurationSlot = ConvertDurationToSlots(meet.getMaxDuration());
            int hardSlot = getHardDeadLineSlot(meet.getStartTime(), MaxDurationSlot);
            meet.setHardDeadLine(randAll.nextInt((95 - hardSlot) + 1) + hardSlot);
            int deltaSlot = ConvertDurationToSlots(delta);
            meet.setSoftDeadLine(randAll.nextInt((meet.getHardDeadLine()-deltaSlot)+1)+deltaSlot);

            //Attendees Details
            int Attendees = randAll.nextInt((MaxAttendees - MinAttendees) + 1) + MinAttendees;
            ArrayList<Person> mPerson = new ArrayList<Person>();
            HashMap<Person, Integer> essentials = new HashMap<Person, Integer>();
            int count = 0;
            while (count != Attendees) {
                int randInt = randAll.nextInt(person.size());
                if (!mPerson.contains(person.get(randInt))) {
                    Person p = person.get(randInt);
                    mPerson.add(p);
                    essentials.put(p, randAll.nextInt(2));
                    count++;
                }
            }

            int essentialCount = getEssentialCount(essentials);
            meet.setAttendee(mPerson);
            meet.setEssentialAttendees(essentials);
            meet.setInitiator(mPerson.get(randAll.nextInt(mPerson.size())));
            
            meet.setQuorum(randAll.nextInt((Attendees-essentialCount)+1)+essentialCount);
            meet.setPreferredTimeSlot(randAll.nextInt((meet.getHardDeadLine()-meet.getStartTime())+1)+meet.getStartTime());
            
            meet.setMeetingPriority(randAll.nextInt((MaxMeetingP-MinMeetingP)+1)+MinMeetingP);

            
            //Initialize and Add MeetingResponse
            MeetingResponse mr = new MeetingResponse(meet.getStartTime(), meet.getHardDeadLine(), mPerson, personAgentMapper);
            meet.setResponse(mr);
            
            //Make Entries in Persons MeetingInitiated
            meet.getInitiator().setMeetingInitiated(meet);
            meetings.add(meet);
        }
        return null;
    }

    public int ConvertDurationToSlots(int Duration) {
        return (int) Math.ceil((double) Duration / 15);
    }

    public int getHardDeadLineSlot(int StartTime, int MaxDurationSlot) {
        int sum = StartTime + MaxDurationSlot;
        int retInt = 0;
        if (sum > 95) {
            retInt = sum - 96;
        } else {
            retInt = sum;
        }
        return retInt;
    }

    public int getEssentialCount(HashMap<Person, Integer> hpi) {
        int count = 0;
        for (Entry<Person, Integer> entry : hpi.entrySet()) {
            if (entry.getValue() == 1) {
                count++;
            }
        }
        return count;
    }
}

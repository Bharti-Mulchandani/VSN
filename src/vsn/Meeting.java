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
public class Meeting {
//    public enum MeetingResponse {
//
//        Available, Busy, Upgradable
//    }

    private int StartTime;
    private int ActualStartTime; //minimum persons required for meeting
    private int HardDeadLine;
    private int SoftDeadLine;
    private int MinDuration;
    private int MaxDuration;
    private int Essential;
    private ArrayList<Person> Attendee;
//    private ArrayList<Meeting.MeetingResponse> AttendeeResponse;
    private int MeetingPriority;
    private HashMap<Person, Integer> EssentialAttendees;
    private String Description;
    private String Location;
    private MeetingResponse Response;
    private boolean Upgradable;
    private int Quorum;
    private int PreferredTimeSlot;
    private Person initiator;
//    private ArrayList<>

//    public void GenerateMeeting() {
//        Random rand = new Random();
//
//        StartTime = java.util.Calendar.getInstance();
//        int Date = rand.nextInt(30) + 1;
//        int Hour = rand.nextInt(24) + 1;
//        int min = rand.nextInt(60) + 1;
//
//        StartTime.set(2015, 03, Date, Hour, min);
//        Duration = rand.nextInt(180);
//
//    }

    /**
     * @return the StartTime
     */
    public int getStartTime() {
        return StartTime;
    }

    /**
     * @param StartTime the StartTime to set
     */
    public void setStartTime(int StartTime) {
        this.StartTime = StartTime;
    }

    /**
     * @return the ActualStartTime
     */
    public int getActualStartTime() {
        return ActualStartTime;
    }

    /**
     * @param ActualStartTime the ActualStartTime to set
     */
    public void setActualStartTime(int ActualStartTime) {
        this.ActualStartTime = ActualStartTime;
    }

    /**
     * @return the HardDeadLine
     */
    public int getHardDeadLine() {
        return HardDeadLine;
    }

    /**
     * @param HardDeadLine the HardDeadLine to set
     */
    public void setHardDeadLine(int HardDeadLine) {
        this.HardDeadLine = HardDeadLine;
    }

    /**
     * @return the SoftDeadLine
     */
    public int getSoftDeadLine() {
        return SoftDeadLine;
    }

    /**
     * @param SoftDeadLine the SoftDeadLine to set
     */
    public void setSoftDeadLine(int SoftDeadLine) {
        this.SoftDeadLine = SoftDeadLine;
    }

    /**
     * @return the Duration
     */
    public int getMinDuration() {
        return MinDuration;
    }

    /**
     * @param Duration the Duration to set
     */
    public void setMinDuration(int Duration) {
        this.MinDuration = Duration;
    }

    /**
     * @return the Essential
     */
    public int getEssential() {
        return Essential;
    }

    /**
     * @param Essential the Essential to set
     */
    public void setEssential(int Essential) {
        this.Essential = Essential;
    }

    /**
     * @return the Attendee
     */
    public ArrayList<Person> getAttendee() {
        return Attendee;
    }

    /**
     * @param Attendee the Attendee to set
     */
    public void setAttendee(ArrayList<Person> Attendee) {
        this.Attendee = Attendee;
    }

    /**
     * @return the AttendeePriority
     */
    public int getMeetingPriority() {
        return MeetingPriority;
    }

    /**
     * @param AttendeePriority the AttendeePriority to set
     */
    public void setMeetingPriority(int MeetingPriority) {
        this.MeetingPriority = MeetingPriority;
    }

    /**
     * @return the EssentialAttendees
     */
    public HashMap<Person, Integer> getEssentialAttendees() {
        return EssentialAttendees;
    }

    /**
     * @param EssentialAttendees the EssentialAttendees to set
     */
    public void setEssentialAttendees(HashMap<Person, Integer> EssentialAttendees) {
        this.EssentialAttendees = EssentialAttendees;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * @return the Location
     */
    public String getLocation() {
        return Location;
    }

    /**
     * @param Location the Location to set
     */
    public void setLocation(String Location) {
        this.Location = Location;
    }

    /**
     * @return the Response
     */
    public MeetingResponse getResponse() {
        return Response;
    }

    /**
     * @param Response the Response to set
     */
    public void setResponse(MeetingResponse Response) {
        this.Response = Response;
    }

    /**
     * @return the Upgradable
     */
    public boolean isUpgradable() {
        return Upgradable;
    }

    /**
     * @param Upgradable the Upgradable to set
     */
    public void setUpgradable(boolean Upgradable) {
        this.Upgradable = Upgradable;
    }

    /**
     * @return the MaxDuration
     */
    public int getMaxDuration() {
        return MaxDuration;
    }

    /**
     * @param MaxDuration the MaxDuration to set
     */
    public void setMaxDuration(int MaxDuration) {
        this.MaxDuration = MaxDuration;
    }

    /**
     * @return the Quorum
     */
    public int getQuorum() {
        return Quorum;
    }

    /**
     * @param Quorum the Quorum to set
     */
    public void setQuorum(int Quorum) {
        this.Quorum = Quorum;
    }

    /**
     * @return the PreferredTimeSlot
     */
    public int getPreferredTimeSlot() {
        return PreferredTimeSlot;
    }

    /**
     * @param PreferredTimeSlot the PreferredTimeSlot to set
     */
    public void setPreferredTimeSlot(int PreferredTimeSlot) {
        this.PreferredTimeSlot = PreferredTimeSlot;
    }

    /**
     * @return the initiator
     */
    public Person getInitiator() {
        return initiator;
    }

    /**
     * @param initiator the initiator to set
     */
    public void setInitiator(Person initiator) {
        this.initiator = initiator;
    }
}

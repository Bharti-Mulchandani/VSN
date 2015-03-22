/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsn;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Dictionary;
/**
 * 
 * @author Sony
 */
public class Schedule {
    private ArrayList<Meeting> meetings;
//    public Meeting.MeetingResponse getAvailability(Calendar meetTime,int duration)
//    {
//        boolean Available=true,Busy=false,Upgradable=false;
//            for(Meeting m:meetings)
//            {
//                //Calendar startTime=m.ActualStartTime;
//                //Calendar EndTime=m.ActualStartTime;
//                if(meetTime.before(m.getActualStartTime()))
//                {
//                    meetTime.add(Calendar.MINUTE, duration);
//                  if(meetTime.after(m.getActualStartTime()))
//                  {
//                  if(m.isUpgradable())
//                       Upgradable=true;
//                  else
//                      Busy=true;
//                  }
//                }
//            }
//            if(Busy)
//                return Meeting.MeetingResponse.Busy;
//            if(Upgradable)
//                return Meeting.MeetingResponse.Upgradable;
//            return Meeting.MeetingResponse.Available;
//    }
    public void AddMeeting(Meeting m)
    {
        meetings.add(m);
    }
}

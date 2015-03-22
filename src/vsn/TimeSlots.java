/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sony
 */
public class TimeSlots {

    HashMap<Date, Integer> calMap = new HashMap<Date, Integer>();

    public TimeSlots() {
        String format = "dd/MM/yyyy hh:mm a";
        long diff = 0;
        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            String dateCurrent = sdf1.format(date).toString();
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            String time = dateCurrent + " 00:00 AM";
            diff = sdf.parse(time).getTime();
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        for (int i = 0; i < 96; i++) {

            calMap.put(new Date(diff), i);
            diff = diff + 900000;
        }
    }

    public Date getDate(int slot) {
        for (Map.Entry<Date, Integer> entry : calMap.entrySet()) {
            if (slot == entry.getValue()) {
                return entry.getKey();
            }
        }
        return null;
    }

    public int getTimeSlot(String Sdate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
            Date Ddate = sdf.parse(Sdate);
            Ddate.setMinutes(roundMinutes(Ddate.getMinutes()));
            for (Map.Entry<Date, Integer> entry : calMap.entrySet()) {
                if (Ddate.equals(entry.getKey())) {
                    return entry.getValue();
                }
            }
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return 99;
    }
    public int roundMinutes(int Minutes){
        int retMin = 0;
        int mod = Minutes%15;
        if(Minutes<=15){
            retMin = 15;
        }else{
            retMin = Minutes+(15-mod);
        }
        return retMin;
    }
}

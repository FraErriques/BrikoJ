package Common.Calendar;

import java.time.*;

public class CalendarService 
{
  // private ...

    public String getCurrentTimeStamp()
    {
//        java.util.Date date = new java.util.Date();
//        int year = date.getYear() +1900;

 //works in jdk 1.8        
        java.time.LocalDateTime tm = java.time.LocalDateTime.now();
        java.time.DayOfWeek weekDay = tm.getDayOfWeek();
        int yearDay = tm.getDayOfYear();
        String res = tm.toString();
        String datePortion = res.substring( 0, 10);
        String timePortion = res.substring( 11, 16);
        StringBuilder sb = new StringBuilder();
        sb.append(datePortion);
        sb.append(" ");
        sb.append("weekDay:"+weekDay.toString());
        sb.append(" ");
        String yds = java.lang.Integer.toString(yearDay);
        sb.append("yearDay:"+  yds );
        sb.append("  time: ");
        sb.append( timePortion);
        String formattedRes = new String( sb.toString() );
        return formattedRes;
        
//return "NOT YET";
    }
	
}

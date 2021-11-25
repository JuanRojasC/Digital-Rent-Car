package com.digital_booking.api_features.util;

import com.google.common.base.Strings;
import lombok.Data;

@Data
public class Log {

    public static String formatLog(String processName, String message){
        Integer processNameSize = 24;
        Integer repeats = processNameSize - processName.length();
        String processNameFormat = new String();
        if(processName.length() < processNameSize){
            processNameFormat = "[" + processName + Strings.repeat(" ", repeats) + "]";
        }else{
            processNameFormat = "[" + processName.substring(0,processNameSize) + "]";
        }
        return  processNameFormat + " : " + message;
    }


}

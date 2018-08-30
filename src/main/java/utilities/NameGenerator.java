package utilities;

import java.util.Calendar;

public class NameGenerator {

    public static String generateName(String name) {

        Calendar calendar = Calendar.getInstance();
        String username = name +
                calendar.get(Calendar.YEAR) +
                String.format("%02d", calendar.get(Calendar.MONTH)+1) +
                String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH))+
                String.format("%02d", calendar.get(Calendar.HOUR_OF_DAY)) +
                String.format("%02d", calendar.get(Calendar.MINUTE)) +
                String.format("%02d", calendar.get(Calendar.SECOND));

        return username;
    }

}

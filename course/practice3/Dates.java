package practice3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java .util.ResourceBundle;

public class Dates {


    

    public static void main(String[] args) {
    	 
    	var x = LocalDate.of(2022, 3, 1);
    	var y = LocalDateTime.of(2022, 1, 1, 2, 55);
    	var f = DateTimeFormatter.ofPattern("yyyy-MM hh:mm");
    	System.out.print(/*f.format(x) + ' ' +*/ f.format(y));
    	
//        Locale locale = Locale.UK;
//        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
//        NumberFormat percentFormat = NumberFormat.getPercentInstance(locale);
//        percentFormat.setMinimumFractionDigits(2);
//        
//        BigDecimal price = BigDecimal.valueOf(1.85);
//        BigDecimal rate = BigDecimal.valueOf(0.065);
//        price = price.multiply(rate).setScale(2,RoundingMode.HALF_UP);        
//        String priceTxt = currencyFormat.format(price);
//        String rateTxt = percentFormat.format(rate);
//
//
//
//        LocalDate today = LocalDate.now();
//        LocalTime teaTime = LocalTime.of(17,30);
//        Duration timeGap = Duration.between(LocalTime.now(), teaTime);
//        LocalDateTime tomorrowTeaTime = LocalDateTime.of(today.plusDays(1), teaTime);
//        
//        
//        ZoneId london = ZoneId.of("Europe/London");
//        ZonedDateTime londonTime = ZonedDateTime.of(tomorrowTeaTime,london);
//        


//        String datePattern = "EE', 'd' of 'MMMM yyyy' at 'HH:mm z";
        String datePattern2 = "MMMM' at 'h' o'clock'";
//        //DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(datePattern, locale);
//        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(datePattern);
//        DateTimeFormatter dateFormat2 = DateTimeFormatter.ofPattern(datePattern2);
//        String timeTxt = dateFormat.format(londonTime);
//        String timeTxt2 = dateFormat2.format(londonTime);
//        System.out.println(timeTxt);
//        System.out.println(timeTxt2);
        
        
        
        
        //ResourceBundle msg = ResourceBundle.getBundle("messages", locale);
//        ResourceBundle msg = ResourceBundle.getBundle("messages");
//        String offerPattern = msg.getString("offer");
//        String teaTxt = "Tea";

        //String msgTxt = MessageFormat.format(offerPattern, teaTxt, priceTxt, rateTxt, timeTxt);
        

    }



    
}

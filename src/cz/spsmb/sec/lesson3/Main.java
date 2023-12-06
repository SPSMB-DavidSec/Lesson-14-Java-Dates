package cz.spsmb.sec.lesson3;

import javax.swing.text.DateFormatter;
import java.text.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    // formát den v týdnu den.měsíc.rok (středa 06.prosince.2023)
    static DateFormat czechDateFormat = new SimpleDateFormat("EEEE dd.MMMM.yyyy", Locale.getDefault());
    static DateTimeFormatter czechDateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.getDefault());

    public static void main(String[] args) {
        //System.out.println(System.currentTimeMillis());

        Date date = new Date();
        //System.out.println(date);

        System.out.println(dateFormat.format(date));
        System.out.println(czechDateFormat.format(date));

        // Parsování datumů ze stringu (vstup od uživatele)
        Date myBirthday = null;
        try {
            myBirthday = dateFormat.parse("11.12.1991");
        } catch (ParseException e) {
            System.out.println("Datum není validní.");
        }
        System.out.println(myBirthday);

        //Je datum před nebo po ...
        System.out.println(myBirthday.before(date));
        System.out.println(myBirthday.after(date));

        // Porovnávání datumů
        System.out.println(myBirthday.compareTo(date));


        List<Date> listWithDates = new ArrayList<>();
        listWithDates.add(new Date());
        listWithDates.add(myBirthday);
        try {
            listWithDates.add(dateFormat.parse("05.12.2023"));
            listWithDates.add(dateFormat.parse("03.12.2023"));
            listWithDates.add(dateFormat.parse("03.11.2023"));
            listWithDates.add(dateFormat.parse("05.10.2023"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //seřazení listu podle data
        System.out.println(listWithDates.stream().sorted().map((d)-> dateFormat.format(d)).collect(Collectors.toList()));


        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(String.format("Aktuání rok je: %s, měsíc: %s, den v týdnu: %s", year, month, dayOfWeek));

        if (dayOfWeek == Calendar.WEDNESDAY){
            System.out.println("Je středa ...");
        }
        else {
            System.out.println("Není středa.");
        }


        //LocalDate
        LocalDate dateNow = LocalDate.now();
        System.out.println(dateNow.format(czechDateTimeFormatter));

        String dateTimeInString = "2023-12-06T11:19:30";
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateTimeInString);
        System.out.println(parsedDateTime);

        System.out.println(dateNow.atStartOfDay());
        System.out.println(dateNow.atStartOfDay(ZoneId.systemDefault()));

        LocalDate myBirthdayLocalDate = LocalDate.of(1991, Month.DECEMBER,11);

        //ChronoUnits Time between
        Long years = ChronoUnit.YEARS.between(myBirthdayLocalDate, dateNow);
        System.out.println("Jsi " + years + " let starý.");
        Long days = ChronoUnit.DAYS.between(myBirthdayLocalDate, dateNow);
        System.out.println("Od narození oplynulo " + days + " dní");

        // Přičítání a odčítání od datumů
        LocalDateTime.now().plus( 1, ChronoUnit.DAYS);
        LocalDateTime.now().plus( 1, ChronoUnit.MONTHS);
        LocalDateTime.now().plus( 10, ChronoUnit.YEARS);
        LocalDateTime.now().minus( 10, ChronoUnit.YEARS);
        LocalDateTime.now().plusHours(1);
        LocalDateTime.now().minusHours(1);













    }
}

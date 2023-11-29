# Cvičení 14 - Java Dates

## java.util.Date
  - System.currentTimeMillis();
  -  new Date();
  - Formátování datumů pomocí DateFormat + date.format()
  - Parsování datumů ze String value pomocí DateFormat.parse()
  - operace s datumy:
      * getTime()
      * before()/after()
      * compareTo()
      * fromInstant()
  
  ## java.time.Instant
   - Aktuální datum a čas : *Instant.now()*
   - date.toInstant();
   - Instatnt.plus()
   - InstantIsAfter() / Instant.IsBefore();

 ## java.time.LocalDate / LocalDateTime / ZonedDateTime
   - Aktuální datum a čas : *LocalDate.now()*, *LocalDateTime.now()*, *ZonedDateTime.now()*
   - LocalDate.of()
   - ChronoUnit.between();
   - .plus() /.minus()
  
  ![Java times](o48bV.png)

package vo;

import org.junit.Test;

import java.time.LocalTime;
import java.util.Date;

import static org.junit.Assert.*;

public class CreneauTest {


    @Test
    public void the_start_time_should_be_before_end() {
        Creneau creneau = new Creneau(new Date(), LocalTime.parse("11:03"), LocalTime.parse("13:37"));
    }



}
package vo;

import org.junit.Test;
import junit.framework.*;

import java.time.LocalTime;
import java.util.Date;

import static org.junit.Assert.assertEquals;


public class CreneauTest {

    @Test
    public void the_start_time_should_be_before_end() {
        new Creneau(new Date(), LocalTime.parse("11:03"), LocalTime.parse("13:37"));
    }

    @Test (expected = CreneauException.class)
    public void date_should_not_be_missing() {
        try {
            new Creneau(null, LocalTime.parse("13:03"), LocalTime.parse("11:37"));
        } catch(CreneauException e) {
            assertEquals(e.getMessage(), ExceptionMessages.NULL.getMessage());
            throw e;
        }
    }

    @Test (expected = CreneauException.class)
    public void start_time_should_not_be_missing() {
        try {
            new Creneau(new Date(), null, LocalTime.parse("11:37"));
        } catch(CreneauException e) {
            assertEquals(e.getMessage(), ExceptionMessages.NULL.getMessage());
            throw e;
        }
    }
    @Test (expected = CreneauException.class)
    public void end_time_should_not_be_missing() {
        try {
            new Creneau(new Date(), LocalTime.parse("13:03"), null);
        } catch(CreneauException e) {
            assertEquals(e.getMessage(), ExceptionMessages.NULL.getMessage());
            throw e;
        }
    }

    @Test(expected = CreneauException.class)
    public void the_start_time_should_not_be_after_end(){
        try {
            new Creneau(new Date(), LocalTime.parse("13:03"), LocalTime.parse("11:37"));
        } catch(CreneauException e) {
            assertEquals(e.getMessage(), ExceptionMessages.ORDER.getMessage());
            throw e;
        }
    }

    @Test(expected = CreneauException.class)
    public void the_creneau_should_last_more_than_30_minutes(){
        try {
            new Creneau(new Date(), LocalTime.parse("11:03"), LocalTime.parse("11:17"));
        } catch(CreneauException e) {
            assertEquals(e.getMessage(), ExceptionMessages.DURATION_LIMIT.getMessage());
            throw e;
        }
    }

    @Test()
    public void the_creneau_last_31_minutes(){
        new Creneau(new Date(), LocalTime.parse("11:03"), LocalTime.parse("11:34"));
    }
}
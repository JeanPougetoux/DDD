package vo;

import org.junit.Test;
import utils.CreneauException;
import utils.ExceptionMessages;

import java.time.LocalTime;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CreneauTest {

    @Test
    public void the_start_time_should_be_before_end() {
        new Creneau(new Date(), LocalTime.parse("11:03"), LocalTime.parse("13:37"));
    }

    @Test
    public void date_should_not_be_missing() {
        assertThatThrownBy(()-> new Creneau(null, LocalTime.parse("13:03"), LocalTime.parse("11:37")))
                .hasMessage(ExceptionMessages.NULL.getMessage())
                .isInstanceOf(CreneauException.class);
    }

    @Test
    public void start_time_should_not_be_missing() {
        assertThatThrownBy(()-> new Creneau(new Date(), null, LocalTime.parse("11:37")))
                .hasMessage(ExceptionMessages.NULL.getMessage())
                .isInstanceOf(CreneauException.class);
    }

    @Test
    public void end_time_should_not_be_missing() {
        assertThatThrownBy(()-> new Creneau(new Date(), LocalTime.parse("13:03"), null))
                .hasMessage(ExceptionMessages.NULL.getMessage())
                .isInstanceOf(CreneauException.class);
    }

    @Test
    public void the_start_time_should_not_be_after_end(){
        assertThatThrownBy(()-> new Creneau(new Date(), LocalTime.parse("13:03"), LocalTime.parse("11:17")))
                .hasMessage(ExceptionMessages.ORDER.getMessage())
                .isInstanceOf(CreneauException.class);
    }

    @Test
    public void the_creneau_should_last_more_than_30_minutes(){
        assertThatThrownBy(()-> new Creneau(new Date(), LocalTime.parse("13:03"), LocalTime.parse("13:10")))
                .hasMessage(ExceptionMessages.DURATION_LIMIT.getMessage())
                .isInstanceOf(CreneauException.class);
    }

    @Test
    public void the_creneau_last_31_minutes(){
        new Creneau(new Date(), LocalTime.parse("11:03"), LocalTime.parse("11:34"));
    }
}
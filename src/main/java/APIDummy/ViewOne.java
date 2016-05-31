package APIDummy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by prashant.gu on 5/30/2016.
 *
 */
class ViewOneBundle {
    private long surveillanceNumber;
    private long surveillanceStart;
    private long surveillanceEnd;
    private String mode;

    public ViewOneBundle() {
        this.surveillanceStart = new TimeNumber(TimeRange.LOWER_RANGE.getRange() , TimeRange.UPPER_RANGE.getRange()).getTimeNumber();
        this.surveillanceEnd = new TimeNumber(this.surveillanceStart, TimeRange.UPPER_RANGE.getRange()).getTimeNumber();

        Random rand = new Random();

        int x = rand.nextInt(2);

        if(x == 1) {
            this.mode = "eavesdrop";
            this.surveillanceNumber = new MobileNumber().getMobileNumber();
        }
        else {
            this.surveillanceNumber = -1;
            this.mode = "recording";
        }
    }

    public long getSurveillanceNumber() {
        return surveillanceNumber;
    }

    public void setSurveillanceNumber(long surveillanceNumber) {
        this.surveillanceNumber = surveillanceNumber;
    }

    public long getSurveillanceStart() {
        return surveillanceStart;
    }

    public void setSurveillanceStart(long surveillanceStart) {
        this.surveillanceStart = surveillanceStart;
    }

    public long getSurveillanceEnd() {
        return surveillanceEnd;
    }

    public void setSurveillanceEnd(long surveillanceEnd) {
        this.surveillanceEnd = surveillanceEnd;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}

public class ViewOne {

    private List<ViewOneBundle> viewOneData;

    ViewOne() {
        this.viewOneData = new ArrayList<>();
    }

    public List<ViewOneBundle> getViewOneData() {
        return viewOneData;
    }

    public void setViewOneData(List<ViewOneBundle> viewOneData) {
        this.viewOneData = viewOneData;
    }

    public void insertInList() {
        this.viewOneData.add(new ViewOneBundle());
    }
}

enum TimeRange {
    LOWER_RANGE  (9000000000L), //assign lower range value
    UPPER_RANGE  (9999999999L); //assign upper range value

    private final long range;

    TimeRange(long range) {
        this.range = range;
    }

    public long getRange() {
        return range;
    }
}

class MobileNumber {
    private long mobileNumber;

    MobileNumber() {

        Random random = new Random();

        long LOWER_RANGE = 9000000000L;
        long UPPER_RANGE = 9999999999L;

        this.mobileNumber = LOWER_RANGE +
                (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}

class TimeNumber {

    private long timeNumber;

    public long getTimeNumber() {
        return timeNumber;
    }

    public void setTimeNumber(long timeNumber) {
        this.timeNumber = timeNumber;
    }

    TimeNumber(long lowerRange, long upperRange) {

        Random random = new Random();

        this.timeNumber = lowerRange +
                (long)(random.nextDouble()*(upperRange - lowerRange));
    }

}

class CallDuration {

    private long callDuration;


    public long getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(long callDuration) {
        this.callDuration = callDuration;
    }

    CallDuration() {
        long LOWER_RANGE = 1L; //assign lower range value
        long UPPER_RANGE = 1000L; //assign upper range value
        Random random = new Random();


        this.callDuration = LOWER_RANGE +
                (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
    }
}
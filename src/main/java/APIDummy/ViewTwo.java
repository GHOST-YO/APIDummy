package APIDummy;
/**
 * Created by prashant.gu on 5/30/2016.
 *
 */


import java.security.SecureRandom;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

final class SessionIdentifierGenerator {
    private SecureRandom random = new SecureRandom();

    public String nextSessionId() {
        return new BigInteger(130, random).toString(32);
    }
}

public class ViewTwo {
    private List<ViewTwoBundle> viewTwoData;

    ViewTwo() {
        this.viewTwoData = new ArrayList<>();
    }

    public List<ViewTwoBundle> getViewTwoData() {
        return viewTwoData;
    }

    public void setViewTwoData(List<ViewTwoBundle> viewTwoData) {
        this.viewTwoData = viewTwoData;
    }

    public void insertInList(long start, long end) {
        this.viewTwoData.add(new ViewTwoBundle(start, end));
    }
}

class ViewTwoBundle {
    private CallType callType;
    private long participatingNumber;
    private long startTime;
    private long callDuration;
    private String audioURL;

    public ViewTwoBundle(long start, long end) {

        Random rand = new Random();

        int x = rand.nextInt(2);

        if(x == 1)
            this.callType = CallType.OUTGOING;
        else
            this.callType = CallType.INCOMING;

        this.participatingNumber = (new MobileNumber()).getMobileNumber();
        this.startTime = (new TimeNumber(start, end)).getTimeNumber();
        this.callDuration = (new CallDuration()).getCallDuration();
        this.audioURL = (new AudioURL().getAudioURL());
    }

    public CallType getCallType() {
        return callType;
    }

    public void setCallType(CallType callType) {
        this.callType = callType;
    }

    public long getParticipatingNumber() {
        return participatingNumber;
    }

    public void setParticipatingNumber(long participatingNumber) {
        this.participatingNumber = participatingNumber;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(long callDuration) {
        this.callDuration = callDuration;
    }

    public String getAudioURL() {
        return audioURL;
    }

    public void setAudioURL(String audioURL) {
        this.audioURL = audioURL;
    }
}

enum CallType {
    INCOMING,
    OUTGOING
}

class AudioURL {
    private String audioURL;

    public String getAudioURL() {
        return audioURL;
    }

    public void setAudioURL(String audioURL) {
        this.audioURL = audioURL;
    }

    AudioURL() {
        SessionIdentifierGenerator se = new SessionIdentifierGenerator();

        this.audioURL = "www." + se.nextSessionId() + ".com";
    }
}
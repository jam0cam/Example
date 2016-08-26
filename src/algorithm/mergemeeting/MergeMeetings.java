package algorithm.mergemeeting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Your company built an in-house calendar tool called HiCal. You want to add a feature to see the times in a day when
 * everyone is available. To do this, you’ll need to know when any team is having a meeting. In HiCal, a meeting is
 * stored as an object of a Meeting class with integer variables startTime and endTime. These integers represent the
 * number of 30-minute blocks past 9:00am.
 *
 * Example:
 * new Meeting(2, 3); // meeting from 10:00 – 10:30 am
 * new Meeting(6, 9); // meeting from 12:00 – 1:30 pm
 *
 *
 * Write a function condenseMeetingTimes() that takes a list of meeting time ranges and returns a list of condensed ranges.
 *
 * Example:
 * INPUT: [(0, 1), (3, 5), (4, 8), (10, 12), (9, 10)]
 * OUTPUT: [(0, 1), (3, 8), (9, 12)]
 *
 *
 * https://www.interviewcake.com/question/java/merging-ranges
 *
 * Created by jtse on 8/26/16.
 */
public class MergeMeetings {

    public static List<Meeting> mMeetings;

    public static void main(String[] args) {

        mMeetings = new ArrayList<>();
        mMeetings.add(new Meeting(0, 1));
        mMeetings.add(new Meeting(3, 5));
        mMeetings.add(new Meeting(4, 8));
        mMeetings.add(new Meeting(10, 12));
        mMeetings.add(new Meeting(9, 10));
        System.out.println("should be:\n" + "(0, 1), (3, 8), (9, 12)");
        solve();


        mMeetings.clear();
        mMeetings.add(new Meeting(1, 2));
        mMeetings.add(new Meeting(2, 3));

        System.out.println("should be:\n" + "(1, 3)");
        solve();

        mMeetings.clear();
        mMeetings.add(new Meeting(1, 5));
        mMeetings.add(new Meeting(2, 3));

        System.out.println("should be:\n" + "(1, 5)");
        solve();


        mMeetings.clear();
        mMeetings.add(new Meeting(1, 10));
        mMeetings.add(new Meeting(2, 6));
        mMeetings.add(new Meeting(3, 5));
        mMeetings.add(new Meeting(7, 9));

        System.out.println("should be:\n" + "(1, 10)");
        solve();

        mMeetings.clear();
        solve();

        mMeetings.add(new Meeting(1, 10));
        solve();

    }

    private static void solve() {
        if (mMeetings == null || mMeetings.isEmpty()) {
            System.out.println("There are no meetings");
            return;
        } else if (mMeetings.size() < 2) {
            System.out.println(mMeetings.get(0).toString());
            return;
        }

        //1. Sort the list based on start time.
        Collections.sort(mMeetings, (o1, o2) -> o1.startTime < o2.startTime ? -1 : 1);

        //for every element, from left to right, if the next start time is before the current end time,
        //then apply the merge.
        int i=0;
        while (i < mMeetings.size()-1) {
            Meeting currentMeeting = mMeetings.get(i);
            Meeting nextMeeting = mMeetings.get(i+1);

            if (currentMeeting.endTime >= nextMeeting.startTime) {
                //perform the merge.

                if (nextMeeting.endTime > currentMeeting.endTime) {
                    currentMeeting.endTime = nextMeeting.endTime;
                }

                mMeetings.remove(nextMeeting);
            } else {
                //there is nothing to merge, advance to the next index
                i++;
            }
        }

        System.out.println("Answer is:");
        for (Meeting meeting : mMeetings) {
            System.out.print(meeting.toString() + ", ");
        }

        System.out.println("");
        System.out.println("");
    }

}

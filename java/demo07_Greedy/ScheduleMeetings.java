package demo07_Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @BelongsProject: algorithm
 * @CreateTime: 2023-11-23  20:20
 * @Author: lanai
 * @Description: 使用贪心算法解决会议安排问题；某时刻给你一系列的会议，
 * 每个会议包括开始时间与结束时间，如何在一间会议室安排最多的会议
 */
public class ScheduleMeetings {
    public class Meeting{
        private int start;
        private int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * 贪心策略：优先安排结束时间较早的会议
     * @param meetings
     * @param nowTime
     * @return
     */
    public int greedOfMeeting(Meeting[] meetings,int nowTime){
        Arrays.sort(meetings, Comparator.comparingInt(o -> o.end));
        int result = 0;
        for (Meeting meeting : meetings) {
            if(nowTime<=meeting.start){
                result++;
                nowTime=meeting.end;
            }
        }
        return result;
    }
}

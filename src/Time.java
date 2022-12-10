public class Time {
    private int hour;
    private int minute;
    private int second;

    // Constructor that takes the initial hour, minute, and second
    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    // Increase the time by one second
    public void tick() {
        second++;
        if (second == 60) {
            second = 0;
            minute++;
            if (minute == 60) {
                minute = 0;
                hour++;
                if (hour == 24) {
                    hour = 0;
                }
            }
        }
    }

    // Method to add a specified amount of time
    public void add(Time time) {
        hour += time.hour;
        minute += time.minute;
        second += time.second;

        // Adjust the time if the number of seconds or minutes exceeds 60
        if (second >= 60) {
            minute += second / 60;
            second %= 60;
        }
        if (minute >= 60) {
            hour += minute / 60;
            minute %= 60;
        }

        // Adjust the hour if it exceeds 24
        if (hour >= 24) {
            hour %= 24;
        }
    }

    // Override the toString() method to return the time in HH:MM:SS format. I did some research, and the %02d adds a 0 to the number if it is less than 10
    public String toString() {
        String hourStr = String.format("%02d", hour);
        String minuteStr = String.format("%02d", minute);
        String secondStr = String.format("%02d", second);
        return hourStr + ":" + minuteStr + ":" + secondStr;
    }

}


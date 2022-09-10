package ch02;

public class BirthDay {

    private int day;
    private int month;
    private int year;


    private boolean isValid = true;
    private boolean yoon;
    private void isYoon(int year) {
        if (year % 400 == 0) {
            yoon = true;
        }
        else if ((year % 100 != 0) && (year % 4 == 0)) {
            yoon = true;
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day < 1 || day > 31) {
            isValid = false;
        }
        switch (month) {
            case 4, 6, 9, 11 -> {
                if (day > 30) {
                    isValid = false;
                } else {
                    this.day = day;
                }
            }
            case 2 -> {
                if (yoon) {
                    if (day > 29) {
                        isValid = false;
                    }
                    else {
                        this.day = day;
                    }
                }
                else {
                    if (day > 28) {
                        isValid = false;
                    }
                    else {
                        this.day = day;
                    }
                }
            }
            default -> {
                this.day = day;
            }
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            isValid = false;
        }
        else {
            this.month = month;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        isYoon(year);
        this.year = year;
    }
    public void showDate() {
        if(isValid) {
            System.out.println(year + "년 " + month + "월 " + day + "일 입니다.");
        }
        else {
            System.out.println("유효하지 않은 날짜 입니다.");
        }
    }
}




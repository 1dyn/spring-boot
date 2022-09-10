package ch03;

public class Customer {

    protected int customerID;
    protected String customerName;
    protected String customerGrade;
    int bonusPoint;
    double bonusRatio;

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerGrade() {
        return customerGrade;
    }

    public void setCustomerGrade(String customerGrade) {
        this.customerGrade = customerGrade;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Customer() {
        customerGrade = "SILVER";
        bonusRatio = 0.01;
    }
    public int calcPrice(int price) {
        bonusPoint += (price * bonusRatio);
        return price;
    }
    public String showCustomerInfo() {
        return customerName + " 고객님의 등급은 " + customerGrade + " 이며, 보너스 포인트는 " + bonusPoint + "점 입니다.";
    }


}

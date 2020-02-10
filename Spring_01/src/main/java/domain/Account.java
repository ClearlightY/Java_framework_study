package domain;

public class Account {
    private Integer aid;
    private String number;
    private Float balance;

    @Override
    public String toString() {
        return "Account{" +
                "aid=" + aid +
                ", number='" + number + '\'' +
                ", balance=" + balance +
                '}';
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }
}

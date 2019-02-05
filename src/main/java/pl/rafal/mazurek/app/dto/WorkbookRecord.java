package pl.rafal.mazurek.app.dto;

import java.util.Objects;

public class WorkbookRecord {

    private String name;
    private String address;
    private String postalCode;
    private String phone;
    private String creditLimit;
    private String birthday;

    public WorkbookRecord(String name, String address, String postalCode, String phone, String creditLimit, String birthday) {
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.phone = phone;
        this.creditLimit = creditLimit;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkbookRecord that = (WorkbookRecord) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(postalCode, that.postalCode) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(creditLimit, that.creditLimit) &&
                Objects.equals(birthday, that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, postalCode, phone, creditLimit, birthday);
    }

    @Override
    public String toString() {
        return "WorkbookRecord{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' +
                ", creditLimit='" + creditLimit + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}

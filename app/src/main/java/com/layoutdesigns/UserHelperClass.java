package com.layoutdesigns;

public class UserHelperClass {

    String FullName,EmailAddress,Birthdate,male,female,KEY_GENDER;

    public UserHelperClass() {
    }



    public String getKEY_GENDER() {
        return KEY_GENDER;
    }

    public void setKEY_GENDER(String KEY_GENDER) {
        this.KEY_GENDER = KEY_GENDER;
    }

    public UserHelperClass(String FullName, String EmailAddress, String Birthdate,  String gender) {
        this.FullName = FullName;
        this.EmailAddress = EmailAddress;
        this.Birthdate = Birthdate;
        this.KEY_GENDER = gender;

    }

    public String getFullName() {

        return FullName;

    }

    public UserHelperClass(String KEY_GENDER) {
        this.KEY_GENDER = KEY_GENDER;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public String getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(String birthdate) {
        Birthdate = birthdate;
    }
}




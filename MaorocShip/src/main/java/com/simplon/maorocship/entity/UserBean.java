package com.simplon.maorocship.entity;



public class UserBean {

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void result(String firstName, String lastName){
        System.out.println("First Name: " + firstName + " Last Name: " + lastName);
    }
}

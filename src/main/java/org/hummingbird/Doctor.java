package org.hummingbird;

public class Doctor implements Staff {
    public Doctor(String qualification) {
        this.qualification = qualification;
    }

    private String qualification;
    public void assist() {
        System.out.println("The doctor is assisting.");
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}

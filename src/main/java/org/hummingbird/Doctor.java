package org.hummingbird;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component // This annotation is used to mark the class as a Spring bean
@Scope("prototype") // This annotation is used to specify the scope of the bean
public class Doctor implements Staff, BeanNameAware {

    @Override
    public String toString() {
        return "Doctor [qualification=" + qualification + "]";
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

    @Override
    public void setBeanName(String name) {
        System.out.println("The bean name is: " + name);
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("The post construct method has been called.");
    }
}

package ngdemo.home.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
// from http://www.vogella.com/articles/REST/
// JAX-RS supports an automatic mapping from JAXB annotated class to XML and JSON
public class Home {

    private String firstName;
    private String lastName;
    private String bmp;
    private String strOutLog;

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
    public String getBmp() {
        return bmp;
    }

    public void setBmp(String bmp) {
        this.bmp = bmp;
    }
    public String getStrOutLog() {
        return strOutLog;
    }

    public void setStrOutLog(String strOutLog) {
        this.strOutLog = strOutLog;
    }
}
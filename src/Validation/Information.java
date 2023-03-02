package Validation;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Information {
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String course;
    private String email;

    public void validateNameField(String fieldName, String fieldValue, int maxLength) {
        if (!fieldValue.matches("^[a-zA-Z]*$")) {
            System.out.println("Error: " + fieldName + " should not contain numerals or special characters.");
            System.exit(1);
        }
        if (fieldValue.length() > maxLength) {
            System.out.println("Error: " + fieldName + " should not exceed " + maxLength + " characters.");
            System.exit(1);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        validateNameField("First name", firstName, 50);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        validateNameField("Last name", lastName, 50);
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthdayStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        try {
            LocalDate bday = LocalDate.parse(birthdayStr, formatter);
            Period age = Period.between(bday, LocalDate.now());
            if (age.getYears() >= 16 && age.getYears() <= 50) {
                this.birthday = bday;
            } else {
                System.out.println("Error: Birthday should be between 16 and 50 years old.");
                System.exit(1);
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid birthday format (yyyy/MM/dd)");
            System.exit(1);
        }
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        if (course.matches("^[^0-9]*$")) {
            if (course.length() <= 50) {
                this.course = course;
            } else {
                System.out.println("Error: Course name should not exceed 50 characters.");
                System.exit(1);
            }
        } else {
            System.out.println("Error: Course name should not contain numerals.");
            System.exit(1);
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            this.email = email;
        } else {
            System.out.println("Error: Invalid email format.");
            System.exit(1);
        }
    }
    public String getStudentNumber() {
        String year = Integer.toString(LocalDate.now().getYear());
        String monthDay = birthday.format(DateTimeFormatter.ofPattern("dd"));
        String surnameInitial = lastName.substring(0, 1).toLowerCase();
        return year + "-" + monthDay + "01-" + surnameInitial;
    }

}

package ru.csu.iit.backend.models.commands;

public class RegistrationCommand {
    private String email;
    private String password;

    public RegistrationCommand(String email) {
        this.email = email;
    }

    public RegistrationCommand(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

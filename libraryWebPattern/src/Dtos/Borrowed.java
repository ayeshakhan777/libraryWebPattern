/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

/**
 *
 * @author Sean
 */
public class Borrowed {
    private User user;
    private Title title;
    private int daysBorrowed;
    private int status;

    public Borrowed(User user, Title title, int daysBorrowed, int status) {
        this.user = user;
        this.title = title;
        this.daysBorrowed = daysBorrowed;
        this.status = status;
    }
    
    public Borrowed() {
        
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public int getDaysBorrowed() {
        return daysBorrowed;
    }

    public void setDaysBorrowed(int daysBorrowed) {
        this.daysBorrowed = daysBorrowed;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "borrowed{" + "user=" + user + ", title=" + title + ", daysBorrowed=" + daysBorrowed + ", status=" + status + '}';
    }
    
    
}

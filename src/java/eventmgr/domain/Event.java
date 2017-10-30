/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventmgr.domain;

import java.util.Date;

/**
 *
 * @author MA393506
 */
public class Event 
{
private int id;
private String name;
private Date startdate;
private Location location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    
    public String toString() {
        return "Event{" + "id=" + id + ", name=" + name + ", startdate=" + startdate + ", location=" + location + '}';
    }
    
}

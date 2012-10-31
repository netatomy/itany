/*
 * Copyright (C) 2006 Sun Microsystems, Inc. All rights reserved. Use is
 * subject to license terms.
 */
package passwordstore.model;

import java.io.Serializable;
import java.net.URI;
import passwordstore.beansx.BeanBase;

/**
 * PasswordEntry represents an account on a particular system. Each
 * PasswordEntry has a host name, user name, password, notes, path to
 * image and dates corresponding to last modified and accessed. All setters
 * follow the beans pattern of notifying property change listeners of changes.
 *
 * @version $Revision$
 */
public class PasswordEntry extends BeanBase implements Serializable {
    private String host;
    private String user;
    private String password;
    private String notes;
    private long lastAccessed;
    private long lastModified;
    private URI imagePath;
    
    public void setHost(String host) {
        String oldHost = this.host;
        this.host = host;
        firePropertyChange("host", oldHost, host);
    }
    
    public String getHost() {
        return host;
    }
    
    public void setUser(String user) {
        String oldUser = this.user;
        this.user = user;
        firePropertyChange("user", oldUser, user);
    }
    
    public String getUser() {
        return user;
    }
    
    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        firePropertyChange("password", oldPassword, password);
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setLastAccessed(long lastAccessed) {
        long oldLastAccessed = this.lastAccessed;
        this.lastAccessed = lastAccessed;
        firePropertyChange("lastAccessed", oldLastAccessed, lastAccessed);
    }
    
    public long getLastAccessed() {
        return lastAccessed;
    }
    
    public void setLastModified(long lastModified) {
        long oldLastModified = this.lastModified;
        this.lastModified = lastModified;
        firePropertyChange("lastModified", oldLastModified, lastModified);
    }
    
    public long getLastModified() {
        return lastModified;
    }
    
    public void setNotes(String notes) {
        String oldNotes = this.notes;
        this.notes = notes;
        firePropertyChange("notes", oldNotes, notes);
    }
    
    public String getNotes() {
        return notes;
    }
    
    public void setImagePath(URI imagePath) {
        URI oldImagePath = this.imagePath;
        this.imagePath = imagePath;
        firePropertyChange("imagePath", oldImagePath, imagePath);
    }
    
    public URI getImagePath() {
        return imagePath;
    }
    
    public PasswordEntry clone() {
        PasswordEntry entry = new PasswordEntry();
        entry.host = host;
        entry.user = user;
        entry.password = password;
        entry.notes = notes;
        entry.lastAccessed = lastAccessed;
        entry.lastModified = lastModified;
        entry.imagePath = imagePath;
        return entry;
    }
}

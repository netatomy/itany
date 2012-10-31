/*
 * Copyright (C) 2006 Sun Microsystems, Inc. All rights reserved. Use is
 * subject to license terms.
 */
package passwordstore.ui;

import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import passwordstore.swingx.app.Application;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import passwordstore.ui.UIFactory;

/**
 * PasswordStore's Application subclass. Does very little other than start up
 * the Controller.
 *
 * NOTE: This demo is meant to be illustrative only and not meant to be used
 * for real analysis of passwords.
 *
 */
public class PasswordStoreApplication extends Application {
    // Controller in terms of MVC.
    private Controller controller;
    private JFrame frame;

    public static PasswordStoreApplication getInstance() {
        return (PasswordStoreApplication)Application.getInstance();
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    // Overriden to return the name of the Application
    public String getName() {
        return getResourceAsString("appName");
    }

    protected void installLookAndFeel() {
        super.installLookAndFeel();
        // Register the factory to get notified when UIs are created. This
        // is used to enable the cut/copy/paste actions.
        UIManager.put("ClassLoader", getClass().getClassLoader());
        UIManager.put("TextFieldUI", UIFactory.class.getName());
        UIManager.put("TextPaneUI", UIFactory.class.getName());
    }

    // Overriden to create the UI and show it.
    protected void init() {
        frame = new JFrame(getResourceBundle().getString("frame.title"));
        frame.setIconImage(new ImageIcon(
                getClass().getResource("resources/Lock128x128.png")).getImage());
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exit();
            }
        });
        controller = new Controller(frame);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    // Overriden to delegate to the controller.
    protected boolean canExit() {
        return controller.canExit();
    }
    
    
    public static void main(String[] args) {
        try {
            // Register various properties for OS X
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            System.setProperty("com.apple.mrj.application.apple.menu.about.name",
                    ResourceBundle.getBundle(PasswordStoreApplication.class.getPackage().getName() +
                    ".resources.Resources").getString("frame.title"));
        } catch (SecurityException e) {
        }
        new PasswordStoreApplication().start();
    }
}

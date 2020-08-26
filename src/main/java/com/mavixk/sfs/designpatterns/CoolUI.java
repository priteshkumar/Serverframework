package com.mavixk.sfs.designpatterns;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CoolUI {

  static interface Button {

    void render();

    void onClick();
  }

  static class LinuxButton implements Button {

    JPanel panel = new JPanel();
    JFrame frame = new JFrame();
    JButton button;

    @Override
    public void render() {
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JLabel label = new JLabel("Hello World!");
      label.setOpaque(true);
      label.setBackground(new Color(235, 233, 126));
      label.setFont(new Font("Dialog", Font.BOLD, 44));
      label.setHorizontalAlignment(SwingConstants.CENTER);
      panel.setLayout(new FlowLayout(FlowLayout.CENTER));
      frame.getContentPane().add(panel);
      panel.add(label);
      onClick();
      panel.add(button);

      frame.setSize(320, 200);
      frame.setVisible(true);
//      onClick();
    }

    @Override
    public void onClick() {
      button = new JButton("Exit");
      button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          frame.setVisible(false);
          System.exit(0);
        }
      });
    }
  }

  static class WebButton implements Button {

    @Override
    public void render() {
      System.out.println("<button>Test</button>");
      onClick();
    }

    @Override
    public void onClick() {
      System.out.println("test clicked");
    }
  }

  static abstract class Dialog {

    public abstract Button createButton();

    public void renderWindow() {
      Button button = createButton();
      button.render();
    }
  }

  static class LinuxDialog extends Dialog {

    @Override
    public Button createButton() {
      return new LinuxButton();
    }
  }

  static class WebDialog extends Dialog {

    @Override
    public Button createButton() {
      return new WebButton();
    }
  }

  public static void main(String[] args) {
    Dialog dialog = null;
    if (System.getProperty("os.name").equals("Linux")) {
      dialog = new LinuxDialog();
    } else {
      dialog = new WebDialog();
    }
    dialog.renderWindow();
  }
}

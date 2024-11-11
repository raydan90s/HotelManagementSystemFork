package myclasses;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import myclasses.buttonStrategy.BackStrategy;
import myclasses.buttonStrategy.EditStrategy;
import myclasses.buttonStrategy.ExitStrategy;
import myclasses.buttonStrategy.LogoutStrategy;
import myinterface.ButtonActionStrategy;

public class Profile extends JFrame implements ActionListener {

    private JButton logoutButton, editButton, backButton, exitButton;
    private Map<JButton, ButtonActionStrategy> actionStrategies;

    public Profile() {
        System.out.println("Currently in Profile class");
        setResizable(false);
        setTitle("The Tipton Hotel Management System");
        setIconImage(
                Toolkit.getDefaultToolkit().getImage(Profile.class.getResource("../images/titleIcon.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 903, 554);
        setLocationRelativeTo(null);
        JPanel contentPane = new JPanel();
        contentPane.setForeground(Color.LIGHT_GRAY);
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(null);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setBounds(533, 153, 322, 224);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel fullName = new JLabel(Login.fullName);
        fullName.setBounds(10, 26, 300, 50);
        panel.add(fullName);
        fullName.setForeground(new Color(142, 224, 240));
        fullName.setFont(new Font("Times New Roman", Font.PLAIN, 22));

        JLabel userName = new JLabel(Login.fullUsername);
        userName.setBounds(10, 86, 300, 50);
        panel.add(userName);
        userName.setForeground(new Color(142, 224, 240));
        userName.setFont(new Font("Times New Roman", Font.PLAIN, 22));

        JLabel phoneNumber = new JLabel(Login.phoneNumber);
        phoneNumber.setBounds(10, 146, 300, 50);
        panel.add(phoneNumber);
        phoneNumber.setForeground(new Color(142, 224, 240));
        phoneNumber.setFont(new Font("Times New Roman", Font.PLAIN, 22));

        BufferedImage ImgLabel = null;
        try {
            ImgLabel
                    = ImageIO.read(Objects.requireNonNull(Profile.class.getResource("../images/profile.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
        assert ImgLabel != null : "The 'Profile.png' image could not be loaded";
        Image imglabel = ImgLabel.getScaledInstance(224, 224, Image.SCALE_SMOOTH);
        JLabel imgLabel = new JLabel(new ImageIcon(imglabel));
        imgLabel.setBounds(124, 153, 224, 224);
        contentPane.add(imgLabel);

        JLabel ProfileInformationLbl = new JLabel("Profile Information");
        ProfileInformationLbl.setHorizontalAlignment(SwingConstants.CENTER);
        ProfileInformationLbl.setForeground(new Color(101, 119, 179));
        ProfileInformationLbl.setFont(new Font("Pristina", Font.BOLD, 40));
        ProfileInformationLbl.setBounds(303, 10, 297, 81);
        contentPane.add(ProfileInformationLbl);

        editButton = new JButton("Edit Info");
        editButton.setOpaque(false);
        editButton.setForeground(new Color(101, 119, 179));
        editButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
        editButton.setBorder(BorderFactory.createEmptyBorder());
        editButton.setBackground(new Color(0, 0, 0, 0));
        editButton.setBounds(672, 387, 80, 30);
        editButton.setFocusable(false);
        contentPane.add(editButton);

        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Tahoma", Font.BOLD, 10));
        exitButton.setBounds(809, 486, 70, 21);
        exitButton.setFocusable(false);
        contentPane.add(exitButton);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Tahoma", Font.BOLD, 10));
        backButton.setBounds(10, 486, 70, 21);
        backButton.setFocusable(false);
        contentPane.add(backButton);

        logoutButton = new JButton("logout");
        logoutButton.setBounds(809, 10, 70, 21);
        logoutButton.setFont(new Font("Tahoma", Font.BOLD, 10));
        logoutButton.setFocusable(false);
        contentPane.add(logoutButton);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(140, 140, 140));
        panel_1.setBounds(0, 0, 200, 517);
        contentPane.add(panel_1);

        actionStrategies = new HashMap<>();

        // Asignar las estrategias a cada botón
        actionStrategies.put(logoutButton, new LogoutStrategy(this));
        actionStrategies.put(editButton, new EditStrategy(this));
        actionStrategies.put(backButton, new BackStrategy(this));
        actionStrategies.put(exitButton, new ExitStrategy());

        // Asignar el ActionListener a los botones
        logoutButton.addActionListener(this);
        editButton.addActionListener(this);
        backButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      // Obtener la estrategia asociada al botón presionado y ejecutar la acción
      ButtonActionStrategy strategy = actionStrategies.get(e.getSource());
      if (strategy != null) {
          strategy.execute();
      }
  }

}

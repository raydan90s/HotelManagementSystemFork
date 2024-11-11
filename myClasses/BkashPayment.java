package myclasses;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import myinterface.InputValidator;
import myinterface.LengthValidator;
import myinterface.NavigationInterface;
import myinterface.PaymentProcessorInterface;

/**
 * The BkashPayment class represents a JFrame window for Bkash payment functionality. It implements
 * the ActionListener interface and uses the ConfirmPayment interface for confirming payments.
 */
public class BkashPayment extends JFrame implements ActionListener, InputValidator, LengthValidator {


  final JLabel bkash_lbl; // Label to display Bkash logo
  final JTextField num_fld; // Text field for entering the mobile number
  final JButton back_btn; // Button for navigating back
  final JButton next_btn; // Button for proceeding to the next step
  final JPasswordField pass_fld; // Password field for entering the PIN

  private final PaymentProcessorInterface paymentProcessor; // Dependency injection for payment processing
  private final NavigationInterface navigation;
  /**
   * The constructor of the BkashPayment class. It initializes the JFrame and adds components to it.
   */
  public BkashPayment(PaymentProcessorInterface paymentProcessor, NavigationInterface navigation) {
    this.paymentProcessor = paymentProcessor;
    this.navigation = navigation;

    System.out.println("Currently in BkashPayment class");
    // Set JFrame properties
    setTitle("Bkash Payment");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 903, 554);
    setLocationRelativeTo(null);
    setResizable(false);
    getContentPane().setBackground(Color.GRAY);
    setResizable(false);

    // Load and display Bkash logo
    ImageIcon img = new ImageIcon("./images/BkashPayment.png");
    Image i = img.getImage();
    Image new_img = i.getScaledInstance(854, 580, Image.SCALE_SMOOTH);
    img = new ImageIcon(new_img);
    bkash_lbl = new JLabel("", img, JLabel.CENTER);
    bkash_lbl.setBounds(-190, -220, 854, 580);

    // Create and position text field for entering mobile number
    num_fld = new JTextField();
    num_fld.setBounds(260, 250, 300, 25);
    this.add(num_fld);

    // Create and position password field for entering PIN
    pass_fld = new JPasswordField();
    pass_fld.setBounds(260, 380, 300, 25);
    this.add(pass_fld);

    // Add Bkash logo label to the JFrame
    this.add(bkash_lbl);

    // Create and position back button
    back_btn = new JButton("Back");
    back_btn.setFont(new Font("Abadi", Font.BOLD, 15));
    back_btn.setBackground(Color.BLACK);
    back_btn.setForeground(Color.WHITE);
    back_btn.setBounds(720, 460, 80, 25);
    back_btn.addActionListener(this);
    this.add(back_btn);

    // Create and position next button
    next_btn = new JButton("Next");
    next_btn.setFont(new Font("Abadi", Font.BOLD, 15));
    next_btn.setBackground(Color.BLACK);
    next_btn.setForeground(Color.WHITE);
    next_btn.setBounds(620, 460, 80, 25);
    next_btn.addActionListener(this);
    this.add(next_btn);

    // Add Bkash logo label to the JFrame
    this.add(bkash_lbl);

    // Set the JFrame visible
    setVisible(true);
  }

  /**
   * This method is invoked when an action is performed on a component. It handles the button clicks
   * for the back and next buttons.
   *
   * @param ae The ActionEvent that occurred.
   */
  public void actionPerformed(ActionEvent ae) {
        String MobileNumber = num_fld.getText();
        String Pin = String.valueOf(pass_fld.getPassword());

        if (ae.getSource() == back_btn) {
            navigation.navigateBack();
            this.setVisible(false);
            System.out.println("Exited from BkashPayment class");
        } else if (ae.getSource() == next_btn) {
            // Call confirmPayment from PaymentProcessor
            paymentProcessor.confirmPayment(num_fld, pass_fld, this);
        }
    }




  /**
   * This method validates if the input values in the number and password fields consist only of
   * digits. It is implemented from the ConfirmPayment interface.
   *
   * @param number the number field representing the mobile number
   * @param password the password field representing the PIN
   * @return true if the input values consist only of digits, false otherwise
   */
  @Override
  public boolean inputValidation(JTextField number, JPasswordField password) {
    System.out.println("inputValidation function called");
    
    String numberText = number.getText();
    String passText = String.valueOf(password.getPassword());

    // Check if both number and password consist of digits only
    boolean isNumberValid = numberText.chars().allMatch(Character::isDigit);
    boolean isPasswordValid = passText.chars().allMatch(Character::isDigit);

    if (!isNumberValid && !isPasswordValid) {
      JOptionPane.showMessageDialog(
          null,
          "Phone number and PIN number cannot contain characters",
          "Input error",
          JOptionPane.WARNING_MESSAGE);
      return false;
    } else if (!isNumberValid) {
      JOptionPane.showMessageDialog(
          null,
          "Phone Number cannot contain characters",
          "Phone number error",
          JOptionPane.WARNING_MESSAGE);
      return false;
    } else if (!isPasswordValid) {
      JOptionPane.showMessageDialog(
          null,
          "PIN number cannot contain characters",
          "PIN number error",
          JOptionPane.WARNING_MESSAGE);
      return false;
    }
    System.out.println("inputValidation function executed successfully");
    return true;
  }
  


  /**
   * This method checks the length of the input values in the number and password fields. It is
   * implemented from the ConfirmPayment interface.
   *
   * @param number the number field representing the mobile number
   * @param password the password field representing the PIN
   * @return true if the length of the input values is valid, false otherwise
   */
  @Override
  public boolean inputLength(JTextField number, JPasswordField password) {
    System.out.println("inputLength funtion called");
    String numberText = number.getText();
    String passText = String.valueOf(password.getPassword());

    if (numberText.length() != 11 && passText.length() != 4) {
      JOptionPane.showMessageDialog(
          null,
          "Phone number must contain exactly 11 digits and PIN number must contain exactly 4"
              + " digits",
          "Length error",
          JOptionPane.WARNING_MESSAGE);
      return false;
    } else if (numberText.length() != 11) {
      JOptionPane.showMessageDialog(
          null,
          "Phone number must contain exactly 11 digits",
          "Length error",
          JOptionPane.WARNING_MESSAGE);
      return false;
    } else if (passText.length() != 4) {
      JOptionPane.showMessageDialog(
          null,
          "PIN number must contain exactly 4 digits",
          "Length error",
          JOptionPane.WARNING_MESSAGE);
      return false;
    }

    System.out.println("inputLength funtion executed successfully");
    return true;
  }
}

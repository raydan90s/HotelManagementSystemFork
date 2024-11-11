package myclasses;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import myclasses.paymentStrategy.BkashPaymentStrategy;
import myclasses.paymentStrategy.NagadPaymentStrategy;
import myclasses.paymentStrategy.NoPaymentSelectedStrategy;
import myinterface.PaymentStrategy;

public class Payment extends JFrame implements ActionListener {

    final JLabel payment_lbl;
    final ButtonGroup bkashNagad_grp;
    private JRadioButton bkash_btn, nagad_btn;
    private JButton next_btn;
    private Map<String, PaymentStrategy> paymentStrategies;

    public Payment() {
        System.out.println("Currently in Payment class");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 903, 554);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        ImageIcon img = new ImageIcon("./images/PaymentPage.png");
        Image i = img.getImage();
        Image new_img = i.getScaledInstance(854, 480, Image.SCALE_SMOOTH);
        img = new ImageIcon(new_img);
        payment_lbl = new JLabel("", img, JLabel.CENTER);
        payment_lbl.setBounds(0, 0, 889, 517);
        getContentPane().setLayout(null);

        nagad_btn = new JRadioButton("");
        nagad_btn.setBounds(201, 315, 30, 20);
        nagad_btn.setBackground(Color.WHITE);
        nagad_btn.setFont(new Font("Arial", Font.BOLD, 33));
        getContentPane().add(nagad_btn);
        bkash_btn = new JRadioButton("");
        bkash_btn.setBounds(602, 315, 30, 20);
        bkash_btn.setFont(new Font("Arial", Font.BOLD, 33));
        bkash_btn.setBackground(Color.WHITE);
        getContentPane().add(bkash_btn);

        bkashNagad_grp = new ButtonGroup();
        bkashNagad_grp.add(nagad_btn);
        bkashNagad_grp.add(bkash_btn);

        next_btn = new JButton("Next");
        next_btn.setFont(new Font("Abadi", Font.BOLD, 15));
        next_btn.setBackground(Color.BLACK);
        next_btn.setForeground(Color.white);
        next_btn.setBounds(620, 390, 80, 25);
        next_btn.addActionListener(this);
        getContentPane().add(next_btn);
        getContentPane().add(payment_lbl);

        setVisible(true);

        paymentStrategies = new HashMap<>();

        // Asignar las estrategias a las claves correspondientes
        paymentStrategies.put("Bkash", new BkashPaymentStrategy());
        paymentStrategies.put("Nagad", new NagadPaymentStrategy());
        paymentStrategies.put("None", new NoPaymentSelectedStrategy());

        // Asignar el ActionListener a los botones
        next_btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == next_btn) {
          PaymentStrategy strategy;
  
          strategy = getPaymentStrategy();
  
          strategy.execute();
  
          setVisible(false);
      }
  }
  
  
  private PaymentStrategy getPaymentStrategy() {
      // Aquí simplemente asignamos la estrategia sin ningún if adicional.
      // Si el botón 'bkash_btn' está seleccionado, devuelve la estrategia de BkashPayment
      if (bkash_btn.isSelected()) {
          return (PaymentStrategy) new BkashPayment();
      }
      
      // Si el botón 'nagad_btn' está seleccionado, devuelve la estrategia de NagadPayment
      if (nagad_btn.isSelected()) {
          return (PaymentStrategy) new NagadPayment();
      }
  
      // Si ninguno está seleccionado, devuelve la estrategia por defecto (ningún pago seleccionado)
      return new NoPaymentSelectedStrategy();
  }

}

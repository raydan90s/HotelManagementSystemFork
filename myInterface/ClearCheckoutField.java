package myinterface;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

public interface ClearCheckoutField {
    void clearCheckoutField(
      JTextField custName_fld,
      JTextField custNum_fld,
      JTextField checkInDate_fld,
      JTextField pricePerDay_fld,
      JTextField dayStay_fld,
      JTextField totalAmount_fld,
      JTextField email_fld,
      JComboBox<String> roomNum_fld,
      JTable table);
}

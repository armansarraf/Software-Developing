package View;

import java.awt.*;
import javax.swing.*;

public class UserView extends JFrame {
	private JLabel userCategory = new JLabel("");

    private JButton login = new JButton("Log in");
    
    private JButton annualFee = new JButton("Annual Fee");
    
    private JButton payWithCoupon = new JButton("Enter Coupon");
    
    private JButton makePayment = new JButton("MAKE PAYMENT");
    
    private JButton seatCancellation = new JButton("CANCEL SEAT");
    
    private JButton register = new JButton("REGISTER");
    
    private JButton noAccount = new JButton("GUEST");
    
    private JTextField annualFeeStatus = new JTextField(30);
    
    private JTextField userName = new JTextField(15);
    
    private JTextField password = new JTextField(15);
    
    private JTextField display = new JTextField(15);
    
    private JTextField coupon_id = new JTextField(15);
    
    private JTextField balance = new JTextField(15);
    
    private JTextField clientName = new JTextField(15);
    
    private JTextField address = new JTextField(30);
    
    private JTextField cardNumber = new JTextField(30);
    
    private JTextField expirationDate = new JTextField(7);
    
    private JTextField cvv = new JTextField(7);
    
    private JTextField financialInstitution = new JTextField(22);
    
    private JTextField email = new JTextField(15);
    
    private JTextField textField;


    public UserView() {
    	
    	setResizable(false);
        
    	Container content_pane = getContentPane();
        
        content_pane.setSize(200, 200);
    
        getContentPane().setLayout(null);

        JPanel panel_0 = new JPanel();
        
        panel_0.setBounds(0, 0, 784, 52);
     
        content_pane.add(panel_0);
        
        JLabel lblNewLabel = new JLabel("MAKE PAYMENT");
        
        lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 27));
        
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        panel_0.add(lblNewLabel);

       
        JPanel Panel_1 = new JPanel();
        
        Panel_1.setBounds(0, 96, 784, 33);
        
        JLabel userNamePrompt = new JLabel("USERNAME");
        
        userNamePrompt.setFont(new Font("Poppins", Font.PLAIN, 11));

        Panel_1.add(userNamePrompt);
        
        Panel_1.add(userName);

        
        content_pane.add(Panel_1);
         
         JPanel panel = new JPanel();

         Panel_1.add(panel);
        
                 
         
         JLabel passwordPrompt = new JLabel("PASSWORD");
         
         passwordPrompt.setFont(new Font("Poppins", Font.PLAIN, 11));
         
         Panel_1.add(passwordPrompt);
         
         Panel_1.add(password);
         
         
         JPanel panel_1 = new JPanel();
         
         FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
         
         flowLayout.setHgap(10);
         
         Panel_1.add(panel_1);
         
         login.setFont(new Font("Poppins", Font.PLAIN, 11));
         
         Panel_1.add(login);
         
         login.setHorizontalAlignment(SwingConstants.LEFT);

        JPanel Panel_2 = new JPanel();
        
        Panel_2.setBounds(0, 448, 784, 33);

               
        JLabel lblSubscription = new JLabel("SUBSCRIPTION");
        
        lblSubscription.setFont(new Font("Poppins", Font.PLAIN, 11));
        
        Panel_2.add(lblSubscription);
              
        
        Panel_2.add(annualFeeStatus);
       
        annualFee.setFont(new Font("Poppins", Font.PLAIN, 11));

        
        Panel_2.add(annualFee);
        
        content_pane.add(Panel_2);
        
        JLabel couponIdPrompt = new JLabel("COUPON");
        
        Panel_2.add(couponIdPrompt);
        
        couponIdPrompt.setFont(new Font("Poppins", Font.PLAIN, 11));
        
        Panel_2.add(coupon_id);
        
        Panel_2.add(payWithCoupon);
        
        payWithCoupon.setFont(new Font("Poppins", Font.PLAIN, 11));

        
        JPanel Panel_4 = new JPanel();
        
        Panel_4.setBounds(0, 186, 784, 33);
        
        JLabel namePrompt = new JLabel("FULL NAME       ");
        
        namePrompt.setFont(new Font("Poppins", Font.PLAIN, 11));
        
        Panel_4.add(namePrompt);
        
        Panel_4.add(clientName);
 
        content_pane.add(Panel_4);
        
        JPanel panel_1_2 = new JPanel();
        
        Panel_4.add(panel_1_2);
        
        JLabel emailPrompt = new JLabel("EMAIL       ");
        
        Panel_4.add(emailPrompt);
        
        emailPrompt.setFont(new Font("Poppins", Font.PLAIN, 11));
        
        emailPrompt.setHorizontalAlignment(SwingConstants.CENTER);
        
        Panel_4.add(email);
        
        
        JPanel Panel_7 = new JPanel();
        
        Panel_7.setBounds(0, 287, 784, 33);
        
        content_pane.add(Panel_7);
        
        JLabel card_noPrompt = new JLabel("CARD NUMBER ");
        
        card_noPrompt.setFont(new Font("Poppins", Font.PLAIN, 11));
        
        Panel_7.add(card_noPrompt);
        
        Panel_7.add(cardNumber);

        
        JPanel Panel_8 = new JPanel();
        
        Panel_8.setBounds(0, 320, 784, 33);
        
        JLabel expr_datePrompt = new JLabel("EXP DATE");
        
        expr_datePrompt.setFont(new Font("Poppins", Font.PLAIN, 11));
        
        Panel_8.add(expr_datePrompt);
        
        Panel_8.add(expirationDate);
        
        content_pane.add(Panel_8);
        
        JPanel panel_1_1 = new JPanel();
        
        Panel_8.add(panel_1_1);
        
        panel_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
        
        JLabel cvvPrompt = new JLabel("CVV");
        
        cvvPrompt.setFont(new Font("Poppins", Font.PLAIN, 11));
        
        Panel_8.add(cvvPrompt);
        
        Panel_8.add(cvv);

        JPanel Panel_13 = new JPanel();
        
        Panel_13.setBounds(0, 364, 784, 40);
        
        register.setFont(new Font("Poppins", Font.PLAIN, 11));
        
        Panel_13.add(register);
        
        JLabel spacePrompt_3 = new JLabel("                  ");
        
        Panel_13.add(spacePrompt_3);
        
        noAccount.setFont(new Font("Poppins", Font.PLAIN, 11));
        
        Panel_13.add(noAccount);
        
        content_pane.add(Panel_13);

        JPanel Panel_14_1 = new JPanel();
        
        Panel_14_1.setBounds(0, 487, 784, 33);
        
        JLabel balance_prompt = new JLabel("BALANCE");
        
        balance_prompt.setFont(new Font("Poppins", Font.PLAIN, 11));
        
        Panel_14_1.add(balance_prompt);
        
        Panel_14_1.add(balance);
        
        makePayment.setFont(new Font("Poppins", Font.PLAIN, 11));
        
        Panel_14_1.add(makePayment);
        
        content_pane.add(Panel_14_1);
        
        seatCancellation.setFont(new Font("Poppins", Font.PLAIN, 11));
        
        
        Panel_14_1.add(seatCancellation);

        
        JPanel Panel_15_0 = new JPanel();
        
        Panel_15_0.setBounds(0, 581, 784, 233);
        
        content_pane.add(Panel_15_0);
        
        ScrollPane messageSp = new ScrollPane();
        
        Panel_15_0 .add(messageSp);
        
       
		
    	display.setLayout(new GridBagLayout());
		
    	display.setBackground(new Color(205,217,245));
        messageSp.add(display);
        
        messageSp.setSize(500, 220);
        
        JPanel Panel_1_1 = new JPanel();
        
        Panel_1_1.setBounds(0, 63, 784, 33);
        
        getContentPane().add(Panel_1_1);
        
        JLabel lblUserLogin = new JLabel("USER LOGIN");
        
        lblUserLogin.setFont(new Font("Poppins", Font.PLAIN, 13));
        
        Panel_1_1.add(lblUserLogin);
        
        JPanel Panel_1_1_1 = new JPanel();
        
        Panel_1_1_1.setBounds(0, 153, 784, 33);
        
        getContentPane().add(Panel_1_1_1);
        
        JLabel lblUserDetails = new JLabel("USER DETAILS");
        
        lblUserDetails.setFont(new Font("Poppins", Font.PLAIN, 13));
        
        Panel_1_1_1.add(lblUserDetails);
        
        JPanel Panel_6_1 = new JPanel();
        
        Panel_6_1.setBounds(0, 218, 784, 40);
        
        getContentPane().add(Panel_6_1);
        
                JPanel Panel_5 = new JPanel();
        
                Panel_6_1.add(Panel_5);
                
                JLabel addressPrompt = new JLabel("ADDRESS         ");
                
                addressPrompt.setFont(new Font("Poppins", Font.PLAIN, 11));
                
                addressPrompt.setHorizontalAlignment(SwingConstants.RIGHT);
                
                Panel_5.add(addressPrompt);
                
                Panel_5.add(address);
        
        JPanel Panel_6_1_1 = new JPanel();
        
        Panel_6_1_1.setBounds(0, 257, 784, 33);
        
        getContentPane().add(Panel_6_1_1);
        
        JLabel bankPrompt = new JLabel("BANK                ");
        
        bankPrompt.setHorizontalAlignment(SwingConstants.CENTER);
        
        bankPrompt.setFont(new Font("Poppins", Font.PLAIN, 11));
        
        Panel_6_1_1.add(bankPrompt);
        
        textField = new JTextField(30);
        
        Panel_6_1_1.add(financialInstitution);
        
        JPanel Panel_1_1_1_1 = new JPanel();
        
        Panel_1_1_1_1.setBounds(0, 415, 784, 33);
        
        getContentPane().add(Panel_1_1_1_1);
        
        JLabel lblCoupon = new JLabel("COUPON VALIDATION");
        
        lblCoupon.setFont(new Font("Poppins", Font.PLAIN, 13));
        
        Panel_1_1_1_1.add(lblCoupon);
        
        JPanel Panel_1_1_1_1_1 = new JPanel();
        
        Panel_1_1_1_1_1.setBounds(0, 547, 784, 33);
        
        getContentPane().add(Panel_1_1_1_1_1);
        
        JLabel lblTicketsAndReceipt = new JLabel("TICKETS AND RECEIPT");
        
        lblTicketsAndReceipt.setFont(new Font("Poppins", Font.PLAIN, 13));
        
        Panel_1_1_1_1_1.add(lblTicketsAndReceipt);

        setTitle("UserInfoView");

        setSize(800, 854);
        
        setLocation(720, 0);
        
        setVisible(true);
    }

   
    public JTextField getUserName() {
   
    	return userName;
    }

    public JTextField getPassword() {
        
    	return password;
    }

    public JTextField getFeeRenewalStatus() {
        
    	return annualFeeStatus;
    }

    public JLabel getUserType() {
        
    	return userCategory;
    }

    public JTextField getNameOfUser() {
        
    	return clientName;
    }

    public JTextField getAddr() {

    	return address;
    }

    public JTextField getBank() {
        
    	return financialInstitution;
    }

    public JTextField getCard_no() {
        
    	return cardNumber;
    }

    public JTextField getExpr_date() {
        
    	return expirationDate;
    }

    public JTextField getCvv() {
        
    	return cvv;
    }

    public JTextField getEmail() {
        
    	return email;
    }

    public JButton getLogin() {
        
    	return login;
    }

    public JButton getNoAccount() {
     
    	return noAccount;
    }

    public JButton getRegister() {
        
    	return register;
    }

    public JTextField getDisplay() {
        
    	return display;
    }

    public JTextField getCouponId() {
        
    	return coupon_id;
    }

    public JButton getMakePayment() {
        
    	return makePayment;
    }

    public JButton getMakePaymentWithCoupon() {
        
    	return payWithCoupon;
    }

    public JTextField getBalance() {
        
    	return balance;
    }

    public JButton getCancelSeat() {
     
    	return seatCancellation;
    }

    public void setDisplay(String text) {
        
    	display.setText(text);
    }

    public void setStatus(String text) {
        
    	annualFeeStatus.setText(text);
    }

    public JButton getRenewFee() {
        
    	return annualFee;
    }

    public void clearDisplay() {
     
    	display.setText("");
    }
}
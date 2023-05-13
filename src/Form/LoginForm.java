package Form;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginForm extends JFrame 
{
    private JPanel jPanelHeader;
    private JPanel jPanelContent;

    private JPanel jPanelTextInput;
    private JPanel jPanelBtn;

    private JLabel jLabelHeader;
    private JLabel jlabelLogin;
    private JLabel jLabelAccNum;
    private JLabel jLabelPinCode;

    private JTextField jTextUserName;
    private JPasswordField jPasswordField;

    private JButton jButtonLogin;



    public LoginForm ()
    {
        setupUI();
        setEvent();
        this.setVisible(true);
    }

    private void setEvent()
    {
        jButtonLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    if(BLL.BLLLogin.login(jTextUserName.getText(), new String(jPasswordField.getPassword())))
                    {
                        dispose();
                        new MainForm();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không chính xác");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            
        });
    }

    private void setupUI()
    {
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setTitle("Login");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        jButtonLogin = new JButton("Login");

        jPasswordField = new JPasswordField();
        jTextUserName = new JTextField();

        jLabelPinCode = new JLabel("Password", JLabel.CENTER);
        jLabelAccNum = new JLabel("User Name", JLabel.CENTER);
        jlabelLogin = new JLabel("Login", JLabel.CENTER);
        jLabelHeader = new JLabel("Ứng dụng quản lý nhân viên quán CAFE", JLabel.CENTER);

        jPanelTextInput = new JPanel();
        jPanelTextInput.setLayout(new GridLayout(3, 1));
        jPanelTextInput.add(jLabelAccNum);
        jPanelTextInput.add(jTextUserName);
        jPanelTextInput.add(jLabelPinCode);
        jPanelTextInput.add(jPasswordField);

        jPanelBtn = new JPanel();
        jPanelBtn.setLayout(new FlowLayout());
        jPanelBtn.add(jButtonLogin);

        jPanelHeader = new JPanel();
        jPanelHeader.setBackground(new Color(52, 152, 219));
        jPanelHeader.add(jLabelHeader);

        jPanelContent = new JPanel();
        jPanelContent.setLayout(new GridLayout(3, 1));
        

        jPanelContent.add(jlabelLogin);
        jPanelContent.add(jPanelTextInput);
        jPanelContent.add(jPanelBtn);


        this.setLayout(new BorderLayout());
        this.add(jPanelHeader, BorderLayout.NORTH);
        this.add(jPanelContent, BorderLayout.CENTER);
    }
}
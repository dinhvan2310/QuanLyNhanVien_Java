package Form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Form.MainForm_ChildForm.JPanelCaiDat;
import Form.MainForm_ChildForm.JPanelQuanLy;
import Form.MainForm_ChildForm.JPanelThongTinUngDung;

public class MainForm extends JFrame {
    private JPanel _JPanelQuanLy;
    private JPanel _JPanelCaiDat;
    private JPanel _JPanelThongTinUngDung;

    private JPanel _JPanelMenu;
    private JPanel _JPanelContent;

    private JButton _ButtonQuanLy;
    private JButton _ButtonCaiDat;
    private JButton _ButtonThongTinUngDung;

    private JLabel _LabelHeaderImage;
    private JLabel _LabelHeader;




    private JPanel _currJPanel = _JPanelQuanLy;

    

    public MainForm() throws SQLException {
        init();
        setEvent();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(1280, 720));
        //Fix cứng kích thước JFrame
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * The function initializes and sets up a graphical user interface with a menu panel and three
     * content panels.
     * @throws SQLException
     */
    private void init() throws SQLException {
        // #region Lable
        _LabelHeaderImage = new JLabel("" ,new ImageIcon(), JLabel.CENTER);
        _LabelHeaderImage.setIcon(new ImageIcon(new ImageIcon(System.getProperty("user.dir") + "//BaiTapNhom//BaiTapNhom//resource" + "//logo.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        _LabelHeader = new JLabel("", null, JLabel.CENTER);
        _LabelHeader.setPreferredSize(new Dimension(WIDTH, 40));
        _LabelHeader.setForeground(Color.WHITE);
        _LabelHeader.setBackground(new Color(112, 161, 255));
        _LabelHeader.setOpaque(true);
        // #endregion

        // #region Button
        _ButtonQuanLy = new JButton("QUAN LY", null);
        _ButtonQuanLy.setMaximumSize(new Dimension(200, 60));
        _ButtonCaiDat = new JButton("CAI DAT", null);
        _ButtonCaiDat.setMaximumSize(new Dimension(200, 60));
        _ButtonThongTinUngDung = new JButton("Thong Tin", null);
        _ButtonThongTinUngDung.setMaximumSize(new Dimension(200, 60));
        // #endregion

        // #region Menu
        _JPanelMenu = new JPanel();
        _JPanelMenu.setLayout(new BoxLayout(_JPanelMenu, BoxLayout.Y_AXIS));
        _JPanelMenu.setPreferredSize(new Dimension(200, 60));
        _JPanelMenu.setBackground(new Color(255, 190, 118));

        _JPanelMenu.add(_LabelHeaderImage);
        // _JPanelMenu.add(Box.createVerticalStrut(30));
        _JPanelMenu.add(_ButtonQuanLy);
        // _JPanelMenu.add(Box.createVerticalStrut(50));
        _JPanelMenu.add(Box.createVerticalStrut(300));
        _JPanelMenu.add(_ButtonThongTinUngDung);
        _JPanelMenu.add(_ButtonCaiDat);
        // _JPanelMenu.add(Box.createVerticalStrut(50));

        _JPanelContent = new JPanel(new BorderLayout());
        _JPanelContent.add(_LabelHeader, BorderLayout.NORTH);
        // #endregion

        // #region Panel
        _JPanelQuanLy = new JPanelQuanLy();
        _JPanelCaiDat = new JPanelCaiDat();
        _JPanelThongTinUngDung = new JPanelThongTinUngDung();
        // #endregion

        setLayout(new BorderLayout());
        add(_JPanelMenu, BorderLayout.WEST);
        add(_JPanelContent, BorderLayout.CENTER);
        openChildJPanel(_JPanelQuanLy, "QUAN LY");
    }

    
    
    /**
     * This function opens a child JPanel and sets it as the current JPanel, hiding the previous one if
     * it exists.
     * 
     * @param currJPanel The JPanel that needs to be opened and displayed on the screen.
     */
    private void openChildJPanel(JPanel currJPanel, String name) {
        if (currJPanel != _currJPanel) {
            currJPanel.setVisible(true);
            if (_currJPanel != null) {
                _currJPanel.setVisible(false);
            }
            _currJPanel = currJPanel;
            _LabelHeader.setText(name);
            _JPanelContent.add(currJPanel, BorderLayout.CENTER);
        }
    }

    /**
     * This function sets the event listeners for three buttons that open different child JPanels when
     * clicked.
     */
    private void setEvent() {
        _ButtonQuanLy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                openChildJPanel(_JPanelQuanLy, "QUẢN LÝ");
            }

        });

        _ButtonCaiDat.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                openChildJPanel(_JPanelCaiDat, "CÀI ĐẶT");
            }

        });

        _ButtonThongTinUngDung.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                openChildJPanel(_JPanelThongTinUngDung, "THÔNG TIN ỨNG DỤNG");
            }

        });
    }
}
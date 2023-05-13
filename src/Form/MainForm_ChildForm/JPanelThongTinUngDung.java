package Form.MainForm_ChildForm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JPanelThongTinUngDung extends JPanel
{
    private JLabel _jlabelHeader;
    private JLabel _jLabelSv1;
    private JLabel _jLabelSv2;
    private JLabel _jLabelSv3;

    private JPanel _jPanelContent;

    public JPanelThongTinUngDung()
    {
        init();
        setEvent();
    }

    private void init()
    {
        System.out.println(this.getMaximumSize().width);
        _jlabelHeader = new JLabel("Danh sách sinh viên thực hiện");
        _jlabelHeader.setHorizontalAlignment(SwingConstants.CENTER);
        _jlabelHeader.setPreferredSize(new Dimension(this.getMaximumSize().width, 80));
        
        _jLabelSv1 = new JLabel("Trần Đình Văn - 102210286");
        _jLabelSv1.setHorizontalAlignment(SwingConstants.CENTER);
        _jLabelSv2 = new JLabel("Thân Đức Nhật Tân - 102210276");
        _jLabelSv2.setHorizontalAlignment(SwingConstants.CENTER);
        _jLabelSv3 = new JLabel("Lê Thanh Việt - 102210287");
        _jLabelSv3.setHorizontalAlignment(SwingConstants.CENTER);

        _jPanelContent = new JPanel();
        _jPanelContent.setLayout(new BoxLayout(_jPanelContent, BoxLayout.Y_AXIS));
        _jPanelContent.add(_jLabelSv1);
        _jPanelContent.add(_jLabelSv2);
        _jPanelContent.add(_jLabelSv3);

        setLayout(new BorderLayout());
        add(_jlabelHeader, BorderLayout.NORTH);
        add(_jPanelContent, BorderLayout.CENTER);
    }

    private void setEvent()
    {

    }
}
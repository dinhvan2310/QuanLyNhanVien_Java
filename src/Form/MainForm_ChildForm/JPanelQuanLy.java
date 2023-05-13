package Form.MainForm_ChildForm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DTO.NhanVien;
import DataAccess.DataHelper;

public class JPanelQuanLy extends JPanel {
    private JTable _jTable;

    private JScrollPane _jscrollPane;

    private JPanel _jPanelSearch;
    private JPanel _jPanelAdd;
    private JPanel _jPanelFooter;
    private JPanel _jPanelButtonAdd;

    private JTextField _jTextSearch;
    private JTextField _jTextName;
    private JTextField _jTextAddress;
    private JTextField _jTextSalary;
    private JTextField _JtextPhoneNumber;
    private JTextField _JTextFieldId;

    private JComboBox _jComboBoxSearch;
    private JComboBox _jComboBoxSort;
    private JComboBox _jComboBoxGender;
    private JComboBox _jComboBoxWorkShift;
    private JComboBox _jComboBoxPosition;

    private JButton _jButtonSearch;
    private JButton _jButtonSort;
    private JButton _jButtonAdd;
    private JButton _jButtonUpdate;
    private JButton _jButtonDelete;
    private JButton _JButtonReset;

    private JLabel _JLabelName;
    private JLabel _JLabelGender;
    private JLabel _JLabelPosition;
    private JLabel _JLabelAddress;
    private JLabel _JLabelPhoneNumber;
    private JLabel _JLabelSalary;
    private JLabel _JLabelWorkShift;
    private JLabel _JLabelId;

    private JCheckBox _jcheckBoxSortAcc;
    private JCheckBox _jcheckBoxSortDes;

    private ButtonGroup _ButtonGroup;

    public JPanelQuanLy() throws SQLException {
        init();

        _JTextFieldId.setEnabled(false);

        showTable();
        setEvent();
    }

    private void init() throws SQLException {
        // #region TextField
        _jTextSearch = new JTextField(20);
        _jTextSearch.setPreferredSize(new Dimension(100, 30));

        _jTextName = new JTextField();
        _jTextAddress = new JTextField();
        _JtextPhoneNumber = new JTextField();
        _jTextSalary = new JTextField();
        _JTextFieldId = new JTextField();
        // #endregion

        // #region button
        _jButtonSearch = new JButton("Search", null);
        _jButtonSearch.setPreferredSize(new Dimension(100, 30));
        _jButtonSort = new JButton("Sort", null);
        _jButtonSort.setPreferredSize(new Dimension(100, 30));
        _jButtonAdd = new JButton("Add", null);
        _jButtonAdd.setPreferredSize(new Dimension(100, 30));
        _jButtonUpdate = new JButton("Update", null);
        _jButtonUpdate.setPreferredSize(new Dimension(100, 30));
        _jButtonDelete = new JButton("Delete", null);
        _jButtonDelete.setPreferredSize(new Dimension(100, 30));
        _JButtonReset = new JButton("Reset", null);
        _JButtonReset.setPreferredSize(new Dimension(100, 30));
        // #endregion

        // #region ComboBox
        _jComboBoxSearch = new JComboBox(new Object[] {
                "Id", "Name", "Gender", "Position", "Address", "WorkShift"
        });
        _jComboBoxSearch.setPreferredSize(new Dimension(100, 30));
        _jComboBoxSort = new JComboBox(new Object[] {
                "Id", "Name", "Gender", "StartDay", "Position", "Address", "Salary", "WorkShift"
        });
        _jComboBoxSort.setPreferredSize(new Dimension(100, 30));

        _jComboBoxGender = new JComboBox(new Object[] {
                "Nữ", "Nam"
        });

        _jComboBoxPosition = new JComboBox(new Object[] {
                "Thu Ngân", "Pha Chế", "Phục Vụ", "Bảo Vệ"
        });

        _jComboBoxWorkShift = new JComboBox(new Object[] {
                "Sáng", "Trưa", "Chiều", "Tối"
        });
        // #endregion

        // #region Label
        _JLabelName = new JLabel("Name");
        _JLabelName.setHorizontalAlignment(SwingConstants.CENTER);
        _JLabelGender = new JLabel("Gender");
        _JLabelGender.setHorizontalAlignment(SwingConstants.CENTER);
        _JLabelPosition = new JLabel("Position");
        _JLabelPosition.setHorizontalAlignment(SwingConstants.CENTER);
        _JLabelAddress = new JLabel("Address");
        _JLabelAddress.setHorizontalAlignment(SwingConstants.CENTER);
        _JLabelPhoneNumber = new JLabel("Phone Number");
        _JLabelPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
        _JLabelSalary = new JLabel("Salary");
        _JLabelSalary.setHorizontalAlignment(SwingConstants.CENTER);
        _JLabelWorkShift = new JLabel("Work Shift");
        _JLabelWorkShift.setHorizontalAlignment(SwingConstants.CENTER);
        _JLabelId = new JLabel("ID: ");
        _JLabelId.setHorizontalAlignment(SwingConstants.CENTER);

        // #endregion

        // #region table
        _jTable = new JTable();
        // #endregion

        // #region JscrollPane
        _jscrollPane = new JScrollPane(_jTable);
        _jscrollPane.setPreferredSize(new Dimension(1000, 500));
        // #endregion

        // #region checkboxes
        _ButtonGroup = new ButtonGroup();
        _jcheckBoxSortAcc = new JCheckBox("Ascending", true);
        _jcheckBoxSortDes = new JCheckBox("Descending");
        _ButtonGroup.add(_jcheckBoxSortAcc);
        _ButtonGroup.add(_jcheckBoxSortDes);
        // #endregion

        // #region Panel
        _jPanelSearch = new JPanel();
        _jPanelSearch.setLayout(new BoxLayout(_jPanelSearch, BoxLayout.X_AXIS));
        _jPanelSearch.add(_jComboBoxSort);
        _jPanelSearch.add(Box.createHorizontalStrut(20));
        _jPanelSearch.add(_jcheckBoxSortAcc);
        _jPanelSearch.add(_jcheckBoxSortDes);
        _jPanelSearch.add(Box.createHorizontalStrut(20));
        _jPanelSearch.add(_jButtonSort);

        _jPanelSearch.add(Box.createHorizontalStrut(250));

        _jPanelSearch.add(_jTextSearch);
        _jPanelSearch.add(Box.createHorizontalStrut(20));
        _jPanelSearch.add(_jComboBoxSearch);
        _jPanelSearch.add(Box.createHorizontalStrut(20));
        _jPanelSearch.add(_jButtonSearch);

        _jPanelAdd = new JPanel(new GridLayout(5, 4));
        _jPanelAdd.add(_JLabelId);
        _jPanelAdd.add(_JTextFieldId);
        _jPanelAdd.add(_JLabelName);
        _jPanelAdd.add(_jTextName);
        _jPanelAdd.add(_JLabelGender);
        _jPanelAdd.add(_jComboBoxGender);
        _jPanelAdd.add(_JLabelPosition);
        _jPanelAdd.add(_jComboBoxPosition);
        _jPanelAdd.add(_JLabelAddress);
        _jPanelAdd.add(_jTextAddress);
        _jPanelAdd.add(_JLabelPhoneNumber);
        _jPanelAdd.add(_JtextPhoneNumber);
        _jPanelAdd.add(_JLabelSalary);
        _jPanelAdd.add(_jTextSalary);
        _jPanelAdd.add(_JLabelWorkShift);
        _jPanelAdd.add(_jComboBoxWorkShift);

        _jPanelButtonAdd = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        _jPanelButtonAdd.add(_jButtonAdd);
        _jPanelButtonAdd.add(_jButtonUpdate);
        _jPanelButtonAdd.add(_jButtonDelete);
        _jPanelButtonAdd.add(_JButtonReset);

        _jPanelFooter = new JPanel(new BorderLayout());
        _jPanelFooter.add(_jPanelAdd, BorderLayout.CENTER);
        _jPanelFooter.setBackground(new Color(112, 161, 255));
        _jPanelFooter.add(_jPanelButtonAdd, BorderLayout.EAST);
        // #endregion

        setBackground(new Color(112, 161, 255));

        setLayout(new BorderLayout(10, 10));

        add(_jPanelSearch, BorderLayout.NORTH);
        add(_jPanelFooter, BorderLayout.SOUTH);
        add(_jscrollPane, BorderLayout.CENTER);
    }

    private void setEvent() {
        _jButtonAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = { "Yes", "No" };
                int selectedOption = JOptionPane.showOptionDialog(null, "Bạn có chắc chắn muốn thêm không?", "Cảnh báo",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                if (selectedOption == 1) 
                {
                    return;
                }


                if (!_JTextFieldId.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Địa chỉ Id đã tồn tại");
                    return;
                }
                boolean check = true;

                if (_jTextName.getText().isEmpty())
                    check = false;
                if (_jTextAddress.getText().isEmpty())
                    check = false;
                if (_jTextSalary.getText().isEmpty())
                    check = false;
                else {
                    try {
                        Double.parseDouble(_jTextSalary.getText());
                    } catch (NumberFormatException nfe) {
                        check = false;
                    }
                }
                if (_JtextPhoneNumber.getText().isEmpty())
                    check = false;
                else {
                    if (!_JtextPhoneNumber.getText().matches("\\d{10}")) {
                        check = false;
                    }
                }

                if (check) {
                    NhanVien nhanVien = new NhanVien();
                    nhanVien.setId(-1);
                    nhanVien.setName(_jTextName.getText());
                    nhanVien.setGender(_jComboBoxGender.getSelectedItem().toString());
                    java.util.Date now = new java.util.Date();
                    nhanVien.setStarDate(new Date(now.getYear(), now.getMonth(), now.getDate()));
                    nhanVien.setPosition(_jComboBoxPosition.getSelectedItem().toString());
                    nhanVien.setAddress(_jTextAddress.getText());
                    nhanVien.setPhoneNumber(_JtextPhoneNumber.getText());
                    nhanVien.setSalary(Double.parseDouble(_jTextSalary.getText()));
                    nhanVien.setWorkShift(_jComboBoxWorkShift.getSelectedItem().toString());
                    if (addDataRow(nhanVien)) {
                        JOptionPane.showMessageDialog(null, "Thêm thành công");
                        showTable();
                    } else {
                        JOptionPane.showMessageDialog(null, "Thêm thất bại");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm thất bại");
                }
            }

        });

        _jButtonUpdate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = { "Yes", "No" };
                int selectedOption = JOptionPane.showOptionDialog(null, "Bạn có chắc chắn muốn cập nhật không?", "Cảnh báo",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                if (selectedOption == 1) 
                {
                    return;
                }

                if (_JTextFieldId.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Chưa xác định được đối tượng cần cập nhật");
                    return;
                }
                boolean check = true;

                if (_jTextName.getText().isEmpty())
                    check = false;
                if (_jTextAddress.getText().isEmpty())
                    check = false;
                if (_jTextSalary.getText().isEmpty())
                    check = false;
                else {
                    try {
                        Double.parseDouble(_jTextSalary.getText());
                    } catch (NumberFormatException nfe) {
                        check = false;
                    }
                }
                if (_JtextPhoneNumber.getText().isEmpty())
                    check = false;
                else {
                    if (!_JtextPhoneNumber.getText().matches("\\d{10}")) {
                        check = false;
                    }
                }

                if (check) {
                    NhanVien nhanVien = new NhanVien();
                    nhanVien.setId(Integer.parseInt(_JTextFieldId.getText()));
                    nhanVien.setName(_jTextName.getText());
                    nhanVien.setGender(_jComboBoxGender.getSelectedItem().toString());
                    java.util.Date now = new java.util.Date();
                    nhanVien.setStarDate(new Date(now.getYear(), now.getMonth(), now.getDate()));
                    nhanVien.setPosition(_jComboBoxPosition.getSelectedItem().toString());
                    nhanVien.setAddress(_jTextAddress.getText());
                    nhanVien.setPhoneNumber(_JtextPhoneNumber.getText());
                    nhanVien.setSalary(Double.parseDouble(_jTextSalary.getText()));
                    nhanVien.setWorkShift(_jComboBoxWorkShift.getSelectedItem().toString());
                    if (addDataRow(nhanVien)) {
                        JOptionPane.showMessageDialog(null, "Thành công");
                        showTable();
                    } else {
                        JOptionPane.showMessageDialog(null, "Thất bại");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Thất bại");
                }
            }

        });

        _jButtonDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = { "Yes", "No" };
                int selectedOption = JOptionPane.showOptionDialog(null, "Bạn có chắc chắn muốn xóa không?", "Cảnh báo",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                if (selectedOption == 0) {
                    int[] rowSelecteds = _jTable.getSelectedRows();
                    for (int i : rowSelecteds) {
                        BLL.BLLDataAccess.deleteNhanVien((int) _jTable.getValueAt(i, 0));
                    }
                    showTable();
                }
            }

        });

        _JButtonReset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                _JTextFieldId.setText("");
                _jTextName.setText("");
                _jTextSalary.setText("");
                _JtextPhoneNumber.setText("");
                _jTextAddress.setText("");

                _jComboBoxGender.setSelectedIndex(0);
                _jComboBoxPosition.setSelectedIndex(0);
                _jComboBoxWorkShift.setSelectedIndex(0);
            }

        });

        _jTable.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = _jTable.getSelectedRow();
                if (selectedRow != -1) {
                    _JTextFieldId.setText(_jTable.getValueAt(selectedRow, 0).toString());
                    _jTextName.setText(_jTable.getValueAt(selectedRow, 1).toString());
                    _jComboBoxGender.setSelectedItem(_jTable.getValueAt(selectedRow, 2));
                    _jComboBoxPosition.setSelectedItem(_jTable.getValueAt(selectedRow, 4));
                    _jTextAddress.setText(_jTable.getValueAt(selectedRow, 5).toString());
                    _JtextPhoneNumber.setText(_jTable.getValueAt(selectedRow, 6).toString());
                    _jTextSalary.setText(_jTable.getValueAt(selectedRow, 7).toString());
                    _jComboBoxWorkShift.setSelectedItem(_jTable.getValueAt(selectedRow, 8));
                }
            }

        });

        _jButtonSort.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                showTablesort();
            }
            
        });

        _jButtonSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                showTableSearch();
            }
            
        });
    }

    private void showTablesort() {
        try {
            ResultSet rs;

            if(_jcheckBoxSortAcc.isSelected() && _jComboBoxSort.getSelectedIndex() == 0)
            {
                rs = BLL.BLLDataAccess.getListFullNhanVienSortAcsByID();
            }
            else if(_jcheckBoxSortDes.isSelected() && _jComboBoxSort.getSelectedIndex() == 0)
            {
                rs = BLL.BLLDataAccess.getListFullNhanVienSortDesByID();
            }  
            else if(_jcheckBoxSortAcc.isSelected() && _jComboBoxSort.getSelectedIndex() == 1)
            {
                rs = BLL.BLLDataAccess.getListFullNhanVienSortAcsByName();
            }
            else if(_jcheckBoxSortDes.isSelected() && _jComboBoxSort.getSelectedIndex() == 1)
            {
                rs = BLL.BLLDataAccess.getListFullNhanVienSortDesByName();
            }
            else if(_jcheckBoxSortAcc.isSelected() && _jComboBoxSort.getSelectedIndex() == 2)
            {
                rs = BLL.BLLDataAccess.getListFullNhanVienSortAcsByGender();
            }
            else if(_jcheckBoxSortDes.isSelected() && _jComboBoxSort.getSelectedIndex() == 2)
            {
                rs = BLL.BLLDataAccess.getListFullNhanVienSortDesByGender();
            }
            else if(_jcheckBoxSortAcc.isSelected() && _jComboBoxSort.getSelectedIndex() == 3)
            {
                rs = BLL.BLLDataAccess.getListFullNhanVienSortAcsByStartDay();
            }
            else if(_jcheckBoxSortDes.isSelected() && _jComboBoxSort.getSelectedIndex() == 3)
            {
                rs = BLL.BLLDataAccess.getListFullNhanVienSortDesByStartDay();
            }
            else if(_jcheckBoxSortAcc.isSelected() && _jComboBoxSort.getSelectedIndex() == 4)
            {
                rs = BLL.BLLDataAccess.getListFullNhanVienSortAcsByPosition();
            }
            else if(_jcheckBoxSortDes.isSelected() && _jComboBoxSort.getSelectedIndex() == 4)
            {
                rs = BLL.BLLDataAccess.getListFullNhanVienSortDesByPosition();
            }
            else if(_jcheckBoxSortAcc.isSelected() && _jComboBoxSort.getSelectedIndex() == 5)
            {
                rs = BLL.BLLDataAccess.getListFullNhanVienSortAcsByAddress();
            }
            else if(_jcheckBoxSortDes.isSelected() && _jComboBoxSort.getSelectedIndex() == 5)
            {
                rs = BLL.BLLDataAccess.getListFullNhanVienSortDesByAddress();
            }
            else if(_jcheckBoxSortAcc.isSelected() && _jComboBoxSort.getSelectedIndex() == 6)
            {
                rs = BLL.BLLDataAccess.getListFullNhanVienSortAscSalary();
            }
            else if(_jcheckBoxSortDes.isSelected() && _jComboBoxSort.getSelectedIndex() == 6)
            {
                rs = BLL.BLLDataAccess.getListFullNhanVienSortDesBySalary();
            }
            else if(_jcheckBoxSortAcc.isSelected() && _jComboBoxSort.getSelectedIndex() == 7)
            {
                rs = BLL.BLLDataAccess.getListFullNhanVienSortAcsWorkShift();
            }
            else if(_jcheckBoxSortDes.isSelected() && _jComboBoxSort.getSelectedIndex() == 7)
            {
                rs = BLL.BLLDataAccess.getListFullNhanVienSortDesByWorkShift();
            }
            else
            {
                rs = null;
            }


            ResultSetMetaData metaData = rs.getMetaData();

            Vector<String> colName = new Vector<String>();
            Vector data = new Vector<>();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                colName.add(metaData.getColumnName(i));
            }

            while (rs.next()) {
                Vector dataRow = new Vector<>();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    dataRow.addElement(rs.getObject(i));
                }
                data.add(dataRow);
            }


            TableModel tableModel = new DefaultTableModel(data, colName);
            _jTable.setModel(tableModel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hiển thị dữ liệu lên table bị lỗi");
        }
    }

    private void showTableSearch() {
        try {
            ResultSet rs = null;
            boolean isValid = true;

            if(_jTextSearch.getText().isEmpty())
            {
                showTable();
                return;
            }

            switch (_jComboBoxSearch.getSelectedIndex())
            {
                case 0:
                {
                    int id = Integer.parseInt(_jTextSearch.getText());
                    rs = BLL.BLLDataAccess.getNhanVienById(id);
                    break;
                }
                case 1:
                {
                    String name = _jTextSearch.getText();
                    rs = BLL.BLLDataAccess.getNhanVienByName(name);
                    break;
                }
                case 2:
                {
                    String gender = _jTextSearch.getText();
                    rs = BLL.BLLDataAccess.getNhanVienByGender(gender);
                    break;
                }
                case 3:
                {
                    String position = _jTextSearch.getText();
                    rs = BLL.BLLDataAccess.getNhanVienByPosition(position);
                    break;
                }
                case 4:
                {
                    String address = _jTextSearch.getText();
                    rs = BLL.BLLDataAccess.getNhanVienByAddress(address);
                    break;
                }
                case 5:
                {
                    String workshift = _jTextSearch.getText();
                    rs = BLL.BLLDataAccess.getNhanVienByWorkShift(workshift);
                    break;
                }
            }
            
            ResultSetMetaData metaData = rs.getMetaData();

            Vector<String> colName = new Vector<String>();
            Vector data = new Vector<>();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                colName.add(metaData.getColumnName(i));
            }

            while (rs.next()) {
                Vector dataRow = new Vector<>();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    dataRow.addElement(rs.getObject(i));
                }
                data.add(dataRow);
            }


            TableModel tableModel = new DefaultTableModel(data, colName);
            _jTable.setModel(tableModel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hiển thị dữ liệu lên table bị lỗi");
        }
    }

    private void showTable() {
        try {
            ResultSet rs = BLL.BLLDataAccess.getListFullNhanVienSortAcsByID();
            ResultSetMetaData metaData = rs.getMetaData();

            Vector<String> colName = new Vector<String>();
            Vector data = new Vector<>();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                colName.add(metaData.getColumnName(i));
            }

            while (rs.next()) {
                Vector dataRow = new Vector<>();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    dataRow.addElement(rs.getObject(i));
                }
                data.add(dataRow);
            }


            TableModel tableModel = new DefaultTableModel(data, colName);
            _jTable.setModel(tableModel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hiển thị dữ liệu lên table bị lỗi");
        }
    }

    private boolean addDataRow(NhanVien nhanVien) {
        return BLL.BLLDataAccess.addNhanVien(nhanVien);
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ps12656_asm_java3;

import javax.swing.table.DefaultTableModel;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;//câu lệnh SQL được biên dịch trước
import java.sql.ResultSet;//Trả về kết quả truy vấn
import java.sql.Statement;//thi hành câu lệnh tùy ý tại thời điểm chạy
import java.util.ArrayList;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author DMX
 */
public class QuanLySV extends javax.swing.JFrame {

    /**
     * Creates new form QuanLySV
     */
    String strHinh = null;
    int row = -1;
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    private String header[] = {"Mã SV", "Họ Tên", "Email", "SĐT", "Giới Tính", "Địa Chỉ", "Hình"};//biến mảng cho bảng
    DefaultTableModel model = new DefaultTableModel(header, 0);// tạo ra bảng và thêm tiêu đề cho bảng
    ArrayList<SinhVien> dssv = new ArrayList<SinhVien>();
    String db_url = "jdbc:sqlserver://localhost;databaseName=QLSV_ASM_JAVA3;user=sa;password=123";

    public QuanLySV() {
        initComponents();
        fillTable();
    }

    public void fillTable() {

        model.setRowCount(0);
        dssv.clear();
        try {
            conn = DriverManager.getConnection(db_url);
            String sql = "Select * from Students";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            //exx\ecuteQuery Dùng để thi hành các câu lệnh truy vấn Select…from…where
            Vector v = null;

            if (rs.isBeforeFirst() == false) {//Xem có tồn tại table ko, nếu sv kko tồn tại thì báo lỗi
                JOptionPane.showMessageDialog(this, "Chưa có sinh viên");
                return;
            }
            while (rs.next()) {
                String masv = rs.getString("MASV");
                String ten = rs.getString("HoTen");
                String email = rs.getString("Email");
                String sdt = rs.getString("SoDT");
                boolean gt = rs.getBoolean("GioiTinh");
                String diachi = rs.getString("DiaChi");
                String hinh = rs.getString("Hinh");
                SinhVien sv = new SinhVien(masv, ten, email, sdt, gt, diachi, hinh);
                dssv.add(sv);

            }
            for (int i = 0; i < dssv.size(); i++) {
                SinhVien sv = dssv.get(i);
                v = new Vector();
                v.add(sv.maSv);
                v.add(sv.hoTen);
                v.add(sv.email);
                v.add(sv.sdt);
                v.add(sv.gioiTinh);
                v.add(sv.diaChi);
                v.add(sv.hinh);
                model.addRow(v);
            }
            tblSV.setModel(model);
            conn.close();
            st.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean validateForm() { // kiểm tra dữ liệu đầu vào không để trống
        if (txtMaSV.getText().equals("") || txtTen.getText().equals("") || txtEmail.getText().equals("") || txtSoDT.getText().equals("") || txtDiachi.getText().equals(""))
        {
            return false;
        }
        return true;
    }

    public void showDuLieu(int row) {// đổ dữ liệu lên bảng
        txtMaSV.setText(tblSV.getValueAt(row, 0).toString());
        txtTen.setText(tblSV.getValueAt(row, 1).toString());
        txtEmail.setText(tblSV.getValueAt(row, 2).toString());
        txtSoDT.setText(tblSV.getValueAt(row, 3).toString());
        boolean gt = Boolean.parseBoolean(tblSV.getValueAt(row, 4).toString());
        if (gt == true) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        txtDiachi.setText(tblSV.getValueAt(row, 5).toString());
        hinhanh(tblSV.getValueAt(row, 6).toString());
    }

    public void hinhanh(String hinh) {
        ImageIcon img = new ImageIcon("src\\images\\" + hinh);// đường dẫn đến hình
        Image im = img.getImage();// lấy hình
        ImageIcon icon = new ImageIcon(im.getScaledInstance(lblHinh.getWidth(), lblHinh.getHeight(), im.SCALE_SMOOTH));
        // getScaledInstance làm cho hình ảnh nhỏ lại, đúng theo chiều rộng và chiều cao đã được qui định
        // SCALE SMOOTH Chọn thuật toán chia tỷ lệ hình ảnh ưu tiên độ mịn hình ảnh cao hơn tốc độ chia tỷ lệ
        lblHinh.setIcon(icon);
    }

    public void clearForm() {// xóa trắng dữ liệu
        txtMaSV.setText("");
        txtTen.setText("");
        txtEmail.setText("");
        txtDiachi.setText("");
        txtSoDT.setText("");

        lblHinh.setIcon(null);
        strHinh = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSoDT = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiachi = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        lblHinh = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSV = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Sinh Viên");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("Quản Lý Sinh Viên");

        jLabel2.setText("Mã SV:");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel3.setText("Họ Tên:");

        jLabel4.setText("Email:");

        jLabel5.setText("Số ĐT:");

        jLabel6.setText("Giới Tính:");

        jLabel7.setText("Địa Chỉ:");

        buttonGroup1.add(rdoNam);
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        txtDiachi.setColumns(20);
        txtDiachi.setRows(5);
        jScrollPane1.setViewportView(txtDiachi);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMaSV)
                                .addComponent(txtTen)
                                .addComponent(txtEmail)
                                .addComponent(txtSoDT, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdoNam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoNu)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHinh, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHinh, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnNew.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/New-icon.png"))); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/save-icon.png"))); // NOI18N
        btnSave.setText(" Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cancel-icon.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update-icon.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnSave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate))
                .addContainerGap())
        );

        tblSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SV", "Họ Tên", "Email", "Số ĐT", "Giới Tính", "Địa Chỉ", "Hình"
            }
        ));
        tblSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSVMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSV);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSVMouseClicked
        // TODO add your handling code here:
        row = tblSV.getSelectedRow();// lấy vị trí
        showDuLieu(row);
    }//GEN-LAST:event_tblSVMouseClicked

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        this.clearForm();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            row = tblSV.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Bạn chưa chọn dữ liệu cần xóa !");
                return;
            } else {
                int ret = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa sinh viên này", "Confirm",
                        JOptionPane.YES_NO_OPTION);
                if (ret != JOptionPane.YES_OPTION) {
                    return;
                }
                String id = txtMaSV.getText();
                try {
                    Connection con = DriverManager.getConnection(db_url);
                    String sql = "delete from Students where MASV=?";
                    PreparedStatement stm = con.prepareStatement(sql);
                    stm.setString(1, id);
                    stm.executeUpdate();
                    //executeUpdate Dùng cho câu lệnh cập nhật dữ liệu (insert,update/delete)
                    dssv.clear();
                    model.setRowCount(0);
                    fillTable();
                    clearForm();

                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (validateForm() == true) {
            try {
                conn = DriverManager.getConnection(db_url);
                String sql = "insert into Students values (?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setString(1, txtMaSV.getText());
                stm.setString(2, txtTen.getText());
                stm.setString(3, txtEmail.getText());
                stm.setString(4, txtSoDT.getText());
                boolean gt;
                if (rdoNam.isSelected()) {
                    gt = true;
                } else {
                    gt = false;
                }
                stm.setBoolean(5, gt);
                stm.setString(6, txtDiachi.getText());
                if (strHinh == null) {
                    stm.setString(7, "No Avata");
                } else {
                    stm.setString(7, strHinh);
                }
                stm.setFloat(8,0);
                stm.setFloat(9,0);
                stm.setFloat(10,0);

                stm.executeUpdate();
                JOptionPane.showMessageDialog(this, "Thêm sinh viên thành công!");
                conn.close();
                fillTable();
                clearForm();

            } catch (Exception e) {
                System.out.println(e.toString());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        row = tblSV.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dữ liệu cần sửa!");
            return;
        } else {
            try {
                conn = DriverManager.getConnection(db_url);
                String sql = "Update Students set HoTen=?,Email=?,SoDT=?,GioiTinh=?,DiaChi=?,Hinh=? where MASV=?";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setString(1, txtTen.getText());
                stm.setString(2, txtEmail.getText());
                stm.setString(3, txtSoDT.getText());
                boolean gt;
                if (rdoNam.isSelected()) {
                    gt = true;
                } else {
                    gt = false;
                }
                stm.setBoolean(4, gt);
                stm.setString(5, txtDiachi.getText());
                
                if (strHinh == null) {
                    stm.setString(6,tblSV.getValueAt(row, 6).toString());// nếu hình ko có thì lấy lại hình cũ ở bảng
                } else {// lấy tên mới của hình
                    stm.setString(6, strHinh);
                }
                stm.setString(7, txtMaSV.getText());

                stm.executeUpdate();
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                fillTable();
                clearForm();
                conn.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }

        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void lblHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseClicked
        // TODO add your handling code here:
        try {
            JFileChooser chooser = new JFileChooser("src\\images");
            int chon = chooser.showOpenDialog(null);//mở 1 file
            if(chon==JFileChooser.APPROVE_OPTION){         
            File file = chooser.getSelectedFile(); // lấy ra tệp hình ảnh
            Image img = ImageIO.read(file);// đọc tệp hình ảnh
            strHinh = file.getName();//lấy tên file của hình
            int width = lblHinh.getWidth();
            int height = lblHinh.getHeight();
            lblHinh.setIcon(new ImageIcon(img.getScaledInstance(width, height,img.SCALE_SMOOTH)));               
            }else{
                return;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }//GEN-LAST:event_lblHinhMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLySV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLySV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLySV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLySV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLySV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblSV;
    private javax.swing.JTextArea txtDiachi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtSoDT;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
//Read(file): trả về một BufferedImage kết quả của việc giải mã một trang được cung cấp Filevới một ImageReader lựa chọn tự động trong số những người hiện đã đăng ký.
//sử dụng read phương thức của lớp Java ImageIO và bạn có thể mở / đọc hình ảnh ở nhiều định dạng (GIF, JPG, PNG) về cơ bản bằng một dòng mã Java.
//Lớp JFileChooser là một thành phần cung cấp một kỹ thuật đơn giản cho người dùng để lựa chọn một file
//JFileChooser(): Xây dựng một JFileChooser trỏ tới thư mục mặc định của người dùng.
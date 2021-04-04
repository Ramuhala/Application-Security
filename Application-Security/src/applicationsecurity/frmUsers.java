/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationsecurity;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Rofhiwa Ramuhala
 */
public class frmUsers extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmUsers
     */
    public frmUsers() {
        initComponents();
        mLoadUserName();
        mLoadGUIControls();
    }
    
    CaesarsChiper clsCC=new CaesarsChiper();
    
    Boolean boolRecordExists=false;
    Boolean boolEdit=false;
    Boolean boolCreate=false;
    String strUserName;
    String strPassword;
    String strRole;
    int intUserID;
    
    private void mClearVariables()
    {
        strUserName="";
        strPassword="";
        strRole="";
        intUserID=0;
    }
    
    private void mGetValuesFromGUI()
    {
        strUserName=txtUserName.getText();
        strPassword=txtPassword.getText();
        strRole=txtRole.getText();
    }
    
     private void mSetValuesInGUI()
    {
        txtUserName.setText(strUserName);
        txtPassword.setText(strPassword);
        txtRole.setText(strRole);
    }
    
     private void mSetValuesToUpperCase()
    {
        strUserName=strUserName.toUpperCase();
        strPassword=strPassword.toUpperCase();
        strRole=strRole.toUpperCase();
    }
     
     private void mClearTextFields()
    {
        txtUserName.setText("");
        txtPassword.setText("");
        txtRole.setText("");
    }
     
     private void mcheckIfItemsExistInTable()
    {
        String strDBConnectionString="jdbc:mysql:localhost:3306/sakila";
        String strDBUser="root";
        String strDBPassword="password";
        java.sql.Connection conMySQLConnectionString = null;
        Statement stStatement=null;
        ResultSet rs=null;
        try 
        {
           conMySQLConnectionString=DriverManager.getConnection(strDBConnectionString,strDBUser,strDBPassword);
            stStatement=conMySQLConnectionString.createStatement();
            String strQuery="Select*from Username where first_name+strFirstName+ and last_name= + ";
            stStatement.execute(strQuery);
            
            rs=stStatement.getResultSet();
            boolRecordExists=rs.next();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try
            {
                stStatement.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Connection String not closed"+""+e);
            }
        }
        
    }
     
      private void mCreateUser()
    {
        java.sql.Connection conMySQLConnectionString=null;
        String URL="jdbc:mysql://localhost:3306/sakila";
        String User="root";
        String Password="password";
        try
        {
            conMySQLConnectionString=DriverManager.getConnection(URL,User,Password);
            Statement myStatement=conMySQLConnectionString.createStatement();
            String sqlinsert=" insert into Actor";
            myStatement.executeUpdate(sqlinsert);
            myStatement.close();
            JOptionPane.showMessageDialog(null, "Complete");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
      
      private void mLoadUserName()
    {
        String strDBConnectionString="jdbc:mysql://localhoast:3306/sakila";
        String strDBUser="root";
        String strDBPassword="password";
        java.sql.Connection conMySQLConnnectionString;
        Statement stStatement=null;
        ResultSet rs=null;
        try
        {
            conMySQLConnnectionString=DriverManager.getConnection(strDBConnectionString, strDBUser, strDBPassword);
            stStatement=conMySQLConnnectionString.createStatement();
            String strQuery="Select first_name from Actor";
            stStatement.execute(strQuery);
            rs=stStatement.getResultSet();
            while(rs.next())
            {
                cboUserName.addItem(rs.getString(1));
            }
            }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
                try
                {
                stStatement.close();
                }
                catch(Exception e)
                {
                JOptionPane.showMessageDialog(null, "Connection String not Closed"+""+e);
                }
        }
    }
      
       private void mUpdateUser()
    {
        String strDBConnectionString="jdbc:mysql://localhost:3306/saskila";
        String strDBUser="root";
        String strDBPassword="password";
        java.sql.Connection conMySQLConnectionString;
        Statement stStatement=null;
        ResultSet rs=null;
        try
        {
            conMySQLConnectionString=DriverManager.getConnection(strDBConnectionString,strDBUser,strDBPassword);
            stStatement=conMySQLConnectionString.createStatement();
            String strQuery=" UPDATE actor SET first_name";
            stStatement.executeUpdate(strQuery);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try
            {
                stStatement.close();
            }
            catch(Exception e)
            {
              JOptionPane.showMessageDialog(null, "Connection String not Closed"+""+e);  
            }
        }
    }
  
    private void mClearComboBox()
    {
        String[] arrArray=new String[0];
       javax.swing.DefaultComboBoxModel model= new javax.swing.DefaultComboBoxModel(arrArray);
       cboUserName.setModel(model);
    }
    
     private void mDeleteUser()
    {
        String strDBConnectionString="jdbc:mysql://localhoast:3306/sakila";
        String strDBUser="root";
        String strDBPassword="password";
        java.sql.Connection conMySQLConnnectionString;
        Statement stStatement=null;
        ResultSet rs=null;
        try
        {
            conMySQLConnnectionString=DriverManager.getConnection(strDBConnectionString, strDBUser, strDBPassword);
            stStatement=conMySQLConnnectionString.createStatement();
            String strQuery="Delete from Users where first_name";
            stStatement=conMySQLConnnectionString.prepareStatement(strQuery);
            stStatement.execute(strQuery);
            }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
                try
                {
                stStatement.close();
                }
                catch(Exception e)
                {
                JOptionPane.showMessageDialog(null, "Connection String not Closed"+""+e);
                }
        }
    }
     
     private void mReadUserDetails()
    {
        String strDBConnectionString="jdbc:mysql://localhost:3306/saskila";
        String strDBUser="root";
        String strDBPassword="password";
        java.sql.Connection conMySQLConnectionString;
        Statement stStatement=null;
        ResultSet rs=null;
        try
        {
            conMySQLConnectionString=DriverManager.getConnection(strDBConnectionString,strDBUser,strDBPassword);
            stStatement=conMySQLConnectionString.createStatement();
            String strQuery=" Select actor_id,first_name";
            stStatement.executeUpdate(strQuery);
            rs=stStatement.getResultSet();
            while(rs.next())
            {
                intUserID=rs.getInt(1);
                strUserName=rs.getString(2);
                strPassword=rs.getString(3);
                strRole=rs.getString(4);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try
            {
                stStatement.close();
            }
            catch(Exception e)
            {
              JOptionPane.showMessageDialog(null, "Connection String not Closed"+""+e);  
            }
        }
    }
     
      private void mLoadGUIControls()
    {
        txtUserName.setEnabled(false);
        txtPassword.setEnabled(false);
        txtRole.setEnabled(false);
        cboUserName.setEnabled(true);
        btnCreate.setEnabled(true);
        btnLoad.setEnabled(true);
        btnEdit.setEnabled(true);
        btnSave.setEnabled(false);
        btnDelete.setEnabled(true);
    }
    
    
    private void mEditGUIControls()
    {
        txtUserName.setEnabled(true);
        txtPassword.setEnabled(true);
        txtRole.setEnabled(true);
        cboUserName.setEnabled(false);
        btnCreate.setEnabled(false);
        btnLoad.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(true);
        btnDelete.setEnabled(true);
    }
    
    private void mSaveGUIControls()
    {
        txtUserName.setEnabled(false);
        txtPassword.setEnabled(false);
        txtRole.setEnabled(false);
        cboUserName.setEnabled(true);
        btnCreate.setEnabled(true);
        btnLoad.setEnabled(true);
        btnEdit.setEnabled(true);
        btnSave.setEnabled(false);
        btnDelete.setEnabled(false);
    }
    
     private void mCreateGUIControls()
    {
        txtUserName.setEnabled(true);
        txtPassword.setEnabled(true);
        txtRole.setEnabled(true);
        cboUserName.setEnabled(false);
        btnCreate.setEnabled(false);
        btnLoad.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(true);
        btnDelete.setEnabled(true);
    }
    
    
    private void mDeleteGUIControls()
    {
        txtUserName.setEnabled(false);
        txtPassword.setEnabled(false);
        txtRole.setEnabled(false);
        cboUserName.setEnabled(true);
        btnCreate.setEnabled(true);
        btnLoad.setEnabled(true);
        btnEdit.setEnabled(true);
        btnSave.setEnabled(false);
        btnDelete.setEnabled(false);
    }
    
    private void mEncryptPassword()
    {
        strPassword=clsCC.mEncrypt(strPassword,5);
    }
    
    private void mDecryptPassword()
    {
        strPassword=clsCC.mDecrypt(strPassword,5);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboUserName = new javax.swing.JComboBox<>();
        lblUserName = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        txtRole = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        cboUserName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblUserName.setText("User Name");

        lblPassword.setText("Password");

        lblRole.setText("Role");

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(cboUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                        .addComponent(lblRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtRole, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                        .addComponent(txtPassword)
                                        .addComponent(txtUserName)))
                                .addComponent(btnLoad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserName)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRole)
                    .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCreate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLoad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        mCreateGUIControls();
        txtUserName.requestFocusInWindow();
        btnDelete.setText("Cancel");
        boolCreate=true;
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
       mReadUserDetails();
       mDecryptPassword();
       mSetValuesInGUI();
       mLoadGUIControls();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
       mReadUserDetails();
       mDecryptPassword();
       mSetValuesInGUI();
       mEditGUIControls();
       txtUserName.requestFocusInWindow();
       btnDelete.setText("Cancel");
       boolEdit=true;
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(boolCreate==true)
        {
            if(txtUserName.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"The field cannot be left empty");
                txtUserName.requestFocusInWindow();
            }
            else if(txtUserName.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"The field cannot be left empty");
                txtUserName.requestFocusInWindow();
            }
            else
            {
                mGetValuesFromGUI();
                mSetValuesToUpperCase();
                mEncryptPassword();
                mcheckIfItemsExistInTable();
                if(boolRecordExists==true)
                {
                    boolRecordExists=false;
                    JOptionPane.showMessageDialog(null, "Actor already Exists");
                }
                else if(boolRecordExists==false)
                {
                    boolCreate=false;
                    mCreateUser();
                    mClearTextFields();
                    mClearVariables();
                    mClearComboBox();
                    mLoadUserName();
                    mLoadGUIControls();
                }
            }
        }
        else if(boolEdit==true)
        {
            boolEdit=false;
            mGetValuesFromGUI();
            mSetValuesToUpperCase();
            mEncryptPassword();
            mUpdateUser();
            mClearTextFields();
            mClearVariables();
            mClearComboBox();
            mLoadUserName();
            mLoadGUIControls();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if("Delete".equals(btnDelete.getText()))
        {
            mReadUserDetails();
            mDeleteUser();
            mClearComboBox();
            mClearVariables();
            mLoadUserName();
        }
        else if("Cancel".equals(btnDelete.getText()))
        {
            mClearTextFields();
            mClearVariables();
            mClearComboBox();
            mLoadUserName();
            mLoadGUIControls();
            btnDelete.setText("Delete");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboUserName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtRole;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}

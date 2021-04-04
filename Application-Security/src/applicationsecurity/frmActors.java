/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationsecurity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Rofhiwa Ramuhala
 */
public class frmActors extends javax.swing.JInternalFrame {

    private Connection conMySQLConnectingString;

    /**
     * Creates new form frmActors
     */
    public frmActors() {
        initComponents();
        mLoadFirstName();
        mLoadGUIControls();
    }
    
    Boolean boolRecordExists=false;
    Boolean boolEdit=false;
    Boolean boolCreate=false;
    String strFirstName;
    String strLastName;
    int intActorID;
    
    private void mClearVariables()
    {
        strFirstName="";
        strLastName="";
        intActorID=0;
    }
    
    private void mGetValuesFromGUI()
    {
        strFirstName=txtFirstName.getText();
        strLastName=txtLastName.getText();
    }
    
    private void mSetValuesInGUI()
    {
        txtFirstName.setText(strFirstName);
        txtLastName.setText(strLastName);
    }
    
    private void mClearTextFields()
    {
        txtFirstName.setText("");
        txtLastName.setText("");
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
           conMySQLConnectingString=DriverManager.getConnection(strDBConnectionString,strDBUser,strDBPassword);
            stStatement=conMySQLConnectionString.createStatement();
            String strQuery="Select*from Actor where first_name+strFirstName+ and last_name= + ";
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
    
    private void mCreateActor()
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
            JOptionPane.showMessageDialog(null, " Complete");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    private void mLoadFirstName()
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
                cboFirstName.addItem(rs.getString(1));
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
    
    private void mUpdateActor()
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
       cboFirstName.setModel(model);
    }
    
     private void mDeleteActor()
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
            String strQuery="Delete from actor where first_name";
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
    
    private void mReadActorDetails()
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
                intActorID=rs.getInt(1);
                strFirstName=rs.getString(2);
                strLastName=rs.getString(3);
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
        txtFirstName.setEnabled(false);
        txtLastName.setEnabled(false);
        cboFirstName.setEnabled(true);
        btnCreate.setEnabled(true);
        btnLoad.setEnabled(true);
        btnEdit.setEnabled(true);
        btnSave.setEnabled(false);
        btnDelete.setEnabled(true);
    }
    
    
    private void mEditGUIControls()
    {
        txtFirstName.setEnabled(true);
        txtLastName.setEnabled(true);
        cboFirstName.setEnabled(false);
        btnCreate.setEnabled(false);
        btnLoad.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(true);
        btnDelete.setEnabled(true);
    }
    
    private void mSaveGUIControls()
    {
        txtFirstName.setEnabled(false);
        txtLastName.setEnabled(false);
        cboFirstName.setEnabled(true);
        btnCreate.setEnabled(true);
        btnLoad.setEnabled(true);
        btnEdit.setEnabled(true);
        btnSave.setEnabled(false);
        btnDelete.setEnabled(false);
    }
    
    private void mCreateGUIControls()
    {
        txtFirstName.setEnabled(true);
        txtLastName.setEnabled(true);
        cboFirstName.setEnabled(false);
        btnCreate.setEnabled(false);
        btnLoad.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(true);
        btnDelete.setEnabled(true);
    }
    
    private void meDeleteGUIControls()
    {
        txtFirstName.setEnabled(false);
        txtLastName.setEnabled(false);
        cboFirstName.setEnabled(true);
        btnCreate.setEnabled(true);
        btnLoad.setEnabled(true);
        btnEdit.setEnabled(true);
        btnSave.setEnabled(false);
        btnDelete.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboFirstName = new javax.swing.JComboBox<>();
        lblFisrtName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        cboFirstName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFirstNameActionPerformed(evt);
            }
        });

        lblFisrtName.setText("First Name ");
        lblFisrtName.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblFisrtNameAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        lblLastName.setText("Last Name ");

        txtLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastNameActionPerformed(evt);
            }
        });

        btnCreate.setText("Create ");
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
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cboFirstName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblFisrtName, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                .addComponent(txtFirstName)))
                        .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(cboFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFisrtName)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastName)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCreate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLoad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if("Delete".equals(btnDelete.getText()))
        {
            mReadActorDetails();
            mDeleteActor();
            mClearComboBox();
            mClearVariables();
            mLoadFirstName();
        }
        else if("Cancel".equals(btnDelete.getText()))
        {
            mClearTextFields();
            mClearVariables();
            mClearComboBox();
            mLoadFirstName();
            mLoadGUIControls();
            btnDelete.setText("Delete");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void cboFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboFirstNameActionPerformed

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastNameActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        mCreateGUIControls();
        txtFirstName.requestFocusInWindow();
        btnDelete.setText("Cancel");
        boolCreate=true;
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
       mReadActorDetails();
       mSetValuesInGUI();
       mLoadGUIControls();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
       mReadActorDetails();
       mSetValuesInGUI();
       mEditGUIControls();
       txtFirstName.requestFocusInWindow();
       btnDelete.setText("Cancel");
       boolEdit=true;
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(boolCreate==true)
        {
            if(txtFirstName.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"The field cannot be left empty");
                txtFirstName.requestFocusInWindow();
            }
            else if(txtLastName.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"The field cannot be left empty");
                txtFirstName.requestFocusInWindow();
            }
            else
            {
                mGetValuesFromGUI();
                mSetValuesInGUI();
                mcheckIfItemsExistInTable();
                if(boolRecordExists==true)
                {
                    boolRecordExists=false;
                    JOptionPane.showMessageDialog(null, "Actor already Exists");
                }
                else if(boolRecordExists==false)
                {
                    boolCreate=false;
                    mCreateActor();
                    mClearTextFields();
                    mClearVariables();
                    mClearComboBox();
                    mLoadFirstName();
                    mLoadGUIControls();
                }
            }
        }
        else if(boolEdit==true)
        {
            boolEdit=false;
            mGetValuesFromGUI();
            mSetValuesInGUI();
            mUpdateActor();
            mClearTextFields();
            mClearVariables();
            mClearComboBox();
            mLoadFirstName();
            mLoadGUIControls();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void lblFisrtNameAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblFisrtNameAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblFisrtNameAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboFirstName;
    private javax.swing.JLabel lblFisrtName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    // End of variables declaration//GEN-END:variables
}

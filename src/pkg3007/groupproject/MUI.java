/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3007.groupproject;

/**
 *
 * @author WH
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ritz619
 */
public class MUI extends javax.swing.JFrame {

    /**
     * Creates new form MUI
     */
    private AbstractFactory factory;
    private AcquaintancesFactoryProvider provider;
    private MUI mg;
    private AcquaintanceComponent a;
    private AcquaintanceComponent temp;
    private int acquaintanceType = -1;
    private int countryType = -1;
    private int num;
    private boolean flag;
    private boolean inputFieldEditable;
    private String op;
    private String str;
    private Validator dateChecker = new validDate();
    private Validator mobileNoChecker = new MobileNoChecker();

    private volatile static MUI uniquedMUI;
    
    private MUI() {}
    
    public static MUI getMUI() {
        if (uniquedMUI == null) {
            synchronized (MUI.class) {
                if (uniquedMUI == null) {
                    uniquedMUI = new MUI();
                }
            }
        }
        return uniquedMUI;
    }
    
    public void initMuiClass(){
        initComponents();
        String[] columnNames = {"S.No", "Name", "Mobile"," Email"};
        DefaultTableModel model = new DefaultTableModel(null, columnNames);
        jXTable1.setModel(model);
        setUpTableData();
    }
    
    public void setMg(MUI mg) {
        this.mg = mg;
    }

    public void setA(AcquaintanceComponent a) {
        this.a = a;
    }
    
    public void setDescription(){
        name.setText("");
        mobile.setText("");
        email.setText("");
        one.setText("");
        two.setText("");
        three.setText("");
        country.setText("");
        
        saveButton.setVisible(true);
        cancelButton.setVisible(true);
        
        name.setEditable(!inputFieldEditable);
        mobile.setEditable(!inputFieldEditable);
        email.setEditable(!inputFieldEditable);
        one.setEditable(!inputFieldEditable);
        two.setEditable(!inputFieldEditable);
        three.setEditable(!inputFieldEditable);
        country.setEditable(!inputFieldEditable && countryType == 0);

        if (countryType == 1) {
            country.setText("Malaysia");
        }    
        
        if(flag) {
            op = "Add";
            saveButton.setText("Add");
        } else {
            op = "Edit";
            saveButton.setText("Save");
            AcquaintanceComponent e = a.get(2*acquaintanceType + countryType).get(num);            
            name.setText(e.getName());
            mobile.setText(e.getMobileNo());
            email.setText(e.getEmail());
            country.setText(e.getCountry());
            switch(acquaintanceType){
                case 0:
                    PersonalFriends perF = (PersonalFriends)e;
                    one.setText(perF.getEvents());
                    two.setText(perF.getAContext());
                    three.setText(perF.getADate());
                    break;
                case 1:
                    Relatives rel = (Relatives)e;
                    one.setText(rel.getBDate());
                    two.setText(rel.getLDate());
                    break;
                case 2:
                    ProfessionalFriends proF = (ProfessionalFriends)e;
                    one.setText(proF.getCommonInterests());
                    break;
                case 3:
                    CasualAcquaintances ca = (CasualAcquaintances)e;
                    one.setText(ca.getWhenWhere());
                    two.setVisible(true);
                    three.setVisible(true);
                    two.setText(ca.getCircumstances());
                    three.setText(ca.getOtherInfo());
                    break;
                default:
                    break;
            }
        }
        
        switch(acquaintanceType){
            case 0:
                two.setVisible(true);
                three.setVisible(true);
                jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, op + " Personal Friends Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));
                meetingLocationLabel.setText("Specific Events:");
                meetingCircumstancesLabel.setText("First Acquaintance Context:");
                otherInfo.setVisible(true);
                detailsLabel.setVisible(true);
                meetingCircumstancesLabel.setVisible(true);
                meetingLocationLabel.setVisible(true);
                jScrollPane5.setVisible(true);
                jScrollPane4.setVisible(true);
                otherInfo.setText("<html>First Acquaintance Date:<br>(dd/mm/yyyy)</html>");
                break;
            case 1:
                jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, op + " Relatives Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16))); 
                meetingLocationLabel.setText("<html>Relatives Birthday:<br> (dd/mm/yyyy)</html>");
                meetingCircumstancesLabel.setVisible(true);
                meetingLocationLabel.setVisible(true);
                two.setVisible(true);
                meetingCircumstancesLabel.setText("<html>Last Date met:<br> (dd/mm/yyyy)</html>");
                otherInfo.setVisible(false);
                three.setVisible(false);
                jScrollPane4.setVisible(true);
                jScrollPane5.setVisible(false);
                break;
            case 2:
                jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, op + " Professional Friends Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16))); 
                meetingLocationLabel.setText("Common Interests: ");
                meetingLocationLabel.setVisible(true);
                meetingCircumstancesLabel.setVisible(false);
                two.setVisible(false);
                jScrollPane4.setVisible(false);
                otherInfo.setVisible(false);
                three.setVisible(false);
                jScrollPane5.setVisible(false);
                break;
            case 3:
                jScrollPane5.setVisible(true);
                jScrollPane4.setVisible(true);
                two.setVisible(true);
                three.setVisible(true);
                meetingLocationLabel.setVisible(true);
                meetingCircumstancesLabel.setVisible(true);
                otherInfo.setVisible(true);
                meetingLocationLabel.setText("First meeting time & location:");
                meetingCircumstancesLabel.setText("First meeting CIrcumstances:");
                otherInfo.setText("Other useful information:");
                break;
            default:
                break;
        }
        
         if(inputFieldEditable){
            saveButton.setText("Back to main menu");
            cancelButton.setVisible(false);
            jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Display Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));
        }
    }

    public final void setUpTableData() {
        DefaultTableModel tableModel = (DefaultTableModel) jXTable1.getModel();
        tableModel.setRowCount(0);
        AcquaintanceComponent list;
        try{        
            list = a.get(2*acquaintanceType + countryType);
        }
        catch(Exception e){
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            String[] data = new String[4];
            data[0] = Integer.toString(i+1);
            data[1] = list.get(i).getName();
            data[2] = list.get(i).getMobileNo();
            data[3] = list.get(i).getEmail();
            tableModel.addRow(data);
        }
        jXTable1.setModel(tableModel);
        tableModel.fireTableDataChanged();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        //**********************instantiation**********************************
        country = new javax.swing.JTextField();
        provider = new AcquaintancesFactoryProvider();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        systemTitleLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        searchexitexitButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        acquantanceTypeList = new javax.swing.JList();
        countryTypeList = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();
        selectCategoryLabel = new javax.swing.JLabel();
        detailsLabel = new javax.swing.JLabel();
        editButton = new javax.swing.JButton();
        viewFullDetails = new javax.swing.JButton();
        readFileButton = new javax.swing.JButton();
        saveFileButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        details = new javax.swing.JTextPane();
        backButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        mobileNoLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        meetingLocationLabel = new javax.swing.JLabel();
        meetingCircumstancesLabel = new javax.swing.JLabel();
        otherInfo = new javax.swing.JLabel();
        countryLabel = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        two = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        three = new javax.swing.JTextArea();
        saveButton = new javax.swing.JButton();
        mobile = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        one = new javax.swing.JTextArea();
        cancelButton = new javax.swing.JButton();
        
        //**********************set text**********************************
        nameLabel.setText("Name:");
        mobileNoLabel.setText("Mobile No:");
        emailLabel.setText("Email:");
        meetingLocationLabel.setText("First meeting time & location:");
        meetingCircumstancesLabel.setText("First meeting CIrcumstances:");
        otherInfo.setText("Other useful information:");
        countryLabel.setText("Country:");
        systemTitleLabel.setText("<html><u>Contact Management System</u></html>");
        addButton.setText("Add");
        deleteButton.setText("Delete");
        searchButton.setText("Search");
        searchexitexitButton.setText("Exit");
        detailsLabel.setText("Details:");
        editButton.setText("Edit");
        selectCategoryLabel.setText("Select Category:");
        viewFullDetails.setText("View full detail");
        readFileButton.setText("Read from file");
        saveFileButton.setText("Save as file");
        saveButton.setText("Add");
        cancelButton.setText("Cancel");
        
        //*****************set font*******************************************
        systemTitleLabel.setFont(new java.awt.Font("Ubuntu Medium", 0, 20)); // NOI18N
        selectCategoryLabel.setFont(new java.awt.Font("Ubuntu Medium", 0, 17)); // NOI18N
        detailsLabel.setFont(new java.awt.Font("Ubuntu Medium", 0, 17)); // NOI18N
         
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        
        systemTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        searchexitexitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        acquantanceTypeList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Personal Friends", "Relatives", "Professional Friends", "Casual Acquaintances" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        acquantanceTypeList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(acquantanceTypeList);

        jXTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "S.No", "Name", "Mobile No", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jXTable1);
        
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        viewFullDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        readFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readFileButtonActionPerformed(evt);
            }
        });

        saveFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileButtonActionPerformed(evt);
            }
        });
        
        countryTypeList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Oversea", "Local" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        
        countryTypeList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList2ValueChanged(evt);
            }
        });
        
        jScrollPane7.setViewportView(countryTypeList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(systemTitleLabel)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(selectCategoryLabel)
                        .addGap(59, 59, 59)
                        .addComponent(detailsLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(viewFullDetails)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(readFileButton))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(saveFileButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(searchexitexitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addButton, deleteButton, searchButton, searchexitexitButton, editButton, viewFullDetails, readFileButton, saveFileButton});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(systemTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(deleteButton)
                        .addComponent(addButton))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchButton)
                        .addComponent(editButton)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchexitexitButton)
                        .addComponent(saveFileButton))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(viewFullDetails)
                        .addComponent(readFileButton)))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectCategoryLabel)
                    .addComponent(detailsLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, "card2");

        details.setEditable(false);
        jScrollPane3.setViewportView(details);

        backButton.setText("Back to main menu");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(backButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backButton)
                .addGap(21, 21, 21))
        );

        getContentPane().add(jPanel2, "card3");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Casual Acquaintance Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16))); // NOI18N

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        two.setColumns(20);
        two.setRows(5);
        two.setAutoscrolls(false);
        jScrollPane4.setViewportView(two);

        three.setColumns(20);
        three.setRows(5);
        jScrollPane5.setViewportView(three);

        
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        one.setColumns(20);
        one.setRows(5);
        jScrollPane6.setViewportView(one);
        
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(otherInfo)
                    .addComponent(meetingCircumstancesLabel)
                    .addComponent(meetingLocationLabel)
                    .addComponent(emailLabel)
                    .addComponent(mobileNoLabel)
                    .addComponent(nameLabel)
                    .addComponent(countryLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                        .addGap(132, 132, 132))
                    .addComponent(country, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mobileNoLabel)
                    .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countryLabel)
                    .addComponent(country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(meetingLocationLabel)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(meetingCircumstancesLabel))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(otherInfo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addGap(3, 3, 3))
        );

        getContentPane().add(jPanel3, "card4");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(acquaintanceType <0 || countryType < 0){
            JOptionPane.showMessageDialog(mg, "Select a category!");
            return;
        }
        jPanel1.setVisible(false);
        jPanel3.setVisible(true);
        flag = true;
        inputFieldEditable = false;
        setDescription();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if(acquaintanceType <0 || countryType < 0){
            JOptionPane.showMessageDialog(mg, "Select a category!");
            return;
        }
        
        int tindex = jXTable1.getSelectedRow();
        if(tindex < 0){
            JOptionPane.showMessageDialog(mg, "Select an entry!");
            return;
        }
        int n = JOptionPane.showConfirmDialog(
            mg,
            "Are you sure you want to delete this?",
            "Confirm",
            JOptionPane.YES_NO_OPTION);
        if(n==0){
            a.get(2*acquaintanceType + countryType).remove(tindex);
            JOptionPane.showMessageDialog(mg, "Successfully Deleted");
            mg.setUpTableData();
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String s = (String)JOptionPane.showInputDialog(
            mg,
            "Enter name: ",
            "Input",
            JOptionPane.PLAIN_MESSAGE,
            null,
            null,
            "");
        if(s==null)
            return;
        jPanel1.setVisible(false);
        jPanel2.setVisible(true);
        str = s;
        details.setContentType( "text/html" );
        runn();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        acquaintanceType = acquantanceTypeList.getSelectedIndex();
        setUpTableData();
    }//GEN-LAST:event_jList1ValueChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(acquaintanceType <0 || countryType < 0){
            JOptionPane.showMessageDialog(mg, "Select a category!");
            return;
        }
        
        int tindex = jXTable1.getSelectedRow();
        if(tindex < 0){
            JOptionPane.showMessageDialog(mg, "Select an entry!");
            return;
        }
        num = tindex;
        flag = false;
        inputFieldEditable = false;
        setDescription();
        jPanel1.setVisible(false);
        jPanel3.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed
    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(acquaintanceType <0 || countryType < 0){
            JOptionPane.showMessageDialog(mg, "Select a category!");
            return;
        }
        int tindex = jXTable1.getSelectedRow();
        if(tindex < 0){
            JOptionPane.showMessageDialog(mg, "Select an entry!");
            return;
        }
        num = tindex;
        flag = false;
        jPanel1.setVisible(false);
        jPanel3.setVisible(true);
        inputFieldEditable = true;
        setDescription();
    }//GEN-LAST:event_jButton6ActionPerformed
    
    private void jList2ValueChanged(javax.swing.event.ListSelectionEvent evt) {                                    
        countryType = countryTypeList.getSelectedIndex();
        factory = provider.getAcquaintanceFactory(countryTypeList.getSelectedIndex());
        setUpTableData();
    }       

    public void runn(){        
        String s = "<html> <b>Search results:</b><br>Found!<br><br>Acquaintance Details: <br>";
        
//        s = s.concat(a.match(str));
        AcquaintanceNode ac = new AcquaintanceNode(a);
        s = s.concat(ac.printSearchedAcquaintance(str));
        if(s.matches("<html> <b>Search results:</b><br>Found!<br><br>Acquaintance Details: <br>")){
            s  = "<html>No result found</html>";
        }
        else{
            s = s.concat("</html>");
        }
        details.setText(s);
    }
    
    private void readFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readFileButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                temp = (AcquaintanceComponent)SerializationUtil.deserialize(selectedFile);
            }
            catch (ClassNotFoundException | IOException e) {
                JOptionPane.showMessageDialog(mg, "Error");
                return;
            }
        }
        else{
            return;
        }
        try{
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < temp.get(i).size(); j++){
                    a.get(i).add(temp.get(i).get(j));
                }
            }
        }
        catch(Exception e){

        }
        mg.setUpTableData();
    }//GEN-LAST:event_readFileButtonActionPerformed

    private void saveFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileButtonActionPerformed
        String s = (String)JOptionPane.showInputDialog(
            mg,
            "Enter file name: (*.ser)",
            "Input",
            JOptionPane.PLAIN_MESSAGE,
            null,
            null,
            "output.ser");
        if(s==null)
        return;
        if(!s.endsWith(".ser")){
            JOptionPane.showMessageDialog(mg, "File name should end with .ser");
            return;
        }
        File[] fileList = (new File(".")).listFiles((File pathname) -> pathname.getName().endsWith(".ser"));
        boolean flag = false;
        for(File f : fileList){
            if(f.getName().matches(s)){
                flag = true;
            }
        }
        if(flag){
            int q = JOptionPane.showConfirmDialog(mg, s + " already exists:\nAre you sure you want to overwrite?");
            if(q!=0)
            return;
        }
        try {
            SerializationUtil.serialize(a, s);
        } catch (IOException e) {
            return;
        }
        JOptionPane.showMessageDialog(mg, s + " saved successfully");
    }//GEN-LAST:event_saveFileButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        jPanel2.setVisible(false);
        jPanel1.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        factory = provider.getAcquaintanceFactory(countryType);
        inputFieldEditable = true;
        String Name = name.getText();
        if(Name.isEmpty()){
            JOptionPane.showMessageDialog(mg, "Enter a name");
            return;
        }
        String Mobile = mobile.getText();
        if(!mobileNoChecker.isValid(Mobile)){
            JOptionPane.showMessageDialog(mg, "Enter a valid mobile number (6-15 digits)");
            return;
        }
        String Email = email.getText();
        if(!Email.contains("@")){
            JOptionPane.showMessageDialog(mg, "Enter a valid email");
            return;
        }
        String One,Two,Three;
        String countryValue = country.getText();
        
        if(countryValue.isEmpty() || countryValue.length() > 300){
            JOptionPane.showMessageDialog(mg, "Enter country");
            return;
        }
        
        switch(acquaintanceType){
            case 0: //perF
                One = one.getText();
                if(One.isEmpty() || One.length() > 300){
                    JOptionPane.showMessageDialog(mg, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                Two = two.getText();
                if(Two.isEmpty() || Two.length() > 300){
                    JOptionPane.showMessageDialog(mg, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                Three = three.getText();
                if(!dateChecker.isValid(Three)){
                    JOptionPane.showMessageDialog(mg, "Enter a valid date");
                    return;
                }
                PersonalFriends perF;
                if(flag)
                    perF = (PersonalFriends) factory.getAcquaintance(acquaintanceType);
                else
                    perF = (PersonalFriends)a.get(2*acquaintanceType + countryType).get(num);
                perF.setName(Name);
                perF.updateCountry(countryValue);
                perF.setMobileNo(Mobile);
                perF.setEmail(Email);
                perF.setEvents(One);
                perF.setAContext(Two);
                perF.setADate(Three);
                if(flag)
                    a.get(2*acquaintanceType + countryType).add(perF);
                    //this.a.get(x).add(perF);
                break;
            case 1: //rel
                One = one.getText();
                if(!dateChecker.isValid(One)){
                    JOptionPane.showMessageDialog(mg, "Enter a valid date");
                    return;
                }
                Two = two.getText();
                if(!dateChecker.isValid(Two)){
                    JOptionPane.showMessageDialog(mg, "Enter a valid date");
                    return;
                }
                Relatives rel;
                if(flag)
                    rel = (Relatives)factory.getAcquaintance(acquaintanceType);
                else
                    rel = (Relatives)a.get(2*acquaintanceType + countryType).get(num);
                rel.setName(Name);
                rel.setMobileNo(Mobile);
                rel.updateCountry(countryValue);
                rel.setEmail(Email);
                rel.setBDate(One);
                rel.setLDate(Two);
                if(flag)
                    a.get(2*acquaintanceType + countryType).add(rel);
                break;
            case 2: //proF
                One = one.getText();
                if(One.isEmpty() || One.length() > 300){
                    JOptionPane.showMessageDialog(mg, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                ProfessionalFriends proF;
                if(flag)
                    proF = (ProfessionalFriends)factory.getAcquaintance(acquaintanceType);
                else
                    proF = (ProfessionalFriends)a.get(2*acquaintanceType + countryType).get(num);
                proF.setName(Name);
                proF.setMobileNo(Mobile);
                proF.updateCountry(countryValue);
                proF.setEmail(Email);
                proF.setCommonInterests(One);
                if(flag)
                    a.get(2*acquaintanceType + countryType).add(proF);
                break;
            case 3: //ca
                One = one.getText();
                if(One.isEmpty() || One.length() > 300){
                    JOptionPane.showMessageDialog(mg, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                Two = two.getText();
                if(Two.isEmpty() || Two.length() > 300){
                    JOptionPane.showMessageDialog(mg, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                Three = three.getText();
                if(Three.isEmpty() || Three.length() > 300){
                    JOptionPane.showMessageDialog(mg, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                CasualAcquaintances ca;
                if(flag)
                    ca = (CasualAcquaintances)factory.getAcquaintance(acquaintanceType);
                else
                    ca = (CasualAcquaintances)a.get(2*acquaintanceType + countryType).get(num);
                ca.setName(Name);
                ca.updateCountry(countryValue);
                ca.setMobileNo(Mobile);
                ca.setEmail(Email);
                ca.setWhenWhere(One);
                ca.setCircumstances(Two);
                ca.setOtherInfo(Three);
                if(flag)
                    a.get(2*acquaintanceType + countryType).add(ca);
                break;
            default:
                break;
        }
        jPanel1.setVisible(true);
        jPanel3.setVisible(false);
        mg.setUpTableData();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        jPanel1.setVisible(true);
        jPanel3.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane details;
    private javax.swing.JTextField email;
    private javax.swing.JButton addButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton searchexitexitButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton viewFullDetails;
    private javax.swing.JButton readFileButton;
    private javax.swing.JButton saveFileButton;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel selectCategoryLabel;
    private javax.swing.JLabel systemTitleLabel;
    private javax.swing.JLabel detailsLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel mobileNoLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel meetingLocationLabel;
    private javax.swing.JLabel meetingCircumstancesLabel;
    private javax.swing.JLabel otherInfo;
    private javax.swing.JLabel countryLabel;
    private javax.swing.JList acquantanceTypeList;
    private javax.swing.JList countryTypeList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private org.jdesktop.swingx.JXTable jXTable1;
    private javax.swing.JTextField mobile;
    private javax.swing.JTextField name;
    private javax.swing.JTextArea one;
    private javax.swing.JTextArea three;
    private javax.swing.JTextArea two;
    private javax.swing.JTextField country;
    // End of variables declaration//GEN-END:variables
}

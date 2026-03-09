import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class StudentManagementSystem extends JFrame implements ActionListener {

    JTextField txtID, txtName, txtCourse, txtYear;
    JButton btnAdd, btnUpdate, btnDelete, btnClear;
    JTable table;
    DefaultTableModel model;

    public StudentManagementSystem() {

        setTitle("Student Information Management System");
        setSize(800, 500);
        setLayout(new BorderLayout());

        // FORM PANEL
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4,2,10,10));

        formPanel.setBorder(BorderFactory.createTitledBorder("Student Information"));

        formPanel.add(new JLabel("Student ID:"));
        txtID = new JTextField();
        formPanel.add(txtID);

        formPanel.add(new JLabel("Name:"));
        txtName = new JTextField();
        formPanel.add(txtName);

        formPanel.add(new JLabel("Course:"));
        txtCourse = new JTextField();
        formPanel.add(txtCourse);

        formPanel.add(new JLabel("Year Level:"));
        txtYear = new JTextField();
        formPanel.add(txtYear);

        add(formPanel, BorderLayout.NORTH);

        // TABLE PANEL
        model = new DefaultTableModel();
        model.addColumn("Student ID");
        model.addColumn("Name");
        model.addColumn("Course");
        model.addColumn("Year Level");

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // BUTTON PANEL
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        btnAdd = new JButton("Add");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnClear = new JButton("Clear");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnClear);

        add(buttonPanel, BorderLayout.SOUTH);

        // EVENTS
        btnAdd.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnClear.addActionListener(this);

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                int selectedRow = table.getSelectedRow();

                txtID.setText(model.getValueAt(selectedRow,0).toString());
                txtName.setText(model.getValueAt(selectedRow,1).toString());
                txtCourse.setText(model.getValueAt(selectedRow,2).toString());
                txtYear.setText(model.getValueAt(selectedRow,3).toString());
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String id = txtID.getText();
        String name = txtName.getText();
        String course = txtCourse.getText();
        String year = txtYear.getText();

        // INPUT VALIDATION
        if(id.isEmpty() || name.isEmpty() || course.isEmpty() || year.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!");
            return;
        }

        if(e.getSource() == btnAdd) {

            model.addRow(new Object[]{id, name, course, year});

            JOptionPane.showMessageDialog(this, "Student Added Successfully!");
        }

        if(e.getSource() == btnUpdate) {

            int selectedRow = table.getSelectedRow();

            if(selectedRow >= 0) {

                model.setValueAt(id, selectedRow, 0);
                model.setValueAt(name, selectedRow, 1);
                model.setValueAt(course, selectedRow, 2);
                model.setValueAt(year, selectedRow, 3);

                JOptionPane.showMessageDialog(this, "Record Updated!");
            }
            else {
                JOptionPane.showMessageDialog(this, "Select a row to update.");
            }
        }

        if(e.getSource() == btnDelete) {

            int selectedRow = table.getSelectedRow();

            if(selectedRow >= 0) {

                model.removeRow(selectedRow);

                JOptionPane.showMessageDialog(this, "Record Deleted!");
            }
            else {
                JOptionPane.showMessageDialog(this, "Select a row to delete.");
            }
        }

        if(e.getSource() == btnClear) {

            txtID.setText("");
            txtName.setText("");
            txtCourse.setText("");
            txtYear.setText("");
        }
    }

    }

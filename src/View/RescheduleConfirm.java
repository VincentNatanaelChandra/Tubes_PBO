package View;

import Controller.Controller;
import Model.Reschedule;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



    public class RescheduleConfirm {

        public JFrame frame;
        Controller controller = new Controller();

        public RescheduleConfirm (int admin_id, String name) {
            this.controller = Controller.getInstance();
            ArrayList<Model.Reschedule> listReschedule = controller.getViewReschedule();
            createRescheduleConfirmWindow(admin_id, name, listReschedule);
            showRescheduleConfirmWindow(false);
        }

        private void createRescheduleConfirmWindow(int admin_id, String name, ArrayList<Reschedule> listReschedule) {
            frame = new JFrame("Request Reschedule List");
            frame.setSize(600, 400);

            Object[][] data = new Object[listReschedule.size()][6];

            for (int i = 0; i < listReschedule.size(); i++) {
                Reschedule refunds = listReschedule.get(i);
                data[i][0] = refunds.getReschedule_id();
                data[i][1] = refunds.getTicket_id();
                data[i][2] = refunds.getReschedule_status();
                data[i][3] = refunds.getReschedule_reason();
                data[i][4] = refunds.getReschedule_date();
                data[i][5] = refunds.getReschedule_seat();
            }

            String[] columns = {"Reschedule_id", "Ticket_id", "Reschedule_status", "Reschedule_reason", "Reschedule_date", "Reschedule_seat"};
            DefaultTableModel model = new DefaultTableModel(data, columns);
            JTable table = new JTable(model);

            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(20, 20, 550, 300);
            frame.add(scrollPane);

            JButton acceptButton = new JButton("Terima");
            acceptButton.setBounds(50, 330, 100, 30);
            frame.add(acceptButton);

            JButton rejectButton = new JButton("Tolak");
            rejectButton.setBounds(200, 330, 100, 30);
            frame.add(rejectButton);

            acceptButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        model.setValueAt("Approved", selectedRow, 3);
                    }
                }
            });

            rejectButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        model.setValueAt("Rejected", selectedRow, 3);
                    }
                }
            });

            JButton backButton = new JButton("Back");
            backButton.setBounds(350, 330, 100, 30);
            backButton.addActionListener(e -> {
                frame.dispose();
                MainMenuAdmin mainMenuAdmin = new MainMenuAdmin(admin_id, name);
            });
            frame.add(backButton);

            frame.setLayout(null);
            frame.setVisible(true);
        }

        public void showRescheduleConfirmWindow(boolean visible) {
            frame.setVisible(visible);
        }
    }


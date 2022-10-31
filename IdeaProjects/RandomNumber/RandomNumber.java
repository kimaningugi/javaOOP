import org.jetbrains.annotations.NotNull;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class RandomNumber implements ActionListener{
    int guess = 0;
    Random rand = new Random();
    int magicNumber = rand.nextInt(100)+1;
    JFrame frame;
    JLabel label;
    JButton button;
    JButton restarter;
    JPanel panel;
    JTextField textField;
    public RandomNumber() {
        frame = new JFrame();
        panel = new JPanel();
        button = new JButton("That's my guess");
        label = new JLabel("Guess a number between 1 and 100!");
        textField = new JTextField();
        restarter = new JButton("Restart");
        textField.setPreferredSize(new Dimension(250,40));
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(textField);
        panel.add(button);
        panel.add(restarter);
        button.addActionListener(this);
        restarter.addActionListener(this);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("N G G");
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new RandomNumber();
    }
    @Override
    public void actionPerformed(@NotNull ActionEvent e) {
// TODO Auto-generated method stub
        if (e.getSource()== button) {
            guess = Integer.parseInt(textField.getText());
        }
        if (guess == magicNumber) {
            label.setText("Congratulations! You have guessed the number!");
        }else if (guess < magicNumber) {
            label.setText("Your guess was too low!");
        }else {
            label.setText("Your guess was too high!");
        }
        if (e.getSource()==restarter) {
            textField.setText(null);
            label.setText("Guess a number between 1 and 100");
            magicNumber = rand.nextInt(100)+1;
        }
    }
}



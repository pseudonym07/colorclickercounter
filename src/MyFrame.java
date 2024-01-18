import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
//Init Commit
public class MyFrame {

    //Stores value for counter
    private int counter = 0;
    private final JLabel label;



    //Defines Pastel Color Pallete
    private final Color[] colors = {new Color(255, 185, 185), new Color(255, 217, 179), new Color(247, 240, 193)};

    public MyFrame() throws IOException, FontFormatException {
        //Makes a button with the text "click here"
        JButton button = new JButton("click here");
        //Makes label for text
        label = new JLabel("Value: " + counter);

        //Loads custom font file from workspace
        File fontFile = new File("assets/mini-wakuwaku.otf");
        Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        // Register the custom font with the graphics environment
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(customFont);

        // Makes new frame
        JFrame frame = new JFrame();
        frame.setTitle("pastel color clicker!");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use the font
        button.setFont(customFont.deriveFont(12f));
        label.setFont(customFont.deriveFont(12f));

        //Centers Button and label
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Add some padding
        panel.add(button, gbc);

        // Use a different grid position for the label
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(label, gbc);

        // Add the panel to the center of the frame
        frame.add(panel, BorderLayout.CENTER);





        button.setBorderPainted(false);

        // Add Action Listener
        button.addActionListener(new ActionListener() {
            int colorIndex = 0; // Initialize color index
            public void actionPerformed(ActionEvent e) {
                counter++;
                label.setText("Value: " + counter);
                panel.setBackground(colors[colorIndex]);
                colorIndex = (colorIndex + 1) % colors.length;
            }
        });

        frame.setVisible(true); // Display the frame
    }
}

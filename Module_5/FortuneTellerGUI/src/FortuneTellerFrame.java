import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;

public class FortuneTellerFrame extends JFrame {

    private final JTextArea fortunesArea;
    private final ArrayList<String> fortunes;
    private final Random rng = new Random();
    private int lastIndex = -1; // track last index to avoid immediate repeat

    public FortuneTellerFrame() {
        super("Fortune Teller");

        // Create fortunes list (>= 12 humorous fortunes)
        fortunes = new ArrayList<>();
        fortunes.add("You will accidentally like a 2012 selfie — and regret nothing.");
        fortunes.add("A mysterious package will arrive. It will contain more snacks.");
        fortunes.add("Your coffee will be exactly the strength you need tomorrow.");
        fortunes.add("You will find a pen when you need it most (and lose it later).");
        fortunes.add("An old playlist will resurface and make you dance at your desk.");
        fortunes.add("Your next idea will be half brilliant, half 'I'll fix it later'.");
        fortunes.add("A small victory will lead to a large celebration (within your head).");
        fortunes.add("You will be praised for something you barely remember doing.");
        fortunes.add("An unexpected refund will fund your next tiny indulgence.");
        fortunes.add("You will invent a new snack combination that will be controversial.");
        fortunes.add("A squirrel will inspire you to run faster (metaphorically).");
        fortunes.add("You will correctly guess a password — then promptly forget it.");
        fortunes.add("A stranger will compliment your shoes. You will feel mysterious.");
        fortunes.add("The plant you forgot about will still be alive. Miracle!");
        // Add more if desired...

        // Fonts
        Font titleFont = new Font(Font.SERIF, Font.BOLD, 40);
        Font fortuneFont = new Font(Font.MONOSPACED, Font.PLAIN, 16);
        Font buttonFont = new Font(Font.SANS_SERIF, Font.PLAIN, 18);

        // Top Panel: Label with ImageIcon and Title
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        JLabel titleLabel;

        // Try to load image from resources or file
        ImageIcon icon = null;
        // Attempt to load using resource (recommended). Put 'fortune.png' in the same package or resources root.
        java.net.URL imgURL = getClass().getResource("/fortune.png"); // looks in resources root
        if (imgURL != null) {
            icon = new ImageIcon(imgURL);
        } else {
            // fallback: try loading from working directory (project root)
            java.io.File f = new java.io.File("fortune.png");
            if (f.exists()) {
                icon = new ImageIcon("fortune.png");
            }
        }

        if (icon != null) {
            // Optionally scale the icon if it's too large
            int desiredIconHeight = 120;
            if (icon.getIconHeight() > desiredIconHeight) {
                Image scaled = icon.getImage().getScaledInstance(-1, desiredIconHeight, Image.SCALE_SMOOTH);
                icon = new ImageIcon(scaled);
            }
            titleLabel = new JLabel("Fortune Teller", icon, JLabel.CENTER);
            // show text below the icon:
            titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
            titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        } else {
            // No icon found; just text
            titleLabel = new JLabel("Fortune Teller", JLabel.CENTER);
        }

        titleLabel.setFont(titleFont);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        topPanel.add(titleLabel, BorderLayout.CENTER);

        // Middle Panel: TextArea inside a ScrollPane
        fortunesArea = new JTextArea();
        fortunesArea.setEditable(false);
        fortunesArea.setFont(fortuneFont);
        fortunesArea.setLineWrap(true);
        fortunesArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(fortunesArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Bottom Panel: Buttons
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton readButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");

        readButton.setFont(buttonFont);
        quitButton.setFont(buttonFont);

        // Action for Read My Fortune button (lambda)
        readButton.addActionListener(e -> {
            appendRandomFortune();
        });

        // Quit button must use lambda expression per instructions
        quitButton.addActionListener(e -> {
            // Confirm quit optionally
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to quit?",
                    "Quit Confirmation",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Dispose and exit
                this.dispose();
                System.exit(0);
            }
        });

        bottomPanel.add(readButton);
        bottomPanel.add(quitButton);

        // Layout the frame using BorderLayout
        this.setLayout(new BorderLayout(10, 10));
        this.add(topPanel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);

        // Use Toolkit to set frame size to 3/4 of screen width and center it
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int width = (screenSize.width * 3) / 4;
        int height = (screenSize.height * 2) / 3; // reasonable height
        this.setSize(width, height);
        this.setLocationRelativeTo(null); // centers on screen

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(600, 400));
    }

    private void appendRandomFortune() {
        if (fortunes.isEmpty()) {
            return;
        }

        // pick a random index different from lastIndex
        int newIndex;
        if (fortunes.size() == 1) {
            newIndex = 0;
        } else {
            do {
                newIndex = rng.nextInt(fortunes.size());
            } while (newIndex == lastIndex);
        }

        String next = fortunes.get(newIndex);
        lastIndex = newIndex;

        // append fortune to text area with a newline
        if (fortunesArea.getText().isEmpty()) {
            fortunesArea.append(next);
        } else {
            fortunesArea.append("\n" + next);
        }

        // Ensure the latest appended text is visible (scroll to bottom)
        fortunesArea.setCaretPosition(fortunesArea.getDocument().getLength());
    }
}

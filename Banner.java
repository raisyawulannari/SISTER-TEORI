public class Banner extends JFrame {
    private JLabel bannerLabel;
    private String bannerText;
    private int xPos = 0;

    public Banner() {
        setTitle("Banner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 100);

        bannerText = JOptionPane.showInputDialog("Masukkan teks untuk banner:");
        bannerLabel = new JLabel(bannerText);
        bannerLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        add(bannerLabel);

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveBanner();
            }
        });

        timer.start();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void moveBanner() {
        int labelWidth = bannerLabel.getPreferredSize().width;
        int windowWidth = getWidth();

        if (xPos + labelWidth > windowWidth) {
            xPos = -labelWidth;
        }

        bannerLabel.setLocation(xPos, 0);
        xPos += 5; // Adjust the speed of movement here
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Banner();
            }
        });
    }
}

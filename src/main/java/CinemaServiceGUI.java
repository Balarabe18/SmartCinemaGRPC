import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bookingticket.BookingTicketProto;
import bookingticket.MovieBookingServiceGrpc;
import cinemaservice.CinemaServiceGrpc;
import cinemaservice.CinemaServiceProto;
import foodanddrinksservice.FoodAndDrinksServiceProto.*;
import foodanddrinksservice.FoodAndDrinksServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class CinemaServiceGUI implements ActionListener {

    private JTextField bookingSeatIdField, bookingMovieNameField, bookingReplyField;
    private JTextField cinemaMovieNameField, cinemaStartingTimeField, cinemaDurationTimeField, cinemaReplyField;
    private JTextField foodSeatIdField, foodOrderField, foodReplyField;

    private ManagedChannel bookingChannel, cinemaChannel, foodAndDrinksChannel;
    private MovieBookingServiceGrpc.MovieBookingServiceBlockingStub bookingBlockingStub;
    private CinemaServiceGrpc.CinemaServiceBlockingStub cinemaBlockingStub;
    private FoodAndDrinksServiceGrpc.FoodAndDrinksServiceBlockingStub foodAndDrinksBlockingStub;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CinemaServiceGUI::new);
    }

    /**
     * @wbp.parser.entryPoint
     */
    public CinemaServiceGUI() {
        initServices();
        build();
    }

    private void initServices() {
        bookingChannel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
        bookingBlockingStub = MovieBookingServiceGrpc.newBlockingStub(bookingChannel);

        cinemaChannel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
        cinemaBlockingStub = CinemaServiceGrpc.newBlockingStub(cinemaChannel);

        foodAndDrinksChannel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
        foodAndDrinksBlockingStub = FoodAndDrinksServiceGrpc.newBlockingStub(foodAndDrinksChannel);
    }

    private void build() {
        JFrame frame = new JFrame("Cinema Service GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));

        panel.add(createBookingPanel());
        panel.add(createCinemaPanel());
        panel.add(createFoodAndDrinksPanel());

        frame.setSize(800, 600);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel createBookingPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        panel.add(new JLabel("Seat ID:"));
        bookingSeatIdField = new JTextField(10);
        panel.add(bookingSeatIdField);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        panel.add(new JLabel("Movie Name:"));
        bookingMovieNameField = new JTextField(10);
        panel.add(bookingMovieNameField);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Book Ticket");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        bookingReplyField = new JTextField(20);
        bookingReplyField.setEditable(false);
        panel.add(bookingReplyField);

        return panel;
    }

    private JPanel createCinemaPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        panel.add(new JLabel("Movie Name:"));
        cinemaMovieNameField = new JTextField(10);
        panel.add(cinemaMovieNameField);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        panel.add(new JLabel("Starting Time:"));
        cinemaStartingTimeField = new JTextField(10);
        panel.add(cinemaStartingTimeField);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        panel.add(new JLabel("Duration Time:"));
        cinemaDurationTimeField = new JTextField(10);
        panel.add(cinemaDurationTimeField);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Check Cinema");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        cinemaReplyField = new JTextField(20);
        cinemaReplyField.setEditable(false);
        panel.add(cinemaReplyField);

        return panel;
    }

    private JPanel createFoodAndDrinksPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        panel.add(new JLabel("Seat ID:"));
        foodSeatIdField = new JTextField(10);
        panel.add(foodSeatIdField);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        panel.add(new JLabel("Order:"));
        foodOrderField = new JTextField(10);
        panel.add(foodOrderField);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Place Order");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        foodReplyField = new JTextField(20);
        foodReplyField.setEditable(false);
        panel.add(foodReplyField);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String label = button.getText();

        switch (label) {
            case "Book Ticket":
                handleBookTicket();
                break;
            case "Check Cinema":
                handleCheckCinema();
                break;
            case "Place Order":
                handlePlaceOrder();
                break;
        }
    }

    private void handleBookTicket() {
        try {
            int seatId = Integer.parseInt(bookingSeatIdField.getText());
            String movieName = bookingMovieNameField.getText();
            BookingTicketProto.BookingRequest request = BookingTicketProto.BookingRequest.newBuilder()
                    .setSeatId(seatId)
                    .setMoviename(movieName)
                    .build();
            BookingTicketProto.BookingResponse response = bookingBlockingStub.bookingTicket(request);
            bookingReplyField.setText(response.getMessage());
        } catch (NumberFormatException ex) {
            bookingReplyField.setText("Invalid seat ID. Please enter a valid number.");
        }
    }

    private void handleCheckCinema() {
        try {
            String movieName = cinemaMovieNameField.getText();
            String startingTime = cinemaStartingTimeField.getText();
            int durationTime = Integer.parseInt(cinemaDurationTimeField.getText());

            CinemaServiceProto.ScheduleRequest request = CinemaServiceProto.ScheduleRequest.newBuilder()
                    .setMoviename(movieName)
                    .setStartingtime(startingTime)
                    .setDurationtime(durationTime)
                    .build();
            CinemaServiceProto.ScheduleResponse response = cinemaBlockingStub.scheduleMovie(request);
            cinemaReplyField.setText(response.getMessage());
        } catch (NumberFormatException ex) {
            cinemaReplyField.setText("Invalid duration time. Please enter a valid number.");
        }
    }

    private void handlePlaceOrder() {
        try {
            String seatId = foodSeatIdField.getText();
            String order = foodOrderField.getText();

            PlaceOrderRequest request = PlaceOrderRequest.newBuilder()
                    .setSeatId(seatId)
                    .addOrder(Item.newBuilder().setItemName(order).setQuantity(1).build())
                    .build();

            PlaceOrderResponse response = foodAndDrinksBlockingStub.placeOrder(request);
            foodReplyField.setText(response.getMessage());
        } catch (Exception ex) {
            foodReplyField.setText("Error placing order: " + ex.getMessage());
        }
    }
}


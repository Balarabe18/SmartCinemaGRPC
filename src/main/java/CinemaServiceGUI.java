import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bookingticket.BookingTicketProto;
import bookingticket.MovieBookingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import foodanddrinksservice.FoodAndDrinksServiceProto.*;
import foodanddrinksservice.FoodAndDrinksServiceGrpc;

import cinemaservice.CinemaServiceGrpc;
import cinemaservice.CinemaServiceProto;

public class CinemaServiceGUI extends JFrame {
    private ManagedChannel bookingChannel;
    private ManagedChannel cinemaChannel;
    private ManagedChannel foodAndDrinksChannel;

    private MovieBookingServiceGrpc.MovieBookingServiceBlockingStub bookingBlockingStub;
    private MovieBookingServiceGrpc.MovieBookingServiceStub bookingAsyncStub;

    private CinemaServiceGrpc.CinemaServiceBlockingStub cinemaBlockingStub;
    private CinemaServiceGrpc.CinemaServiceStub cinemaAsyncStub;

    private FoodAndDrinksServiceGrpc.FoodAndDrinksServiceBlockingStub foodAndDrinksBlockingStub;
    private FoodAndDrinksServiceGrpc.FoodAndDrinksServiceStub foodAndDrinksAsyncStub;

    public CinemaServiceGUI() {
        initServices();
        initComponents();
    }

    private void initServices() {
        bookingChannel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
        bookingBlockingStub = MovieBookingServiceGrpc.newBlockingStub(bookingChannel);
        bookingAsyncStub = MovieBookingServiceGrpc.newStub(bookingChannel);

        cinemaChannel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
        cinemaBlockingStub = CinemaServiceGrpc.newBlockingStub(cinemaChannel);
        cinemaAsyncStub = CinemaServiceGrpc.newStub(cinemaChannel);

        foodAndDrinksChannel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
        foodAndDrinksBlockingStub = FoodAndDrinksServiceGrpc.newBlockingStub(foodAndDrinksChannel);
        foodAndDrinksAsyncStub = FoodAndDrinksServiceGrpc.newStub(foodAndDrinksChannel);
    }

    private void initComponents() {
        setTitle("Cinema Service GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Booking Ticket Tab
        JPanel bookingPanel = new JPanel();
        bookingPanel.setLayout(new GridLayout(3, 2));
        bookingPanel.add(new JLabel("Seat ID:"));
        JTextField seatIdField = new JTextField();
        bookingPanel.add(seatIdField);
        bookingPanel.add(new JLabel("Movie ID:"));
        JTextField movieIdField = new JTextField();
        bookingPanel.add(movieIdField);
        JButton bookTicketButton = new JButton("Book Ticket");
        bookingPanel.add(bookTicketButton);
        JTextArea bookingResponseArea = new JTextArea();
        bookingPanel.add(new JScrollPane(bookingResponseArea));

        bookTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int seatId = Integer.parseInt(seatIdField.getText()); // Convert String to int
                    String movieName = movieIdField.getText();
                    BookingTicketProto.BookingRequest request = BookingTicketProto.BookingRequest.newBuilder()
                            .setSeatId(seatId) // Use the int value here
                            .setMoviename(movieName) // Ensure the field name matches with the proto file
                            .build();
                    BookingTicketProto.BookingResponse response = bookingBlockingStub.bookingTicket(request);
                    bookingResponseArea.setText(response.getMessage());
                } catch (NumberFormatException ex) {
                    // Handle the case where seatId is not a valid integer
                    bookingResponseArea.setText("Invalid seat ID. Please enter a valid number.");
                }
            }
        });

        // Cinema Service Tab
        JPanel cinemaPanel = new JPanel();
        cinemaPanel.setLayout(new GridLayout(3, 2));
        cinemaPanel.add(new JLabel("Customer ID:"));
        JTextField customerIdField = new JTextField();
        cinemaPanel.add(customerIdField);
        cinemaPanel.add(new JLabel("Ticket ID:"));
        JTextField ticketIdField = new JTextField();
        cinemaPanel.add(ticketIdField);
        JButton checkCinemaButton = new JButton("Check Cinema");
        cinemaPanel.add(checkCinemaButton);
        JTextArea cinemaResponseArea = new JTextArea();
        cinemaPanel.add(new JScrollPane(cinemaResponseArea));

        checkCinemaButton.addActionListener(new ActionListener() {
        	private JLabel movieNameField;
            private JLabel startingTimeField;
            private JLabel durationTimeField;
            @Override
            public void actionPerformed(ActionEvent e) {
                String moviename = movieNameField.getText();
                String startingtime = startingTimeField.getText();
                int durationtime;
                try {
                    durationtime = Integer.parseInt(durationTimeField.getText());
                } catch (NumberFormatException ex) {
                    cinemaResponseArea.setText("Invalid duration time. Please enter a valid number.");
                    return;
                }

                CinemaServiceProto.ScheduleRequest request = CinemaServiceProto.ScheduleRequest.newBuilder()
                        .setMoviename(moviename)
                        .setStartingtime(startingtime)
                        .setDurationtime(durationtime)
                        .build();
                CinemaServiceProto.ScheduleResponse response = cinemaBlockingStub.scheduleMovie(request);
                cinemaResponseArea.setText(response.getMessage());
            }
        });
        // Food and Drinks Service Tab
        JPanel foodAndDrinksPanel = new JPanel();
        foodAndDrinksPanel.setLayout(new GridLayout(3, 2));
        foodAndDrinksPanel.add(new JLabel("Seat ID:"));
        JTextField foodSeatIdField = new JTextField();
        foodAndDrinksPanel.add(foodSeatIdField);
        foodAndDrinksPanel.add(new JLabel("Order:"));
        JTextField orderField = new JTextField();
        foodAndDrinksPanel.add(orderField);
        JButton placeOrderButton = new JButton("Place Order");
        foodAndDrinksPanel.add(placeOrderButton);
        JTextArea foodAndDrinksResponseArea = new JTextArea();
        foodAndDrinksPanel.add(new JScrollPane(foodAndDrinksResponseArea));

        placeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seatId = foodSeatIdField.getText();
                String order = orderField.getText();
                PlaceOrderRequest request = PlaceOrderRequest.newBuilder()
                        .setSeatId(seatId)
                        .addOrder(Item.newBuilder().setItemName(order).setQuantity(1).build())
                        .build();
                PlaceOrderResponse response = foodAndDrinksBlockingStub.placeOrder(request);
                foodAndDrinksResponseArea.setText(response.getMessage());
            }
        });

        tabbedPane.addTab("Book Ticket", bookingPanel);
        tabbedPane.addTab("Check Cinema", cinemaPanel);
        tabbedPane.addTab("Food and Drinks", foodAndDrinksPanel);

        add(tabbedPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CinemaServiceGUI();
            }
        });
    }
}


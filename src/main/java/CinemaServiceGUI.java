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

    // GUI components for booking ticket
    private JTextField bookingSeatIdField, bookingMovieNameField, bookingReplyField, bookingIdField, bookingUserIdField;
    private JTextArea bookingUpdatesArea;

    // GUI components for cinema service
    private JTextField cinemaMovieNameField, cinemaStartingTimeField, cinemaDurationTimeField, cinemaReplyField, scheduleIdField, updateTimeField, cinemaStatusField;
    private JTextArea cinemaStatusUpdatesArea;

    // GUI components for food and drinks service
    private JTextField foodSeatIdField, foodOrderField, foodReplyField, orderIdField, orderStatusField;
    private JTextArea orderUpdatesArea;

    // gRPC channels and stubs for service communication
    private ManagedChannel bookingChannel, cinemaChannel, foodAndDrinksChannel;
    private MovieBookingServiceGrpc.MovieBookingServiceBlockingStub bookingBlockingStub;
    private CinemaServiceGrpc.CinemaServiceBlockingStub cinemaBlockingStub;
    private FoodAndDrinksServiceGrpc.FoodAndDrinksServiceBlockingStub foodAndDrinksBlockingStub;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CinemaServiceGUI::new);
    }

    // Constructor: Initializes services and sets up GUI
    /**
     * @wbp.parser.entryPoint
     */
    public CinemaServiceGUI() {
        initServices();
        build();
    }

    // Initializes gRPC channels and stubs for communication with the services
    private void initServices() {
        bookingChannel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
        bookingBlockingStub = MovieBookingServiceGrpc.newBlockingStub(bookingChannel);

        cinemaChannel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
        cinemaBlockingStub = CinemaServiceGrpc.newBlockingStub(cinemaChannel);

        foodAndDrinksChannel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
        foodAndDrinksBlockingStub = FoodAndDrinksServiceGrpc.newBlockingStub(foodAndDrinksChannel);
    }

    // Sets up the GUI components and layout
    private void build() {
        JFrame frmSmartcinemaapp = new JFrame("Cinema Service GUI");
        frmSmartcinemaapp.setTitle("SmartCinemaApp");
        frmSmartcinemaapp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));

        panel.add(createBookingPanel());
        panel.add(createCinemaPanel());
        panel.add(createFoodAndDrinksPanel());

        frmSmartcinemaapp.setSize(800, 600);
        frmSmartcinemaapp.getContentPane().add(panel);
        frmSmartcinemaapp.pack();
        frmSmartcinemaapp.setVisible(true);
    }

    // Creates and returns the panel for booking operations
    private JPanel createBookingPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Panel for booking a ticket
        JPanel bookingPanel = new JPanel();
        bookingPanel.setLayout(new BoxLayout(bookingPanel, BoxLayout.X_AXIS));

        bookingPanel.add(new JLabel("Seat ID:"));
        bookingSeatIdField = new JTextField(10);
        bookingPanel.add(bookingSeatIdField);
        bookingPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        bookingPanel.add(new JLabel("Movie Name:"));
        bookingMovieNameField = new JTextField(10);
        bookingPanel.add(bookingMovieNameField);
        bookingPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton bookButton = new JButton("Book Ticket");
        bookButton.addActionListener(this);
        bookingPanel.add(bookButton);

        bookingReplyField = new JTextField(20);
        bookingReplyField.setEditable(false);
        bookingPanel.add(bookingReplyField);

        panel.add(bookingPanel);

        // Panel for canceling a ticket
        JPanel cancelPanel = new JPanel();
        cancelPanel.setLayout(new BoxLayout(cancelPanel, BoxLayout.X_AXIS));

        cancelPanel.add(new JLabel("Booking ID:"));
        bookingIdField = new JTextField(10);
        cancelPanel.add(bookingIdField);
        cancelPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton cancelButton = new JButton("Cancel Ticket");
        cancelButton.addActionListener(this);
        cancelPanel.add(cancelButton);

        bookingReplyField = new JTextField(20);
        bookingReplyField.setEditable(false);
        cancelPanel.add(bookingReplyField);

        panel.add(cancelPanel);

        // Panel for streaming booking updates
        JPanel updatesPanel = new JPanel();
        updatesPanel.setLayout(new BoxLayout(updatesPanel, BoxLayout.X_AXIS));

        updatesPanel.add(new JLabel("User ID:"));
        bookingUserIdField = new JTextField(10);
        updatesPanel.add(bookingUserIdField);
        updatesPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton updatesButton = new JButton("Start Booking Updates");
        updatesButton.addActionListener(this);
        updatesPanel.add(updatesButton);

        bookingUpdatesArea = new JTextArea(5, 30);
        bookingUpdatesArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(bookingUpdatesArea);
        updatesPanel.add(scrollPane);

        panel.add(updatesPanel);

        return panel;
    }

    // Creates and returns the panel for cinema operations
    private JPanel createCinemaPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Panel for checking cinema schedule
        JPanel schedulePanel = new JPanel();
        schedulePanel.setLayout(new BoxLayout(schedulePanel, BoxLayout.X_AXIS));

        schedulePanel.add(new JLabel("Movie Name:"));
        cinemaMovieNameField = new JTextField(10);
        schedulePanel.add(cinemaMovieNameField);
        schedulePanel.add(Box.createRigidArea(new Dimension(10, 0)));

        schedulePanel.add(new JLabel("Starting Time:"));
        cinemaStartingTimeField = new JTextField(10);
        schedulePanel.add(cinemaStartingTimeField);
        schedulePanel.add(Box.createRigidArea(new Dimension(10, 0)));

        schedulePanel.add(new JLabel("Duration Time:"));
        cinemaDurationTimeField = new JTextField(10);
        schedulePanel.add(cinemaDurationTimeField);
        schedulePanel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton checkScheduleButton = new JButton("Check Cinema");
        checkScheduleButton.addActionListener(this);
        schedulePanel.add(checkScheduleButton);

        cinemaReplyField = new JTextField(20);
        cinemaReplyField.setEditable(false);
        schedulePanel.add(cinemaReplyField);

        panel.add(schedulePanel);

        // Panel for updating cinema schedule
        JPanel updatePanel = new JPanel();
        updatePanel.setLayout(new BoxLayout(updatePanel, BoxLayout.X_AXIS));

        updatePanel.add(new JLabel("Schedule ID:"));
        scheduleIdField = new JTextField(10);
        updatePanel.add(scheduleIdField);
        updatePanel.add(Box.createRigidArea(new Dimension(10, 0)));

        updatePanel.add(new JLabel("Update Time:"));
        updateTimeField = new JTextField(10);
        updatePanel.add(updateTimeField);
        updatePanel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton updateScheduleButton = new JButton("Update Schedule");
        updateScheduleButton.addActionListener(this);
        updatePanel.add(updateScheduleButton);

        cinemaReplyField = new JTextField(20);
        cinemaReplyField.setEditable(false);
        updatePanel.add(cinemaReplyField);

        panel.add(updatePanel);

        // Panel for streaming cinema status
        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));

        statusPanel.add(new JLabel("Cinema ID:"));
        cinemaStatusField = new JTextField(10);
        statusPanel.add(cinemaStatusField);
        statusPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton statusButton = new JButton("Start Cinema Status");
        statusButton.addActionListener(this);
        statusPanel.add(statusButton);

        cinemaStatusUpdatesArea = new JTextArea(5, 30);
        cinemaStatusUpdatesArea.setEditable(false);
        JScrollPane statusScrollPane = new JScrollPane(cinemaStatusUpdatesArea);
        statusPanel.add(statusScrollPane);

        panel.add(statusPanel);

        return panel;
    }

    // Creates and returns the panel for food and drinks operations
    private JPanel createFoodAndDrinksPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Panel for placing an order
        JPanel orderPanel = new JPanel();
        orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.X_AXIS));

        orderPanel.add(new JLabel("Seat ID:"));
        foodSeatIdField = new JTextField(10);
        orderPanel.add(foodSeatIdField);
        orderPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        orderPanel.add(new JLabel("Order:"));
        foodOrderField = new JTextField(10);
        orderPanel.add(foodOrderField);
        orderPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton placeOrderButton = new JButton("Place Order");
        placeOrderButton.addActionListener(this);
        orderPanel.add(placeOrderButton);

        foodReplyField = new JTextField(20);
        foodReplyField.setEditable(false);
        orderPanel.add(foodReplyField);

        panel.add(orderPanel);

        // Panel for checking order status
        JPanel checkOrderPanel = new JPanel();
        checkOrderPanel.setLayout(new BoxLayout(checkOrderPanel, BoxLayout.X_AXIS));

        checkOrderPanel.add(new JLabel("Order ID:"));
        orderIdField = new JTextField(10);
        checkOrderPanel.add(orderIdField);
        checkOrderPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton checkOrderButton = new JButton("Check Order Status");
        checkOrderButton.addActionListener(this);
        checkOrderPanel.add(checkOrderButton);

        orderStatusField = new JTextField(20);
        orderStatusField.setEditable(false);
        checkOrderPanel.add(orderStatusField);

        panel.add(checkOrderPanel);

        // Panel for streaming order updates
        JPanel orderUpdatesPanel = new JPanel();
        orderUpdatesPanel.setLayout(new BoxLayout(orderUpdatesPanel, BoxLayout.X_AXIS));

        orderUpdatesPanel.add(new JLabel("Customer ID:"));
        foodSeatIdField = new JTextField(10);
        orderUpdatesPanel.add(foodSeatIdField);
        orderUpdatesPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton orderUpdatesButton = new JButton("Start Order Updates");
        orderUpdatesButton.addActionListener(this);
        orderUpdatesPanel.add(orderUpdatesButton);

        orderUpdatesArea = new JTextArea(5, 30);
        orderUpdatesArea.setEditable(false);
        JScrollPane orderScrollPane = new JScrollPane(orderUpdatesArea);
        orderUpdatesPanel.add(orderScrollPane);

        panel.add(orderUpdatesPanel);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String label = button.getText();

        // Determine which action to take based on the button clicked
        switch (label) {
            case "Book Ticket":
                handleBookTicket();
                break;
            case "Cancel Ticket":
                handleCancelTicket();
                break;
            case "Start Booking Updates":
                handleStreamBookingUpdates();
                break;
            case "Check Cinema":
                handleCheckCinema();
                break;
            case "Update Schedule":
                handleUpdateSchedule();
                break;
            case "Start Cinema Status":
                handleStreamCinemaStatus();
                break;
            case "Place Order":
                handlePlaceOrder();
                break;
            case "Check Order Status":
                handleCheckOrderStatus();
                break;
            case "Start Order Updates":
                handleStreamOrderUpdates();
                break;
        }
    }

    // Handles booking a ticket by sending a request and updating the response field
    private void handleBookTicket() {
        try {
            String moviename = bookingMovieNameField.getText();
            int seatId = Integer.parseInt(bookingSeatIdField.getText());
            String starttime = bookingSeatIdField.getText(); // Adjust as needed for the actual input
            BookingTicketProto.BookingRequest request = BookingTicketProto.BookingRequest.newBuilder()
                    .setMoviename(moviename)
                    .setSeatId(seatId)
                    .setStarttime(starttime)
                    .build();

            BookingTicketProto.BookingResponse response = bookingBlockingStub.bookingTicket(request);
            bookingReplyField.setText(response.getMessage());
        } catch (Exception ex) {
            bookingReplyField.setText("Booking failed: " + ex.getMessage());
        }
    }

    // Handles canceling a ticket by sending a request and updating the response field
    private void handleCancelTicket() {
        try {
            String bookingid = bookingIdField.getText();
            int seatId = Integer.parseInt(bookingSeatIdField.getText());
            BookingTicketProto.CancelRequest request = BookingTicketProto.CancelRequest.newBuilder()
                    .setBookingid(bookingid)
                    .setSeatId(seatId)
                    .build();

            BookingTicketProto.CancelResponse response = bookingBlockingStub.cancelTicket(request);
            bookingReplyField.setText(response.getMessage());
        } catch (Exception ex) {
            bookingReplyField.setText("Cancellation failed: " + ex.getMessage());
        }
    }

    // Handles streaming booking updates by creating a new thread and appending updates to the text area
    private void handleStreamBookingUpdates() {
        try {
            String userid = bookingUserIdField.getText();
            BookingTicketProto.BookingUpdatesRequest request = BookingTicketProto.BookingUpdatesRequest.newBuilder()
                    .setUserid(userid)
                    .build();

            new Thread(() -> {
                bookingBlockingStub.streamBookingUpdates(request).forEachRemaining(update -> {
                    bookingUpdatesArea.append("Update: " + update.getMessage() + "\n");
                });
            }).start();
        } catch (Exception ex) {
            bookingReplyField.setText("Failed to stream booking updates: " + ex.getMessage());
        }
    }

    // Handles checking the cinema schedule by sending a request and updating the response field
    private void handleCheckCinema() {
        try {
            String moviename = cinemaMovieNameField.getText();
            String startingtime = cinemaStartingTimeField.getText();
            int durationtime = Integer.parseInt(cinemaDurationTimeField.getText());

            CinemaServiceProto.ScheduleRequest request = CinemaServiceProto.ScheduleRequest.newBuilder()
                    .setMoviename(moviename)
                    .setStartingtime(startingtime)
                    .setDurationtime(durationtime)
                    .build();

            CinemaServiceProto.ScheduleResponse response = cinemaBlockingStub.scheduleMovie(request);
            cinemaReplyField.setText(response.getMessage());
        } catch (NumberFormatException ex) {
            cinemaReplyField.setText("Invalid input. Please check the values.");
        } catch (Exception ex) {
            cinemaReplyField.setText("Failed to check cinema schedule: " + ex.getMessage());
        }
    }

    // Handles updating the cinema schedule by sending a request and updating the response field
    private void handleUpdateSchedule() {
        try {
            String scheduleId = scheduleIdField.getText();
            String updatetime = updateTimeField.getText();

            CinemaServiceProto.UpdateScheduleRequest request = CinemaServiceProto.UpdateScheduleRequest.newBuilder()
                    .setScheduleId(scheduleId)
                    .setUpdatetime(updatetime)
                    .build();

            CinemaServiceProto.UpdateScheduleResponse response = cinemaBlockingStub.updateSchedule(request);
            cinemaReplyField.setText(response.getMessage());
        } catch (Exception ex) {
            cinemaReplyField.setText("Failed to update schedule: " + ex.getMessage());
        }
    }

    // Handles streaming cinema status by creating a new thread and appending status updates to the text area
    private void handleStreamCinemaStatus() {
        try {
            String cinemaId = cinemaStatusField.getText();
            CinemaServiceProto.CinemaStatusRequest request = CinemaServiceProto.CinemaStatusRequest.newBuilder()
                    .setCinemaId(cinemaId)
                    .build();

            new Thread(() -> {
                cinemaBlockingStub.streamCinemaStatus(request).forEachRemaining(status -> {
                    cinemaStatusUpdatesArea.append("Status: " + status.getStatus() + " | Climate: " + status.getClimate() + " | Occupancy: " + status.getOccupancy() + "\n");
                });
            }).start();
        } catch (Exception ex) {
            cinemaReplyField.setText("Failed to stream cinema status: " + ex.getMessage());
        }
    }

    // Handles placing an order by sending a request and updating the response field
    private void handlePlaceOrder() {
        try {
            String seatId = foodSeatIdField.getText();
            String itemName = foodOrderField.getText(); // assuming single item order for simplicity
            Item item = Item.newBuilder()
                    .setItemName(itemName)
                    .setQuantity(1)
                    .build();

            PlaceOrderRequest request = PlaceOrderRequest.newBuilder()
                    .setSeatId(seatId)
                    .addOrder(item)
                    .build();

            PlaceOrderResponse response = foodAndDrinksBlockingStub.placeOrder(request);
            foodReplyField.setText(response.getMessage());
        } catch (Exception ex) {
            foodReplyField.setText("Failed to place order: " + ex.getMessage());
        }
    }

    // Handles checking the order status by sending a request and updating the response field
    private void handleCheckOrderStatus() {
        try {
            String orderId = orderIdField.getText();
            CheckOrderStatusRequest request = CheckOrderStatusRequest.newBuilder()
                    .setOrderId(orderId)
                    .build();

            CheckOrderStatusResponse response = foodAndDrinksBlockingStub.checkOrderStatus(request);
            foodReplyField.setText(response.getStatus());
        } catch (Exception ex) {
            foodReplyField.setText("Failed to check order status: " + ex.getMessage());
        }
    }

    // Handles streaming order updates by creating a new thread and appending updates to the text area
    private void handleStreamOrderUpdates() {
        try {
            String customerId = foodSeatIdField.getText();
            OrderUpdatesRequest request = OrderUpdatesRequest.newBuilder()
                    .setCustomerId(customerId)
                    .build();

            new Thread(() -> {
                foodAndDrinksBlockingStub.streamOrderUpdates(request).forEachRemaining(update -> {
                    orderUpdatesArea.append("Order Update: " + update.getMessage() + "\n");
                });
            }).start();
        } catch (Exception ex) {
            foodReplyField.setText("Failed to stream order updates: " + ex.getMessage());
        }
    }
}


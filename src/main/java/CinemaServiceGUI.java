import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import cinemaservice.CinemaServiceGrpc;
import cinemaservice.CinemaServiceProto.*;

public class CinemaServiceGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField movieNameField, startTimeField, durationField, scheduleIdField, updateTimeField, cinemaIdField;
    private JTextArea responseArea;
    private ManagedChannel channel;
    private CinemaServiceGrpc.CinemaServiceBlockingStub blockingStub;
    private CinemaServiceGrpc.CinemaServiceStub asyncStub;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CinemaServiceGUI frame = new CinemaServiceGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public CinemaServiceGUI() {
        setTitle("Cinema Service Client");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(10, 2, 10, 10));

        add(new JLabel("Movie Name:"));
        movieNameField = new JTextField();
        add(movieNameField);

        add(new JLabel("Start Time (YYYY-MM-DDTHH:MM:SS):"));
        startTimeField = new JTextField();
        add(startTimeField);

        add(new JLabel("Duration (minutes):"));
        durationField = new JTextField();
        add(durationField);

        JButton scheduleButton = new JButton("Schedule Movie");
        scheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scheduleMovie();
            }
        });
        add(scheduleButton);

        add(new JLabel("Schedule ID:"));
        scheduleIdField = new JTextField();
        add(scheduleIdField);

        add(new JLabel("Update Time (YYYY-MM-DDTHH:MM:SS):"));
        updateTimeField = new JTextField();
        add(updateTimeField);

        JButton updateButton = new JButton("Update Schedule");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSchedule();
            }
        });
        add(updateButton);

        add(new JLabel("Cinema ID:"));
        cinemaIdField = new JTextField();
        add(cinemaIdField);

        JButton streamButton = new JButton("Stream Cinema Status");
        streamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                streamCinemaStatus();
            }
        });
        add(streamButton);

        responseArea = new JTextArea();
        responseArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(responseArea);
        contentPane.add(scrollPane);
        contentPane.add(new JLabel(""));

        // Initialize gRPC channel and stubs
        channel = ManagedChannelBuilder.forAddress("localhost", 50052)
                .usePlaintext()
                .build();
        blockingStub = CinemaServiceGrpc.newBlockingStub(channel);
        asyncStub = CinemaServiceGrpc.newStub(channel);
    }

    private void scheduleMovie() {
        String movieName = movieNameField.getText();
        String startTime = startTimeField.getText();
        int duration = Integer.parseInt(durationField.getText());

        ScheduleRequest request = ScheduleRequest.newBuilder()
                .setMoviename(movieName)
                .setStartingtime(startTime)
                .setDurationtime(duration)
                .build();
        ScheduleResponse response = blockingStub.scheduleMovie(request);
        responseArea.append("ScheduleMovie Response: " + response.getMessage() + "\n");
    }

    private void updateSchedule() {
        String scheduleId = scheduleIdField.getText();
        String updateTime = updateTimeField.getText();

        UpdateScheduleRequest request = UpdateScheduleRequest.newBuilder()
                .setScheduleId(scheduleId)
                .setUpdatetime(updateTime)
                .build();
        UpdateScheduleResponse response = blockingStub.updateSchedule(request);
        responseArea.append("UpdateSchedule Response: " + response.getMessage() + "\n");
    }

    private void streamCinemaStatus() {
        String cinemaId = cinemaIdField.getText();

        CinemaStatusRequest request = CinemaStatusRequest.newBuilder()
                .setCinemaId(cinemaId)
                .build();
        asyncStub.streamCinemaStatus(request, new StreamObserver<CinemaStatus>() {
            @Override
            public void onNext(CinemaStatus cinemaStatus) {
                responseArea.append("CinemaStatus: " + cinemaStatus.getMoviename() +
                        ", Status: " + cinemaStatus.getStatus() +
                        ", Climate: " + cinemaStatus.getClimate() +
                        ", Occupancy: " + cinemaStatus.getOccupancy() + "\n");
            }

            @Override
            public void onError(Throwable t) {
                responseArea.append("Error: " + t.getMessage() + "\n");
            }

            @Override
            public void onCompleted() {
                responseArea.append("Completed receiving cinema status updates\n");
            }
        });
    }
}




import javax.swing.*;
import java.awt.*;

public class FitnessMacroSystem {

    // User Data
    public static String name;
    public static String gender;
    public static int age;
    public static double weight;
    public static double height;
    public static String activityLevel;
    public static String phase;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FitnessMacroSystem().createUI());
    }

    public void createUI() {
        JFrame frame = new JFrame("Fitness Macro Calculator System");
        frame.setSize(600, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new CardLayout());

        // Panels for different screens
        JPanel mainScreen = createMainScreen(frame);
        JPanel activityScreen = createActivityScreen(frame);
        JPanel phaseScreen = createPhaseScreen(frame);
        JPanel resultScreen = createResultScreen(frame);
        JPanel workoutScheduleScreen = createWorkoutScheduleScreen(frame);

        // Add panels to frame
        frame.add(mainScreen, "MainScreen");
        frame.add(activityScreen, "ActivityScreen");
        frame.add(phaseScreen, "PhaseScreen");
        frame.add(resultScreen, "ResultScreen");
        frame.add(workoutScheduleScreen, "WorkoutScheduleScreen");

        // Show main screen
        frame.setVisible(true);
    }

    public JPanel createMainScreen(JFrame frame) {
        JPanel panel = createStyledPanel();
    
        JLabel welcomeLabel = createStyledLabel("Welcome to Macro Mate!", 30);
        JTextField nameField = createStyledTextField();
        JTextField ageField = createStyledTextField();
        JTextField weightField = createStyledTextField();
        JTextField heightField = createStyledTextField();
        JComboBox<String> genderCombo = createStyledComboBox(new String[]{"Male", "Female"});
        JButton nextButton = createStyledButton("Next");
    
        nextButton.addActionListener(e -> {
            name = nameField.getText();
            gender = (String) genderCombo.getSelectedItem();
            try {
                age = Integer.parseInt(ageField.getText());
                weight = Double.parseDouble(weightField.getText());
                height = Double.parseDouble(heightField.getText());
    
                CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
                cl.show(frame.getContentPane(), "ActivityScreen");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please fill all the fields correctly.");
            }
        });
    
        panel.add(welcomeLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 30))); // Add space between the welcome label and fields
        
        addComponentsToPanel(panel, new JLabel("Name:"), nameField);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Space between fields
        addComponentsToPanel(panel, new JLabel("Gender:"), genderCombo);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        addComponentsToPanel(panel, new JLabel("Age:"), ageField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        addComponentsToPanel(panel, new JLabel("Weight (kg):"), weightField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        addComponentsToPanel(panel, new JLabel("Height (cm):"), heightField);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Space before the button
        panel.add(nextButton);
    
        return panel;
    }
    
    public JPanel createActivityScreen(JFrame frame) {
        JPanel panel = createStyledPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    
        panel.add(Box.createVerticalGlue());  // Pushes content to center vertically
    
        JLabel label = createStyledLabel("Select Activity Level", 30);
        JComboBox<String> activityCombo = createStyledComboBox(new String[]{
                "Light Exercise (1-2 days/week)",
                "Moderate Exercise (3-5 days/week)",
                "Heavy Exercise (6-7 days/week)",
                "Intense Exercise (2x per day)"
        });
        JButton nextButton = createStyledButton("Next");
    
        nextButton.addActionListener(e -> {
            activityLevel = (String) activityCombo.getSelectedItem();
            CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
            cl.show(frame.getContentPane(), "PhaseScreen");
        });
    
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));  // Space between label and combo box
        panel.add(activityCombo);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));  // Space between combo box and button
        panel.add(nextButton);
        
        panel.add(Box.createVerticalGlue());  // Pushes content to center vertically
    
        return panel;
    }
    
    public JPanel createPhaseScreen(JFrame frame) {
        JPanel panel = createStyledPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    
        panel.add(Box.createVerticalGlue());
    
        JLabel label = createStyledLabel("Select Dietary Phase", 30);
        JComboBox<String> phaseCombo = createStyledComboBox(new String[]{"Maintenance", "Cutting", "Bulking"});
        JButton calculateButton = createStyledButton("Calculate");
    
        calculateButton.addActionListener(e -> {
            phase = (String) phaseCombo.getSelectedItem();
            CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
            cl.show(frame.getContentPane(), "ResultScreen");
        });
    
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));  // Space between label and combo box
        panel.add(phaseCombo);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));  // Space between combo box and button
        panel.add(calculateButton);
        
        panel.add(Box.createVerticalGlue());
    
        return panel;
    }
    

    public JPanel createResultScreen(JFrame frame) {
        JPanel panel = createStyledPanel();
        
        JLabel resultLabel = createStyledLabel("RESULT", 30);
        JTextArea resultText = new JTextArea(12, 40);
        resultText.setFont(new Font("Courier New", Font.PLAIN, 14)); // Monospaced for alignment
        resultText.setEditable(false);
        resultText.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        JScrollPane scrollPane = new JScrollPane(resultText);
        
        JButton workoutButton = createStyledButton("View Workout Schedule");
        workoutButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
            cl.show(frame.getContentPane(), "WorkoutScheduleScreen");
        });
        
        JButton exitButton = createStyledButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        
        // Display results when the screen is shown
        panel.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentShown(java.awt.event.ComponentEvent evt) {
                if (gender == null || weight <= 0 || height <= 0 || age <= 0 || activityLevel == null || phase == null) {
                    JOptionPane.showMessageDialog(frame, "Please complete all fields before viewing results.");
                    return;
                }
        
                double bmr = calculateBMR(gender, weight, height, age);
                double tdee = calculateTDEE(bmr, activityLevel);
                double[] macros = calculateMacros(tdee, phase);
        
                // Convert results to whole numbers
                long roundedTDEE = Math.round(tdee);
                long roundedWeeklyCalories = Math.round(tdee * 7);
                long carbs = Math.round(macros[0]);
                long fats = Math.round(macros[2]);
                long protein = Math.round(macros[1]);
        
                String result = String.format(
                        "Hello, %s!\n" +
                        "You are a %d-year-old %s who weighs %d kg and height of \n%d cm tall.\n" +
                        "You perform %s and you are in \nthe %s phase.\n\n" +
                        "Daily caloric intake: %d calories per day\n" +
                        "Weekly caloric intake: %d calories per week\n\n" +
                        "Macronutrient:\n" +
                        "Carbs: %d grams per day\n" +
                        "Fats: %d grams per day\n" +
                        "Protein: %d grams per day",
                        name, age, gender, (int) weight, (int) height, activityLevel, phase,
                        roundedTDEE, roundedWeeklyCalories, carbs, fats, protein
                );
        
                resultText.setText(result);
            }
        });
        
        panel.add(resultLabel);
        panel.add(scrollPane);
        panel.add(workoutButton);
        panel.add(exitButton);
        
        return panel;
    }
    
    

    public JPanel createWorkoutScheduleScreen(JFrame frame) {
        JPanel panel = createStyledPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JLabel scheduleLabel = createStyledLabel("Workout Schedule", 25);
        JTextArea workoutText = new JTextArea(15, 40);
        workoutText.setFont(new Font("Arial", Font.PLAIN, 12));
        workoutText.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(workoutText);
        
        // Buttons for each day
        JPanel daysPanel = new JPanel();
        daysPanel.setLayout(new GridLayout(1, 7, 5, 5)); // 7 buttons in one row with spacing
        daysPanel.setBackground(panel.getBackground());
        
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        
        for (String day : days) {
            JButton dayButton = createStyledButton(day);
            dayButton.setFont(new Font("Arial", Font.PLAIN, 12)); // Smaller font for better fit
            
            dayButton.addActionListener(e -> {
                workoutText.setText(getWorkoutForDay(day)); // Display workout for the selected day
            });
            daysPanel.add(dayButton);
        }
        
        JButton backButton = createStyledButton("Back to Results");
        backButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
            cl.show(frame.getContentPane(), "ResultScreen");
        });
        
        panel.add(scheduleLabel);
        panel.add(daysPanel);
        panel.add(scrollPane);
        panel.add(backButton);
        
        return panel;
    }
    
    // Example workouts for each day
    private String getWorkoutForDay(String day) {
        switch (day) {
            case "Monday":
                return "MONDAY - Chest & Triceps:\n" +
                        "Chest Exercise\n" +
                        "   3 sets / 8 - 12 reps\n" +
                        "     - High to Low Flyes\n" +
                        "     - Mid Chest Flyes\n" +
                        "   3 sets / 12 - 15 reps\n" +
                        "     - Wide Push-Ups\n\n" +
                        "Tricep Exercise\n" +
                        "   3 sets / 8 - 12 reps\n" +
                        "     - Overhead Tricep Extensions\n" +
                        "     - Tricep Push Down\n" +
                        "   3 sets / 12 - 15 reps\n" +
                        "     - Diamond Push-Ups\n";
            case "Tuesday":
                return "TUESDAY - Biceps & Back:\n" +
                        "Bicep Exercise\n" +
                        "   3 sets / 8 - 12 reps\n" +
                        "     - Bicep Curls\n" +
                        "     - Hammer Curls\n" +
                        "     - Cross Body Hammer Curls\n\n" +
                        "Back Exercise\n" +
                        "   3 sets / 8 - 12 reps\n" +
                        "     - Arm Pull Down\n" +
                        "     - Lat Pull Down\n" +
                        "     - Supinated Lat Pull Down\n" +
                        "     - Underhand Row\n" +
                        "   3 sets / 12 - 15 reps\n" +
                        "     - Close Grip Push-Ups\n";
            case "Wednesday":
                return "WEDNESDAY - Shoulders & Legs:\n" +
                        "Shoulder Exercise\n" +
                        "   3 sets / 8 - 12 reps\n" +
                        "     - Shoulder Press\n" +
                        "     - Lateral Raise\n" +
                        "     - Face Pulls\n" +
                        "   3 sets / 12 - 15 reps\n" +
                        "     - Pike Push-Ups\n\n" +
                        "Leg Exercise\n" +
                        "   3 sets / 8 - 12 reps\n" +
                        "     - Squats\n" +
                        "     - Stiff Leg Deadlift\n" +
                        "     - Lunges\n";
            case "Thursday":
                return "THURSDAY - Chest & Triceps:\n" +
                        "Chest Exercise\n" +
                        "   3 sets / 8 - 12 reps\n" +
                        "     - High to Low Flyes\n" +
                        "     - Mid Chest Flyes\n" +
                        "   3 sets / 12 - 15 reps\n" +
                        "     - Wide Push-Ups\n\n" +
                        "Tricep Exercise\n" +
                        "   3 sets / 8 - 12 reps\n" +
                        "     - Overhead Tricep Extensions\n" +
                        "     - Tricep Push Down\n" +
                        "   3 sets / 12 - 15 reps\n" +
                        "     - Diamond Push-Ups\n";
            case "Friday":
                return "FRIDAY - Biceps & Back:\n" +
                        "Bicep Exercise\n" +
                        "   3 sets / 8 - 12 reps\n" +
                        "     - Bicep Curls\n" +
                        "     - Hammer Curls\n" +
                        "     - Cross Body Hammer Curls\n\n" +
                        "Back Exercise\n" +
                        "   3 sets / 8 - 12 reps\n" +
                        "     - Arm Pull Down\n" +
                        "     - Lat Pull Down\n" +
                        "     - Supinated Lat Pull Down\n" +
                        "     - Underhand Row\n" +
                        "   3 sets / 12 - 15 reps\n" +
                        "     - Close Grip Push-Ups\n";
            case "Saturday":
                return "SATURDAY - Shoulders & Legs:\n" +
                        "Shoulder Exercise\n" +
                        "   3 sets / 8 - 12 reps\n" +
                        "     - Shoulder Press\n" +
                        "     - Lateral Raise\n" +
                        "     - Face Pulls\n" +
                        "   3 sets / 12 - 15 reps\n" +
                        "     - Pike Push-Ups\n\n" +
                        "Leg Exercise\n" +
                        "   3 sets / 8 - 12 reps\n" +
                        "     - Squats\n" +
                        "     - Stiff Leg Deadlift\n" +
                        "     - Lunges\n";
            case "Sunday":
                return "SUNDAY - Cardio & Abs:\n" +
                        "Cardio Exercise\n" +
                        "     - basketball\n" +
                        "     - 30 minutes of running, cycling, or brisk walking\n\n" +
                        "ABS Exercise\n" +
                        "   3 sets / 8 - 12 reps\n" +
                        "     - Crunches\n" +
                        "     - Russian Twist\n" +
                        "     - Leg Raise\n" +
                        "     - Plank (30 seconds to 1 minute)\n";
            default:
                return "Select a valid day.";
        }
    }
    
    
    

    // BMR calculation method
    public double calculateBMR(String gender, double weight, double height, int age) {
        if (gender.equalsIgnoreCase("Male")) {
            return 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        } else {
            return 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        }
    }

    // TDEE calculation method
    public double calculateTDEE(double bmr, String activityLevel) {
        double activityFactor;
        switch (activityLevel) {
            case "Light Exercise (1-2 days/week)":
                activityFactor = 1.2;
                break;
            case "Moderate Exercise (3-5 days/week)":
                activityFactor = 1.375;
                break;
            case "Heavy Exercise (6-7 days/week)":
                activityFactor = 1.55;
                break;
            case "Intense Exercise (2x per day)":
                activityFactor = 1.725;
                break;
            default:
                activityFactor = 1.0;
                break;
        }
        return bmr * activityFactor;
    }
    // Macronutrient calculation method
    public double[] calculateMacros(double tdee, String phase) {
        double[] macros = new double[3]; // Carbs, Protein, Fat
        switch (phase) {
            case "Maintenance":
                macros[0] = (tdee * 0.45) / 4; // Carbs (45% of TDEE, 4 kcal/g)
                macros[1] = (tdee * 0.30) / 4; // Protein (30% of TDEE, 4 kcal/g)
                macros[2] = (tdee * 0.25) / 9; // Fat (25% of TDEE, 9 kcal/g)
                break;
            case "Cutting":
                macros[0] = (tdee * 0.35) / 4;
                macros[1] = (tdee * 0.40) / 4;
                macros[2] = (tdee * 0.25) / 9;
                break;
            case "Bulking":
                macros[0] = (tdee * 0.50) / 4;
                macros[1] = (tdee * 0.30) / 4;
                macros[2] = (tdee * 0.20) / 9;
                break;
        }
        return macros;
    }
    

    public JPanel createStyledPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.decode("#E0F7FA"));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        return panel;
    }

    public JLabel createStyledLabel(String text, int fontSize) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, fontSize));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setForeground(Color.decode("#00796B"));
        return label;
    }

    public JTextField createStyledTextField() {
        JTextField field = new JTextField(20);
        field.setMaximumSize(new Dimension(400, 30));
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        return field;
    }

    public JComboBox<String> createStyledComboBox(String[] options) {
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setMaximumSize(new Dimension(400, 30));
        comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        return comboBox;
    }

    public JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(Color.decode("#00796B"));
        button.setForeground(Color.WHITE);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }

    public void addComponentsToPanel(JPanel panel, JLabel label, JComponent field) {
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);
        panel.add(field);
    }
}

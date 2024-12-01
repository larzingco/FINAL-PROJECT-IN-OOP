<div align="center"> <img src="https://github.com/user-attachments/assets/24418ef3-3b22-4106-8352-04cebf4daecf">  

**Ingco, Larz Byron E.**

***IT-2104***

🏋️‍♂️🏋️‍♂️🏋️‍♂️</div>


## I. Project Overview 💪
Fitness Macro Calculator System is a Java-based application designed to assist users in calculating their daily caloric needs and macronutrient distribution based on their fitness goals. The system allows users to input essential personal details such as name, age, weight, height, gender, and activity level. Based on these inputs, it provides tailored nutritional recommendations for different dietary phases: Maintenance, Cutting, or Bulking. By using established formulas for BMR (Basal Metabolic Rate) and TDEE (Total Daily Energy Expenditure), the system calculates precise caloric intake requirements and breaks them down into carbohydrates, proteins, and fats for a balanced diet.

In addition to nutritional guidance, the application offers a structured weekly workout schedule. Users can view detailed exercise routines categorized by day and muscle group, helping them stay on track with their fitness goals. The program features a user-friendly interface built with Java Swing, enabling seamless navigation between input screens, result displays, and workout plans. This combination of personalized nutrition and exercise planning makes the Fitness Macro Calculator System a comprehensive tool for health and fitness management.

---

## II. Application of OOP Principles 🔗
The Object-Oriented Programming (OOP) principles applied in this Fitness Macro System Java program are:

1. Encapsulation 💊
   - Encapsulation is only partially applied. The attributes (e.g., name, age, weight) are public static variables, making them accessible globally, which violates encapsulation.
   - Improvement: Convert these fields into private attributes with getter and setter methods to restrict direct access and ensure data validation.

2. Abstraction 🗄️
   - The program effectively abstracts GUI components by modularizing the creation of different screens (createMainScreen, createActivityScreen, createPhaseScreen, etc.).
   - Helper methods like createStyledLabel, createStyledTextField, and addComponentsToPanel encapsulate complex UI logic, allowing cleaner and more manageable code.

3. Inheritance 🧬
   - Inheritance is not explicitly applied, but it can be introduced to reduce redundancy. For example, creating a base Screen class with common panel methods could improve maintainability and reuse.
  
4. Polymorphism 📑
   - While method overriding (polymorphism) isn't explicitly used, there’s potential for introducing it by creating multiple implementations of common behaviors. For example, introducing different screen types that inherit from a base Screen class and override the display() method for each specific panel.

---

## III. SDG and its Integration 🌍
<div align="center"> <img src="https://github.com/user-attachments/assets/3b5d1779-48a7-486a-a57d-bddca83edb1f"> 

### SDG 3: Good Health and Well-Being </div>
The Macro Mate system plays a crucial role in promoting good health and well-being by empowering users to take charge of their physical fitness and nutrition. Here’s how it supports SDG 3:

1. **Promoting Healthy Lifestyles**
   - Personalized Fitness and Nutrition Guidance: The system calculates BMR (Basal Metabolic Rate), TDEE (Total Daily Energy Expenditure), and macronutrient needs based on individual data (age, weight, height, gender, activity level), helping users understand their body’s energy requirements. This customization promotes better lifestyle choices, such as maintaining a balanced diet and exercising at the right intensity, which are vital for overall well-being.
   - Dietary Phase Customization: Users can choose from different dietary phases (Maintenance, Cutting, or Bulking), aligning their nutrition with specific fitness goals. Whether aiming to lose weight (cutting), maintain weight (maintenance), or build muscle (bulking), the system provides personalized guidance, helping users make informed decisions for better health outcomes.

2. **Supporting Mental and Physical Health**
   - Goal-Oriented Fitness Plans: The system includes a workout schedule to provide users with a structured plan, which can help them stay motivated and achieve fitness goals. Consistent physical activity and proper nutrition are crucial for enhancing both mental and physical health. By offering daily workout plans, the system encourages regular activity and overall fitness improvement.
   - Building Healthy Habits: Through structured daily workouts and tailored macronutrient guidance, the system supports users in forming consistent, healthy habits. Regular exercise and balanced nutrition not only improve physical health but also reduce stress, anxiety, and depression, boosting mental well-being.
  
3. **Reducing Health Risks**
   - Preventive Health: The system offers personalized advice on calorie intake, macronutrient distribution, and exercise routines, encouraging users to adopt healthier lifestyles and prevent chronic conditions such as obesity, diabetes, and heart disease. Proper nutrition and physical activity play a significant role in disease prevention.
   - Promoting Balance: By helping users maintain a balance between nutrition and exercise, the system helps prevent malnutrition, including both undernutrition and overnutrition, which are major global health challenges. Educating users on their caloric and macronutrient needs ensures healthier daily choices.
  
4. **Enhancing Community Health**
   - Accessibility and Inclusivity: The system’s intuitive interface ensures accessibility for a diverse audience, allowing individuals from various backgrounds to access personalized fitness and nutrition advice. This inclusivity helps improve the overall well-being of the community by empowering people to take charge of their health.
   - Encouraging Physical Activity: With personalized workout and nutrition plans, the system encourages users to incorporate more physical activity into their daily routines. This is vital for improving community health and reducing the risks associated with sedentary lifestyles, such as obesity and cardiovascular diseases.
  
5. **Education and Empowerment**
   - Informed Health Decisions: By providing detailed insights into BMR, TDEE, and macronutrients, the system educates users on the importance of nutrition and exercise in maintaining good health. This knowledge empowers individuals to make informed decisions about their diet and fitness, leading to healthier lifestyle choices.

---

## IV. Running the Program 🖥️
## **Prerequisites: 📜**
1. Java Development Kit (JDK) (version 8 or higher)
   - Download and install Java from Oracle if not already installed.
   - Ensure the java command is added to your system’s PATH.
2. IDE or Text Editor
   - You can use any IDE like IntelliJ IDEA, Eclipse, or a simple text editor like Visual Studio Code, or Notepad++.

## **Steps to Run the Program: 🏃‍♂️**
1. Download the Code:
   - Clone from GitHub:
     - If you're using GitHub, copy or clone the Java script to your local machine.
   - Alternatively, copy the code:
     - Copy and paste the FitnessMacroSystem.java file into your local project directory.
2. Compile the Java Program:
   - Open a terminal or command prompt.
   - Navigate to the folder containing the FitnessMacroSystem.java file.
3. Run the Program:
   - After compiling, you can run the program with the following command.
  
## **Folder Structure: 📂**
  ```bash
OOP FINAL PROJECT
  │
  ├── src/
  │   ├── Fitness Macro Calculator System.java              # Main file
  └── README.md                   # Documentation
```
## **Program Controls: 🕹️**

**Main Screen:**
   - Input your name, age, weight, height, and gender.
   - Click "Next" to proceed to the Activity Level screen.

**Activity Level Screen:**
   - Select your activity level (e.g., "Light Exercise", "Moderate Exercise", etc.).
   - Click "Next" to proceed to the Dietary Phase screen.

**Dietary Phase Screen:**
   - Select a dietary phase ("Maintenance", "Cutting", or "Bulking").
   - Click "Next" to calculate your BMR, TDEE, and macronutrients.

**Result Screen:**
   - View your results, including BMR, TDEE, daily and weekly calorie intake, and macronutrient breakdown.
   - "See Workout Schedule" Navigates to a personalized workout plan screen.

**Workout Schedule Screen:**
   - Click on the buttons for each day (e.g., Monday, Tuesday) to view the workout plan for that day.
   - Click "Back to Results" to return to the result screen.

## **Functionality Controls: ⚙️**
   - Submit and Proceed: After filling in the details, click "Next" to proceed to the next screen.
   - Calculate Results: The program will calculate your daily calorie needs, macronutrient requirements, and display a tailored workout schedule.
   - Workout Plan: The program offers a personalized workout schedule for each day of the week, which you can view by clicking on the respective days.

---

## Thank You for Using Macro Mate!

I sincerely appreciate you choosing Macro Mate as your fitness and nutrition guide. I hope it has helped you gain valuable insights into your health, nutrition, and workout plans. Remember, consistency is key, and Macro Mate are here to support you on your wellness journey.

Stay healthy, stay strong, and come back anytime to keep track of your fitness progress!

## Happy training and healthy living! 💪🏋️‍♂️

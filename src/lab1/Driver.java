package lab1;

public class Driver {

  public static void main(String[] args) {

    // Creating a model using empty constructor
    Model model = new Model();

    // Printing first name from created model - Should be null
    System.out.println(model.getFirstName());

    // Seting first name and last name to created model
    model.setFirstName("Irina");
    model.setLastName("Shayk");

    // Printing updated first name and last name - Should print Irina Shayk
    System.out.println(model.getFirstName());
    System.out.println(model.getLastName());

    // Creating a model using the second constructor
    Model model2 = new Model("Gisele",
                              "Bündchen",
                                70,
                                121.0,
                          true,
                                false);

    // Printing model's height in Inches
    System.out.println(model2.getHeight());

    // Printing model's height in Feet and Inches
    System.out.println(model2.getHeightInFeetAndInches());

    // Printing model's weight in Pounds
    System.out.println(model2.getWeight());

    // Printing model's weight in Kilograms
    System.out.println(model2.getWeightKg());

    // Printing if model can travel
    System.out.println(model2.isAvailableToTravel());

    // Printing if model is smoker
    System.out.println(model2.isSmoker());

    // Creating a model using the third constructor
    Model model3 = new Model("Barbara", "Palvin", 68, 120.0);

    // Setting a new weight using kilograms
    model3.setWeight(75L);

    // Printing the value in kilograms
    System.out.println(model3.getWeightKg());

    // Setting a new height using feet and inches
    model3.setHeight(5, 9);

    // Printing the value in feet and inches
    System.out.println(model3.getHeightInFeetAndInches());

    // Setting a new height to model - Should throw a new exception for invalid values
    // model3.setHeight(10);

    // Displaying basic details
    model.printDetails();
    model2.printDetails();
    model3.printDetails();

    // Displaying models details
    model.displayModelDetails();
    model2.displayModelDetails();
    model3.displayModelDetails();
  }

}

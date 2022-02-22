package lab1;

/**
 * @author Joao Victor Anastacio
 */
public class Model {

  private static final int MINIMUM_NAME_LENGTH = 3;
  private static final int MAXIMUM_NAME_LENGTH = 20;
  private static final int MINIMUM_HEIGHT = 24;
  private static final int MAXIMUM_HEIGHT = 80;
  private static final double MINIMUM_WEIGHT = 80;
  private static final double MAXIMUM_WEIGHT = 280;
  private static final double POUNDS_PER_KG = 2.2046;
  private static final int INCHES_PER_FOOT = 12;
  private static final int BASE_RATE_DOLLARS_PER_HOUR = 60;
  private static final int TALL_INCHES = 67;
  private static final double THIN_POUNDS = 140.0;
  private static final int TALL_THIN_BONUS_DOLLARS_PER_HOUR = 5;
  private static final int TRAVEL_BONUS_DOLLARS_PER_HOUR = 4;
  private static final int SMOKER_DEDUCTION_DOLLARS_PER_HOUR = 10;
  private static final String TRUE_BOOLEAN_FORMAT = "yep";
  private static final String FALSE_BOOLEAN_FORMAT = "nope";

  private String firstName;
  private String lastName;
  private int heightInches;
  private double weightPounds;
  private boolean availableToTravel;
  private boolean smoker;

  /**
   * No arg constructor
   */
  public Model() {
  }

  /**
   * All args constructor
   * @param firstName Model's first name
   * @param lastName Model's last name
   * @param height Model's height in inches
   * @param weight Model's weight in pounds
   * @param availableToTravel Indicates if model is available to travel
   * @param smoker Indicates if model is smoker
   */
  public Model(String firstName,
                String lastName,
                int height,
                double weight,
                boolean availableToTravel,
                boolean smoker) {
    setFirstName(firstName);
    setLastName(lastName);
    setHeight(height);
    setWeight(weight);
    setAvailableToTravel(availableToTravel);
    setSmoker(smoker);
  }

  /**
   * Basic information constructor
   * @param firstName Model's first name
   * @param lastName Model's last name
   * @param height Model's height in inches
   * @param weight Model's weight in pounds
   */
  public Model(String firstName, String lastName, int height, double weight) {
    setFirstName(firstName);
    setLastName(lastName);
    setHeight(height);
    setWeight(weight);
    setAvailableToTravel(true);
    setSmoker(false);
  }

  /**
   * Private method used to validate the length of strings firstName and lastName
   * @param name
   * @return [boolean] String is valid or not
   */
  private boolean validateName(String name) {
    return name.length() >= MINIMUM_NAME_LENGTH && name.length() <= MAXIMUM_NAME_LENGTH;
  }

  /**
   * Method used to print basic details of the model
   */
  public void printDetails() {
    System.out.println();
    System.out.println("Name: " + getFirstName() + " " + getLastName());
    System.out.println("Height: " + getHeight() + " inches");
    System.out.println("Weight: " + Math.round(getWeight()) + " pounds");

    if (isAvailableToTravel() == true) {
      System.out.println("Does travel ");
    } else {
      System.out.println("Does not travel ");
    }

    if (isSmoker() == true) {
      System.out.println("Does smoke ");
    } else {
      System.out.println("Does not smoke ");
    }
  }

  /**
   * Method used to calculate the amount per hour that a model have to receive
   * @return
   */
  public int calculatePayDollarsPerHour() {
    int payDollarPerHour = 0;

    if(this.getHeight() >= TALL_INCHES && this.getWeight() < THIN_POUNDS) {
      payDollarPerHour = BASE_RATE_DOLLARS_PER_HOUR + TALL_THIN_BONUS_DOLLARS_PER_HOUR;
    } else {
      payDollarPerHour = BASE_RATE_DOLLARS_PER_HOUR;
    }

    if(this.isAvailableToTravel()) {
      payDollarPerHour += TRAVEL_BONUS_DOLLARS_PER_HOUR;
    }

    if(this.isSmoker()) {
      payDollarPerHour = payDollarPerHour - SMOKER_DEDUCTION_DOLLARS_PER_HOUR;
    }
    return payDollarPerHour;
  }

  /**
   * Method used to print all information about the model
   */
  public void displayModelDetails() {
    String modelFullName = getFirstName() + " " + getLastName();
    String canTravelFormatted = isAvailableToTravel() ? TRUE_BOOLEAN_FORMAT : FALSE_BOOLEAN_FORMAT;
    String isSmokerFormatted = isSmoker() ? TRUE_BOOLEAN_FORMAT : FALSE_BOOLEAN_FORMAT;

    System.out.println();
    System.out.println(String.format("Name: %s\n"
        + "Height: %s\n"
        + "Weight: %.1f pounds\n"
        + "Travels: %s\n"
        + "Smokes: %s\n"
        + "Hourly rate: $%d",
        modelFullName,
        getHeightInFeetAndInches(),
        getWeight(),
        canTravelFormatted,
        isSmokerFormatted,
        calculatePayDollarsPerHour()));
  }

  /**
   * Used to get model first name
   * @return [String] Model's first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName New first name for the model
   * @throws IllegalArgumentException
   */
  public void setFirstName(String firstName) {
    if(validateName(firstName)) {
      this.firstName = firstName;
    } else {
      throw new IllegalArgumentException("First name must be greater than 3 and less than 20");
    }
  }

  /**
   * Used to get model last name
   * @return [String] Model's last name
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName New last name for the model
   * @throws IllegalArgumentException
   */
  public void setLastName(String lastName) {
    if(validateName(lastName)) {
      this.lastName = lastName;
    } else {
      throw new IllegalArgumentException("Last name must be greater than 3 and less than 20");
    }
  }

  /**
   * Used to get model height in inches
   * @return [int] Model's height
   */
  public int getHeight() {
    return heightInches;
  }

  /**
   * @param height New height value in inch only
   * @throws IllegalArgumentException
   */
  public void setHeight(int height) {
    if(height >= MINIMUM_HEIGHT && height <= MAXIMUM_HEIGHT) {
      this.heightInches = height;
    } else {
      throw new IllegalArgumentException("Height must be greater than 24 and less than 84");
    }
  }

  /**
   * Used to get model height in feet and inches
   * @return [String] Model's height in feet and inches
   */
  public String getHeightInFeetAndInches() {
    int heightInFeet = this.heightInches / INCHES_PER_FOOT;
    int heightInInches = this.heightInches % INCHES_PER_FOOT;
    return String.format("%d feet %d inch", heightInFeet, heightInInches);
  }

  /**
   * @param feet New feet value for model
   * @param inches New inch value for model
   * @throws IllegalArgumentException
   */
  public void setHeight(int feet, int inches) {
    int convertedToInches = inches + (feet * INCHES_PER_FOOT);
    if(convertedToInches >= MINIMUM_HEIGHT && convertedToInches <= MAXIMUM_HEIGHT) {
      this.heightInches = convertedToInches;
    } else {
      throw new IllegalArgumentException("Height must be greater than 24 and less than 84");
    }
  }

  /**
   * Used to get model weight in pounds
   * @return [double] Model's weight in pounds
   */
  public double getWeight() {
    return weightPounds;
  }

  /**
   * @param weight New weight in pounds
   * @throws IllegalArgumentException
   */
  public void setWeight(double weight) {
    if(weight >= MINIMUM_WEIGHT && weight <= MAXIMUM_WEIGHT) {
      this.weightPounds = weight;
    } else {
      throw new IllegalArgumentException("Weight must be greater than 80 and less than 280");
    }
  }

  /**
   * Used to get model weight in kilograms
   * @return [long] Model's weight in kilograms
   */
  public long getWeightKg() {
    return (long) (this.weightPounds / POUNDS_PER_KG);
  }

  /**
   * @param kilograms New weight in kilograms
   * @throws IllegalArgumentException
   */
  public void setWeight(long kilograms) {
    double convertedToPounds = kilograms * POUNDS_PER_KG;
    if(convertedToPounds >= MINIMUM_WEIGHT && convertedToPounds <= MAXIMUM_WEIGHT) {
      this.weightPounds = convertedToPounds;
    } else {
      throw new IllegalArgumentException("Weight must be greater than 80 and less than 280");
    }
  }

  /**
   * Used to know if model is available to travel
   * @return [boolean] Model's availability
   */
  public boolean isAvailableToTravel() {
    return availableToTravel;
  }

  /**
   * @param availableToTravel Boolean value to indicate if model is available to travel
   */
  public void setAvailableToTravel(boolean availableToTravel) {
    this.availableToTravel = availableToTravel;
  }

  /**
   * Used to know if model is smoker
   * @return [boolean] Model's habit
   */
  public boolean isSmoker() {
    return smoker;
  }

  /**
   * @param smoker Boolean value to indicate if model is smoker or not
   */
  public void setSmoker(boolean smoker) {
    this.smoker = smoker;
  }
}

Feature: Feature containing flyus seat booking functionalities

  @FlyusSeatBooking
  Scenario Outline: Seat Booking functionalities of flyus
    Given User navigates to flyus
    When User enters "<source>" and "<destination>" and clicks search
    When User selects the flight
    When User enters the below passenger info
      | firstName   | lastName   | gender   | dob   |
      | <FirstName> | <LastName> | <Gender> | <DOB> |
    When User selects the seat
    Then print the price
    Examples: 
      | source        | destination | FirstName | LastName | Gender | DOB        |
      | London        | Dubai       | Dhivya    | Suresh   | Female | 07/12/1996 |
      | New York City | Srinagar    | Mugisha   | Suresh   | Female | 08/11/1996 |

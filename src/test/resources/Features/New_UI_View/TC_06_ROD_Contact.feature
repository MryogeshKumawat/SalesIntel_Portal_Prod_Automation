Feature: Validate RoD Contacts Verification


  @First @Sanity
  Scenario: To validate SalesIntel application Valid User Username and Valid Password
    And Enter Valid Username
    And Enter Valid Password
    And Click On Login Button

  @First @Smoke @Reg
  @Sanity
  Scenario: To validate application Search Contact for ROD
    Then Click on Contact Radio Button for Universal User
    When Click on Search Button
    Then Verify Contact Name is displayed
    When Click on Contact Name Button
    Then Verify First Name is displayed
    And Verify Last Name is displayed
    When Enter the Universal First Name
    And Enter the Universal Last Name
    And Click on Search Button
    And Click On Searched Contact

  @First @Smoke @Reg
  @Sanity
  Scenario: To validate application "Request Verification"
    Then Verify Request Verification Button is displayed
    And Click On Request Verification Button

  @First @Smoke @Reg
  @Sanity
  Scenario: To validate application for Validate "Requested Verification"
    Then Verify Requested Verification Status

  @First @Smoke @Reg
  @Sanity
  Scenario: To validate application Contact Requested in ROD Section
     Then Verify RoD Tab is displayed
     And Click On RoD Tab
    And Verify Requested ROD is Displayed in ROD tab


  @First @Sanity
  Scenario: To validate application Logout
    When Click On Setting Options
    And Click On Logout Options
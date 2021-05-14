Feature: Information

Background: The user already login
  Given Given The user already login to Fado website with username is "bichhue11995@gmail.com" password is "A12345678@"

  Scenario: Show current user's information for udpate
    Given The update user information form is showed
    Then The current user information is showed for default
    And The email information can't be updated
    #And The date of birth is display as dd-mm-yyyy format.

  Scenario: Show Calendar popup for date of birth selection
    Given The update user information form is showed
    When The user try to show the Calendar popup for new value for birthday. "21-01-1990" for example
    Then The value of date of birth will be updated to "21-01-1990"

  Scenario: Show the require field input
    Given The update user information form is showed
    When The user attempt to clear value of Fullname and Phone
    Then The message "Họ và tên là bắt buộc" will be displayed below Fullname field
    And The message "Điện thoại là bắt buộc" will be displayed below phone number

  Scenario: Show update message for all valid values
    Given The update user information form is showed
    When The user attempt to update with all valid values
    Then The message "Quý khách đã cập nhập thông tin tài khoản thành công !" will be showed

  Scenario: Clear all values except Email field
    Given The update user information form is showed
    When The user attempt to clear all values
    Then The user should see blank value for all except email field
    And The email field value is "khanh.tx@live.com"

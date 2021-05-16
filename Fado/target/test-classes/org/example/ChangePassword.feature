Feature: ChangePassword
  Background:
    Given Given The user already login to Fado website with username is "bichhue11995@gmail.com" password is "A12345678@"

  Scenario:  Show the require field input
    Given The change password page is showed
    When The user try to change password with blank value for all field
    Then The message "Vui lòng nhập dữ liệu" will be displayed next CurrentPassword field
    And The message "Vui lòng nhập dữ liệu" will be displayed next NewPassword field
    And The focus will be set on CurrentPassword field

  Scenario: Input NewPassword less than 6 characters
    Given The change password page is showed
    When The user try to change password with NewPassword is less than 6 characters
    Then The min length message "Vui lòng nhập dữ liệu" will be displayed next NewPassword field

  Scenario:  Wrong Current Password provided
    Given  The change password page is showed
    When The user try to change password with wrong CurrentPassword
    Then The wrong current password message "Có lỗi xảy ra:- Mật khẩu cũ không chính xác" will be displayed

  Scenario: ConfirmNewPassword field is not match with NewPassword
    Given The change password page is showed
    When The user input ConfirmNewPassword is not match with NewPassword
    Then The not match error message "Mật khẩu nhập lại không trùng khớp" will be displayed next ConfirmNewPassword field

  Scenario: Change password success
    Given The change password page is showed
    When The user try to change password with valid data
    Then The success message "Thay đổi mật khẩu thành công" will be displayed

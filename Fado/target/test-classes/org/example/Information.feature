Feature: Information

Background: The user already login
  Given The user already login with username is "bichhue11995@gmail.com" password is "A12345678@"

Scenario:tc1_Show current information
  Given The "Quản lý tài khoản" page is displayed
  When The user click on "Thông tin tài khoản"
  Then All information is fill out

Feature: Validating add place API

Scenario Outline: Verify place added with AddplaceAPI

Given Add place payload with "<name>" "<phone_number>" "<address>"

When user calls "AddplaceAPI" with post http request

Then API call get success with status code "200"

And "status" in response body is "OK"

And "scope" in response body is "APP"


Examples:


|name| phone_number |address|

|Shubhajyoti|8910690514|kolkata W.B|

|Abhishek|1230690514|kata W.B|



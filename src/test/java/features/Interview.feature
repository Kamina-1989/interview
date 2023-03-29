Feature: REST API Exercise for CGM Interview

  Scenario Outline: Executable test scenario for GET Api
    Given The user invokes API URI
    When The user sends the request
    Then The user receives a "<statusCode>" response

    @good
    Examples:
      |statusCode|
      |200       |

    @bad
    Examples:
      |statusCode|
      |400       |
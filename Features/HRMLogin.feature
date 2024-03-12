Feature: HRMpage login

  Scenario: To Login  successfully
    Given user enters valid username "Admin"
    When the user enters valid password "admin123"
    And user clicks login button
    Then confirm user is successfully logged in

  Scenario Outline: To login with invalid credentials
    Given user enters valid username "<username>"
    When the user enters valid password "<password>"
    And user clicks login button
    Then validate user is not logged in

    Examples: 
      | username | password |
      | Admin    | xyz123   |
      | qwer     | admin123 |
      | zxcvb    | zxcvb123 |

  Scenario Outline: To login with null credentials
    Given user enters valid username "<username>"
    When the user enters valid password "<password>"
    And user clicks login button
    Then validate user with corresponding tooltip message

    Examples: 
      | username | password |
      |          | xyz123   |
      | zxcv     |          |
      |          |          |

  Scenario: To validate HRMlogo
    Given user clicks hrmlogo
    Then user validates HRMlogo

  Scenario: To validate link forgot password
    Given user clicks forget password link
    Then user  validates forget password link

  Scenario: To validate HRM url link
    Given user clicks hrm_url_link
    Then user validates hrm_url_link

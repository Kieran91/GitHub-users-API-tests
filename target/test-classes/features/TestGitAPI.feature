Feature: Testing the GitHub API and frontend

  @test
  Scenario: The GitHub API returns the correct values for a specified user
    Given the github public users API receives a GET request for the user "6wl"
     When a HTTP response of "200" is received
     Then the JSON response contains the field "name" with a value of "Gregory Loscombe"
      And the JSON response contains the field "id" with a value of "15330"
      And the JSON response contains the field "company" with a value of "Amplience"
      And the JSON response contains the field "location" with a value of "London"
      And the JSON response contains the field "public_repos" with a value of "4"
      And the JSON response contains the field "public_gists" with a value of "10"
      And the JSON response contains the field "followers" with a value of "12"
      And the JSON response contains the field "following" with a value of "20"
  
  @test
  Scenario: The values returned from the GitHub API match the values shown on the webpage for a specified user
    Given the github public users API receives a GET request for the user "6wl"
     When a HTTP response of "200" is received
     Then the webpage value for "name" matches the corresponding JSON value received in the API response
      And the webpage value for "company" matches the corresponding JSON value received in the API response
      And the webpage value for "location" matches the corresponding JSON value received in the API response
      And the webpage value for "public_repos" matches the corresponding JSON value received in the API response
      And the webpage value for "public_gists" matches the corresponding JSON value received in the API response
      And the webpage value for "followers" matches the corresponding JSON value received in the API response
      And the webpage value for "following" matches the corresponding JSON value received in the API response
  
  

Feature: Validating Add Place API
# tagging will help like which scenario we want to run
    # when we pass data then we have write Scenario Outline
    @AddPlace
    Scenario Outline: Verify place added successfully
        Given Add place payload with "<name>" "<languages>" "<address>"
        When user calls "AddPlaceAPI" with "POST" http request
        Then Response with success and status should be ok and status code should 200
        And "status" in Response body is "OK"
        And "scope" in Response body is "APP"
        And  Verify placeId created maps to "<name>" using "GetPlaceAPI"
#        When user calls DeletePlaceAPI with post request   for more parameter just we need to pass additional parameters
        # Driving data through Property file
    Examples:
        | name    | languages | address               |
        | Jar jar | English   | Koramangala 6th block |
       # | TCS  | Spanish   | Pune                  |
        #| Virat | French    | French colony         |

      @DeletePlace
        Scenario: Verify delete place functionality is working
            Given  Delete place payload
            When user calls "DeletePlaceAPI" with "POST" http request
            Then Response with success and status should be ok and status code should 200
            And "status" in Response body is "OK"


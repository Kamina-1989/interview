# interview
For the exercise I created a simple feature file with a scenario outline in order to manage different response status codes dinamically. I used RESTAssured for the solution of the exercise: set the URI in the @Given, generate the request for the GET method in the @When and verify it with an assert in @Then. For the payload I created a POJO class to build the request and convert the JSON file in a Java class. The searchString parameter is mandatory so I used the lombok annotation @NonNull that throws an error for a null value, otherwise the annotations can be deleted in order to test the 400 bad response scenario. The ternary operator inside the POJO class set the order value to ASC if it is null.
